package com.study.totee.persistence;

import com.study.totee.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
    Boolean existsByEmail(String email);
    UserEntity findByEmail(String email);
}