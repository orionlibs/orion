package com.orion.math.geometry.point.tasks.relocation;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.shape.line.LineRules;
import com.orion.math.number.ANumber;

public class ReflectPointAboutLineTask extends Orion
{
    public static Point run(Point p, Line line)
    {
        PointRules.isValid(p);
        LineRules.isValid(line);
        ANumber aSquaredPlusBSquared = line.getA().squareGET().addGET(line.getB().squareGET());
        ANumber x = p.getX().multiplyGET(line.getA().squareGET().subtractGET(line.getB().squareGET()));
        x.subtract(line.getB().doubleGET().multiplyGET(line.getA().multiplyGET(p.getY()).addGET(line.getC())));
        x.divide(aSquaredPlusBSquared);
        ANumber y = p.getY().multiplyGET(line.getB().squareGET().subtractGET(line.getA().squareGET()));
        y.subtract(line.getA().doubleGET().multiplyGET(line.getB().multiplyGET(p.getX()).addGET(line.getC())));
        y.divide(aSquaredPlusBSquared);
        return Point.of(x, y);
    }
}