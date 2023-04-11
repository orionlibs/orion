package com.orion.math.geometry.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import java.util.Arrays;

public class PointEqualsTask extends Orion
{
    public static boolean run(Point x, Object y)
    {
        PointRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            return Arrays.equals(x.getCoordinates(), ((Point)y).getCoordinates());
        }

    }
}