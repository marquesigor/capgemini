package com.capegemini.javaTest;

import java.util.HashMap;
import java.util.Map;

import com.capegemini.javaTest.firstExercise.MergeTwoMaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JavaTestApplication.class)
public class MergeTwoMapsTest {

    private Map<String, Integer> firstMap;
    private Map<String, Integer> secondMap;

    @BeforeEach
    void buildHashMaps() {
        this.firstMap = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1);
            }
        };

        this.secondMap = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1000);
                put("c", 1000);
            }
        };

    }

    @Test
    public void mergingTwoPopulatedHashMapAndGettingTheExpectedResult() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>() {
            {
                put("a", 2);
                put("b", 1001);
                put("c", 1000);
            }
        };

        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(this.firstMap, this.secondMap));
    }

    @Test
    public void mergingWithJustFirstMapPopulatedAndGettingFirstMapLikeResult() {
        Map<String, Integer> secondMap = new HashMap<String, Integer>();

        Map<String, Integer> expectedResult = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1);
            }
        };

        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(this.firstMap, secondMap));
    }

    @Test
    public void mergingWithJustSecondMapPopulatedAndGettingSecondMapLikeResult() {
        Map<String, Integer> firstMap = new HashMap<String, Integer>();

        Map<String, Integer> expectedResult = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1000);
                put("c", 1000);
            }
        };

        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(firstMap, this.secondMap));
    }

    @Test
    public void mergingNullHashMapsAndGettingNewHashMap() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>();
        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(null, null));
    }

    @Test
    public void mergingFirstHashMapWithNullHashMapsAndGettingTheFirstHashMap() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1);
            }
        };
        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(this.firstMap, null));
    }

    @Test
    public void mergingSecondHashMapWithNullHashMapsAndGettingTheSecondHashMap() {
        Map<String, Integer> expectedResult = new HashMap<String, Integer>() {
            {
                put("a", 1);
                put("b", 1000);
                put("c", 1000);
            }
        };
        Assertions.assertEquals(expectedResult, MergeTwoMaps.resolveTwoMaps(null, this.secondMap));
    }
}
