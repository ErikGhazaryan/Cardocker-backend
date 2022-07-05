package com.cardocker.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Make {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="make_id")
    private Long id;

    @Column(name ="make_name")
    private String makeName;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "make")
    private List<Car> cars;
}
