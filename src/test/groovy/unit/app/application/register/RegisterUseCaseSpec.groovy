package unit.app.application.register

import com.example.auth.app.auth.application.register.RegisterUseCase
import com.example.auth.app.auth.domain.contracts.AuthDataSource
import com.example.auth.app.auth.domain.entities.User
import com.example.auth.app.auth.domain.entities.register.RegisterParams
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification
import spock.lang.Subject

class RegisterUseCaseSpec extends Specification{

    private PasswordEncoder passwordEncoder = Mock()
    private AuthDataSource authDataSource = Mock()

    @Subject
    RegisterUseCase registerUseCase = new RegisterUseCase(passwordEncoder,authDataSource)

    def "Should register a user"(){
        given:
            def encodedPassword = "AwSeDrFtGyHuj2343"
            def registerParams =RegisterParams
                .builder()
                .firstName("Juan")
                .lastName("Perez")
                .email("user@email.com")
                .password("12345678")
                .build()

            def userToSave = User
                .builder()
                .firstName(registerParams.firstName)
                .lastName(registerParams.lastName)
                .email(registerParams.email)
                .password(encodedPassword)
                .build()

            def newUser = User
                .builder()
                .id("randomID")
                .firstName("Juan")
                .lastName("Perez")
                .email("user@email.com")
                .password("12345678")
                .verified(true)
                .active(true)
                .build()

            passwordEncoder.encode("12345678") >> encodedPassword
            authDataSource.save(userToSave) >> newUser

        when:
            def result = registerUseCase.execute(registerParams)

        then:
            result.email == "user@email.com"
            result.verified
    }


}
