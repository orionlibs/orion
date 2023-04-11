package com.orion.math.geometry.shape.triangle.threed.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.threed.Triangle3D;
import com.orion.math.geometry.shape.triangle.threed.Triangle3DRules;

public class IsTriangle3DSimilarToAnotherTask extends Orion
{
    public static boolean run(Triangle3D x, Triangle3D other)
    {
        Triangle3DRules.areValid(x, other);
        boolean aEqualsA = x.getAngleA().equal(other.getAngleA());
        boolean aEqualsB = x.getAngleA().equal(other.getAngleB());
        boolean aEqualsC = x.getAngleA().equal(other.getAngleC());
        return (aEqualsA && (x.getAngleB().equal(other.getAngleB()) || x.getAngleB().equal(other.getAngleC())))
                        || (aEqualsB && (x.getAngleB().equal(other.getAngleA()) || x.getAngleB().equal(other.getAngleC())))
                        || (aEqualsC && (x.getAngleB().equal(other.getAngleA()) || x.getAngleB().equal(other.getAngleB())));
    }
}