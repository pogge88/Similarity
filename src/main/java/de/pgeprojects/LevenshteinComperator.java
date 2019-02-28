package de.pgeprojects;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.Comparator;

public class LevenshteinComperator implements Comparator<String> {

    private final String target;

    public LevenshteinComperator(String target){
        this.target = target;
    }


    @Override
    public int compare(String s1, String s2) {
        int d1 = getDistance(s1);
        int d2 = getDistance(s2);

        if(d1 - d2 == 0) return 0;
        if(d1 > d2){
            return 1;
        } else {
            return -1;
        }
    }


    private int getDistance(String word){
        LevenshteinDistance distance = LevenshteinDistance.getDefaultInstance();
        return distance.apply(word, target);
    }
}
