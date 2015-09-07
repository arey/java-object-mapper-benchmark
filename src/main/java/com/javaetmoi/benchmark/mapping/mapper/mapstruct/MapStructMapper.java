package com.javaetmoi.benchmark.mapping.mapper.mapstruct;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import org.mapstruct.factory.Mappers;


public class MapStructMapper implements OrderMapper {

    MapStructOrderMapper mapper = Mappers.getMapper(MapStructOrderMapper.class);

    @Override
    public OrderDTO map(Order source) {
        return mapper.map(source);
    }
}
