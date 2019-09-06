package com.javaetmoi.benchmark.mapping.mapper.bull;

import com.hotels.beans.BeanUtils;
import com.hotels.transformer.Transformer;
import com.hotels.transformer.model.FieldMapping;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

/**
 * BULL mapper.
 * For more details see: https://github.com/HotelsDotCom/bull.
 */
public class BullMapper implements OrderMapper {
    private final Transformer transformer;

    public BullMapper() {
        FieldMapping[] fieldMappings = new FieldMapping[] {
                new FieldMapping("customer.name", "customerName"),
                new FieldMapping("customer.billingAddress.city", "billingCity"),
                new FieldMapping("customer.billingAddress.street", "billingStreetAddress"),
                new FieldMapping("customer.shippingAddress.city", "shippingCity"),
                new FieldMapping("customer.shippingAddress.street", "shippingStreetAddress")
        };
        this.transformer = new BeanUtils().getTransformer().withFieldMapping(fieldMappings);
    }

    @Override
    public OrderDTO map(Order source) {
        return transformer.transform(source, OrderDTO.class);
    }
}