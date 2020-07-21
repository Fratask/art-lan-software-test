package ru.fratask.service;

import ru.fratask.model.dto.user.SignInDto;
import ru.fratask.model.dto.user.SignUpDto;
import ru.fratask.model.entity.OAuthAccessToken;

public interface UserService {

    OAuthAccessToken signUp(SignUpDto signUpDto);

    OAuthAccessToken signIn(SignInDto signInDto);

}
