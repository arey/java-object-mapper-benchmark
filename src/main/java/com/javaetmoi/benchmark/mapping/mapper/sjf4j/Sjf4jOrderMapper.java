package com.javaetmoi.benchmark.mapping.mapper.sjf4j;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;
import org.sjf4j.annotation.mapper.CompiledMapper;
import org.sjf4j.annotation.mapper.Mapping;
import org.sjf4j.annotation.mapper.Mappings;

@CompiledMapper
public interface Sjf4jOrderMapper extends OrderMapper {

    @Mappings({
            @Mapping(target = "customerName", source = "$.customer.name"),
            @Mapping(target = "billingStreetAddress", source = "$.customer.billingAddress.street"),
            @Mapping(target = "billingCity", source = "$.customer.billingAddress.city"),
            @Mapping(target = "shippingStreetAddress", source = "$.customer.shippingAddress.street"),
            @Mapping(target = "shippingCity", source = "$.customer.shippingAddress.city"),
    })
    OrderDTO map(Order source);

    ProductDTO productToProductDTO(Product product);

}