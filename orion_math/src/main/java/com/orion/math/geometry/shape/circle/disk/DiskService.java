package com.orion.math.geometry.shape.circle.disk;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;

public class DiskService extends OrionService
{
    public static boolean isPointInsideDisk(Disk disk, Point point)
    {
        DiskRules.isValid(disk);
        return disk.getFormula().run(point.getX(), point.getY()).isNegative();
    }


    public static boolean isPointOnDisk(Disk disk, Point point)
    {
        DiskRules.isValid(disk);
        return disk.getFormula().run(point.getX(), point.getY()).isZero();
    }


    public static boolean isPointInsideOrOnDisk(Disk disk, Point point)
    {
        return isPointInsideDisk(disk, point) || isPointOnDisk(disk, point);
    }
}