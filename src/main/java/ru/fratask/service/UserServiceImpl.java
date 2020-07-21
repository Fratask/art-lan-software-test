package ru.fratask.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.fratask.dao.TokenRepository;
import ru.fratask.dao.UserRepository;
import ru.fratask.model.AppException;
import ru.fratask.model.AppResponseCode;
import ru.fratask.model.dto.user.SignInDto;
import ru.fratask.model.dto.user.SignUpDto;
import ru.fratask.model.entity.OAuthAccessToken;
import ru.fratask.model.entity.User;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final TokenRepository tokenRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenRepository = tokenRepository;
    }

    public OAuthAccessToken signUp(SignUpDto signUpDto) {
        User user = saveUser(signUpDto);
        return authorize(user);
    }

    public OAuthAccessToken signIn(SignInDto signInDto) {
        return null;
    }

    private User saveUser(SignUpDto signUpDto) {
        checkNewUser(signUpDto.getUsername());
        User user = new User();
        user.setUsername(signUpDto.getUsername());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        user = userRepository.save(user);
        return user;
    }

    private void checkNewUser(String username) {
        userRepository.findByUsername(username).ifPresent(user -> {
            throw new AppException(AppResponseCode.USER_ALREADY_EXISTS);
        });
    }

    private OAuthAccessToken authorize(User user) {
        Optional<OAuthAccessToken> token = tokenRepository.findByUsername(user.getUsername());
        OAuthAccessToken accessToken;
        if (token.isPresent()) {
            accessToken = token.get();
        } else {
            accessToken = new OAuthAccessToken(user.getUsername());
            tokenRepository.save(accessToken);
        }
        return accessToken;
    }

}
