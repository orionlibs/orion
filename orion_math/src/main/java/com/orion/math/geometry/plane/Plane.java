package com.orion.math.geometry.plane;

import com.orion.math.MathObject;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class Plane implements MathObject
{
    private ANumber a;
    private ANumber b;
    private ANumber c;
    private ANumber d;
    private Function3x1<ANumber, ANumber, ANumber, ANumber> formula;


    public Plane(ANumber a, ANumber b, ANumber c, ANumber d)
    {
        NumberRules.areNotNull(a, b, c, d);
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        buildFormula();
    }


    public Plane(Number a, Number b, Number c, Number d)
    {
        NumberRules.areNotNull(a, b, c, d);
        this.a = ANumber.of(a);
        this.b = ANumber.of(b);
        this.c = ANumber.of(c);
        this.d = ANumber.of(d);
        buildFormula();
    }


    public Plane(Point point1, Point point2, Point point3)
    {
        PlaneRules.isValid(point1, point2, point3);
        ANumber a1 = point2.getX().subtractGET(point1.getX());
        ANumber b1 = point2.getY().subtractGET(point1.getY());
        ANumber c1 = point2.getZ().subtractGET(point1.getZ());
        ANumber a2 = point3.getX().subtractGET(point1.getX());
        ANumber b2 = point3.getY().subtractGET(point1.getY());
        ANumber c2 = point3.getZ().subtractGET(point1.getZ());
        this.a = b1.multiplyGET(c2).subtractGET(b2.multiplyGET(c1));
        this.b = a2.multiplyGET(c1).subtractGET(c2.multiplyGET(a1));
        this.c = a1.multiplyGET(b2).subtractGET(a2.multiplyGET(b1));
        this.d = a.negateGET().multiplyGET(point1.getX()).subtractGET(b.multiplyGET(point1.getY())).subtractGET(c.multiplyGET(point1.getZ()));
        buildFormula();
    }


    public static Plane of(ANumber a, ANumber b, ANumber c, ANumber d)
    {
        return new Plane(a, b, c, d);
    }


    public static Plane of(Number a, Number b, Number c, Number d)
    {
        return new Plane(a, b, c, d);
    }


    public static Plane of(Point point1, Point point2, Point point3)
    {
        return new Plane(point1, point2, point3);
    }


    private void buildFormula()
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y, ANumber z) ->
        {
            return a.multiplyGET(x).addGET(b.multiplyGET(y)).addGET(c.multiplyGET(z)).addGET(d);
        };
        formula = new Function3x1<ANumber, ANumber, ANumber, ANumber>(formulaFunction);
    }


    public ANumber getDistanceFromPoint(Point point)
    {
        return PlaneService.getDistanceFromPoint(this, point);
    }


    public ANumber getAngleWithPlane(Plane other)
    {
        return PlaneService.getAngleWithPlane(this, other);
    }


    public ANumber getAngleWithPlane(Plane other, int precision)
    {
        return PlaneService.getAngleWithPlane(this, other, precision);
    }


    public boolean isParallelTo(Plane other)
    {
        return PlaneService.isParallelTo(this, other);
    }


    public boolean isNotParallelTo(Plane other)
    {
        return PlaneService.isNotParallelTo(this, other);
    }


    public ANumber getDistanceFromParallelPlane(Plane other)
    {
        return PlaneService.getDistanceFromParallelPlane(this, other);
    }


    public ANumber getDistanceFromParallelPlane(Plane other, int precision)
    {
        return PlaneService.getDistanceFromParallelPlane(this, other, precision);
    }


    public Point getFootOfPerpendicularLineFromPoint(Point point)
    {
        return PlaneService.getFootOfPerpendicularLineFromPoint(this, point);
    }


    public ANumber getA()
    {
        return this.a;
    }


    public ANumber getB()
    {
        return this.b;
    }


    public ANumber getC()
    {
        return this.c;
    }


    public ANumber getD()
    {
        return this.d;
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }
}