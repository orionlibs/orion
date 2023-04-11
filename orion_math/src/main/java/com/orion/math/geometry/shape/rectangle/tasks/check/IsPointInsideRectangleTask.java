package com.orion.math.geometry.shape.rectangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleRules;

public class IsPointInsideRectangleTask extends Orion
{
    public static boolean run(Rectangle x, Point other)
    {
        RectangleRules.isValid(x);
        PointRules.isValid(other);
        PointRules.doDimensionsMatch(x.getTopLeftPoint(), other);
        return x.getBottomLeftPoint().getX().isLessThan(other.getX())
                        && x.getBottomLeftPoint().getY().isLessThan(other.getY())
                        && x.getTopRightPoint().getX().isGreaterThan(other.getX())
                        && x.getTopRightPoint().getY().isGreaterThan(other.getY());
    }
}