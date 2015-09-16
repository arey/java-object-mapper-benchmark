package com.javaetmoi.benchmark.mapping.mapper.orika;

import java.util.concurrent.ConcurrentHashMap;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.impl.NonCyclicMappingContext;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public class OrikaMapper implements OrderMapper {

    private MapperFacade facade;
	private BoundMapperFacade<Order, OrderDTO> boundedMapper;

    public OrikaMapper() {
        MapperFactory factory = new DefaultMapperFactory.Builder()
        .dumpStateOnException(false)
        .mappingContextFactory(new NonCyclicMappingContext.Factory(new ConcurrentHashMap<Object, Object>()))
        .build();
        factory.classMap(Order.class, OrderDTO.class)
                .field("customer.name", "customerName")
                .field("customer.billingAddress.street",
                        "billingStreetAddress")
                .field("customer.billingAddress.city", "billingCity")
                .field("customer.shippingAddress.street",
                        "shippingStreetAddress")
                .field("customer.shippingAddress.city",
                        "shippingCity")
                .field("products", "products")
                .register();
        facade = factory.getMapperFacade();
        boundedMapper = factory.getMapperFacade(Order.class, OrderDTO.class);
    }

    @Override
    public OrderDTO map(Order source) {
        return boundedMapper.map(source);
    }
};

