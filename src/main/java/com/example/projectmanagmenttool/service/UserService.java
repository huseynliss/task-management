package com.example.projectmanagmenttool.service;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import com.example.projectmanagmenttool.dao.repository.UserRepository;
import com.example.projectmanagmenttool.util.ImageUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository){
        this.userRepository  = userRepository;
    }


//    public ResponseEntity<?> saveUser(UserEntity userEntity){
//        var saved = userRepository.save(userEntity);
//        return ResponseEntity.ok(saved);
//    }

    public List<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public List<UserEntity> getLast4Users(){

        return userRepository.findFirst4ByOrderByIdDesc();
    }

    public UserEntity createUser(String name, MultipartFile imageData) throws IOException {
        byte[] imageData1 = imageData.getBytes();
        // UserEntity oluşturun ve veritabanına kaydedin
        UserEntity user = new UserEntity();
        user.setName(name);
        user.setImageData(imageData1);

        return userRepository.save(user);
    }
}
