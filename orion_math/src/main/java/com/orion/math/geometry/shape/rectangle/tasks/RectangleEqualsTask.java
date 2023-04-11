package com.orion.math.geometry.shape.rectangle.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleRules;

public class RectangleEqualsTask extends Orion
{
    public static boolean run(Rectangle x, Object y)
    {
        RectangleRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Rectangle other = (Rectangle)y;
            return x.getLengthOfSideFromTopLeftToTopRight().equal(other.getLengthOfSideFromBottomLeftToBottomRight())
                            && x.getLengthOfSideFromTopLeftToBottomLeft().equal(other.getLengthOfSideFromTopRightToBottomRight());
        }

    }
}