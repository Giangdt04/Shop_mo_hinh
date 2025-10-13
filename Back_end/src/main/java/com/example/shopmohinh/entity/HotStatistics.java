package com.example.shopmohinh.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Table(name = "hot_statistics")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HotStatistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "type")
    Integer type;

    @Column(name = "product_id")
    Long productId;

    @Column(name = "keyword")
    String keyword;

    @Column(name = "count_value")
    Long countValue;

    @Column(name = "created_at")
    LocalDateTime createdAt;
}
