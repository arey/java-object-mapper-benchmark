package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.modelmapper.ModelMapper;


public class ModelMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new ModelMapper();
    }
}
