package com.hungdev.coffe_restaurant_system.model;

import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "orderItem")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class OrderItem extends BaseIdObject {

    @OneToOne
    @JoinColumn(name = "orderId", nullable = false)
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice", precision = 10, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
