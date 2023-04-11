package com.orion.math.geometry.shape.rectangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleRules;

public class RectangleHashCodeTask extends Orion
{
    public static int run(Rectangle x)
    {
        RectangleRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        hash = defaultPrimeNumberForHashing * hash + x.getTopLeftPoint().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getTopRightPoint().hashCode();
        hash = defaultPrimeNumberForHashing * hash + x.getBottomLeftPoint().hashCode();
        return defaultPrimeNumberForHashing * hash + x.getBottomRightPoint().hashCode();
    }
}