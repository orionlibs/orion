package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;

public class PolygonHashCodeTask extends Orion
{
    public static int run(Polygon x)
    {
        PolygonRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getPoints().hashCode();
    }
}