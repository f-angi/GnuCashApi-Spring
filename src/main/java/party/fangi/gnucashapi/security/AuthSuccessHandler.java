package party.fangi.gnucashapi.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    private final TokenService tokenService;

    @Value("${application.google-auth.allowed-emails}")
    private List<String> allowedEmails;

    @Value("${application.google-auth.redirect-url.success}")
    private String redirectUrlSuccess;

    @Value("${application.google-auth.redirect-url.failure}")
    private String redirectUrlFailure;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        AuthenticationSuccessHandler.super.onAuthenticationSuccess(request, response, chain, authentication);
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        final var token = tokenService.generateToken(authentication);

        final OAuth2User user = (OAuth2User) authentication.getPrincipal();
        final var email = (String) user.getAttribute("email");
        if (email != null && allowedEmails.contains(email)) {
            response.sendRedirect(redirectUrlSuccess + token);
        } else {
            response.sendRedirect(redirectUrlFailure);
        }
    }
}
