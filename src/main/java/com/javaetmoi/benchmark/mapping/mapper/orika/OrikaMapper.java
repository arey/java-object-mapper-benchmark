package com.javaetmoi.benchmark.mapping.mapper.orika;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public class OrikaMapper implements OrderMapper {

    private MapperFacade facade;

    public OrikaMapper() {
        MapperFactory factory = new DefaultMapperFactory.Builder().build();
        factory.registerClassMap(ClassMapBuilder.map(Order.class, OrderDTO.class)
                .field("customer.name", "customerName")
                .field("customer.billingAddress.street",
                        "billingStreetAddress")
                .field("customer.billingAddress.city", "billingCity")
                .field("customer.shippingAddress.street",
                        "shippingStreetAddress")
                .field("customer.shippingAddress.city",
                        "shippingCity")
                .field("products", "products")
                .toClassMap());
        factory.build();
        facade = factory.getMapperFacade();
    }

    @Override
    public OrderDTO map(Order source) {
        return facade.map(source, OrderDTO.class);
    }
};

