package com.orion.math.number.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;

public class IndicationFunction extends Orion
{
    public static ANumber run(ANumber x, ANumber y)
    {
        return NumberEqualityFunction.run(x, y);
    }


    public static ANumber run(Number x, Number y)
    {
        return NumberEqualityFunction.run(ANumber.of(x), ANumber.of(y));
    }


    public static boolean runAndGetBoolean(ANumber x, ANumber y)
    {
        return (NumberEqualityFunction.run(x, y).isZero()) ? true : false;
    }


    public static boolean runAndGetBoolean(Number x, Number y)
    {
        return (NumberEqualityFunction.run(ANumber.of(x), ANumber.of(y)).isZero()) ? true : false;
    }
}