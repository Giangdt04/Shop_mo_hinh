package com.example.shopmohinh.service;

import com.example.shopmohinh.entity.Product;

import java.util.List;

public interface ElasticSearchService {
    void saveSearchProducts(Product product);

    void delete(Product product);

    void updateByProjectSearch(Product product);

    List<String> autoCompleteSuggestions(String prefix, int limit);
}