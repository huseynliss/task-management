package com.example.projectmanagmenttool.controller;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import com.example.projectmanagmenttool.dao.repository.UserRepository;
import com.example.projectmanagmenttool.response.UserResponse;
import com.example.projectmanagmenttool.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;



    @GetMapping("/users")
    public String getAllUsers(Model model) {
        List<UserEntity> users = userRepository.findAll();
        List<UserResponse> userResponses = users.stream()
                .map(this::mapToUserResponse)
                .collect(Collectors.toList());

        model.addAttribute("users", userResponses);

        return "user";
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

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestParam("name") String name, @RequestParam("image_data") MultipartFile imageData) throws IOException {

        UserEntity user = userService.createUser(name, imageData);

        // Cevap döndürün
        return ResponseEntity.ok(user);
    }

}
