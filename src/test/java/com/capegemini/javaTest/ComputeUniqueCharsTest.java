package com.capegemini.javaTest;

import org.springframework.boot.test.context.SpringBootTest;

import com.capegemini.javaTest.secondExercise.ComputeUniqueChars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@SpringBootTest(classes = JavaTestApplication.class)
public class ComputeUniqueCharsTest {

    @Test
    public void usingStringAndGettingTheUniqueChars() {
        Integer expectedResult = 48;
        Integer result = ComputeUniqueChars.resolveString(
                "$VmpKVloxbFhOV3RKUnpreFkyZHZTMk16VW5aamJWVm5XVmMxYTB3eU9YbEpSMFpxV1R[KV2VtTjVRbkJpYlZwMlkyMHhhR1JIYkhaaWFVSjJZbWxDYUVsSFVteGtiV3hxV2xOM1oyTXpWbXBoUTBKb1kzbENhbUl5");

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void usingEmptyStringAndGettingTheNumberZeroLikeResult() {
        Integer expectedResult = 0;
        Integer result = ComputeUniqueChars.resolveString("");

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    public void usingNullStringAndGettingTheNumberZeroLikeResult() {
        Integer expectedResult = 0;
        Integer result = ComputeUniqueChars.resolveString(null);

        Assertions.assertEquals(expectedResult, result);
    }
}
