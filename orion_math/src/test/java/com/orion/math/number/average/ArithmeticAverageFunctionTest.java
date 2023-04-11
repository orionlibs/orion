package com.orion.math.number.average;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.number.ANumber;
import com.orion.math.number.average.function.ArithmeticAverageFunction;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class ArithmeticAverageFunctionTest
{
    @Test
    public void test1()
    {
        ANumber result = ArithmeticAverageFunction.run(Arrays.asList(ANumber.of(1), ANumber.of(2), ANumber.of(3)));
        ANumber expected = ANumber.of(2);
        assertTrue(expected.equal(result));
    }
}