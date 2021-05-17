package com.capegemini.javaTest.firstExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoMaps {

    public static Map<String, Integer> resolveTwoMaps(Map<String, Integer> firstMap, Map<String, Integer> secondMap) {
        Map<String, Integer> hashMapResult = new HashMap<String, Integer>();

        if ((firstMap == null) && (secondMap == null)) {
            return new HashMap<String, Integer>();
        }

        if (firstMap == null)
            return secondMap;

        if (secondMap == null)
            return firstMap;

        hashMapResult = Stream.of(firstMap, secondMap).flatMap(m -> m.entrySet().stream())
                .collect(Collectors.groupingBy(Entry::getKey, Collectors.summingInt(Entry::getValue)));

        return hashMapResult;
    }
}