package unit.app.application.login

import com.example.auth.app.auth.application.login.LoginUseCase
import com.example.auth.app.auth.domain.contracts.AuthDataSource
import com.example.auth.app.auth.domain.contracts.TokenManager
import com.example.auth.app.auth.domain.entities.User
import com.example.auth.app.auth.domain.entities.login.LoginParams
import com.example.auth.app.auth.domain.entities.login.token.AccessTokenPayload
import com.example.auth.app.auth.domain.entities.login.token.RefreshTokenPayload
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import spock.lang.Subject

class LoginUseCaseSpec extends Specification{

    private PasswordEncoder passwordEncoder = Mock()
    private AuthDataSource authDataSource = Mock()
    private TokenManager tokenManager = Mock()

    @Subject
    LoginUseCase loginUseCase = new LoginUseCase(passwordEncoder,authDataSource,tokenManager)

    def "Should login a user successfully"(){
        given:
            def loginParams = new LoginParams("user@email.com", "12345678")
            def user = User
                    .builder()
                    .id("randomID")
                    .firstName("Juan")
                    .lastName("Perez")
                    .email("user@email.com")
                    .password("12345678")
                    .verified(true)
                    .active(true)
                    .build()

            authDataSource.findByEmail(_ as String) >> Optional.of(user)
            passwordEncoder.matches(_ as String, _ as String) >> true
            tokenManager.generateAccessToken(_ as AccessTokenPayload) >> "accessToken"
            tokenManager.generateRefreshToken(_ as RefreshTokenPayload) >> "refreshToken"

        when:
            def result = loginUseCase.execute(loginParams)

        then:
            result.user.id == "randomID"
            result.user.firstName == "Juan"
            result.accessToken == "accessToken"
            result.refreshToken == "refreshToken"
            result.success
    }

    def "Should not login a user"(){
        given:
            def loginParams = new LoginParams("wrong@email.com", "12345678")

            authDataSource.findByEmail(_ as String) >> Optional.empty()
            passwordEncoder.matches(_ as String, _ as String) >> true
            tokenManager.generateAccessToken(_ as AccessTokenPayload) >> "accessToken"
            tokenManager.generateRefreshToken(_ as RefreshTokenPayload) >> "refreshToken"

        when:
            def result = loginUseCase.execute(loginParams)

        then:
            !result.success
    }



}