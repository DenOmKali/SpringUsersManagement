package com.test.test.repository;

import com.test.test.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Apilat Denis
 * Date :11.02.2024
 * Time :13:43
 * Project Name :test
 */

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}
