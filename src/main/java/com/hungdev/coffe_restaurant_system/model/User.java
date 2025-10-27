package com.hungdev.coffe_restaurant_system.model;

import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CollectionId;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder

public class User extends BaseIdObject {
    @Column(name = "userName", unique = true, nullable = false, length = 255)
    private String userName;

    @Column(name = "fullName", unique = true, nullable = false, length = 255)
    private String fullName;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "password", unique = true, nullable = false, length = 255)
    private String password;

    @Column(name = "addressId")
    private int addressId;

    @Column(name = "roleId")
    private int roleId;

    @Column(name = "phoneNum", unique = true, nullable = false, length = 20)
    private String phoneNum;

    @Column(name = "avatarUrl", length = 255)
    private String avatarUrl;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
