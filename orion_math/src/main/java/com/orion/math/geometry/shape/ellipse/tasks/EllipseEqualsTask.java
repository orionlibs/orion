package com.orion.math.geometry.shape.ellipse.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.ellipse.Ellipse;
import com.orion.math.geometry.shape.ellipse.EllipseRules;

public class EllipseEqualsTask extends Orion
{
    public static boolean run(Ellipse x, Object y)
    {
        EllipseRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Ellipse other = (Ellipse)y;
            return x.getCenter().equals(other.getCenter());
        }

    }
}