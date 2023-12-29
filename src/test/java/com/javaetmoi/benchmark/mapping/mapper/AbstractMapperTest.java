package com.javaetmoi.benchmark.mapping.mapper;


import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.OrderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public abstract class AbstractMapperTest {

    @Test
    public void map_with_all_fields() {
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

    @Test
    public void map_with_partial_order() {
        Order order = OrderFactory.buildPartialOrder();
        OrderDTO orderDTO = testedOrderMapper().map(order);
        assertEquals(orderDTO.getCustomerName(), "John Doe");
        assertEquals(orderDTO.getBillingStreetAddress(), "93 Newcastle Dr.");
        assertTrue(orderDTO.getProducts().isEmpty());
    }

    @Test
    public void map_with_empty_order() {
        Order order = new Order();
        OrderDTO orderDTO = testedOrderMapper().map(order);
        assertNotNull(orderDTO);
    }

    protected abstract OrderMapper testedOrderMapper();
}
