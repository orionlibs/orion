package com.orion.math.geometry.shape.circle.sector;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.sector.tasks.GetAreaOfCircleSectorTask;
import com.orion.math.geometry.shape.circle.sector.tasks.IsPointOnSectorTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class CircleSectorService extends OrionService
{
    public static ANumber getArea(CircleSector sector)
    {
        return GetAreaOfCircleSectorTask.run(sector);
    }


    public static boolean isPointOnSector(CircleSector sector, Point point)
    {
        return IsPointOnSectorTask.run(sector, point, Precision.precision);
    }


    public static boolean isPointOnSector(CircleSector sector, Point point, int precision)
    {
        return IsPointOnSectorTask.run(sector, point, precision);
    }
}