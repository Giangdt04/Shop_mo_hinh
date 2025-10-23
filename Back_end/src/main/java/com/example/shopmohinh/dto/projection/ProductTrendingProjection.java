package com.example.shopmohinh.dto.projection;

public interface ProductTrendingProjection {
    Long getProductId();
    Long getCurrentViews();
    Long getPastViews();
    Double getGrowthPercent();

}
