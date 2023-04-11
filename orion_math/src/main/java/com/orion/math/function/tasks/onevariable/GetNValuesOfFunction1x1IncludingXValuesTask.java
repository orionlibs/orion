package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class GetNValuesOfFunction1x1IncludingXValuesTask extends Orion
{
    public static Pair<ANumber[], ANumber[]> run(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        FunctionRules.isValid(f);
        return run(f.getFunctionCasted(), domain, numberOfSampleValues);
    }


    public static Pair<ANumber[], ANumber[]> run(Function1x1IF<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        NumberRules.hasNaturalNumberValue(numberOfSampleValues);
        FunctionRules.isValid(f);
        IntervalRules.isValid(domain);
        ANumber[] sampleX = new ANumber[numberOfSampleValues];
        ANumber[] sampleY = new ANumber[numberOfSampleValues];
        ANumber h = domain.getLengthOfEachOfNSubintervals(numberOfSampleValues - 1);

        for(int i = 0; i < numberOfSampleValues; i++)
        {

            if(i == 0)
            {
                sampleX[i] = domain.getLeftEndpoint();
            }
            else if(i == numberOfSampleValues - 1)
            {
                sampleX[i] = domain.getRightEndpointCopy();
            }
            else
            {
                sampleX[i] = domain.getLeftEndpoint().addGET(h.multiplyGET(ANumber.of(i)));
            }

            sampleY[i] = f.run(sampleX[i]);
        }

        return Pair.of(sampleX, sampleY);
    }
}