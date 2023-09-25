package com.example.projectmanagmenttool.dao.repository;

import com.example.projectmanagmenttool.dao.entity.TaskEntity;
import com.example.projectmanagmenttool.enumMain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    List<TaskEntity> findByStatus(Status status);
}
