package com.orion.math.combinatorics;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class CombinatoricsServiceTest
{
    @Test
    public void testGetNumberOfCombinations()
    {
        ANumber result = CombinatoricsService.getNumberOfCombinations(ANumber.of(5), ANumber.of(2));
        assertTrue(ANumber.of(10).equal(result));
    }


    @Test
    public void testGetCombinationsWithoutElementRepetition()
    {
        List<String> list = Arrays.asList("1", "2", "3", "4");
        List<List<String>> result = CombinatoricsService.getCombinationsWithoutElementRepetition(list, 2);
        assertTrue(result.get(0).equals(Arrays.asList("1", "2")));
        assertTrue(result.get(1).equals(Arrays.asList("1", "3")));
        assertTrue(result.get(2).equals(Arrays.asList("1", "4")));
        assertTrue(result.get(3).equals(Arrays.asList("2", "3")));
        assertTrue(result.get(4).equals(Arrays.asList("2", "4")));
        assertTrue(result.get(5).equals(Arrays.asList("3", "4")));
    }
}