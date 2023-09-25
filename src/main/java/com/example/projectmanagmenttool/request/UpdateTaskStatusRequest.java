package com.example.projectmanagmenttool.request;

import lombok.Data;

@Data
public class UpdateTaskStatusRequest {
    private Long taskId;
    private String newStatus;

    // Getter ve setter metodlarını ekleyin
}
