package com.orion.math.geometry.point.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class ArePointsCoplanarTask extends Orion
{
    public static boolean run(int precision, Point... points)
    {

        if(points != null)
        {

            if(points.length < 4)
            {
                return true;
            }
            else
            {
                precision = Precision.getValidPrecision(precision);
                PointRules.doDimensionsMatch(points);
                int dimensions = points[0].getDimensions();
                ANumber[][] elements = new ANumber[points.length - 1][dimensions];

                for(int i = 0; i < points.length - 1; i++)
                {
                    Vector vector = Vector.of(points[0], points[i + 1]);

                    for(int j = 0; j < dimensions; j++)
                    {
                        elements[i][j] = vector.get(j);
                    }

                }

                return Matrix.of(elements).getRank().isLessThanOrEqual(2);
            }

        }

        return false;
    }
}