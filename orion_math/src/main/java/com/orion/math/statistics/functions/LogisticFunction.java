package com.orion.math.statistics.functions;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class LogisticFunction extends Orion
{
    private static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> formula;
    static
    {
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> f = (ANumber maximumValue, ANumber growthRate, ANumber xValueOfSigmoidsMidpoint, ANumber x) ->
        {
            ANumber ePower = ArithmeticService.getEToThePowerOf(xValueOfSigmoidsMidpoint.subtractGET(x).multiplyGET(growthRate));
            return maximumValue.divideGET(ANumber.of(1).addGET(ePower));
        };
        formula = Function4x1.of(f);
    }


    public static ANumber run(ANumber maximumValue, ANumber growthRate, ANumber xValueOfSigmoidsMidpoint, ANumber x)
    {
        return formula.run(maximumValue, growthRate, xValueOfSigmoidsMidpoint, x);
    }


    public static ANumber run(Number maximumValue, Number growthRate, Number xValueOfSigmoidsMidpoint, Number x)
    {
        return run(ANumber.of(maximumValue), ANumber.of(growthRate), ANumber.of(xValueOfSigmoidsMidpoint), ANumber.of(x));
    }
}