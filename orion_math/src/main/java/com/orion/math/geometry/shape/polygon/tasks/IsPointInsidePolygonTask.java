package com.orion.math.geometry.shape.polygon.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.constant.Constants;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.polygon.Polygon;
import com.orion.math.geometry.shape.polygon.PolygonRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import java.util.List;

public class IsPointInsidePolygonTask extends Orion
{
    public static boolean run(Polygon polygon, Point point)
    {
        PolygonRules.isValid(polygon);
        PointRules.isValid(point);

        //polygon is a triangle
        if(polygon.getNumberOfVertices() == 3)
        {
            Vector v1 = Vector.of(point, polygon.get(0));

            if(v1.isZeroVector())
            {
                return true;
            }

            Vector v2 = Vector.of(point, polygon.get(1));

            if(v2.isZeroVector())
            {
                return true;
            }

            Vector v3 = Vector.of(point, polygon.get(2));

            if(v3.isZeroVector())
            {
                return true;
            }

            ANumber angleBetweenV1AndV2 = v1.getAngleWithVectorAsRadians(v2);
            ANumber angleBetweenV2AndV3 = v2.getAngleWithVectorAsRadians(v3);
            ANumber angleBetweenV3AndV1 = v3.getAngleWithVectorAsRadians(v1);
            return angleBetweenV1AndV2.addGET(angleBetweenV2AndV3).addGET(angleBetweenV3AndV1).applyPrecisionGET(5).equal(Constants.twoPI.applyPrecisionGET(5));
        }
        else
        {
            List<ANumber> allXOrdinates = polygon.getPoints().mapToList(p -> p.getX());
            List<ANumber> allYAbscissas = polygon.getPoints().mapToList(p -> p.getY());
            ANumber minimumX = ArithmeticService.getMinimum(allXOrdinates);
            ANumber maximumX = ArithmeticService.getMaximum(allXOrdinates);
            ANumber minimumY = ArithmeticService.getMinimum(allYAbscissas);
            ANumber maximumY = ArithmeticService.getMaximum(allYAbscissas);

            if(point.getX().isLessThan(minimumX) || point.getX().isGreaterThan(maximumX)
                            || point.getY().isLessThan(minimumY) || point.getY().isGreaterThan(maximumY))
            {
                return false;
            }
            else
            {
                Point outsidePoint = Point.of(minimumX.subtractOneGET(), minimumY.subtractOneGET());
                LineSegment pointLineSegment = LineSegment.of(point, outsidePoint);
                int count = 0;
                int i = 0;

                do
                {
                    int next = (i + 1) % polygon.getNumberOfVertices();
                    LineSegment polygonLineSegment = LineSegment.of(polygon.get(i), polygon.get(next));

                    if(polygonLineSegment.isPointOnLineSegment(point))
                    {
                        return true;
                    }
                    else
                    {

                        if(polygonLineSegment.doesIntersect(pointLineSegment))
                        {
                            count++;
                        }

                        i = next;
                    }

                }
                while(i != 0);

                return count % 2 == 1;
            }

        }

    }
}