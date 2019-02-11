package com.javaetmoi.benchmark.mapping.mapper.bull;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.model.FieldMapping;
import com.hotels.beans.transformer.Transformer;
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
        this.transformer = new BeanUtils().getTransformer();
    }

    @Override
    public OrderDTO map(Order source) {
        return transformer
                .withFieldMapping(getCustomerFieldMappings())
                .transform(source, OrderDTO.class);
    }

    private FieldMapping[] getCustomerFieldMappings() {
        return new FieldMapping[] {
            new FieldMapping("customer.name", "customerName"),
            new FieldMapping("customer.billingAddress.city", "billingCity"),
            new FieldMapping("customer.billingAddress.street", "billingStreetAddress"),
            new FieldMapping("customer.shippingAddress.city", "shippingCity"),
            new FieldMapping("customer.shippingAddress.street", "shippingStreetAddress")
        };
    }
}