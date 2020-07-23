package ru.fratask.service;

import ru.fratask.model.entity.OAuthAccessToken;
import ru.fratask.model.entity.User;

public interface TokenService {

    OAuthAccessToken findTokenForUser(String username);

    User findUserByToken(String token);
}
