package com.javaetmoi.benchmark.mapping.model.dto;

import java.util.List;

import com.googlecode.jmapper.annotations.JMap;

public class OrderDTO {
	@JMap
    private List<ProductDTO> products;
    String customerName;
    @JMap("customer.shippingAddress.street")
    private String shippingStreetAddress;
    @JMap("customer.shippingAddress.city")
    private String shippingCity;
    @JMap("customer.billingAddress.street")
    private String billingStreetAddress;
    @JMap("customer.billingAddress.city")
    private String billingCity;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getShippingStreetAddress() {
        return shippingStreetAddress;
    }

    public void setShippingStreetAddress(String shippingStreetAddress) {
        this.shippingStreetAddress = shippingStreetAddress;
    }

    public String getShippingCity() {
        return shippingCity;
    }

    public void setShippingCity(String shippingCity) {
        this.shippingCity = shippingCity;
    }

    public String getBillingStreetAddress() {
        return billingStreetAddress;
    }

    public void setBillingStreetAddress(String billingStreetAddress) {
        this.billingStreetAddress = billingStreetAddress;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public List<ProductDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDTO> products) {
        this.products = products;
    }
}