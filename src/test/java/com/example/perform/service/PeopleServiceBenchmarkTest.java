package com.example.perform.service;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class PeopleServiceBenchmarkTest {

    @Test
    public void testPeopleServiceBenchmark() throws Exception {
        Options options = new OptionsBuilder()
                .include(PeopleServiceBenchmark.class.getSimpleName())
                .forks(0)
                .threads(1)
                .warmupIterations(5)
                .warmupTime(TimeValue.milliseconds(200))
                .measurementIterations(5)
                .measurementTime(TimeValue.milliseconds(200))
                .timeUnit(TimeUnit.MICROSECONDS)
                .mode(Mode.AverageTime)
                .build();

        new Runner(options).run();
    }

}
