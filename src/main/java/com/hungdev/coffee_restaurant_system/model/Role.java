package com.hungdev.coffee_restaurant_system.model;

import com.hungdev.coffee_restaurant_system.model.base.BaseIdObject;
import com.hungdev.coffee_restaurant_system.model.constants.RoleName;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Role extends BaseIdObject {
    @Enumerated(EnumType.STRING)
    @Column(name = "roleName")
    private RoleName roleName;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
