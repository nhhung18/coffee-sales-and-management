package com.hungdev.coffee_restaurant_system.model;

import com.hungdev.coffee_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "user_address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAddress extends BaseIdObject {

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "addressId", nullable = false)
    private Address addressId;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
