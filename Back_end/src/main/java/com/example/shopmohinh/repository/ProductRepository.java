package com.example.shopmohinh.repository;

import com.example.shopmohinh.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query(value = """
            select * from product order by product.id desc limit 1
            """,nativeQuery = true)
    Product getTop1();

    Optional<Product> findByCode(String code);
}
