package com.example.shopmohinh.repository;

import com.example.shopmohinh.dto.projection.ProductProjection;
import com.example.shopmohinh.dto.search.ProductSearch;
import com.example.shopmohinh.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public static final String SELECT = """
            select p.id as 'id',
                           p.code as 'code',
                           p.DESCRIPTION as 'description',
                           p.HEIGHT as 'height',
                           p.NAME as 'name',
                           p.PRICE as 'price',
                           p.QUANTITY as 'quantity',
                           p.WEIGHT as 'weight',
                           p.STATUS as 'status',
                           i.is_main as 'mainImage',
                           i.image_url as 'imageUrl',
                           i.id as 'idImage'
            """;
    public static final String FROM = """
            from product p
            left join image i on p.ID = i.product_id and i.is_main = true
            """;
    public static final String SEARCH = """
             where (:#{#request.keyword} is null or p.code like CONCAT(:#{#request.keyword}, '%'))
                   or (:#{#request.keyword} is null or p.name like CONCAT(:#{#request.keyword}, '%')) 
            """;
    public static final String FILTER = """
             where  (:#{#request.price} is null or p.price = :#{#request.price} )
                    and (:#{#request.weight} is null or p.WEIGHT = :#{#request.weight} )
                    and (:#{#request.height} is null or p.HEIGHT = :#{#request.height} )
            """;
    public static final String ORDER_BY = """
            order by p.CREATED_DATE desc
            """;

    @Query(value = """
            select * from product order by product.id desc limit 1
            """, nativeQuery = true)
    Product getTop1();

    @Query(value = SELECT + FROM + SEARCH + ORDER_BY, nativeQuery = true)
    Page<ProductProjection> getAll(ProductSearch request, Pageable pageable);

    Optional<Product> existsProductById(Long id);

    Optional<Product> findByCode(String code);
}
