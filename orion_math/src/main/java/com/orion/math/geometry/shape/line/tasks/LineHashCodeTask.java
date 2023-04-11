package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;

public class LineHashCodeTask extends Orion
{
    public static int run(Line x)
    {
        LineRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getA().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getB().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getC().hashCode();
    }
}