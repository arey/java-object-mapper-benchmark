package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.jmapper.JMapperMapper;

public class JMapperMapperTest extends AbstractMapperTest {

    @Override
    protected OrderMapper testedOrderMapper() {
        return new JMapperMapper();
    }
}