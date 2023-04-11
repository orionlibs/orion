package com.orion.math.statistics.functions;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class StandardLogisticFunction extends Orion
{
    private static Function1x1<ANumber, ANumber> formula;
    static
    {
        Function1x1IF<ANumber, ANumber> f = (ANumber x) ->
        {
            return LogisticFunction.run(ANumber.of(1), ANumber.of(1), ANumber.of(0), x);
        };
        formula = Function1x1.of(f);
    }


    public static ANumber run(ANumber x)
    {
        return formula.run(x);
    }


    public static ANumber run(Number x)
    {
        return run(ANumber.of(x));
    }
}