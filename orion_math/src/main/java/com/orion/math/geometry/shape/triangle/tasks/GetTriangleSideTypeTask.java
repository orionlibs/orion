package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.geometry.shape.triangle.TriangleSideType;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetTriangleSideTypeTask extends Orion
{
    public static TriangleSideType run(Triangle x, int precision)
    {
        TriangleRules.isValid(x);
        precision = Precision.getValidPrecision(precision);
        ANumber a = x.getPointA().getDistanceSquaredFromPoint(x.getPointB()).applyPrecisionGET(precision);
        ANumber b = x.getPointA().getDistanceSquaredFromPoint(x.getPointC()).applyPrecisionGET(precision);
        ANumber c = x.getPointB().getDistanceSquaredFromPoint(x.getPointC()).applyPrecisionGET(precision);

        if(a.equal(b) && b.equal(c))
        {
            return TriangleSideType.Equilateral;
        }
        else if(a.equal(b) || b.equal(c) || a.equal(c))
        {
            return TriangleSideType.Isosceles;
        }
        else
        {
            return TriangleSideType.Scalene;
        }

    }
}