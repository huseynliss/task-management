package com.example.projectmanagmenttool.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

//    @Lob
    @Column(name = "image_data", columnDefinition = "bytea")
//    @Type(type="org.hibernate.type.BinaryType")
    private byte[] imageData;



    // Getter ve setter metotları
}
