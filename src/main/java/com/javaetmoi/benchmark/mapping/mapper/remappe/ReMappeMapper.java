package com.javaetmoi.benchmark.mapping.mapper.remappe;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Address;
import com.javaetmoi.benchmark.mapping.model.entity.Customer;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;
import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public final class ReMappeMapper implements OrderMapper {

    private final Mapper<Product, ProductDTO> mapperToDtoProduct = Mapping
        .from(Product.class)
        .to(ProductDTO.class)
        .mapper();

    private final Mapper<Order, OrderDTO> mapperToDto = Mapping
        .from(Order.class)
        .to(OrderDTO.class)
        .replace(Order::getCustomer, OrderDTO::getCustomerName).withSkipWhenNull(customer -> customer.getName())
        .replace(Order::getCustomer, OrderDTO::getBillingStreetAddress).withSkipWhenNull(customer -> {
            Address billingAddress = customer.getBillingAddress();
            return Objects.nonNull(billingAddress)
                ? billingAddress.getStreet()
                : null;
        })
        .replace(Order::getCustomer, OrderDTO::getBillingCity).withSkipWhenNull(customer -> {
            Address billingAddress = customer.getBillingAddress();
            return Objects.nonNull(billingAddress)
                ? billingAddress.getCity()
                : null;
        })
        .replace(Order::getCustomer, OrderDTO::getShippingStreetAddress).withSkipWhenNull(customer -> {
            Address shippingAddress = customer.getShippingAddress();
            return Objects.nonNull(shippingAddress)
                ? shippingAddress.getStreet()
                : null;
        })
        .replace(Order::getCustomer, OrderDTO::getShippingCity).withSkipWhenNull(customer -> {
            Address shippingAddress = customer.getShippingAddress();
            return Objects.nonNull(shippingAddress)
                ? shippingAddress.getCity()
                : null;
        })
        .useMapper(mapperToDtoProduct)
        .mapper();

    @Override
    public OrderDTO map(Order source) {
        return mapperToDto.map(source);
    }

}
