package com.orion.math.number.average.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.average.AverageService;
import java.util.Arrays;
import java.util.List;

public class WeightedArithmeticAverageFunction extends Orion
{
    private static Function2x1<List<ANumber>, List<ANumber>, ANumber> formula;
    static
    {
        Function2x1IF<List<ANumber>, List<ANumber>, ANumber> f = (List<ANumber> values, List<ANumber> weights) -> (AverageService.getWeightedArithmeticAverage(values, weights));
        formula = Function2x1.of(f);
    }


    public static ANumber run(List<ANumber> values, List<ANumber> weights)
    {
        return formula.run(values, weights);
    }


    public static ANumber run(ANumber[] values, ANumber[] weights)
    {
        NumberRules.doSizesMatch(values, weights);
        return formula.run(Arrays.asList(values), Arrays.asList(weights));
    }
}