package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.datus.DatusMapper;

public class DatusMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new DatusMapper();
    }
}
