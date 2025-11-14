package com.hungdev.coffee_restaurant_system.model;

import com.hungdev.coffee_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "address")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Address extends BaseIdObject {
    @Column(name = "unitNum", nullable = false)
    private int unitNum;

    @Column(name = "streetNum", nullable = false)
    private int streetNum;

    @Column(name = "addressLine", nullable = false, length = 255)
    private String addressLine;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    @Column(name = "postalCode", nullable = false, length = 50)
    private String postalCode;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;

    @OneToMany(mappedBy = "id")
    List<Address> addressList;
}
