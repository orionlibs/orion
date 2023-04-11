package com.orion.math.probability.distribution.continuous.exponential;

import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.probability.distribution.continuous.ProbabilityDensityFunctionOfContinuousNumericalVariable;

public class ExponentialDistribution extends ProbabilityDensityFunctionOfContinuousNumericalVariable
{
    private ANumber lambda;
    private Function2x1<ANumber, ANumber, ANumber> formula;
    private Function2x1<ANumber, ANumber, ANumber> formulaForProbabilityOfEventsLessThanOrEqualTo;


    public ExponentialDistribution(ANumber lambda)
    {
        ExponentialDistributionRules.isValid(lambda);
        this.lambda = lambda;
        Function2x1IF<ANumber, ANumber, ANumber> f = (ANumber x, ANumber lambda1) ->
        {
            NumberRules.isPositive(x);
            return lambda1.multiplyGET(ArithmeticService.getEToThePowerOf(lambda1.multiplyGET(x).negateGET()));
        };
        formula = Function2x1.<ANumber, ANumber, ANumber>of(f);
        Function2x1IF<ANumber, ANumber, ANumber> f1 = (ANumber x, ANumber lambda1) ->
        {
            NumberRules.isPositive(x);
            return ANumber.of(1).subtractGET(ArithmeticService.getEToThePowerOf(lambda1.multiplyGET(x).negateGET()));
        };
        formulaForProbabilityOfEventsLessThanOrEqualTo = Function2x1.<ANumber, ANumber, ANumber>of(f1);
    }


    public static ExponentialDistribution of(ANumber lambda)
    {
        return new ExponentialDistribution(lambda);
    }


    public ANumber getProbability(ANumber x)
    {
        return formula.run(x, lambda);
    }


    public ANumber getProbabilityOfEventsLessThanOrEqualTo(ANumber x)
    {
        return formula.run(x, lambda);
    }


    public ANumber getExectedValue()
    {
        return lambda.reciprocateGET();
    }


    public ANumber getVariance()
    {
        return lambda.squareGET().reciprocateGET();
    }


    public ANumber getStandardDeviation()
    {
        return getVariance().getSquareRoot();
    }


    public ANumber getLambda()
    {
        return this.lambda;
    }
}