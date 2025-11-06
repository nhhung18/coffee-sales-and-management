package com.hungdev.coffe_restaurant_system.model;

import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserAddress extends BaseIdObject {

    @ManyToOne
    @Column(name = "userId", nullable = false)
    private User userId;

    @ManyToOne
    @Column(name = "addressId", nullable = false)
    private Address addressId;


}
