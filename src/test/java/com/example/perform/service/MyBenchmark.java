package com.example.perform.service;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@State(Scope.Thread)
public class MyBenchmark {
    private List<String> list;

    @Setup
    public void setup() {
            list = new ArrayList<>();
        for (int i = 0; i < 10000; i ++ ) {
                list.add(UUID.randomUUID().toString());
        }
        System.out.println("Init complete");
    }

    @TearDown
    public void tearDown() {
            list = null;
        System.out.println("Tear down complete");
    }

    @Benchmark
    public void testSort() {
            Collections.sort(list);
    }
}
