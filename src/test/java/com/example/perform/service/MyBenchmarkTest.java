package com.example.perform.service;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

public class MyBenchmarkTest {
    @Test
    public void testMyBenchmark() throws Exception {
            Options options = new OptionsBuilder()
            .include(MyBenchmark.class.getSimpleName())
            .forks(1)
            .threads(1)
            .warmupIterations(2)
            .warmupTime(TimeValue.milliseconds(200))
            .measurementIterations(5)
            .measurementTime(TimeValue.milliseconds(200))
            .timeUnit(TimeUnit.MICROSECONDS)
            .mode(Mode.AverageTime)
            .build();

        new Runner(options).run();
    }
}
