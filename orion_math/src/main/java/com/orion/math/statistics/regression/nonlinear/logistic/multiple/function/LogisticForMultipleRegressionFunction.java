package com.orion.math.statistics.regression.nonlinear.logistic.multiple.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.statistics.regression.nonlinear.logistic.multiple.MultipleLogisticRegressionRules;
import java.util.stream.IntStream;

public class LogisticForMultipleRegressionFunction extends Orion
{
    private static Function3x1<ANumber, Vector, Vector, ANumber> formula;
    static
    {
        Function3x1IF<ANumber, Vector, Vector, ANumber> f = (ANumber intercept, Vector slopes, Vector xValues) ->
        {
            MultipleLogisticRegressionRules.doSizesMatch(slopes, xValues);
            ANumber sum = intercept;
            IntStream.range(0, slopes.getDimensions()).forEach(i -> sum.add(slopes.get(i).multiplyGET(xValues.get(i))));
            ANumber ePower = ArithmeticService.getEToThePowerOf(intercept.addGET(sum));
            return ePower.divideGET(ePower.addOneGET());
        };
        formula = Function3x1.of(f);
    }


    public static ANumber run(ANumber intercept, Vector slopes, Vector xValues)
    {
        return formula.run(intercept, slopes, xValues);
    }


    public static Function3x1<ANumber, Vector, Vector, ANumber> getFormula()
    {
        return formula;
    }
}