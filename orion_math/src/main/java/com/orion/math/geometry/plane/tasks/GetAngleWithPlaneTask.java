package com.orion.math.geometry.plane.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetAngleWithPlaneTask extends Orion
{
    public static ANumber run(Plane x, Plane other, int precision)
    {
        PlaneRules.areValid(x, other);
        precision = Precision.getValidPrecision(precision);
        ANumber d = x.getA().multiplyGET(other.getA()).addGET(x.getB().multiplyGET(other.getB())).addGET(x.getC().multiplyGET(other.getC()));
        d = d.getAbsoluteValue();
        ANumber e1 = x.getA().squareGET().addGET(x.getB().squareGET()).addGET(x.getC().squareGET()).getSquareRoot(precision);
        ANumber e2 = other.getA().squareGET().addGET(other.getB().squareGET()).addGET(other.getC().squareGET()).getSquareRoot(precision);
        d.divide(e1.multiplyGET(e2));
        return d.getArccosine(precision);
    }
}