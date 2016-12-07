package com.javaetmoi.benchmark.mapping.mapper.dozer;


import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractMapperTest {

    @Test
    public void map() {
        Order order = OrderFactory.buildOrder();
        OrderDTO orderDTO = testedOrderMapper().map(order);
        assertEquals(orderDTO.getCustomerName(), "Joe Smith");
        assertEquals(orderDTO.getBillingStreetAddress(), "1234 Market Street");
        assertEquals(orderDTO.getBillingCity(), "San Fran");
        assertEquals(orderDTO.getShippingStreetAddress(), "1234 West Townsend");
        assertEquals(orderDTO.getShippingCity(), "Boston");
        assertEquals(orderDTO.getProducts().get(0).getName(), "socks");
        assertEquals(orderDTO.getProducts().get(1).getName(), "shoes");
    }

    protected abstract OrderMapper testedOrderMapper();
}
