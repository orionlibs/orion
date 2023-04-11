package com.orion.math.geometry.shape.rectangle;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import java.util.Arrays;

public class RectangleRules extends MathRule
{
    public static void isValid(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        PointRules.areValid(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        PointRules.doDimensionsMatch(2, topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        Vector vector1 = Vector.of(topLeftPoint, topRightPoint);
        Vector vector2 = Vector.of(topRightPoint, bottomRightPoint);
        Vector vector3 = Vector.of(bottomRightPoint, bottomLeftPoint);
        Vector vector4 = Vector.of(bottomLeftPoint, topLeftPoint);
        Assert.isFalse(vector1.isNotParallelTo(vector3) || vector2.isNotParallelTo(vector4)
                        || vector1.isNotPerpendicularTo(vector2) || vector1.isNotPerpendicularTo(vector4)
                        || vector1.getMagnitude().notEqual(vector3.getMagnitude())
                        || vector2.getMagnitude().notEqual(vector4.getMagnitude()), "Rectangle is invalid, because the points do not form a rectangle.");
    }


    public static void isValid(Point midpoint1, Point midpoint2)
    {
        PointRules.areValid(midpoint1, midpoint2);
        PointRules.doDimensionsMatch(2, midpoint1, midpoint2);
    }


    public static void isValid(Rectangle rectangle)
    {
        Assert.notNull(rectangle, "The rectangle input cannot be null.");
        isValid(rectangle.getTopLeftPoint(), rectangle.getTopRightPoint(), rectangle.getBottomLeftPoint(), rectangle.getBottomRightPoint());
    }


    public static void areValid(Rectangle... rectangles)
    {
        Assert.notEmpty(rectangles, "The rectangles input cannot be null/empty.");
        Arrays.stream(rectangles).forEach(rectangle -> isValid(rectangle));
    }
}