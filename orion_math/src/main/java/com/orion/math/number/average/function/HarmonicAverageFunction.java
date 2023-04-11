package com.orion.math.number.average.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.average.AverageService;
import java.util.Arrays;
import java.util.List;

public class HarmonicAverageFunction extends Orion
{
    private static Function1x1<List<ANumber>, ANumber> formula;
    static
    {
        Function1x1IF<List<ANumber>, ANumber> f = (List<ANumber> values) -> (AverageService.getHarmonicAverage(values));
        formula = Function1x1.of(f);
    }


    public static ANumber run(List<ANumber> values)
    {
        return formula.run(values);
    }


    public static ANumber run(ANumber[] values)
    {
        NumberRules.areNotNull(values);
        return formula.run(Arrays.asList(values));
    }
}