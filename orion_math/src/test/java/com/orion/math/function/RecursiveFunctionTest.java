package com.orion.math.function;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.function.onevariable.RecursiveFunction1x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class RecursiveFunctionTest
{
    @SuppressWarnings("rawtypes")
    @Test
    public void testRecursiveFunction()
    {
        Function2x1IF<Function2x1IF, ANumber, ANumber> temp = (Function2x1IF f1, ANumber x) -> ((x.isZero()) ? ANumber.of(0) : (ANumber)f1.run(f1, x.subtractOneGET()));
        RecursiveFunction1x1<ANumber, ANumber> f = RecursiveFunction1x1.of(temp);
        assertTrue(ANumber.of(0).equal(f.run(ANumber.of(5))));
    }
}