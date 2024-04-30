package com.landcharms.mono.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Spaces extends RepresentationModel<Spaces> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private double acres;
    private String description;
    @OneToOne
    private Address address;
    @ManyToOne
    private Category category;
    @ManyToOne
    private UserLand owner;

}
