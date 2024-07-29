package com.example.shopmohinh.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "category")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbtractEntity{
    private String code;

    private String name;

    private String status;
}
