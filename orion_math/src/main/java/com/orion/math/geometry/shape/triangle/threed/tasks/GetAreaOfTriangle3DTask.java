package com.orion.math.geometry.shape.triangle.threed.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.threed.Triangle3D;
import com.orion.math.geometry.shape.triangle.threed.Triangle3DRules;
import com.orion.math.number.ANumber;

public class GetAreaOfTriangle3DTask extends Orion
{
    public static ANumber run(Triangle3D x, int precision)
    {
        Triangle3DRules.isValid(x);
        ANumber halfPerimeter = x.getHalfPerimeter();
        ANumber halfPerimeterMinusA = halfPerimeter.subtractGET(x.getLengthOfA());
        ANumber halfPerimeterMinusB = halfPerimeter.subtractGET(x.getLengthOfB());
        ANumber halfPerimeterMinusC = halfPerimeter.subtractGET(x.getLengthOfC());
        return halfPerimeter.multiplyGET(halfPerimeterMinusA).multiplyGET(halfPerimeterMinusB).multiplyGET(halfPerimeterMinusC).getSquareRoot(precision);
    }
}