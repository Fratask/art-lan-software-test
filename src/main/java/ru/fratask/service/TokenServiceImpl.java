package ru.fratask.service;

import org.springframework.stereotype.Service;
import ru.fratask.dao.TokenRepository;
import ru.fratask.dao.UserRepository;
import ru.fratask.model.AppException;
import ru.fratask.model.AppResponseCode;
import ru.fratask.model.entity.OAuthAccessToken;
import ru.fratask.model.entity.User;

import javax.servlet.http.HttpServletRequest;

@Service
public class TokenServiceImpl implements TokenService {

    private final TokenRepository tokenRepository;
    private final UserRepository userRepository;

    public TokenServiceImpl(TokenRepository tokenRepository, UserRepository userRepository) {
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OAuthAccessToken findTokenForUser(String username) {
        return tokenRepository.findByUsername(username).orElseThrow(() -> new AppException(AppResponseCode.TOKEN_NOT_FOUND));
    }

    @Override
    public User findUserByToken(String token) {
        OAuthAccessToken oAuthAccessToken = tokenRepository.findByAccessToken(token).orElseThrow(() -> new AppException(AppResponseCode.TOKEN_NOT_FOUND));
        User user = userRepository.findByUsername(oAuthAccessToken.getUsername()).orElseThrow(() -> new AppException(AppResponseCode.USER_WITH_THIS_TOKEN_NOT_FOUND));
        return user;
    }

    @Override
    public Boolean isPresent(String token) {
        return tokenRepository.findByAccessToken(token).isPresent();
    }

    @Override
    public OAuthAccessToken getTokenFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (!authHeader.split(" ")[0].equals("Bearer")) {
            throw new AppException(AppResponseCode.AUTHORIZATION_HEADER_WRONG_FORMAT);
        }
        String token = authHeader.split(" ")[1];
        if (token.isEmpty()) {
            throw new AppException(AppResponseCode.AUTHORIZATION_WRONG_TOKEN);
        }
        if (!isPresent(token)) {
            throw new AppException(AppResponseCode.AUTHORIZATION_WRONG_TOKEN);
        }
        return tokenRepository.findByAccessToken(token).orElseThrow(() -> new AppException(AppResponseCode.TOKEN_NOT_FOUND));
    }
}
