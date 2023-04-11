package com.orion.math.geometry.shape.cube.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.cube.Cube;
import com.orion.math.geometry.shape.cube.CubeRules;

public class CubeEqualsTask extends Orion
{
    public static boolean run(Cube x, Object y)
    {
        CubeRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Cube other = (Cube)y;
            return x.getLengthOfSide().equal(other.getLengthOfSide());
        }

    }
}