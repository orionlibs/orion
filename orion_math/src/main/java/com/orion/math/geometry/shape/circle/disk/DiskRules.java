package com.orion.math.geometry.shape.circle.disk;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.CircleRules;
import com.orion.math.number.ANumber;

public class DiskRules extends MathRule
{
    public static void isValid(Point center, ANumber radius)
    {
        CircleRules.isValid(center, radius);
    }


    public static void isValid(Disk disk)
    {
        Assert.notNull(disk, "The disk input cannot be null.");
        isValid(disk.getCenter(), disk.getRadius());
    }
}