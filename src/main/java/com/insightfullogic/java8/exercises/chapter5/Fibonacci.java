package com.insightfullogic.java8.exercises.chapter5;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private Map<Integer, Long> fibonacciNumbersMap;

    public Fibonacci() {
        fibonacciNumbersMap = new HashMap<>();
        fibonacciNumbersMap.put(0, 0L);
        fibonacciNumbersMap.put(1, 1L);
    }

    public long fibonacci(int x) {
        return fibonacciNumbersMap.computeIfAbsent(x, v -> fibonacci(x-1)+ fibonacci(x-2));
    }
}
