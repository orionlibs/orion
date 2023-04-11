package com.orion.math.geometry.shape.ellipse.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.ellipse.Ellipse;
import com.orion.math.geometry.shape.ellipse.EllipseRules;

public class EllipseHashCodeTask extends Orion
{
    public static int run(Ellipse x)
    {
        EllipseRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getCenter().hashCode();
    }
}