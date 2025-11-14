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
@Table(name = "category")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category extends BaseIdObject {

    @Column(name = "categoryName", nullable = false, length = 255)
    private String categoryName;

    @Column(name = "updateAt", updatable = false, insertable = false)
    private Timestamp updateAt;

    @Column(name = "createAt", updatable = false, insertable = false)
    private Timestamp createAt;

    @OneToMany(mappedBy = "id")
    List<Product> productList;
}
