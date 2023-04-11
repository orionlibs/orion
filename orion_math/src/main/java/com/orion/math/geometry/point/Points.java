package com.orion.math.geometry.point;

import com.orion.math.MathRule;
import com.orion.math.number.ANumber;

public class Points extends MathRule
{
    public static boolean doDimensionsMatch(Point point1, Point point2)
    {

        if(isValid(point1) && isValid(point2))
        {
            return point1.getDimensions() == point2.getDimensions();
        }

        return false;
    }


    public static boolean isValid(Point point)
    {
        return point != null && isValid(point.getCoordinates());
    }


    public static boolean isValid(ANumber[] coordinates)
    {
        return coordinates != null;
    }


    public static boolean isValid(int dimensions)
    {
        return dimensions >= 0;
    }
}