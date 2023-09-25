package com.example.projectmanagmenttool.service;

import com.example.projectmanagmenttool.dao.entity.TaskEntity;
import com.example.projectmanagmenttool.dao.repository.TaskRepository;
import com.example.projectmanagmenttool.dao.repository.UserRepository;
import com.example.projectmanagmenttool.enumMain.Status;
import com.example.projectmanagmenttool.request.TaskRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public TaskEntity createTask(TaskRequest task){
        TaskEntity taskEntity = new TaskEntity();
//        taskEntity.setUser(userRepository.findById(task.getUser().getId()).get());
        taskEntity.setTaskName(task.getTaskName());
        taskEntity.setDescription(task.getDescription());
        taskEntity.setDate(task.getDate());
        taskEntity.setUser(userRepository.findById(task.getUserId()).get());
        taskRepository.save(taskEntity);

        return taskEntity;
    }

    public List<TaskEntity> getToDoTasks() {
        return taskRepository.findByStatus(Status.TO_DO);
    }

    public TaskEntity updateTaskStatus(Long taskId, String newStatus) {
        // TaskEntityRepository kullanarak taskId'ye göre görevi bulun
        TaskEntity task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));

        // Görevin statüsünü güncelleyin
        task.setStatus(Status.valueOf(newStatus)); // Statüyü enum değerine dönüştürün

        // Güncellenen görevi kaydedin
        return taskRepository.save(task);
    }

}
