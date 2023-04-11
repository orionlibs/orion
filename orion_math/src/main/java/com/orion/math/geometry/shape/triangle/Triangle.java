package com.orion.math.geometry.shape.triangle;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Triple;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Triangle implements MathObject, Cloneable
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


    public Triangle(Point pointA, Point pointB, Point pointC)
    {
        this(pointA, pointB, pointC, Precision.precision);
    }


    public Triangle(Point pointA, Point pointB, Point pointC, int precision)
    {
        TriangleRules.isValid(pointA, pointB, pointC);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.lengthOfA = pointB.getDistanceFromPoint(pointC, precision);
        this.lengthOfB = pointA.getDistanceFromPoint(pointC, precision);
        this.lengthOfC = pointA.getDistanceFromPoint(pointB, precision);
        Triple<ANumber, ANumber, ANumber> angles = TriangleService.getAnglesAsRadians(this, precision);
        this.angleA = angles.getFirst();
        this.angleB = angles.getSecond();
        this.angleC = angles.getThird();
    }


    public Triangle(ANumber area, ANumber hypotenuse)
    {
        TriangleRules.isValid(area, hypotenuse);
        buildRightTriangleFromAreaAndHypotenuse(area, hypotenuse, Precision.precision);
    }


    public Triangle(ANumber area, ANumber hypotenuse, int precision)
    {
        TriangleRules.isValid(area, hypotenuse);
        buildRightTriangleFromAreaAndHypotenuse(area, hypotenuse, precision);
    }


    public static Triangle of(Point pointA, Point pointB, Point pointC)
    {
        return new Triangle(pointA, pointB, pointC);
    }


    public static Triangle of(Point pointA, Point pointB, Point pointC, int precision)
    {
        return new Triangle(pointA, pointB, pointC, precision);
    }


    public static Triangle of(ANumber area, ANumber hypotenuse)
    {
        return new Triangle(area, hypotenuse);
    }


    public static Triangle of(ANumber area, ANumber hypotenuse, int precision)
    {
        return new Triangle(area, hypotenuse, precision);
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
            Triple<ANumber, ANumber, ANumber> angles = TriangleService.getAnglesAsRadians(this, precision);
            this.angleA = angles.getFirst();
            this.angleB = angles.getSecond();
            this.angleC = angles.getThird();
            this.isLengthOnlyTriangle = true;
        }
        else
        {
            TriangleRules.isValid(this);
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
        return TriangleService.getPerimeter(this);
    }


    public ANumber getHalfPerimeter()
    {
        return TriangleService.getHalfPerimeter(this);
    }


    public ANumber getArea()
    {
        return TriangleService.getArea(this);
    }


    public ANumber getArea(int precision)
    {
        return TriangleService.getArea(this, precision);
    }


    public boolean isPointInsideOrOnTriangle(Point other)
    {
        return TriangleService.isPointInsideOrOnTriangle(this, other);
    }


    public boolean isPointInsideOrOnTriangle(Point other, int precision)
    {
        return TriangleService.isPointInsideOrOnTriangle(this, other, precision);
    }


    public boolean isPointOnTriangle(Point other)
    {
        return TriangleService.isPointOnTriangle(this, other);
    }


    public boolean isPointOnTriangle(Point other, int precision)
    {
        return TriangleService.isPointOnTriangle(this, other, precision);
    }


    public ANumber getNumberOfLatticePoints()
    {
        return TriangleService.getNumberOfLatticePoints(this);
    }


    public ANumber getNumberOfIntegralPoints()
    {
        return TriangleService.getNumberOfIntegralPoints(this);
    }


    public TriangleSideType getSideType()
    {
        return TriangleService.getSideType(this);
    }


    public TriangleSideType getSideType(int precision)
    {
        return TriangleService.getSideType(this, precision);
    }


    public TriangleAngleType getAngleType()
    {
        return TriangleService.getAngleType(this);
    }


    public Point getCircumcenter()
    {
        return TriangleService.getCircumcenter(this);
    }


    public boolean isEquiable()
    {
        return getPerimeter().equal(getArea());
    }


    public boolean isSimilarTo(Triangle other)
    {
        return TriangleService.isSimilarTo(this, other);
    }


    public Point getCentroid()
    {
        return TriangleService.getCentroid(this);
    }


    @Override
    public Triangle clone() throws CloneNotSupportedException
    {
        return (Triangle)CloningService.clone(this);
    }


    public Triangle getCopy()
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
        return TriangleInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return TriangleInternalService.equals(this, object);
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