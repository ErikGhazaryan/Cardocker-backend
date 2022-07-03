package com.luv2code.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "make_id", nullable = false)
    private Make make;

    @ManyToOne
    @JoinColumn(name = "bodystyle_id")
    private BodyStyle bodyStyle;

    @Column(name="model_name")
    private String modelName;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="seller_description")
    private String sellerDescription;

    @Column(name = "seats")
    private int seats;

    @Column(name = "year_of_production")
    private LocalDate yearOfProduction;

    @Column(name = "image_url")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "car")
    private List<ImageUrl> imageUrl;







}
