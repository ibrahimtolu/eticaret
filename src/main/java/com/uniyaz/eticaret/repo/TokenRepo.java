package com.uniyaz.eticaret.repo;

import java.util.List;
import java.util.Optional;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo extends JpaRepository<Token, Long> {

    @Query("select token from  Token  token " +
            "left join  token.user user where " +
            "user.userId=:id and (token.expired=false  or token.revoked=false )")
    List<Token> findAllValidTokenByUser(Long id);



    Optional<Token> findByToken(String token);
}