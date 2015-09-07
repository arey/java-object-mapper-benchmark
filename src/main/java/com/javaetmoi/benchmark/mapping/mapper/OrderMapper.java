package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

public interface OrderMapper {
    OrderDTO map(Order source);
}