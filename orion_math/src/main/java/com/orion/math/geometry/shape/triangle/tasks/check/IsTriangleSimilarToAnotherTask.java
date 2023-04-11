package com.orion.math.geometry.shape.triangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.Triangle;
import com.orion.math.geometry.shape.triangle.TriangleRules;

public class IsTriangleSimilarToAnotherTask extends Orion
{
    public static boolean run(Triangle x, Triangle other)
    {
        TriangleRules.areValid(x, other);
        boolean aEqualsA = x.getAngleA().equal(other.getAngleA());
        boolean aEqualsB = x.getAngleA().equal(other.getAngleB());
        boolean aEqualsC = x.getAngleA().equal(other.getAngleC());
        return (aEqualsA && (x.getAngleB().equal(other.getAngleB()) || x.getAngleB().equal(other.getAngleC())))
                        || (aEqualsB && (x.getAngleB().equal(other.getAngleA()) || x.getAngleB().equal(other.getAngleC())))
                        || (aEqualsC && (x.getAngleB().equal(other.getAngleA()) || x.getAngleB().equal(other.getAngleB())));
    }
}