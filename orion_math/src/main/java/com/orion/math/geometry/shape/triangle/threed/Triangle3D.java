package com.orion.math.geometry.shape.triangle.threed;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Triple;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Triangle3D implements MathObject, Cloneable
{
    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ANumber lengthOfA;
    private ANumber lengthOfB;
    private ANumber lengthOfC;
    private ANumber angleA;
    private ANumber angleB;
    private ANumber angleC;
    private boolean isLengthOnlyTriangle;


    public Triangle3D(Point pointA, Point pointB, Point pointC)
    {
        this(pointA, pointB, pointC, Precision.precision);
    }


    public Triangle3D(Point pointA, Point pointB, Point pointC, int precision)
    {
        Triangle3DRules.isValid(pointA, pointB, pointC);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.lengthOfA = pointB.getDistanceFromPoint(pointC, precision);
        this.lengthOfB = pointA.getDistanceFromPoint(pointC, precision);
        this.lengthOfC = pointA.getDistanceFromPoint(pointB, precision);
        Triple<ANumber, ANumber, ANumber> angles = Triangle3DService.getAnglesAsRadians(this, precision);
        this.angleA = angles.getFirst();
        this.angleB = angles.getSecond();
        this.angleC = angles.getThird();
    }


    public Triangle3D(ANumber area, ANumber hypotenuse)
    {
        Triangle3DRules.isValid(area, hypotenuse);
        buildRightTriangleFromAreaAndHypotenuse(area, hypotenuse, Precision.precision);
    }


    public Triangle3D(ANumber area, ANumber hypotenuse, int precision)
    {
        Triangle3DRules.isValid(area, hypotenuse);
        buildRightTriangleFromAreaAndHypotenuse(area, hypotenuse, precision);
    }


    public static Triangle3D of(Point pointA, Point pointB, Point pointC)
    {
        return new Triangle3D(pointA, pointB, pointC);
    }


    public static Triangle3D of(Point pointA, Point pointB, Point pointC, int precision)
    {
        return new Triangle3D(pointA, pointB, pointC, precision);
    }


    public static Triangle3D of(ANumber area, ANumber hypotenuse)
    {
        return new Triangle3D(area, hypotenuse);
    }


    public static Triangle3D of(ANumber area, ANumber hypotenuse, int precision)
    {
        return new Triangle3D(area, hypotenuse, precision);
    }


    private void buildRightTriangleFromAreaAndHypotenuse(ANumber area, ANumber hypotenuse, int precision)
    {
        ANumber hypotenuseSquared = hypotenuse.squareGET();
        ANumber discriminant = hypotenuseSquared.squareGET().subtractGET(area.squareGET().multiplyGET(16));
        ANumber discriminantSquareRoot = discriminant.getSquareRoot(precision);

        if(discriminant.isNonNegative())
        {
            ANumber root1 = hypotenuseSquared.addGET(discriminantSquareRoot).halfGET();
            ANumber root2 = hypotenuseSquared.subtractGET(discriminantSquareRoot).halfGET();
            this.lengthOfA = root1.getSquareRoot(precision);
            this.lengthOfB = hypotenuse.getCopy();
            this.lengthOfC = root2.getSquareRoot(precision);
            Triple<ANumber, ANumber, ANumber> angles = Triangle3DService.getAnglesAsRadians(this, precision);
            this.angleA = angles.getFirst();
            this.angleB = angles.getSecond();
            this.angleC = angles.getThird();
            this.isLengthOnlyTriangle = true;
        }
        else
        {
            Triangle3DRules.isValid(this);
        }

    }


    public ANumber getAngleAAsDegrees()
    {
        return TrigonometryService.convertRadiansToDegrees(getAngleA());
    }


    public ANumber getAngleBAsDegrees()
    {
        return TrigonometryService.convertRadiansToDegrees(getAngleB());
    }


    public ANumber getAngleCAsDegrees()
    {
        return TrigonometryService.convertRadiansToDegrees(getAngleC());
    }


    public ANumber getPerimeter()
    {
        return Triangle3DService.getPerimeter(this);
    }


    public ANumber getHalfPerimeter()
    {
        return Triangle3DService.getHalfPerimeter(this);
    }


    public ANumber getArea()
    {
        return Triangle3DService.getArea(this);
    }


    public boolean isEquiable()
    {
        return getPerimeter().equal(getArea());
    }


    public boolean isSimilarTo(Triangle3D other)
    {
        return Triangle3DService.isSimilarTo(this, other);
    }


    @Override
    public Triangle3D clone() throws CloneNotSupportedException
    {
        return (Triangle3D)CloningService.clone(this);
    }


    public Triangle3D getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return Triangle3DInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return Triangle3DInternalService.equals(this, object);
    }


    public Point getPointA()
    {
        return this.pointA;
    }


    public Point getPointB()
    {
        return this.pointB;
    }


    public Point getPointC()
    {
        return this.pointC;
    }


    public ANumber getLengthOfA()
    {
        return this.lengthOfA;
    }


    public ANumber getLengthOfB()
    {
        return this.lengthOfB;
    }


    public ANumber getLengthOfC()
    {
        return this.lengthOfC;
    }


    public boolean isLengthOnlyTriangle()
    {
        return this.isLengthOnlyTriangle;
    }


    public ANumber getAngleA()
    {
        return this.angleA;
    }


    public ANumber getAngleB()
    {
        return this.angleB;
    }


    public ANumber getAngleC()
    {
        return this.angleC;
    }
}