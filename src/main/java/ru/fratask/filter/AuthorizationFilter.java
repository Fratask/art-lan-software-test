package ru.fratask.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.fratask.dao.RequestRepository;
import ru.fratask.dao.TokenRepository;
import ru.fratask.model.AppException;
import ru.fratask.model.AppResponseCode;
import ru.fratask.model.entity.OAuthAccessToken;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

@Component
public class AuthorizationFilter implements Filter {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private TokenRepository tokenRepository;

    private final String[] PUBLIC_URLS = {
            "/user/signUp", "/user/signIn", "/error"
    };

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        if (Arrays.stream(PUBLIC_URLS).noneMatch(s -> httpServletRequest.getRequestURI().equals(s))) {
            validateUserAuth(httpServletRequest, httpServletResponse);
        }
        validateUriForUser(httpServletRequest, httpServletResponse);
        chain.doFilter(request, response);
    }

    private void validateUserAuth(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || authHeader.isEmpty()) {
            throw new AppException(AppResponseCode.AUTHORIZATION_HEADER_EMPTY);
        }
        if (authHeader.split(" ").length != 2) {
            throw new AppException(AppResponseCode.AUTHORIZATION_HEADER_WRONG_FORMAT);
        }
        if (!authHeader.split(" ")[0].equals("Bearer")) {
            throw new AppException(AppResponseCode.AUTHORIZATION_HEADER_WRONG_FORMAT);
        }
        String token = authHeader.split(" ")[1];
        if (token.isEmpty()) {
            throw new AppException(AppResponseCode.AUTHORIZATION_WRONG_TOKEN);
        }
        Optional<OAuthAccessToken> foundTokenOptional = tokenRepository.findByAccessToken(token);
        if (!foundTokenOptional.isPresent()) {
            throw new AppException(AppResponseCode.AUTHORIZATION_WRONG_TOKEN);
        }
    }

    private void validateUriForUser(HttpServletRequest request, HttpServletResponse response) {

    }

}
