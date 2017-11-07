package com.javaetmoi.benchmark;

import java.util.Collection;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
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

@State(Scope.Benchmark)
public class MapperBenchmark {

    private OrderMapper dozerMapper = new DozerMapper();

    private OrderMapper orikaMapper = new OrikaMapper();

    private OrderMapper modelMapper = new ModelMapper();

    private OrderMapper mapStructMapper = new MapStructMapper();

    private OrderMapper selmaMapper = new SelmaMapper();

    private OrderMapper jmapperMapper = new JMapperMapper();
    
    private OrderMapper manualMapper = new ManualMapper();

    @Benchmark
    public void Dozer() {
        dozerMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void Orika() {
        orikaMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void ModelMapper() {
        modelMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void MapStruct() {
        mapStructMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void Selma() {
        selmaMapper.map(OrderFactory.buildOrder());
    }

    @Benchmark
    public void JMapper() {
        jmapperMapper.map(OrderFactory.buildOrder());
    }
    
    @Benchmark
    public void Manual() {
        manualMapper.map(OrderFactory.buildOrder());
    }

    public static void main(String... args) throws Exception {
        Options opts = new OptionsBuilder()
                .include(".*")
                .warmupIterations(2)
                .measurementIterations(2)
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
