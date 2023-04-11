package com.orion.math.calculus.integral.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.integral.IntegrationService;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;

public class IntegrationFunction extends Orion
{
    @SuppressWarnings("rawtypes")
    private static Function2x1<Function1x1, Interval, ANumber> formula;
    static
    {
        @SuppressWarnings("rawtypes")
        Function2x1IF<Function1x1, Interval, ANumber> f = (Function1x1 func, Interval interval) -> (IntegrationService.integrate(func, interval));
        formula = Function2x1.of(f);
    }


    @SuppressWarnings("rawtypes")
    public static ANumber run(Function1x1 f, Interval interval)
    {
        return formula.run(f, interval);
    }
}