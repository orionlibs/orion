package com.orion.math.geometry.shape.triangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.geometry.vector.Vector;

public class IsPointOnTriangleTask extends Orion
{
    public static boolean run(Triangle x, Point other, int precision)
    {
        TriangleRules.isValid(x);
        PointRules.isValid(other);
        PointRules.doDimensionsMatch(x.getPointA(), x.getPointB(), x.getPointC(), other);

        if(other.equals(x.getPointA()) || other.equals(x.getPointB()) || other.equals(x.getPointC()))
        {
            return true;
        }
        else
        {
            Vector vector = Vector.of(x.getPointA(), x.getPointB());

            if(vector.isPointBetweenVectorEndPoints(other))
            {
                return true;
            }
            else
            {
                vector = Vector.of(x.getPointB(), x.getPointC());

                if(vector.isPointBetweenVectorEndPoints(other))
                {
                    return true;
                }
                else
                {
                    vector = Vector.of(x.getPointA(), x.getPointC());

                    if(vector.isPointBetweenVectorEndPoints(other))
                    {
                        return true;
                    }

                }

            }

            return false;
        }

    }
}