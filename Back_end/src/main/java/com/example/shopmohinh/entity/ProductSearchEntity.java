package com.example.shopmohinh.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Document(indexName = "product")
public class ProductSearchEntity extends AbtractEntity {
//  FieldType.Keyword: dùng cho dữ liệu không cần phân tích (như mã, trạng thái…)
//  FieldType.Text: dùng cho dữ liệu có thể tìm kiếm full-text
//  analyzer = "standard": bộ phân tích mặc định của Elasticsearch (dùng để tách từ)
    @Field(type = FieldType.Text, analyzer = "standard")
    private String code;
    @Field(type = FieldType.Integer)
    private int status;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String name;
    @Field(type = FieldType.Text, analyzer = "standard")
    private String description;
    @Field(type = FieldType.Double)
    private BigDecimal price;
}
