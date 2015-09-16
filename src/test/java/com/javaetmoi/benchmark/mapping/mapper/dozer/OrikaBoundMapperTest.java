package com.javaetmoi.benchmark.mapping.mapper.dozer;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaBoundMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaMapper;

public class OrikaBoundMapperTest extends AbstractMapperTest {
    @Override
    protected OrderMapper testedOrderMapper() {
        return new OrikaBoundMapper();
    }
}
