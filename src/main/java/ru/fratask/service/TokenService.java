package ru.fratask.service;

import ru.fratask.model.entity.OAuthAccessToken;
import ru.fratask.model.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {

    OAuthAccessToken findTokenForUser(String username);

    User findUserByToken(String token);

    Boolean isPresent(String token);

    OAuthAccessToken getTokenFromRequest(HttpServletRequest request);
}
