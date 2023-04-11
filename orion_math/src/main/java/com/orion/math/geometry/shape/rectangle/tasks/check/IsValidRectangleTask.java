package com.orion.math.geometry.shape.rectangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;

public class IsValidRectangleTask extends Orion
{
    public static boolean run(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        PointRules.areValid(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        PointRules.doDimensionsMatch(2, topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        Vector vector1 = Vector.of(topLeftPoint, topRightPoint);
        Vector vector2 = Vector.of(topRightPoint, bottomRightPoint);
        Vector vector3 = Vector.of(bottomRightPoint, bottomLeftPoint);
        Vector vector4 = Vector.of(bottomLeftPoint, topLeftPoint);
        return vector1.isParallelTo(vector3) && vector2.isParallelTo(vector4)
                        && vector1.isPerpendicularTo(vector2) && vector1.isPerpendicularTo(vector4)
                        && vector1.getMagnitude().equal(vector3.getMagnitude())
                        && vector2.getMagnitude().equal(vector4.getMagnitude());
    }
}