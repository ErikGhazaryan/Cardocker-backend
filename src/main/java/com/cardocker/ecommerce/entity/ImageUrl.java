package com.cardocker.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class ImageUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="image_id")
    private Long id;

    @Column(name="image_url")
    private String imageUrlString;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
}
