package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;

public class DozerMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new DozerMapper();
    }
}