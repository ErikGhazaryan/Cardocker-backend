package com.cardocker.ecommerce.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CarMake {

    private Long id;

    private String makeName;

    private String modelName;

    private BigDecimal price;

    private int seats;

    private LocalDate yearOfProduction;

    private String imageUrl;

    private String sellerDescription;

    private String bodyStyle;
}
