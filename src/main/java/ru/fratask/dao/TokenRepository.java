package ru.fratask.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.fratask.model.entity.OAuthAccessToken;

import java.util.Optional;

@Repository
public interface TokenRepository extends CrudRepository<OAuthAccessToken, Long> {

    Optional<OAuthAccessToken> findByUsername(String username);
}
