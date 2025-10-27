package com.hungdev.coffe_restaurant_system.model.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public class BaseIdObject
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}

