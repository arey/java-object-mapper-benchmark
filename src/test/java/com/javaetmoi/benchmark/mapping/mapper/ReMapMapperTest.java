package com.javaetmoi.benchmark.mapping.mapper;

import com.javaetmoi.benchmark.mapping.mapper.remappe.ReMappeMapper;

public class ReMapMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new ReMappeMapper();
    }
}
