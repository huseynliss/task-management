package com.example.projectmanagmenttool.dao.repository;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
