package com.orion.math.geometry.shape.circle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.circle.CircleRules;

public class CircleEqualsTask extends Orion
{
    public static boolean run(Circle x, Object y)
    {
        CircleRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Circle other = (Circle)y;
            return x.getRadius().equal(other.getRadius());
        }

    }
}