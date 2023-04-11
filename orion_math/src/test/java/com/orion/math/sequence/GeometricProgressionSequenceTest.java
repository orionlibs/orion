package com.orion.math.sequence;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class GeometricProgressionSequenceTest
{
    @Test
    public void geometricProgressionSequence()
    {
        GeometricProgressionSequence sequence = GeometricProgressionSequence.of(ANumber.of(2), ANumber.of(3));
        ANumber result = sequence.getNthTerm(ANumber.of(1));
        assertTrue(ANumber.of(6).equal(result));
        result = sequence.getNthTerm(ANumber.of(2));
        assertTrue(ANumber.of(18).equal(result));
    }
}