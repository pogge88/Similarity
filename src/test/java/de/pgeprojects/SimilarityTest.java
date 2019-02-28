package de.pgeprojects;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class SimilarityTest {

    private Similarity subject;

    @Test
    public void testSimpleSource() throws Exception{
        this.subject = setUp10WordInstance();
        List<String> result = subject.findMatching("Nase",2,2);

        Assertions.assertThat(result).hasSize(2);
        Assertions.assertThat(result).containsExactly("Hase","Blase");
    }


    @Test
    public void testSourceMatchingWord() throws Exception{
        this.subject = setUp10WordInstance();
        List<String> result = subject.findMatching("Fisch",10,1);

        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result).containsOnly("Fisch");
    }


    private Similarity setUp10WordInstance(){
        List<String> dictonary = Arrays.asList("Hase","Haus","Hammer","Fisch","Kind","Ofen", "Motor", "Blase", "Gyros", "Katze");
        return new Similarity(dictonary);
    }
}
