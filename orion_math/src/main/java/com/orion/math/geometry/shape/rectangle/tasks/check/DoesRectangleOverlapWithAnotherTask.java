package com.orion.math.geometry.shape.rectangle.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleRules;

public class DoesRectangleOverlapWithAnotherTask extends Orion
{
    public static boolean run(Rectangle x, Rectangle other)
    {
        RectangleRules.areValid(x, other);

        if(x.getTopLeftPoint().getX().isGreaterThan(other.getBottomRightPoint().getX())
                        || other.getTopLeftPoint().getX().isGreaterThan(x.getBottomRightPoint().getX()))
        {
            return false;
        }

        if(x.getTopLeftPoint().getY().isLessThan(other.getBottomRightPoint().getY())
                        || other.getTopLeftPoint().getY().isLessThan(x.getBottomRightPoint().getY()))
        {
            return false;
        }

        return true;
    }
}