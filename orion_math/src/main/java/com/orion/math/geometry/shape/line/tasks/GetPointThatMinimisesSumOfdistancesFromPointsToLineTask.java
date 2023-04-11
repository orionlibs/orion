package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.stream.IntStream;

public class GetPointThatMinimisesSumOfdistancesFromPointsToLineTask extends Orion
{
    public static Pair<Point, ANumber> run(Line line, Point[] points, int precision)
    {
        LineRules.isValid(line);
        PointRules.areValid(points);
        ANumber EPS = Precision.getEPSAsNumber(precision);
        ANumber low = EPS.negateGET();
        ANumber high = EPS.getCopy();

        while((high.subtractGET(low)).isGreaterThan(EPS))
        {
            ANumber mid1 = low.addGET(high.subtractGET(low).divideGET(3));
            ANumber mid2 = high.subtractGET(high.subtractGET(low).divideGET(3));
            Pair<Point, ANumber> dist1 = compute(points, line, mid1, precision);
            Pair<Point, ANumber> dist2 = compute(points, line, mid2, precision);

            if(dist1.getSecond().isLessThan(dist2.getSecond()))
            {
                high = mid2.getCopy();
            }
            else
            {
                low = mid1.getCopy();
            }

        }

        Pair<Point, ANumber> result = compute(points, line, low.addGET(high).halfGET(), precision);
        ANumber minimumSumOfDistances = result.getSecond();
        return Pair.of(result.getFirst(), minimumSumOfDistances);
    }


    private static Pair<Point, ANumber> compute(Point[] points, Line line, ANumber x, int precision)
    {
        ANumber result = ANumber.of(0);
        ANumber y = (line.getC().addGET(line.getA().multiplyGET(x))).negateGET().divideGET(line.getB());
        IntStream.range(0, points.length).forEach(i -> result.add(Point.of(x, y).getDistanceFromPoint(points[i], precision)));
        return Pair.of(Point.of(x, y), result);
    }
}