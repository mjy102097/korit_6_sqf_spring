package com.study.rest.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

@Builder
@Data
public class Car {
    private String model;
    private String color;
}
