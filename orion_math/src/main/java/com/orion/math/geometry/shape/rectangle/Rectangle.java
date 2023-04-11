package com.orion.math.geometry.shape.rectangle;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Quadruple;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class Rectangle implements MathObject, Cloneable
{
    private Point topLeftPoint;
    private Point topRightPoint;
    private Point bottomLeftPoint;
    private Point bottomRightPoint;
    private ANumber lengthOfSideFromTopLeftToTopRight;
    private ANumber lengthOfSideFromTopLeftToBottomLeft;
    private ANumber lengthOfSideFromBottomLeftToBottomRight;
    private ANumber lengthOfSideFromTopRightToBottomRight;


    protected Rectangle()
    {
    }


    public Rectangle(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        this(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint, Precision.precision);
    }


    public Rectangle(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint, int precision)
    {
        buildRectangleBasedOnCornerPoints(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint, precision);
    }


    public Rectangle(Point midpoint1, Point midpoint2, ANumber lengthOfSide)
    {
        this(midpoint1, midpoint2, lengthOfSide, Precision.precision);
    }


    public Rectangle(Point midpoint1, Point midpoint2, ANumber lengthOfSide, int precision)
    {
        RectangleRules.isValid(midpoint1, midpoint2);
        NumberRules.isPositive(lengthOfSide);
        getRectangleFromMidpoints(midpoint1, midpoint2, lengthOfSide);
        this.lengthOfSideFromTopLeftToTopRight = Vector.of(topLeftPoint, topRightPoint).getMagnitude(precision);
        this.lengthOfSideFromTopLeftToBottomLeft = Vector.of(topLeftPoint, bottomLeftPoint).getMagnitude(precision);
        this.lengthOfSideFromBottomLeftToBottomRight = Vector.of(bottomLeftPoint, bottomRightPoint).getMagnitude(precision);
        this.lengthOfSideFromTopRightToBottomRight = Vector.of(topRightPoint, bottomRightPoint).getMagnitude(precision);
    }


    public Rectangle(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        Quadruple<Point, Point, Point, Point> cornerPoints = RectangleService.getRectangleCornerPointsUsing4LineSegments(s1, s2, s3, s4);
        buildRectangleBasedOnCornerPoints(cornerPoints.getFirst(), cornerPoints.getSecond(), cornerPoints.getThird(), cornerPoints.getFourth(), Precision.precision);
    }


    public Rectangle(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        Quadruple<Point, Point, Point, Point> cornerPoints = RectangleService.getRectangleCornerPointsUsing4LineSegments(s1, s2, s3, s4, precision);
        buildRectangleBasedOnCornerPoints(cornerPoints.getFirst(), cornerPoints.getSecond(), cornerPoints.getThird(), cornerPoints.getFourth(), precision);
    }


    public static Rectangle of(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint)
    {
        return new Rectangle(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
    }


    public static Rectangle of(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint, int precision)
    {
        return new Rectangle(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint, precision);
    }


    public static Rectangle of(Point midpoint1, Point midpoint2, ANumber lengthOfSide)
    {
        return new Rectangle(midpoint1, midpoint2, lengthOfSide);
    }


    public static Rectangle of(Point midpoint1, Point midpoint2, ANumber lengthOfSide, int precision)
    {
        return new Rectangle(midpoint1, midpoint2, lengthOfSide, precision);
    }


    public static Rectangle of(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4)
    {
        return new Rectangle(s1, s2, s3, s4);
    }


    public static Rectangle of(LineSegment s1, LineSegment s2, LineSegment s3, LineSegment s4, int precision)
    {
        return new Rectangle(s1, s2, s3, s4, precision);
    }


    private void buildRectangleBasedOnCornerPoints(Point topLeftPoint, Point topRightPoint, Point bottomLeftPoint, Point bottomRightPoint, int precision)
    {
        RectangleRules.isValid(topLeftPoint, topRightPoint, bottomLeftPoint, bottomRightPoint);
        this.topLeftPoint = topLeftPoint;
        this.topRightPoint = topRightPoint;
        this.bottomLeftPoint = bottomLeftPoint;
        this.bottomRightPoint = bottomRightPoint;
        this.lengthOfSideFromTopLeftToTopRight = Vector.of(topLeftPoint, topRightPoint).getMagnitude(precision);
        this.lengthOfSideFromTopLeftToBottomLeft = Vector.of(topLeftPoint, bottomLeftPoint).getMagnitude(precision);
        this.lengthOfSideFromBottomLeftToBottomRight = Vector.of(bottomLeftPoint, bottomRightPoint).getMagnitude(precision);
        this.lengthOfSideFromTopRightToBottomRight = Vector.of(topRightPoint, bottomRightPoint).getMagnitude(precision);
    }


    protected void getRectangleFromMidpoints(Point midpoint1, Point midpoint2, ANumber lengthOfSide)
    {
        getRectangleFromMidpoints(midpoint1, midpoint2, lengthOfSide, Precision.precision);
    }


    protected void getRectangleFromMidpoints(Point midpoint1, Point midpoint2, ANumber lengthOfSide, int precision)
    {
        ANumber lengthHalf = lengthOfSide.halfGET();

        if(midpoint1.getX().equal(midpoint2.getX()))
        {
            this.topLeftPoint = Point.of(midpoint1.getX().subtractGET(lengthHalf), midpoint1.getY());
            this.topRightPoint = Point.of(midpoint1.getX().addGET(lengthHalf), midpoint1.getY());
            this.bottomLeftPoint = Point.of(midpoint2.getX().subtractGET(lengthHalf), midpoint2.getY());
            this.bottomRightPoint = Point.of(midpoint2.getX().addGET(lengthHalf), midpoint2.getY());
        }
        else if(midpoint1.getY().equal(midpoint2.getY()))
        {
            this.topLeftPoint = Point.of(midpoint1.getX(), midpoint1.getY().subtractGET(lengthHalf));
            this.topRightPoint = Point.of(midpoint1.getX(), midpoint1.getY().addGET(lengthHalf));
            this.bottomLeftPoint = Point.of(midpoint2.getX(), midpoint2.getY().subtractGET(lengthHalf));
            this.bottomRightPoint = Point.of(midpoint2.getX(), midpoint2.getY().addGET(lengthHalf));
        }
        else
        {
            ANumber slopeOfSide = midpoint1.getX().subtractGET(midpoint2.getX()).divideGET(midpoint2.getY().subtractGET(midpoint1.getY()));
            ANumber dx = lengthOfSide.divideGET(slopeOfSide.squareGET().addOneGET().getSquareRoot(precision)).halfGET();
            ANumber dy = slopeOfSide.multiplyGET(dx);
            this.topLeftPoint = Point.of(midpoint1.getX().subtractGET(dx), midpoint1.getY().subtractGET(dy));
            this.topRightPoint = Point.of(midpoint1.getX().addGET(dx), midpoint1.getY().addGET(dy));
            this.bottomLeftPoint = Point.of(midpoint2.getX().subtractGET(dx), midpoint2.getY().subtractGET(dy));
            this.bottomRightPoint = Point.of(midpoint2.getX().addGET(dx), midpoint2.getY().addGET(dy));
        }

    }


    public ANumber getPerimeter()
    {
        return RectangleService.getPerimeter(this);
    }


    public ANumber getArea()
    {
        return RectangleService.getArea(this);
    }


    public boolean isPointInsideRectangle(Point other)
    {
        return RectangleService.isPointInsideRectangle(this, other);
    }


    public boolean isPointOnRectangle(Point other)
    {
        return RectangleService.isPointOnRectangle(this, other);
    }


    public boolean isPointInsideOrOnRectangle(Point other)
    {
        return RectangleService.isPointInsideOrOnRectangle(this, other);
    }


    public boolean doesOverlapWith(Rectangle other)
    {
        return RectangleService.doesOverlapWith(this, other);
    }


    public boolean isEquiable()
    {
        return getPerimeter().equal(getArea());
    }


    public ANumber getLengthOfDiagonal()
    {
        return RectangleService.getLengthOfDiagonal(this);
    }


    public ANumber getLengthOfDiagonal(int precision)
    {
        return RectangleService.getLengthOfDiagonal(this, precision);
    }


    public ANumber getCircumradius()
    {
        return RectangleService.getCircumradius(this);
    }


    public ANumber getCircumradius(int precision)
    {
        return RectangleService.getCircumradius(this, precision);
    }


    public LineSegment getLeftDiagonal()
    {
        return RectangleService.getLeftDiagonal(this);
    }


    public LineSegment getRightDiagonal()
    {
        return RectangleService.getRightDiagonal(this);
    }


    @Override
    public Rectangle clone() throws CloneNotSupportedException
    {
        return (Rectangle)CloningService.clone(this);
    }


    public Rectangle getCopy()
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
        return RectangleInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return RectangleInternalService.equals(this, object);
    }


    public Point getTopLeftPoint()
    {
        return this.topLeftPoint;
    }


    public Point getTopRightPoint()
    {
        return this.topRightPoint;
    }


    public Point getBottomLeftPoint()
    {
        return this.bottomLeftPoint;
    }


    public Point getBottomRightPoint()
    {
        return this.bottomRightPoint;
    }


    public ANumber getLengthOfSideFromTopLeftToTopRight()
    {
        return this.lengthOfSideFromTopLeftToTopRight;
    }


    public ANumber getLengthOfSideFromTopLeftToBottomLeft()
    {
        return this.lengthOfSideFromTopLeftToBottomLeft;
    }


    public ANumber getLengthOfSideFromBottomLeftToBottomRight()
    {
        return this.lengthOfSideFromBottomLeftToBottomRight;
    }


    public ANumber getLengthOfSideFromTopRightToBottomRight()
    {
        return this.lengthOfSideFromTopRightToBottomRight;
    }


    protected void setTopLeftPoint(Point topLeftPoint)
    {
        this.topLeftPoint = topLeftPoint;
    }


    protected void setTopRightPoint(Point topRightPoint)
    {
        this.topRightPoint = topRightPoint;
    }


    protected void setBottomLeftPoint(Point bottomLeftPoint)
    {
        this.bottomLeftPoint = bottomLeftPoint;
    }


    protected void setBottomRightPoint(Point bottomRightPoint)
    {
        this.bottomRightPoint = bottomRightPoint;
    }


    protected void setLengthOfSideFromTopLeftToTopRight(ANumber lengthOfSideFromTopLeftToTopRight)
    {
        this.lengthOfSideFromTopLeftToTopRight = lengthOfSideFromTopLeftToTopRight;
    }


    protected void setLengthOfSideFromTopLeftToBottomLeft(ANumber lengthOfSideFromTopLeftToBottomLeft)
    {
        this.lengthOfSideFromTopLeftToBottomLeft = lengthOfSideFromTopLeftToBottomLeft;
    }


    protected void setLengthOfSideFromBottomLeftToBottomRight(ANumber lengthOfSideFromBottomLeftToBottomRight)
    {
        this.lengthOfSideFromBottomLeftToBottomRight = lengthOfSideFromBottomLeftToBottomRight;
    }


    protected void setLengthOfSideFromTopRightToBottomRight(ANumber lengthOfSideFromTopRightToBottomRight)
    {
        this.lengthOfSideFromTopRightToBottomRight = lengthOfSideFromTopRightToBottomRight;
    }
}