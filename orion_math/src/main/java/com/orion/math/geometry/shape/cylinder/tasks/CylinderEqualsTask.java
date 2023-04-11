package com.orion.math.geometry.shape.cylinder.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.cylinder.Cylinder;
import com.orion.math.geometry.shape.cylinder.CylinderRules;

public class CylinderEqualsTask extends Orion
{
    public static boolean run(Cylinder x, Object y)
    {
        CylinderRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Cylinder other = (Cylinder)y;
            return x.getRadius().equal(other.getRadius()) && x.getHeight().equal(other.getHeight());
        }

    }
}