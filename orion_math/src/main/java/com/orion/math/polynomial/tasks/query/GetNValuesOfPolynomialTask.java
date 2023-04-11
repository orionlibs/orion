package com.orion.math.polynomial.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import java.util.stream.IntStream;

public class GetNValuesOfPolynomialTask extends Orion
{
    public static ANumber[] run(Polynomial polynomial, Interval domain, int numberOfSampleValues)
    {
        PolynomialRules.isValid(polynomial);
        NumberRules.hasNaturalNumberValue(numberOfSampleValues);
        IntervalRules.isValid(domain);
        ANumber[] sample = new ANumber[numberOfSampleValues];
        ANumber h = domain.getLength().divideGET(numberOfSampleValues);
        IntStream.range(0, numberOfSampleValues)
                        .forEach(i -> sample[i] = polynomial.getValueFor(domain.getLeftEndpoint().addGET(h.multiplyGET(ANumber.of(i)))));
        return sample;
    }
}