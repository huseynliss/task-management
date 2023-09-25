package com.example.projectmanagmenttool.dao.repository;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findFirst4ByOrderByIdDesc();
}
