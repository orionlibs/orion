package com.orion.math.geometry.point.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;

public class PointPrintTask extends Orion
{
    public static String run(Point point)
    {
        PointRules.isValid(point);
        StringBuilder result = new StringBuilder("(");

        for(int i = 0; i < point.getCoordinates().length; i++)
        {
            result.append(point.getCoordinates()[i]);

            if(i < point.getCoordinates().length - 1)
            {
                result.append(", ");
            }

        }

        result.append(")");
        return result.toString();
    }
}