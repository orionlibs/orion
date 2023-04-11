package com.orion.math.geometry.shape.circle.sector.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.circle.sector.CircleSector;
import com.orion.math.geometry.shape.circle.sector.CircleSectorRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class IsPointOnSectorTask extends Orion
{
    public static boolean run(CircleSector sector, Point point, int precision)
    {
        CircleSectorRules.isValidIgnoringEndPoint(sector);
        PointRules.isValid(point);
        Vector vector1 = Vector.of(sector.getCenter(), sector.getStartPoint());
        ANumber angleBetweenStartPointAndXAxis = vector1.getAngleWithXAxisAsRadians(precision);
        ANumber angleBetweenEndPointAndXAxis = angleBetweenStartPointAndXAxis.addGET(sector.getAngleInRadians());
        Vector vector2 = Vector.of(sector.getCenter(), point);
        return sector.getCircle().isPointOnCircle(point, precision)
                        && Numbers.isBetween(vector2.getAngleWithXAxisAsRadians(precision), angleBetweenStartPointAndXAxis, angleBetweenEndPointAndXAxis);
    }
}