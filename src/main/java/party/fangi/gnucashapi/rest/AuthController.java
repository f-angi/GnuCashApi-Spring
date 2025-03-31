package party.fangi.gnucashapi.rest;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import party.fangi.gnucashapi.security.TokenService;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "${application.cors-origins}", maxAge = 3600)
public class AuthController {

    private final TokenService tokenService;

    @PostMapping(value = "/token", produces = MediaType.TEXT_PLAIN_VALUE)
    @SecurityRequirement(name = "basic")
    public ResponseEntity<String> token(Authentication authentication) {
        log.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        log.debug("Token granted: {}", token);
        return ResponseEntity
                .ok()
                .body(token);
    }

}
