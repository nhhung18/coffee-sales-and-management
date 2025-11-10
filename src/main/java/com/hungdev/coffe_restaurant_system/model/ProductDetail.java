package com.hungdev.coffe_restaurant_system.model;

import com.hungdev.coffe_restaurant_system.model.base.BaseIdObject;
import com.hungdev.coffe_restaurant_system.model.constants.RoastLevelName;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table(name = "productDetail")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ProductDetail extends BaseIdObject {

    @OneToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product productId;

    @Column(name = "origin", nullable = false, length = 255)
    private String origin;

    @Enumerated(EnumType.STRING)
    @Column(name = "roastLevel", nullable = false)
    private RoastLevelName roastLevel;

    @Column(name = "flavorNotes", length = 255)
    private String flavorNotes;

    @Column(name = "varietal", length = 255)
    private String varietal;

    @Column(name = "processingMethod", length = 255)
    private String processingMethod;

    @Column(name = "grindOptions", length = 255)
    private String grindOptions;

    @Column(name = "basicUser")
    private boolean basicUser;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;
}
