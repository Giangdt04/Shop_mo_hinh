package com.example.shopmohinh.entity.elasticsearch;

import com.example.shopmohinh.entity.AbtractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@ToString
@Document(indexName = "product")
public class ProductSearchEntity{
    //  FieldType.Keyword: dùng cho dữ liệu không cần phân tích (như mã, trạng thái…)
//  FieldType.Text: dùng cho dữ liệu có thể tìm kiếm full-text
//  analyzer = "standard": bộ phân tích mặc định của Elasticsearch (dùng để tách từ)
    @Id
    String id;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String name;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String code;


}
