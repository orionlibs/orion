package com.orion.math.geometry.shape.line.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.number.ANumber;

public class GetDistanceBetweenPointAndLineTask extends Orion
{
    public static ANumber run(Line line, Point point, int precision)
    {
        LineRules.isValid(line);
        PointRules.isValid(point);
        ANumber result = line.getFormula().run(point.get(0), point.get(1));
        ANumber sumOfSquares = line.getA().squareGET().addGET(line.getB().squareGET());
        return result.getAbsoluteValue().divideGET(sumOfSquares.getSquareRoot(precision));
    }
}