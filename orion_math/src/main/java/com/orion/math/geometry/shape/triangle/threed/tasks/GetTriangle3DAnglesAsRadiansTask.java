package com.orion.math.geometry.shape.triangle.threed.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Triple;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.shape.triangle.threed.Triangle3D;
import com.orion.math.geometry.shape.triangle.threed.Triangle3DRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class GetTriangle3DAnglesAsRadiansTask extends Orion
{
    public static Triple<ANumber, ANumber, ANumber> run(Triangle3D x, int precision)
    {
        Triangle3DRules.isValid(x);
        Vector vectorAB = Vector.of(x.getPointA(), x.getPointB());
        Vector vectorAC = Vector.of(x.getPointA(), x.getPointC());
        Vector vectorBA = vectorAB.reverseDirection();
        Vector vectorBC = Vector.of(x.getPointB(), x.getPointC());
        ANumber angleA = vectorAB.getAngleWithVectorAsRadians(vectorAC, precision);
        ANumber angleB = vectorBA.getAngleWithVectorAsRadians(vectorBC, precision);
        ANumber angleC = Constants.PI.getValue().subtractGET(angleA.addGET(angleB));
        return Triple.of(angleA, angleB, angleC);
    }
}