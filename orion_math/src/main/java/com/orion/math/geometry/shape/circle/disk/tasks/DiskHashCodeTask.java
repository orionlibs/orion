package com.orion.math.geometry.shape.circle.disk.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.circle.disk.Disk;
import com.orion.math.geometry.shape.circle.disk.DiskRules;

public class DiskHashCodeTask extends Orion
{
    public static int run(Disk x)
    {
        DiskRules.isValid(x);
        int defaultPrimeNumberForHashing = 31;
        int hash = 3;
        return defaultPrimeNumberForHashing * hash + x.getCircle().hashCode();
    }
}