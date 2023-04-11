package com.orion.math.geometry.shape.circle.disk;

import com.orion.math.MathObject;
import com.orion.math.geometry.shape.circle.disk.tasks.DiskEqualsTask;
import com.orion.math.geometry.shape.circle.disk.tasks.DiskHashCodeTask;

class DiskInternalService implements MathObject
{
    static boolean equals(Disk x, Object y)
    {
        return DiskEqualsTask.run(x, y);
    }


    static int hashCode(Disk x)
    {
        return DiskHashCodeTask.run(x);
    }
}