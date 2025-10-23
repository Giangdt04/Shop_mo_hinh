package com.example.shopmohinh.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_product_view_log")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserProductViewLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "user_id")
    Long userId;
    @Column(name = "product_id")
    Long productId;
    @Column(name = "category_id")
    Long categoryId;
    @Column(name = "viewed_at")
    LocalDateTime viewedAt;
    @Column(name = "action_type")
    Integer actionType;
}
