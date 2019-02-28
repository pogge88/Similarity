package de.pgeprojects;

import java.util.List;
import java.util.stream.Collectors;

public class Similarity {

    private final List<String> dictonary;

    public Similarity(List<String> dictonary){
        this.dictonary = dictonary;
    }


    public List<String> findMatching(final String target, final int distance, int max){
        return dictonary.stream()
                        .filter(w -> w.length() <= target.length() + distance)
                        .sorted(new LevenshteinComperator(target))
                        .limit(max)
                        .collect(Collectors.toList());

    }


}
