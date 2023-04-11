package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.number.ANumber;

public class GetAreaOfTriangleTask extends Orion
{
    public static ANumber run(Triangle x, int precision)
    {
        TriangleRules.isValid(x);
        ANumber halfPerimeter = x.getHalfPerimeter();
        ANumber halfPerimeterMinusA = halfPerimeter.subtractGET(x.getLengthOfA());
        ANumber halfPerimeterMinusB = halfPerimeter.subtractGET(x.getLengthOfB());
        ANumber halfPerimeterMinusC = halfPerimeter.subtractGET(x.getLengthOfC());
        return halfPerimeter.multiplyGET(halfPerimeterMinusA).multiplyGET(halfPerimeterMinusB).multiplyGET(halfPerimeterMinusC).getSquareRoot(precision);
    }
}