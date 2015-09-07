package com.javaetmoi.benchmark.mapping.mapper.selma;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import fr.xebia.extras.selma.Selma;

public class SelmaMapper implements OrderMapper {

    private SelmaOrderMapper mapper = Selma.builder(SelmaOrderMapper.class).build();

    @Override
    public OrderDTO map(Order source) {
        return mapper.map(source);
    }
}
