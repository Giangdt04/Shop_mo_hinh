package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.CartDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetailEntity,Long> {
    CartDetailEntity getTop1();

    @Modifying
    @Query(value = """
            DELETE FROM cart_detail WHERE product_id IN (:productIds);
            """,nativeQuery=true)
    int deleteByProductIds(List<Long> productIds);
}
