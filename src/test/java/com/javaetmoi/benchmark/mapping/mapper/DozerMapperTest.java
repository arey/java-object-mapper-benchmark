package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.dozer.DozerMapper;

public class DozerMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new DozerMapper();
    }
}