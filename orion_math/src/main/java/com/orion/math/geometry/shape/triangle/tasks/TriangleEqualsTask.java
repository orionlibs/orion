package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;

public class TriangleEqualsTask extends Orion
{
    public static boolean run(Triangle x, Object y)
    {
        TriangleRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Triangle other = (Triangle)y;
            return x.getLengthOfA().equal(other.getLengthOfA())
                            && x.getLengthOfB().equal(other.getLengthOfB())
                            && x.getLengthOfC().equal(other.getLengthOfC());
        }

    }
}