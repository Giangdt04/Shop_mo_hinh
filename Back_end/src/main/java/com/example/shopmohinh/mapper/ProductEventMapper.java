package com.example.shopmohinh.mapper;

import com.example.shopmohinh.dto.request.ProductEventRequest;
import com.example.shopmohinh.dto.response.ProductEventResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductEventMapper {
    ProductEventResponse toProductEventResponse(ProductEventRequest req);
}
