package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 1
 */
public class MapUsingReduce {

    public static <I, O> List<O> map(Stream<I> stream, Function<I, O> mapper) {
        List<O> initialAcc = new ArrayList<>();
        return stream.reduce(initialAcc,
                (List<O> acc, I e) -> {
            List<O> newAcc = new ArrayList<>(acc);
            newAcc.add(mapper.apply(e));
            return newAcc;
                },
                (List<O> initAcc, List<O> finalAcc) ->{
            List<O> c = new ArrayList<>(initAcc);
            c.addAll(finalAcc);
            return c;
                });

    }

}
