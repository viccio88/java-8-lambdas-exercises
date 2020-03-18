package com.insightfullogic.java8.exercises.chapter9;

import com.insightfullogic.java8.examples.chapter1.Artist;
import com.insightfullogic.java8.exercises.Exercises;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class CallbackArtistAnalyser implements ArtistAnalyzer {

    private final Function<String, Artist> artistLookupService;

    public CallbackArtistAnalyser(Function<String, Artist> artistLookupService) {
        this.artistLookupService = artistLookupService;
    }

    public void isLargerGroup(String artistName, String otherArtistName, Consumer<Boolean> handler) {
        CompletableFuture<Long> countOfMembersInFirstBand = getNumberOfMembers(artistName);
        CompletableFuture<Long> countOfMembersInSecondBand = getNumberOfMembers(otherArtistName);

        countOfMembersInFirstBand
                .thenCombine(countOfMembersInSecondBand, (nr1, nr2) -> nr1 > nr2)
                .thenAccept((result) ->
                                    handler.accept(result));
    }

    private CompletableFuture<Long>  getNumberOfMembers(String artistName) {
        return CompletableFuture.supplyAsync(() -> artistLookupService.apply(artistName))
                .thenApply(Artist::getMembers).thenApply(members -> members.count());
    }

}
