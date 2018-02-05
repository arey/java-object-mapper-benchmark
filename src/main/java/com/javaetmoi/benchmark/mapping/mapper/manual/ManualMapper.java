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
            if (customer.getBillingAddress() != null) {
                target.setBillingCity(customer.getBillingAddress().getCity());
                target.setBillingStreetAddress(customer.getBillingAddress().getStreet());
            }
            if (customer.getShippingAddress() != null) {
                target.setShippingCity(customer.getShippingAddress().getCity());
                target.setShippingStreetAddress(customer.getShippingAddress().getStreet());
            }
        }
        if (source.getProducts() != null) {
            List<ProductDTO> targetProducts = new ArrayList<ProductDTO>(source.getProducts().size());
            for (Product product : source.getProducts()) {
                targetProducts.add(new ProductDTO(product.getName()));
            }
            target.setProducts(targetProducts);
        }
        return target;
    }

}
