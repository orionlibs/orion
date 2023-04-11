package com.orion.core.string;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class StringServiceTest
{
    @Test
    public void getSimilarityPercentageBetween()
    {
        double result = StringsService.getSimilarityPercentageBetween("", "");
        assertTrue(result == 1.0);
        result = StringsService.getSimilarityPercentageBetween("1234567890", "1");
        assertTrue(result == 0.1);
        result = StringsService.getSimilarityPercentageBetween("1234567890", "123");
        assertTrue(result == 0.3);
        result = StringsService.getSimilarityPercentageBetween("1234567890", "1234567");
        assertTrue(result == 0.7);
        result = StringsService.getSimilarityPercentageBetween("1234567890", "1234567890");
        assertTrue(result == 1.0);
        result = StringsService.getSimilarityPercentageBetween("1234567890", "1234567980");
        assertTrue(result == 0.8);
        result = StringsService.getSimilarityPercentageBetween("47/2010", "472010");
        assertTrue(result == 0.8571428571428571);
        result = StringsService.getSimilarityPercentageBetween("47/2010", "472011");
        assertTrue(result == 0.7142857142857143);
        result = StringsService.getSimilarityPercentageBetween("47/2010", "AB.CDEF");
        assertTrue(result == 0.0);
        result = StringsService.getSimilarityPercentageBetween("47/2010", "4B.CDEFG");
        assertTrue(result == 0.125);
        result = StringsService.getSimilarityPercentageBetween("47/2010", "AB.CDEFG");
        assertTrue(result == 0.0);
        result = StringsService.getSimilarityPercentageBetween("The quick fox jumped", "The fox jumped");
        assertTrue(result == 0.7);
        result = StringsService.getSimilarityPercentageBetween("The quick fox jumped", "The fox");
        assertTrue(result == 0.35);
        result = StringsService.getSimilarityPercentageBetween("The quick fox jumped", "The quick fox jumped off the balcany");
        assertTrue(result == 0.5555555555555556);
        result = StringsService.getSimilarityPercentageBetween("kitten", "sitting");
        assertTrue(result == 0.5714285714285714);
    }
}