package ru.fratask.service;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import ru.fratask.model.dto.user.SignInDto;
import ru.fratask.model.dto.user.SignUpDto;

public interface UserService {

    OAuth2AccessToken signUp(SignUpDto signUpDto);

    OAuth2AccessToken signIn(SignInDto signInDto);

}
