package com.capegemini.javaTest.thirdExercise;

import java.util.Set;

public interface IFileProcessor {
    boolean process(Set<String> invalidCaracters, String line);
}
