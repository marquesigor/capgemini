package com.capegemini.javaTest;

import java.io.IOException;
import java.nio.file.Path;

import com.capegemini.javaTest.thirdExercise.FileProcessor;
import com.capegemini.javaTest.thirdExercise.FileProcessorFilterThirdColumn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JavaTestApplication.class)
public class FileProcessorTest {

    @Test
    public void tryingToProcessTheFileButGetIoExceptionBecauseDidntFoundTheFile() {
        Assertions.assertThrows(IOException.class,
                () -> new FileProcessor(Path.of("wrongPath"), new FileProcessorFilterThirdColumn()).process());
    }

    @Test
    public void tryingToProcessValidFile() throws IOException {
        new FileProcessor(Path.of("src/test/resources/source_mock.csv"), new FileProcessorFilterThirdColumn()).process();
    }
}
