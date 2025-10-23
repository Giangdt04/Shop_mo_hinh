package com.example.shopmohinh.repository.elasticsearch;

import com.example.shopmohinh.entity.elasticsearch.ProductSearchEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<ProductSearchEntity, Long> {

    ProductSearchEntity findByCode(String code);

    @Query("""
            {
              "bool": {
                "should": [
                  { "match_phrase_prefix": { "name": "?0" } }
                ]
              }
            }
            """)
    List<ProductSearchEntity> autoCompleteByPrefix(String prefix, Pageable pageable);


}
