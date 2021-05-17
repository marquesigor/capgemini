package com.capegemini.javaTest.thirdExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileProcessor {
    private final Path source;
    private final IFileProcessor processor;

    public FileProcessor(Path source, IFileProcessor processor) {
        this.source = source;
        this.processor = processor;
    }

    public void process() throws IOException {
        FileConsumerFactory fileConsumerFactory = new FileConsumerFactory();

        Set<String> listOfInvalidInputs = Files.lines(Path.of("src/main/resources/invalid_data.csv"))
                .collect(Collectors.toSet());

        try (Stream<String> stream = Files.lines(source)) {
            stream.forEach(line -> {
                boolean skipLine = processor.process(listOfInvalidInputs, line);
                if (skipLine) {
                    return;
                }

                System.out.println(line);
                FileConsumer fileConsumer = fileConsumerFactory.createFileConsumer(line);
                fileConsumer.consume(line);
            });
        }
    }

    static class FileConsumerFactory {
        FileConsumer createFileConsumer(String line) {
            // Some logic here to create a valid file consumer.
            // For this example it only return a Default File Consumer
            // You don’t need to care about this method.
            return new DefaultFileConsumer();
        }
    }

    interface FileConsumer {
        void consume(String line);
    }

    static class DefaultFileConsumer implements FileConsumer {
        @Override
        public void consume(String line) {
            // Some code is done here, but it is not important for this exercise
        }
    }
}
