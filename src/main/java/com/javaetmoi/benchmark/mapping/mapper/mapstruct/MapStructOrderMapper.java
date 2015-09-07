package com.javaetmoi.benchmark.mapping.mapper.mapstruct;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface MapStructOrderMapper extends OrderMapper {

    @Mappings({
            @Mapping(source = "customer.name", target = "customerName"),
            @Mapping(source = "customer.billingAddress.street", target = "billingStreetAddress"),
            @Mapping(source = "customer.billingAddress.city", target = "billingCity"),
            @Mapping(source = "customer.shippingAddress.street", target = "shippingStreetAddress"),
            @Mapping(source = "customer.shippingAddress.city", target = "shippingCity"),
    })
    OrderDTO map(Order source);

    @Mapping(source = "name", target = "name")
    ProductDTO productToProductDTO(Product product);
}