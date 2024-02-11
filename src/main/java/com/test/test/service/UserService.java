package com.test.test.service;

import com.test.test.entity.UserEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author Apilat Denis
 * Date :11.02.2024
 * Time :13:53
 * Project Name :test
 */

public interface UserService {
    List<UserEntity> getUsers();
    Optional<UserEntity> getUserById(String userId);
    void saveUser(UserEntity userEntity);
    void updateUserById(String userId, UserEntity newUserEntity);
    void deleteUserById(String userId);
}
