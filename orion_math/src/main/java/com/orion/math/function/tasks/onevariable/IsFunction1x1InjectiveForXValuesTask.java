package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class IsFunction1x1InjectiveForXValuesTask extends Orion
{
    public static boolean run(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(xValues);
        Set<ANumber> yValues = new HashSet<>();
        IntStream.range(0, xValues.length).forEach(i -> yValues.add(f.run(xValues[i])));
        return yValues.size() == xValues.length;
    }
}