package com.orion.math.geometry.shape.triangle.threed.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.threed.Triangle3D;
import com.orion.math.geometry.shape.triangle.threed.Triangle3DRules;

public class Triangle3DEqualsTask extends Orion
{
    public static boolean run(Triangle3D x, Object y)
    {
        Triangle3DRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Triangle3D other = (Triangle3D)y;
            return x.getLengthOfA().equal(other.getLengthOfA())
                            && x.getLengthOfB().equal(other.getLengthOfB())
                            && x.getLengthOfC().equal(other.getLengthOfC());
        }

    }
}