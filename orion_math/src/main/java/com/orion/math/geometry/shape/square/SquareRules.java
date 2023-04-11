package com.orion.math.geometry.shape.square;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class SquareRules extends MathRule
{
    public static void isValid(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        PointRules.areValid(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        PointRules.doDimensionsMatch(2, topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        Vector vector1 = Vector.of(topLeftPoint, topRightPoint);
        Vector vector2 = Vector.of(topLeftPoint, bottomLeftPoint);
        Vector vector3 = Vector.of(bottomLeftPoint, bottomRightPoint);
        Vector vector4 = Vector.of(topRightPoint, bottomRightPoint);
        ANumber vector1Magnitude = vector1.getMagnitude();
        ANumber vector2Magnitude = vector2.getMagnitude();
        ANumber vector3Magnitude = vector3.getMagnitude();
        ANumber vector4Magnitude = vector4.getMagnitude();
        Assert.isFalse(vector1.isNotParallelTo(vector3) || vector2.isNotParallelTo(vector4)
                        || vector1.isNotPerpendicularTo(vector2) || vector1.isNotPerpendicularTo(vector4)
                        || vector1Magnitude.notEqual(vector3Magnitude)
                        || vector2Magnitude.notEqual(vector4Magnitude)
                        || vector1Magnitude.notEqual(vector2Magnitude)
                        || vector3Magnitude.notEqual(vector4Magnitude), "Square is invalid, because the points do not form a square.");
    }


    public static void isValid(Point midpoint1, Point midpoint2)
    {
        PointRules.areValid(midpoint1, midpoint2);
        PointRules.doDimensionsMatch(2, midpoint1, midpoint2);
    }


    public static void isValid(Square square)
    {
        Assert.notNull(square, "The square input cannot be null.");
        isValid(square.getTopLeftPoint(), square.getTopRightPoint(), square.getBottomLeftPoint(), square.getBottomRightPoint());
    }
}