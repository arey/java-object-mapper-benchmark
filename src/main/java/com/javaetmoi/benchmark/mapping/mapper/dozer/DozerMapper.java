package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;

import java.util.Collections;

public class DozerMapper implements OrderMapper {

    private Mapper beanMapper;

    public DozerMapper() {
        beanMapper = DozerBeanMapperBuilder
                .create()
                .withMappingFiles(Collections.singletonList("com/javaetmoi/benchmark/mapping/mapper/dozer/dozer.xml"))
                .build();
    }

    @Override
    public OrderDTO map(Order source) {
        return beanMapper.map(source, OrderDTO.class);
    }
}



