package com.luv2code.ecommerce.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class TrialClass {
    @Id
    private Long id;
    private String myString;
    private Integer price;
}
