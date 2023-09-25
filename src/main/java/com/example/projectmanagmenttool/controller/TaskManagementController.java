package com.example.projectmanagmenttool.controller;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import com.example.projectmanagmenttool.response.UserResponse;
import com.example.projectmanagmenttool.service.TaskService;
import com.example.projectmanagmenttool.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/taskManagement")
public class TaskManagementController {
    private final UserService userService;
    private final TaskService taskService;

    public TaskManagementController(UserService userService, TaskService taskService) {
        this.userService = userService;
        this.taskService = taskService;

    }

    @GetMapping
    public String showIndexPage(Model model){
        List<UserEntity> last4Users = userService.getLast4Users();
        List<UserResponse> last4UserResponses = last4Users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());

        List<UserEntity> users = userService.getAllUsers();

        List<UserResponse> usersResponses =  users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());



        model.addAttribute("users", usersResponses);

        model.addAttribute("last4UserResponses", last4UserResponses);

        model.addAttribute("toDoTasks", taskService.getToDoTasks());



        return "task-management";
    }

    private UserResponse mapToUserResponse(UserEntity userEntity) {
        UserResponse userResponse = new UserResponse();
        userResponse.setId(userEntity.getId());
        userResponse.setName(userEntity.getName());

        // Byte dizisini Base64 kodlayarak cevapta gönder
        if (userEntity.getImageData() != null) {
            String imageDataBase64 = Base64.getEncoder().encodeToString(userEntity.getImageData());
            userResponse.setImageDataBase64(imageDataBase64);
        }

        return userResponse;
    }
}
