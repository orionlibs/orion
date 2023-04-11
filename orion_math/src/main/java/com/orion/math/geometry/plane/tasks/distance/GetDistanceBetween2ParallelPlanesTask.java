package com.orion.math.geometry.plane.tasks.distance;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetDistanceBetween2ParallelPlanesTask extends Orion
{
    public static ANumber run(Plane x, Plane other, int precision)
    {
        PlaneRules.areParallel(x, other);
        precision = Precision.getValidPrecision(precision);
        ANumber z1 = x.getD().negateGET().divideGET(x.getC());
        return other.getC().multiplyGET(z1).addGET(other.getD()).getAbsoluteValue()
                        .divideGET(other.getA().squareGET().addGET(other.getB().squareGET()).addGET(other.getC().squareGET()).getSquareRoot(precision));
    }
}