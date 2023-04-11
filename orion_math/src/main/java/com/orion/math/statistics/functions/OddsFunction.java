package com.orion.math.statistics.functions;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class OddsFunction extends Orion
{
    private static Function1x1<ANumber, ANumber> formula;
    static
    {
        Function1x1IF<ANumber, ANumber> f = (ANumber probability) -> (probability.divideGET(ANumber.of(1).subtractGET(probability)));
        formula = Function1x1.of(f);
    }


    public static ANumber run(ANumber probability)
    {
        return formula.run(probability);
    }


    public static ANumber run(Number probability)
    {
        return run(ANumber.of(probability));
    }
}