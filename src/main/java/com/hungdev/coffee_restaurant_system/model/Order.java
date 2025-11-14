package com.hungdev.coffee_restaurant_system.model;

import com.hungdev.coffee_restaurant_system.model.base.BaseIdObject;
import com.hungdev.coffee_restaurant_system.model.constants.StatusName;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order extends BaseIdObject {

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User userId;

    @Column(name = "orderDate")
    private Timestamp orderDate;

    @Column(name = "totalAmount", precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusName status;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;

    @OneToOne(mappedBy = "orderId")
    private OrderItem orderItem;

    @OneToMany(mappedBy = "id")
    List<ApplyDiscount> applyDiscountList;
}
