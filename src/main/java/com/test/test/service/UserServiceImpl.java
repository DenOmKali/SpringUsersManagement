package com.test.test.service;

import com.test.test.entity.UserEntity;
import com.test.test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Apilat Denis
 * Date :11.02.2024
 * Time :13:54
 * Project Name :test
 */

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserEntity> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserById(String userId, UserEntity updatedUser) {
        Optional<UserEntity> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            UserEntity existingUser = existingUserOptional.get();

            existingUser.setFirstName(updatedUser.getFirstName());
            existingUser.setLastName(updatedUser.getLastName());
            existingUser.setRole(updatedUser.getRole());

            userRepository.save(existingUser);
        }
    }

    @Override
    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
