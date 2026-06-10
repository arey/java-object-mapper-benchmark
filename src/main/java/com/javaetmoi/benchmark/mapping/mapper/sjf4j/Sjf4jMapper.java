package com.javaetmoi.benchmark.mapping.mapper.sjf4j;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import org.sjf4j.compiled.CompiledNodes;


public class Sjf4jMapper implements OrderMapper {

    private final Sjf4jOrderMapper mapper = CompiledNodes.of(Sjf4jOrderMapper.class);

    @Override
    public OrderDTO map(Order source) {
        return mapper.map(source);
    }
}
