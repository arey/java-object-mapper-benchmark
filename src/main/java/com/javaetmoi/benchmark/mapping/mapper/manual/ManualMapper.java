package com.javaetmoi.benchmark.mapping.mapper.manual;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.dto.ProductDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Address;
import com.javaetmoi.benchmark.mapping.model.entity.Customer;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import com.javaetmoi.benchmark.mapping.model.entity.Product;

import java.util.ArrayList;
import java.util.List;


public final class ManualMapper implements OrderMapper {

    @Override
    public OrderDTO map(Order source) {
        OrderDTO target = new OrderDTO();
        Customer customer = source.getCustomer();
        if (customer != null) {
            target.setCustomerName(customer.getName());
            mapBillingAddress(target, customer.getBillingAddress());
            mapShippingAddress(target, customer.getShippingAddress());
        }
        mapProducts(source, target);
        return target;
    }

    private void mapShippingAddress(OrderDTO target, Address shippingAddress) {
        if (shippingAddress != null) {
            target.setShippingCity(shippingAddress.getCity());
            target.setShippingStreetAddress(shippingAddress.getStreet());
        }
    }

    private void mapBillingAddress(OrderDTO target, Address billingAddress) {
        if (billingAddress != null) {
            target.setBillingCity(billingAddress.getCity());
            target.setBillingStreetAddress(billingAddress.getStreet());
        }
    }

    private void mapProducts(Order source, OrderDTO target) {
        if (source.getProducts() == null) {
            return;
        }
        List<ProductDTO> targetProducts = new ArrayList<ProductDTO>(source.getProducts().size());
        for (Product product : source.getProducts()) {
            targetProducts.add(new ProductDTO(product.getName()));
        }
        target.setProducts(targetProducts);
    }
}
