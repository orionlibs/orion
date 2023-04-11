package com.orion.math.geometry.plane.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.plane.Plane;
import com.orion.math.geometry.plane.PlaneRules;
import com.orion.math.number.ANumber;

public class IsPlaneParallelToAnotherTask extends Orion
{
    public static boolean run(Plane x, Plane other)
    {
        PlaneRules.areValid(x, other);
        ANumber ratioOfA = x.getA().divideGET(other.getA());
        ANumber ratioOfB = x.getB().divideGET(other.getB());
        ANumber ratioOfC = x.getC().divideGET(other.getC());
        return ratioOfA.equal(ratioOfB) && ratioOfB.equal(ratioOfC);
    }
}