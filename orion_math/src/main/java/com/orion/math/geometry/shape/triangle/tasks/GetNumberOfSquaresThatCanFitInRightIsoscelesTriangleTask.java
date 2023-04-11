package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleAngleType;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.geometry.shape.triangle.TriangleSideType;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetNumberOfSquaresThatCanFitInRightIsoscelesTriangleTask extends Orion
{
    public static ANumber run(Triangle x, ANumber squareSideLength)
    {
        TriangleRules.isValid(x);
        NumberRules.isPositive(squareSideLength);

        if(x.getAngleType().is(TriangleAngleType.Right)
                        && x.getSideType().is(TriangleSideType.Isosceles))
        {
            ANumber triangleBase = x.getLengthOfA();

            if(x.getLengthOfB().equal(x.getLengthOfC()))
            {
                triangleBase = x.getLengthOfB();
            }

            if(squareSideLength.isLessThanOrEqual(triangleBase))
            {
                triangleBase = triangleBase.subtractGET(squareSideLength);
                triangleBase = triangleBase.divideGET(squareSideLength);
                return triangleBase.multiplyGET((triangleBase.addOneGET()).halfGET());
            }

        }

        return ANumber.of(0);
    }
}