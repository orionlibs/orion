package com.orion.math.geometry.shape.circle.arc.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.arc.CircleArc;
import com.orion.math.geometry.shape.circle.arc.CircleArcRules;

public class CircleArcEqualsTask extends Orion
{
    public static boolean run(CircleArc x, Object y)
    {
        CircleArcRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            CircleArc other = (CircleArc)y;
            return x.getCircle().equals(other.getCircle())
                            && x.getAngleInRadians().equal(other.getAngleInRadians());
        }

    }
}