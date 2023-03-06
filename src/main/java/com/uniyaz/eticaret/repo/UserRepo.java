package com.uniyaz.eticaret.repo;

import com.uniyaz.eticaret.converter.UserConverter;
import com.uniyaz.eticaret.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    @Query("select  user.userId as userId,user.userName as userName,user.userType.userTypeId as userTypeId  from User  user  " +
           "where  user.userName=:userName and user.userPassword=:userPassword")
    Optional<UserConverter> findByUserNameAndUserPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

}
