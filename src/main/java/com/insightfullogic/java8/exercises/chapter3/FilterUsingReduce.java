package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Advanced Exercises Question 2
 */
public class FilterUsingReduce {

    public static <I> List<I> filter(Stream<I> stream, Predicate<I> predicate) {
        List<I> arr = new ArrayList<>();
         List<I> list = stream
                .reduce(arr,
                        (List<I> acc, I e) -> {
                    if (predicate.test(e)) {
                        List<I> newAcc = new ArrayList<>(acc);
                        newAcc.add(e);
                        return newAcc;
                    }
                    return acc; },
                        (List<I> initialAccState, List<I> finalAccState) -> {
                    List<I> c = new ArrayList();
                    c.addAll(initialAccState);
                    c.addAll(finalAccState);
                    return c;
                        } );
        return list;

    }

}
