package com.hungdev.coffe_restaurant_system.model;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import com.hungdev.coffe_restaurant_system.model.constants.DiscountTypeName;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "discount")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Discount extends BaseIdObject {

    @Column(name = "description", length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "discount_type", nullable = false)
    private DiscountTypeName discountType;

    @Column(name = "discount_value", precision = 5, scale = 2)
    private BigDecimal discountValue;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;

    @OneToMany(mappedBy = "id")
    List<ApplyDiscount> applyDiscountList;
}
