package com.example.shopmohinh.repository.jpa;

import com.example.shopmohinh.dto.projection.CategoryTrendingProjection;
import com.example.shopmohinh.dto.projection.ProductTrendingProjection;
import com.example.shopmohinh.entity.UserProductViewLogEntity;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserProductViewLogRepository extends JpaRepository<UserProductViewLogEntity, Long> {

    @Query(value = """
                        WITH past_week AS (
                            SELECT product_id, COUNT(*) AS past_views
                            FROM user_product_view_log
                            WHERE viewed_at >= CURDATE() - INTERVAL 14 DAY
                              AND viewed_at <  CURDATE() - INTERVAL 7 DAY
                            GROUP BY product_id
                        ),
                             current_week AS (
                                 SELECT product_id, COUNT(*) AS current_views
                                 FROM user_product_view_log
                                 WHERE viewed_at >= CURDATE() - INTERVAL 7 DAY
                                 GROUP BY product_id
                             )
                        SELECT
                            c.product_id as productId,
                            c.current_views as currentViews,
                            p.past_views as pastViews,
            --              Cột growth_percent thể hiện phần trăm tăng trưởng lượt xem trong tuần này so với tuần trước.
                            ROUND((c.current_views - p.past_views) / NULLIF(p.past_views, 0) * 100, 2) AS growthPercent
                        FROM current_week c
                                 JOIN past_week p ON c.product_id = p.product_id
                        WHERE c.current_views > p.past_views
                        ORDER BY growthPercent DESC
                        LIMIT 3
            """, nativeQuery = true)
    List<ProductTrendingProjection> getTop3ProductTrendingOn7day();

    @Query(value = """
            SELECT
                c.category_id AS categoryId,
                cat.name AS categoryName,
                COUNT(*) AS totalViews
            FROM user_product_view_log c
                     JOIN category cat ON c.category_id = cat.id
            WHERE c.viewed_at >= CURDATE() - INTERVAL :intervalDate DAY
            GROUP BY c.category_id, cat.name
            ORDER BY totalViews DESC
            LIMIT 5
            """, nativeQuery = true)
    List<CategoryTrendingProjection> getTop5CategoryTrending(@Param("intervalDate") Integer intervalDate);

}
