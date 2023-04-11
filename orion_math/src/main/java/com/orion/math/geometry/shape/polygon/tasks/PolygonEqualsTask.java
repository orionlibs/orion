package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;

public class PolygonEqualsTask extends Orion
{
    public static boolean run(Polygon x, Object y)
    {
        PolygonRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Polygon other = (Polygon)y;
            return x.getPoints().equals(other.getPoints());
        }

    }
}