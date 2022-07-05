package com.cardocker.ecommerce.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="bodystyle")
public class BodyStyle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bodystyle_id")
    private Long id;

    @Column(name="bodystyle_name")
    private String bodyStyleName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodyStyle")
    private List<Car> cars;
}
