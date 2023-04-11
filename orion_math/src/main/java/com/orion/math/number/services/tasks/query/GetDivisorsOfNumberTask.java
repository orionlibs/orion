package com.orion.math.number.services.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.streams.NumberStream;
import java.util.Arrays;
import java.util.List;

public class GetDivisorsOfNumberTask extends Orion
{
    public static List<ANumber> run(ANumber x)
    {
        NumberRules.isPositive(x);
        NumberRules.hasIntegerValue(x);

        if(x.isOne())
        {
            return Arrays.asList(ANumber.of(1));
        }
        else
        {
            return NumberStream.of(ANumber.of(1), x.getAbsoluteValue())
                            .filter(i -> x.getRemainderOfDivision(i).isZero())
                            .getAsList();
        }

    }
}