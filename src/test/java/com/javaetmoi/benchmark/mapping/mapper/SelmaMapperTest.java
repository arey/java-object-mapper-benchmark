package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.selma.SelmaMapper;

public class SelmaMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new SelmaMapper();
    }
}
