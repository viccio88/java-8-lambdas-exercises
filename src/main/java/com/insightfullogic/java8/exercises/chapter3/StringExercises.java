package com.insightfullogic.java8.exercises.chapter3;

import com.insightfullogic.java8.exercises.Exercises;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StringExercises {

    // Question 7
    public static int countLowercaseLetters(String string) {
        return (int)string.chars().filter(c -> Character.isLowerCase(c)).count();
    }

    // Question 8
    public static Optional<String> mostLowercaseString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(StringExercises::countLowercaseLetters));

    }
}
