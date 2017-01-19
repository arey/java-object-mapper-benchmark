package com.javaetmoi.benchmark.mapping.mapper.selma;

import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.Mapper;

@Mapper(
        withCustomFields = {
                @Field({"customer.name", "customerName"}),
                @Field({"customer.billingAddress.street", "billingStreetAddress"}),
                @Field({"customer.billingAddress.city", "billingCity"}),
                @Field({"customer.shippingAddress.street", "shippingStreetAddress"}),
                @Field({"customer.shippingAddress.city", "shippingCity"})
        }
)
public interface SelmaOrderMapper {

    OrderDTO map(Order source);

    ProductDTO map(Product product);
}
