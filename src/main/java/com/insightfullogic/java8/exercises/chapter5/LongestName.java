package com.insightfullogic.java8.exercises.chapter5;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class LongestName {

    public static Artist byReduce(List<Artist> artists) {
        Comparator<Artist> comparator = Comparator.comparingInt(a -> a.getName().length());
        return artists.stream()
                //.flatMap(band -> band.getMembers())
                .reduce((acc, artist) -> acc = comparator.compare(artist, acc) >0 ? artist : acc)
                .orElse(null);
    }

    public static Artist byCollecting(List<Artist> artists) {
        Comparator<Artist> comparator = Comparator.comparingInt(a -> a.getName().length());
        return artists.stream()
                //.flatMap(band -> band.getMembers())
                .collect(Collectors.maxBy(comparator)).orElse(null);
    }

}
