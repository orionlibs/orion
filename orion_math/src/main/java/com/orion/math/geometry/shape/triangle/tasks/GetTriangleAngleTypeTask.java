package com.orion.math.geometry.shape.triangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleAngleType;
import com.orion.math.geometry.shape.triangle.TriangleRules;
import com.orion.math.number.ANumber;
import java.util.Arrays;

public class GetTriangleAngleTypeTask extends Orion
{
    public static TriangleAngleType run(Triangle x)
    {
        TriangleRules.isValid(x);
        ANumber a = x.getPointA().getDistanceSquaredFromPoint(x.getPointB());
        ANumber b = x.getPointA().getDistanceSquaredFromPoint(x.getPointC());
        ANumber c = x.getPointB().getDistanceSquaredFromPoint(x.getPointC());
        ANumber[] sides = new ANumber[]
        {a, b, c};
        Arrays.sort(sides);

        if(a.addGET(b).isGreaterThan(c))
        {
            return TriangleAngleType.Acute;
        }
        else if(a.addGET(b).equal(c))
        {
            return TriangleAngleType.Right;
        }
        else
        {
            return TriangleAngleType.Obtuse;
        }

    }
}