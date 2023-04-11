package com.orion.math.geometry.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetMinimumDistanceBetweenLineAndPointIn3DTask extends Orion
{
    public static ANumber run(Point linePoint1, Point linePoint2, Point point, int precision)
    {
        PointRules.areValid(linePoint1, linePoint2, point);
        precision = Precision.getValidPrecision(precision);
        Vector lineSegmentVector = Vector.of(linePoint1, linePoint2);
        VectorRules.isNotZeroVector(lineSegmentVector);
        Vector vectorFromLinePoint1ToPoint = Vector.of(linePoint1, point);
        return lineSegmentVector.getCrossProductMagnitude(vectorFromLinePoint1ToPoint, precision).divideGET(lineSegmentVector.getMagnitude(precision));
    }
}