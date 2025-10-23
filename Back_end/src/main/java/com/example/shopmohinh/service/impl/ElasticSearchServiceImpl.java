package com.example.shopmohinh.service.impl;

import com.example.shopmohinh.entity.Product;
import com.example.shopmohinh.entity.elasticsearch.ProductSearchEntity;
import com.example.shopmohinh.repository.elasticsearch.ProductSearchRepository;
import com.example.shopmohinh.service.ElasticSearchService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ElasticSearchServiceImpl implements ElasticSearchService {
    ProductSearchRepository searchRepository;

    @Override
    public List<String> autoCompleteSuggestions(String prefix, int limit) {
        if (prefix == null || prefix.trim().isEmpty() || prefix.length() < 1) {
            return List.of();
        }

        try {
            // Gợi ý autocomplete dựa trên name
            List<ProductSearchEntity> docs = searchRepository
                    .autoCompleteByPrefix(prefix.toLowerCase(), PageRequest.of(0, limit * 2));

            return docs.stream()
                    .map(ProductSearchEntity::getName)
                    .filter(Objects::nonNull)
                    .distinct()
                    .limit(limit)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.err.println("Lỗi autocomplete: " + e.getMessage());
            return List.of();
        }
    }



    @Override
    public void saveSearchProducts(Product product){
        ProductSearchEntity productSearch = new ProductSearchEntity();
        productSearch.setCode(product.getCode());
        productSearch.setName(product.getName());
        searchRepository.save(productSearch);
    }

    @Override
    public void delete(Product product){
        ProductSearchEntity deleteProduct = searchRepository.findByCode(product.getCode());
        if (deleteProduct != null) {
            searchRepository.delete(deleteProduct);
        }
    }

    public void updateByProjectSearch(Product product){
        ProductSearchEntity search = searchRepository.findByCode(product.getCode());
        if (search != null) {
            search.setCode(product.getCode());
            search.setName(product.getName());
            searchRepository.save(search);
        }else{
            this.saveSearchProducts(product);
        }
    }




}
