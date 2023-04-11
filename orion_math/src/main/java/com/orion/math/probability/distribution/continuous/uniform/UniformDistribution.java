package com.orion.math.probability.distribution.continuous.uniform;

import com.orion.math.error.ErrorService;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.probability.distribution.continuous.ProbabilityDensityFunctionOfContinuousNumericalVariable;

public class UniformDistribution extends ProbabilityDensityFunctionOfContinuousNumericalVariable
{
    private ANumber minimum;
    private ANumber maximum;
    private Function3x1<ANumber, ANumber, ANumber, ANumber> formula;


    public UniformDistribution(ANumber minimum, ANumber maximum)
    {
        UniformDistributionRules.isValid(minimum, maximum);
        this.minimum = minimum;
        this.maximum = maximum;
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f = (ANumber x, ANumber minimum1, ANumber maximum1) ->
        {
            NumberRules.isNotNull(x);

            if(Numbers.isBetween(x, minimum1, maximum1))
            {
                return maximum1.subtractGET(minimum1).reciprocateGET();
            }
            else
            {
                return ANumber.of(0);
            }

        };
        formula = Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f);
    }


    public static UniformDistribution of(ANumber minimum, ANumber maximum)
    {
        return new UniformDistribution(minimum, maximum);
    }


    public ANumber getProbability(ANumber x)
    {
        return formula.run(x, minimum, maximum);
    }


    public ANumber getExectedValue()
    {
        return minimum.addGET(maximum).halfGET();
    }


    public ANumber getVariance()
    {
        return ErrorService.getErrorSquared(minimum, maximum).divideGET(12);
    }


    public ANumber getStandardDeviation()
    {
        return getVariance().getSquareRoot();
    }


    public ANumber getMinimum()
    {
        return this.minimum;
    }


    public ANumber getMaximum()
    {
        return this.maximum;
    }
}