package com.javaetmoi.benchmark;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

import com.javaetmoi.benchmark.mapping.model.dto.OrderDTO;
import com.javaetmoi.benchmark.mapping.model.entity.Order;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.Result;
import org.openjdk.jmh.results.RunResult;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.javaetmoi.benchmark.mapping.mapper.OrderMapper;
import com.javaetmoi.benchmark.mapping.mapper.dozer.DozerMapper;
import com.javaetmoi.benchmark.mapping.mapper.jmapper.JMapperMapper;
import com.javaetmoi.benchmark.mapping.mapper.manual.ManualMapper;
import com.javaetmoi.benchmark.mapping.mapper.mapstruct.MapStructMapper;
import com.javaetmoi.benchmark.mapping.mapper.modelmapper.ModelMapper;
import com.javaetmoi.benchmark.mapping.mapper.orika.OrikaMapper;
import com.javaetmoi.benchmark.mapping.mapper.selma.SelmaMapper;
import com.javaetmoi.benchmark.mapping.model.entity.OrderFactory;
import org.openjdk.jmh.runner.options.TimeValue;

@State(Scope.Benchmark)
public class MapperBenchmark {

    @Param({"DozerMapper", "JMapperMapper", "ManualMapper", "MapStructMapper", "ModelMapper", "OrikaMapper",  "SelmaMapper"})
    private String type;

    private OrderMapper mapper;
    private Order order;

    @Setup(Level.Trial)
    public void setup(){
        switch (type) {
            case "DozerMapper":
                mapper = new DozerMapper();
                break;
            case "OrikaMapper":
                mapper = new OrikaMapper();
                break;
            case "ModelMapper":
                mapper = new ModelMapper();
                break;
            case "MapStructMapper":
                mapper = new MapStructMapper();
                break;
            case "SelmaMapper":
                mapper = new SelmaMapper();
                break;
            case "JMapperMapper":
                mapper = new JMapperMapper();
                break;
            case "ManualMapper":
                mapper = new ManualMapper();
                break;
            default:
                throw new IllegalStateException("Unknown type: " + type);
        }
    }

    @Setup(Level.Iteration)
    public void preInit(){
        order = OrderFactory.buildOrder();
    }

    @Benchmark
    public void mapper() {
        mapper.map(order);
    }

    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(MapperBenchmark.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .jvmArgs("-server")
                .forks(1)
                .resultFormat(ResultFormatType.TEXT)
                .build();

        Collection<RunResult> results = new Runner(opts).run();
        for (RunResult result : results) {
            Result<?> r = result.getPrimaryResult();
            System.out.println("API replied benchmark score: "
                    + r.getScore() + " "
                    + r.getScoreUnit() + " over "
                    + r.getStatistics().getN() + " iterations");
        }
    }

}
