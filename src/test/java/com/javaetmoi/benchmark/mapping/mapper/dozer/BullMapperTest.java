package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.bull.BullMapper;

public class BullMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new BullMapper();
    }
}
