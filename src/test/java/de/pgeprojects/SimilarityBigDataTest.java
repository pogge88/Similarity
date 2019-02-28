package de.pgeprojects;

import org.apache.commons.io.IOUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimilarityBigDataTest {

    private List<String> dictonary;

    private Similarity subject;

    @BeforeEach
    public void initAll() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String data = IOUtils.toString(classLoader.getResourceAsStream("wordlist_raw.txt"), StandardCharsets.UTF_8);
        data = data.substring(1);
        dictonary = Arrays.stream(data.split("\\r?\\n"))
                          .filter(w -> !w.startsWith(".") && !w.startsWith("###"))
                          .collect(Collectors.toList());

        this.subject = new Similarity(dictonary);
    }

    @Test
    public void testSimpleBigData(){
        List<String> result = subject.findMatching("Ghostwriter",1,1);

        Assertions.assertThat(result).containsOnly("Ghostwriter");
    }
}
