package com.orion.math.geometry.shape.square;

import com.orion.core.object.CloningService;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.shape.rectangle.Rectangle;
import com.orion.math.geometry.shape.rectangle.RectangleService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class Square extends Rectangle
{
    private ANumber lengthOfSide;


    public Square(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        super(s1, s2, s3, s4, Precision.precision);
        SquareRules.isValid(getTopLeftPoint(), getTopRightPoint(), getBottomLeftPoint(), getBottomRightPoint());
        this.lengthOfSide = Vector.of(getTopLeftPoint(), getTopRightPoint()).getMagnitude(Precision.precision);
    }


    public Square(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        super(s1, s2, s3, s4, precision);
        SquareRules.isValid(getTopLeftPoint(), getTopRightPoint(), getBottomLeftPoint(), getBottomRightPoint());
        this.lengthOfSide = Vector.of(getTopLeftPoint(), getTopRightPoint()).getMagnitude(precision);
    }


    public Square(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        this(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint, Precision.precision);
    }


    public Square(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint, int precision)
    {
        super(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        SquareRules.isValid(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        this.lengthOfSide = Vector.of(topLeftPoint, topRightPoint).getMagnitude(precision);
    }


    public Square(Point midpoint1, Point midpoint2, ANumber lengthOfSide)
    {
        super(midpoint1, midpoint2, lengthOfSide);
        SquareRules.isValid(midpoint1, midpoint2);
        NumberRules.isPositive(lengthOfSide);
        this.lengthOfSide = Vector.of(getTopLeftPoint(), getTopRightPoint()).getMagnitude();
    }


    public Square(ANumber lengthOfSide)
    {
        NumberRules.isPositive(lengthOfSide);
        this.lengthOfSide = lengthOfSide;
    }


    public Square(Number lengthOfSide)
    {
        NumberRules.isPositive(lengthOfSide);
        this.lengthOfSide = ANumber.of(lengthOfSide);
    }


    public static Square of(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        return new Square(s1, s2, s3, s4);
    }


    public static Square of(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        return new Square(s1, s2, s3, s4, precision);
    }


    public static Square of(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        return new Square(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
    }


    public static Square of(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint, int precision)
    {
        return new Square(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint, precision);
    }


    public static Square of(Point midPoint1, Point midpoint2, ANumber lengthOfSide)
    {
        return new Square(midPoint1, midpoint2, lengthOfSide);
    }


    public static Square of(ANumber lengthOfSide)
    {
        return new Square(lengthOfSide);
    }


    public static Square of(Number lengthOfSide)
    {
        return new Square(lengthOfSide);
    }


    public static Square ofUnitSquare()
    {
        return new Square(ANumber.of(1));
    }


    public ANumber getPerimeter()
    {
        return SquareService.getPerimeter(this);
    }


    public ANumber getArea()
    {
        return SquareService.getArea(this);
    }


    public boolean isPointInsideSquare(Point other)
    {
        return isPointInsideRectangle(other);
    }


    public boolean isPointOnSquare(Point other)
    {
        return isPointOnRectangle(other);
    }


    public boolean isPointInsideOrOnSquare(Point other)
    {
        return isPointInsideOrOnRectangle(other);
    }


    public boolean doesOverlapWith(Square other)
    {
        return RectangleService.doesOverlapWith(this, other);
    }


    @Override
    public int hashCode()
    {
        return SquareInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return SquareInternalService.equals(this, object);
    }


    @Override
    public Square clone() throws CloneNotSupportedException
    {
        return (Square)CloningService.clone(this);
    }


    public Square getCopy()
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


    public ANumber getLengthOfSide()
    {
        return this.lengthOfSide;
    }
}