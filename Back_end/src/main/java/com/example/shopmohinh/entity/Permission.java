package com.example.shopmohinh.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "permission")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Permission extends AbtractEntity{
    @Column(name = "NAME")
    String name;

}
