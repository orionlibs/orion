package com.orion.math.geometry.shape.circle.disk.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.disk.Disk;
import com.orion.math.geometry.shape.circle.disk.DiskRules;

public class DiskEqualsTask extends Orion
{
    public static boolean run(Disk x, Object y)
    {
        DiskRules.isValid(x);

        if(y == null || x.getClass() != y.getClass())
        {
            return false;
        }
        else
        {
            Disk other = (Disk)y;
            return x.getCircle().equals(other.getCircle());
        }

    }
}