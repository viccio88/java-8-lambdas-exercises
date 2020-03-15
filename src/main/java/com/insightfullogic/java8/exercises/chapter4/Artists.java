package com.insightfullogic.java8.exercises.chapter4;

import com.insightfullogic.java8.answers.chapter3.StringExercises;
import com.insightfullogic.java8.examples.chapter1.Artist;

import java.util.List;
import java.util.Optional;

public class Artists {

    private List<Artist> artists;

    public Artists(List<Artist> artists) {
        this.artists = artists;
    }

    public Artist getArtist(int index) {
        if(index > artists.size() || index < 0 ){
            indexException(index);
        }
        return artists.get(index);
    }

    private void indexException(int index) {
        throw new IllegalArgumentException(index + 
                                           " doesn't correspond to an Artist");
    }

    public String getArtistName(int index) {
        if(index > artists.size() || index < 0 ){
            return "unknown";
        }
        return Optional.ofNullable(artists.get(index))
                .orElse(new Artist("unknown","unknown"))
                .getName();
    }
}
