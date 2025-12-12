package com.counter.character;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.reducing;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharCounter {

    public Map<Character, Integer> countChars(String text) {
        return text.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(identity(), LinkedHashMap::new, reducing(0, i -> 1, Integer::sum)));
    }
    
}