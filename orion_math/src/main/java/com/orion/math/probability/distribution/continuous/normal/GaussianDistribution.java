package com.orion.math.probability.distribution.continuous.normal;

import com.orion.math.constant.Constants;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.probability.distribution.continuous.ProbabilityDensityFunctionOfContinuousNumericalVariable;

public class GaussianDistribution extends ProbabilityDensityFunctionOfContinuousNumericalVariable
{
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formula;
    private static Function3x1<ANumber, ANumber, ANumber, ANumber> formulaToTransformVariableToStandardisedForm;
    static
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f = (ANumber x, ANumber standardDeviation, ANumber mean) ->
        {
            NumberRules.areNotNull(standardDeviation, mean, x);
            ANumber a = standardDeviation.multiplyGET(Constants.twoPI.getSquareRoot()).reciprocateGET();
            ANumber b = x.subtractGET(mean).squareGET().negateGET();
            ANumber c = b.divideGET(standardDeviation.squareGET().doubleGET());
            ANumber d = ArithmeticService.getEToThePowerOf(c);
            return a.multiplyGET(d);
        };
        formula = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f1 = (ANumber x, ANumber standardDeviation, ANumber mean) ->
        {
            NumberRules.areNotNull(standardDeviation, mean, x);
            return x.subtractGET(mean).divideGET(standardDeviation);
        };
        formulaToTransformVariableToStandardisedForm = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f1);
    }


    public static ANumber getProbability(ANumber x, ANumber standardDeviation, ANumber mean)
    {
        return formula.run(x, standardDeviation, mean);
    }


    public static ANumber transformVariableToStandardisedForm(ANumber x, ANumber standardDeviation, ANumber mean)
    {
        return formulaToTransformVariableToStandardisedForm.run(x, standardDeviation, mean);
    }


    public static ANumber getXValue(ANumber x, ANumber standardDeviation, ANumber mean)
    {
        return mean.addGET(standardDeviation.multiplyGET(transformVariableToStandardisedForm(x, standardDeviation, mean)));
    }
}