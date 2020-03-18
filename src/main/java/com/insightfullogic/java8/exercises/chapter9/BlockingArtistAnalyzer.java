package com.insightfullogic.java8.exercises.chapter9;

import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.NoSuchElementException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class BlockingArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public BlockingArtistAnalyzer(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public boolean isLargerGroup(String artistName, String otherArtistName) {
        CompletableFuture<Long> countOfMembersInFirstBand = getNumberOfMembers(artistName);
        CompletableFuture<Long> countOfMembersInSecondBand = getNumberOfMembers(otherArtistName);

        try {
            return countOfMembersInFirstBand.get() >countOfMembersInSecondBand.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }

    private CompletableFuture<Long> getNumberOfMembers(String artistName) {
        return CompletableFuture.supplyAsync(() -> artistLookupService.apply(artistName))
                .thenApply(Artist::getMembers).thenApply(members -> members.count());
    }
}
