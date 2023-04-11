package com.orion.math.number.average.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.average.AverageService;
import com.orion.math.number.precision.Precision;
import java.util.Arrays;
import java.util.List;

public class GeometricAverageFunction extends Orion
{
    private static Function1x1<List<ANumber>, ANumber> formula;
    private static Function2x1<List<ANumber>, Integer, ANumber> formulaWithPrecision;
    static
    {
        Function1x1IF<List<ANumber>, ANumber> f1 = (List<ANumber> values) -> (AverageService.getGeometricAverage(values));
        formula = Function1x1.of(f1);
        Function2x1IF<List<ANumber>, Integer, ANumber> f2 = (List<ANumber> values, Integer precision) -> (AverageService.getGeometricAverage(values, precision));
        formulaWithPrecision = Function2x1.of(f2);
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


    public static ANumber run(List<ANumber> values, int precision)
    {
        NumberRules.areNotNull(values);
        precision = Precision.getValidPrecision(precision);
        return formulaWithPrecision.run(values, precision);
    }


    public static ANumber run(ANumber[] values, int precision)
    {
        NumberRules.areNotNull(values);
        precision = Precision.getValidPrecision(precision);
        return formulaWithPrecision.run(Arrays.asList(values), precision);
    }
}