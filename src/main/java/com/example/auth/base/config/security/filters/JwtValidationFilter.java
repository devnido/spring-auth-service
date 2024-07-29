package com.example.auth.base.config.security.filters;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.example.auth.app.domain.contracts.TokenManager;

import static com.example.auth.base.config.security.constants.JwtConstants.AUTHORIZATION_HEADER;
import static com.example.auth.base.config.security.constants.JwtConstants.BEARER_PREFIX;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtValidationFilter extends OncePerRequestFilter {

  private final TokenManager tokenManager;

  public JwtValidationFilter(TokenManager tokenManager) {
    this.tokenManager = tokenManager;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    try {

      String bearerToken = request.getHeader(AUTHORIZATION_HEADER);

      if (bearerToken == null) {
        filterChain.doFilter(request, response);
        return;
      }

      if (this.tokenManager.validateAccessToken(bearerToken.replace(BEARER_PREFIX, ""))) {

        logger.info("Token is valid");

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("asdasdsadsa",
            null);
        authentication.setAuthenticated(true);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        logger.info(SecurityContextHolder.getContext().getAuthentication());

        filterChain.doFilter(request, response);

        return;
      }

    } catch (Exception e) {
      response.getWriter().write(e.getMessage());
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }

  }

}
