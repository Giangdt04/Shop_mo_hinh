package com.example.shopmohinh.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product extends AbtractEntity{
    @Column(name = "CODE")
    private String code;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NAME")
    private String name;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "HIGHT")
    private String hight;
    @Column(name = "WEIGHT")
    private String weight;
    @Column(name = "QUANTITY")
    private Long quantity;
    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;
}
