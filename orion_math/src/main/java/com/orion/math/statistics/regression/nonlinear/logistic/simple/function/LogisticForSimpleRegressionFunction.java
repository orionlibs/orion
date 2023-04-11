package com.orion.math.statistics.regression.nonlinear.logistic.simple.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class LogisticForSimpleRegressionFunction extends Orion
{
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formula;
    static
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f = (ANumber intercept, ANumber slope, ANumber x) ->
        {
            ANumber ePower = ArithmeticService.getEToThePowerOf(intercept.addGET(slope.multiplyGET(x)));
            return ePower.divideGET(ePower.addOneGET());
        };
        formula = Function3x1.of(f);
    }


    public static ANumber run(ANumber intercept, ANumber slope, ANumber x)
    {
        return formula.run(intercept, slope, x);
    }


    public static ANumber run(Number intercept, Number slope, Number x)
    {
        return run(ANumber.of(intercept), ANumber.of(slope), ANumber.of(x));
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getFormula()
    {
        return formula;
    }
}