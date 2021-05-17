package com.capegemini.javaTest.thirdExercise;

import java.util.Set;

public class FileProcessorFilterThirdColumn implements IFileProcessor {

    @Override
    public boolean process(Set<String> invalidCaracters, String line) {
        String[] valuesOfLine = line.split(";");

        if (line.isEmpty())
            return false;

        if (valuesOfLine.length <= 2)
            return false;
        return (invalidCaracters.stream().anyMatch(filter -> filter.equals(valuesOfLine[2])));
    }
}
