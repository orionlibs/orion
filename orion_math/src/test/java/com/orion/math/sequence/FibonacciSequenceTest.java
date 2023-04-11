package com.orion.math.sequence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class FibonacciSequenceTest
{
    @Test
    public void fibonacciSequence()
    {
        FibonacciSequence sequence = FibonacciSequence.of();
        ANumber result = sequence.getNthTerm(ANumber.of(1));
        assertTrue(ANumber.of(1).equal(result));
        result = sequence.getNthTerm(ANumber.of(2));
        assertTrue(ANumber.of(1).equal(result));
        result = sequence.getNthTerm(ANumber.of(3));
        assertTrue(ANumber.of(2).equal(result));
        result = sequence.getNthTerm(ANumber.of(4));
        assertTrue(ANumber.of(3).equal(result));
        result = sequence.getNthTerm(ANumber.of(5));
        assertTrue(ANumber.of(5).equal(result));
        result = sequence.getNthTerm(ANumber.of(6));
        assertTrue(ANumber.of(8).equal(result));
        result = sequence.getSumOfFirstNTerms(ANumber.of(6));
        assertTrue(ANumber.of(20).equal(result));
    }


    @Test
    public void getTermIndex()
    {
        FibonacciSequence sequence = FibonacciSequence.of();
        ANumber result = sequence.getTermIndex(ANumber.of(1));
        assertTrue(ANumber.of(1).equal(result));
        result = sequence.getTermIndex(ANumber.of(2));
        assertTrue(ANumber.of(3).equal(result));
        result = sequence.getTermIndex(ANumber.of(8));
        assertTrue(ANumber.of(6).equal(result));
    }
}