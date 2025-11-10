package com.hungdev.coffe_restaurant_system.model;

import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "applyDiscount")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApplyDiscount extends BaseIdObject {

    @ManyToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "discountId", nullable = false)
    private Discount discountId;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
