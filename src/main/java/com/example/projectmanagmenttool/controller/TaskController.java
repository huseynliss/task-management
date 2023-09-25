package com.example.projectmanagmenttool.controller;

import com.example.projectmanagmenttool.dao.entity.TaskEntity;
import com.example.projectmanagmenttool.dao.entity.UserEntity;
import com.example.projectmanagmenttool.request.TaskRequest;
import com.example.projectmanagmenttool.request.UpdateTaskStatusRequest;
import com.example.projectmanagmenttool.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/task")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest) throws IOException {
        TaskEntity task = taskService.createTask(taskRequest);
        // Return a response
        return ResponseEntity.ok(task);
    }

    @PutMapping("/update-task-status")
    public ResponseEntity<?> updateTaskStatus(@RequestBody UpdateTaskStatusRequest request) {
        try {
            TaskEntity updatedTask = taskService.updateTaskStatus(request.getTaskId(), request.getNewStatus());
            return ResponseEntity.ok(updatedTask);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to update task status.");
        }
    }


}
