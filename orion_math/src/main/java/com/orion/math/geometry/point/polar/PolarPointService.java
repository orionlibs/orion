package com.orion.math.geometry.point.polar;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.point.polar.tasks.PolarPointPrintTask;

public class PolarPointService extends OrionService
{
    public static String print(PolarPoint point)
    {
        return PolarPointPrintTask.run(point);
    }
}