package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;
import java.util.stream.IntStream;

public class GetNValuesOfFunction1x1Task extends Orion
{
    public static ANumber[] run(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        NumberRules.hasNaturalNumberValue(numberOfSampleValues);
        FunctionRules.isValid(f);
        IntervalRules.isValid(domain);
        ANumber[] sample = new ANumber[numberOfSampleValues];
        ANumber h = domain.getLengthOfEachOfNSubintervals(numberOfSampleValues - 1);
        IntStream.range(0, numberOfSampleValues)
                        .forEach(i -> sample[i] = f.run(domain.getLeftEndpoint().addGET(h.multiplyGET(ANumber.of(i)))));
        return sample;
    }
}