package com.orion.math.number.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;

public class NumberThresholdFunction extends Orion
{
    private static Function2x1<ANumber, ANumber, ANumber> formula;
    static
    {
        Function2x1IF<ANumber, ANumber, ANumber> f = (ANumber x, ANumber y) -> ((x.isLessThan(y)) ? ANumber.of(1) : ANumber.of(0));
        formula = Function2x1.of(f);
    }


    public static ANumber run(ANumber x, ANumber y)
    {
        return formula.run(x, y);
    }


    public static ANumber run(Number x, Number y)
    {
        return formula.run(ANumber.of(x), ANumber.of(y));
    }


    public static boolean runAndGetBoolean(ANumber x, ANumber y)
    {
        return (formula.run(x, y).isOne()) ? true : false;
    }


    public static boolean runAndGetBoolean(Number x, Number y)
    {
        return (formula.run(ANumber.of(x), ANumber.of(y)).isOne()) ? true : false;
    }
}