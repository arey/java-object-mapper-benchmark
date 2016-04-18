package com.javaetmoi.benchmark.mapping.mapper.jmapper;

import com.googlecode.jmapper.JMapper;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

public class JMapperMapper implements OrderMapper {

	JMapper<OrderDTO, Order> mapper = new JMapper<OrderDTO, Order>(OrderDTO.class, Order.class);

	@Override
	public OrderDTO map(Order source) {
		return mapper.getDestination(source);
	}

}
