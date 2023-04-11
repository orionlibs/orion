package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;

public class GetMinimumCostOfTriangulationOfPolygonTask extends Orion
{
    public static ANumber run(Polygon polygon, int precision)
    {
        PolygonRules.isValid(polygon);
        return run(polygon, 0, polygon.getNumberOfVertices() - 1, precision);
    }


    private static ANumber run(Polygon polygon, int start, int end, int precision)
    {

        if(end < start + 2)
        {
            return ANumber.of(0);
        }

        ANumber result = ANumber.ofMax();

        for(int i = start + 1; i < end; i++)
        {
            ANumber temp = (run(polygon, start, i, precision).addGET(run(polygon, i, end, precision)).addGET(getCost(polygon, start, i, end, precision)));
            result = ArithmeticService.getMinimum(result, temp);
        }

        return result;
    }


    private static ANumber getCost(Polygon polygon, int start, int end, int other, int precision)
    {
        Point p1 = polygon.get(start);
        Point p2 = polygon.get(end);
        Point p3 = polygon.get(other);
        return p1.getDistanceFromPoint(p2, precision).addGET(p2.getDistanceFromPoint(p3, precision)).addGET(p3.getDistanceFromPoint(p1, precision));
    }
}