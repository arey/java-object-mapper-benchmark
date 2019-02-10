package com.javaetmoi.benchmark.mapping.mapper.bull;

import com.hotels.beans.BeanUtils;
import com.hotels.beans.model.FieldTransformer;
import com.hotels.beans.transformer.Transformer;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Customer;
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
                .withFieldTransformer(getCustomerTransformers(source.getCustomer()))
                .transform(source, OrderDTO.class);
    }

    private FieldTransformer[] getCustomerTransformers(Customer customer) {
        return new FieldTransformer[]{
                new FieldTransformer<>("customerName", val -> customer.getName()),
                new FieldTransformer<>("billingStreetAddress", val -> customer.getBillingAddress().getStreet()),
                new FieldTransformer<>("billingCity", val -> customer.getBillingAddress().getCity()),
                new FieldTransformer<>("shippingStreetAddress", val -> customer.getShippingAddress().getStreet()),
                new FieldTransformer<>("shippingCity", val -> customer.getShippingAddress().getCity()),
        };
    }
}