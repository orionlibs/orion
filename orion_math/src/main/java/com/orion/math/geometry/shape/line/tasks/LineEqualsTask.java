package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;

public class LineEqualsTask extends Orion
{
    public static boolean run(Line x, Object y)
    {
        LineRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Line other = (Line)y;
            boolean areEqual = x.getA().equal(other.getA()) && x.getB().equal(other.getB())
                            && x.getC().equal(other.getC());

            if(areEqual)
            {
                return true;
            }
            else
            {
                return x.getSlope().equal(other.getSlope())
                                && x.getInterceptForSlopeForm().equal(other.getInterceptForSlopeForm());
            }

        }

    }
}