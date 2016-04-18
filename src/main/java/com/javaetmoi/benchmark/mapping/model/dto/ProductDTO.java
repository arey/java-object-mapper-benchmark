package com.javaetmoi.benchmark.mapping.model.dto;

public class ProductDTO {
    
	private String name;

    public ProductDTO() {

    }

    public ProductDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}