package com.orion.math.probability.distribution.discrete.poisson;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.stream.IntStream;

public class PoissonDistribution extends Orion
{
    private ANumber lambda;
    private ANumber expectedValue;
    private ANumber variance;
    private Function2x1<ANumber, ANumber, ANumber> formula;
    private Function1x1<ANumber, ANumber> formulaForProbabilityForEventsLessThanOrEqualTo;


    public PoissonDistribution(ANumber lambda)
    {
        PoissonDistributionRules.isValid(lambda);
        this.lambda = lambda;
        this.expectedValue = lambda;
        this.variance = lambda;
        Function2x1IF<ANumber, ANumber, ANumber> f = (ANumber event, ANumber lambda1) ->
        {
            NumberRules.isNotNull(event);
            ANumber xFactorial = ArithmeticService.getFactorial(event);
            ANumber eTotheMinusLambda = ArithmeticService.getEToThePowerOf(lambda1.negateGET());
            return lambda1.exponentiateGET(event).multiplyGET(eTotheMinusLambda).divideGET(xFactorial);
        };
        formula = Function2x1.<ANumber, ANumber, ANumber>of(f);
        Function1x1IF<ANumber, ANumber> f1 = (ANumber event) ->
        {
            PoissonDistributionRules.isValidForProbabilityForEventsLessThanOrEqualTo(event);
            ANumber sum = ANumber.of(0);
            IntStream.range(0, event.addOneGET().getAsInt())
                            .forEach(x -> sum.add(getProbability(ANumber.of(x))));
            return sum;
        };
        formulaForProbabilityForEventsLessThanOrEqualTo = Function1x1.<ANumber, ANumber>of(f1);
    }


    public static PoissonDistribution of(ANumber lambda)
    {
        return new PoissonDistribution(lambda);
    }


    public ANumber getProbability(ANumber event)
    {
        return formula.run(event, lambda);
    }


    public ANumber getProbabilityForEventsLessThanOrEqualTo(ANumber event)
    {
        return formulaForProbabilityForEventsLessThanOrEqualTo.run(event);
    }


    public ANumber getProbabilityForEventsLessThan(ANumber event)
    {
        return getProbabilityForEventsLessThanOrEqualTo(event.subtractOneGET());
    }


    public ANumber getProbabilityForEventsGreaterThanOrEqualTo(ANumber event)
    {
        return ANumber.of(1).subtractGET(getProbabilityForEventsLessThan(event));
    }


    public ANumber getProbabilityForEventsGreaterThan(ANumber event)
    {
        return getProbabilityForEventsGreaterThanOrEqualTo(event.addOneGET());
    }


    public ANumber getLambda()
    {
        return this.lambda;
    }


    public ANumber getExpectedValue()
    {
        return this.expectedValue;
    }


    public ANumber getVariance()
    {
        return this.variance;
    }
}