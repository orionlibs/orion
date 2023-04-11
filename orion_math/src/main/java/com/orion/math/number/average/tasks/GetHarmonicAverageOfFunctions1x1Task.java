package com.orion.math.number.average.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import java.util.List;

public class GetHarmonicAverageOfFunctions1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        Function1x1<ANumber, ANumber>[] sum = new Function1x1[1];
        sum[0] = Function1x1.Zero;
        functions.forEach(x -> sum[0] = sum[0].add(x.reciprocate()));
        Function1x1<ANumber, ANumber> f = Function1x1.<ANumber, ANumber>of(x -> ANumber.of(functions.size()));
        return f.divide(sum[0]);
    }
}