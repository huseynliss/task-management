package com.example.projectmanagmenttool.request;

import com.example.projectmanagmenttool.dao.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
public class TaskRequest {



    private String taskName;

    private String description;


    private Date date;

    private Long userId;
}
