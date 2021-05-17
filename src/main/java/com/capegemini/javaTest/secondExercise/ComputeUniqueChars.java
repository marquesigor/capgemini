package com.capegemini.javaTest.secondExercise;

import java.util.stream.Collectors;

public class ComputeUniqueChars {

    public static int resolveString(String input) {
        if (input == null)
            return 0;

        return input.chars().mapToObj(e -> Character.toString((char) e)).distinct().collect(Collectors.toList()).size();
    }
}
