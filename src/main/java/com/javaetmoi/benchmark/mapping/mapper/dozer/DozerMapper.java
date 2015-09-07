package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import org.dozer.DozerBeanMapper;

import java.util.Arrays;

public class DozerMapper implements OrderMapper {

    private DozerBeanMapper beanMapper = new DozerBeanMapper();

    public DozerMapper() {
        beanMapper.setMappingFiles(Arrays.asList("com/javaetmoi/benchmark/mapping/mapper/dozer/dozer.xml"));
    }

    @Override
    public OrderDTO map(Order source) {
        return beanMapper.map(source, OrderDTO.class);
    }
}



