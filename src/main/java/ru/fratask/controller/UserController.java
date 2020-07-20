package ru.fratask.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.fratask.model.dto.user.SignInDto;
import ru.fratask.model.dto.user.SignUpDto;

@Controller("/user")
public class UserController {

    @PostMapping("/signIn")
    public ResponseEntity<OAuth2AccessToken> signIn(@RequestBody SignUpDto signUpDto) {
        return null;
    }

    @PostMapping("/signUp")
    public ResponseEntity<OAuth2AccessToken> signUp(@RequestBody SignInDto signInDto) {
        return null;
    }

}
