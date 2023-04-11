package com.orion.math.geometry.shape.linesegment;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.point.PointRules;
import com.orion.math.geometry.shape.line.Line;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class LineSegment implements MathObject, Cloneable, Comparable<LineSegment>
{
    private Point startPoint;
    private Point endPoint;


    public LineSegment(Point startPoint, Point endPoint)
    {
        PointRules.areNotEqual(startPoint, endPoint);
        PointRules.doDimensionsMatch(startPoint, endPoint);

        if(startPoint.getX().isLessThanOrEqual(endPoint.getX()))
        {

            if(startPoint.getY().isLessThanOrEqual(endPoint.getY()))
            {
                this.startPoint = startPoint;
                this.endPoint = endPoint;
            }
            else
            {
                this.startPoint = endPoint;
                this.endPoint = startPoint;
            }

        }
        else
        {
            this.startPoint = endPoint;
            this.endPoint = startPoint;
        }

    }


    public static LineSegment of(Point startPoint, Point endPoint)
    {
        return new LineSegment(startPoint, endPoint);
    }


    public static LineSegment ofStartAndMidpoint(Point startPoint, Point midPoint)
    {
        PointRules.areValid(startPoint, midPoint);
        ANumber x = midPoint.getX().doubleGET().subtractGET(startPoint.getX());
        ANumber y = midPoint.getY().doubleGET().subtractGET(startPoint.getY());
        return new LineSegment(startPoint, Point.of(x, y));
    }


    public Line getLine()
    {
        return LineSegmentService.getLine(this);
    }


    public ANumber getLength()
    {
        return getStartPoint().getDistanceFromPoint(getEndPoint());
    }


    public ANumber getLength(int precision)
    {
        return getStartPoint().getDistanceFromPoint(getEndPoint(), precision);
    }


    public int getDimensions()
    {
        return getStartPointCoordinates().length;
    }


    public boolean doesIntersect(LineSegment other)
    {
        return LineSegmentService.doesIntersect(this, other);
    }


    public boolean isPointOnLineSegment(Point point)
    {
        return LineSegmentService.isPointOnLineSegment(this, point);
    }


    public boolean isCollinearTo(LineSegment other)
    {
        return LineSegmentService.isCollinearTo(this, other);
    }


    public boolean isNotCollinearTo(LineSegment other)
    {
        return LineSegmentService.isNotCollinearTo(this, other);
    }


    public boolean isPerpendicularTo(LineSegment other)
    {
        return LineSegmentService.isPerpendicularTo(this, other);
    }


    public boolean isPerpendicularTo(LineSegment other, int precision)
    {
        return LineSegmentService.isPerpendicularTo(this, other, precision);
    }


    public boolean isParallelTo(LineSegment other)
    {
        return LineSegmentService.isParallelTo(this, other);
    }


    public boolean isParallelTo(LineSegment other, int precision)
    {
        return LineSegmentService.isParallelTo(this, other, precision);
    }


    public boolean isParallelToXAxis()
    {
        return LineSegmentService.isParallelToXAxis(this);
    }


    public boolean isParallelToXAxis(int precision)
    {
        return LineSegmentService.isParallelToXAxis(this, precision);
    }


    public ANumber getAngleWithXAxisAsRadians()
    {
        return LineSegmentService.getAngleWithXAxisAsRadians(this);
    }


    public Line getPerpendicularBisector()
    {
        return LineSegmentService.getPerpendicularBisector(this);
    }


    public Point getMidpoint()
    {
        return LineSegmentService.getMidpoint(this);
    }


    public boolean doesPointLieOnTheLeft(Point point)
    {
        return LineSegmentService.doesPointLieOnTheLeft(this, point);
    }


    public boolean doesPointLieOnTheRight(Point point)
    {
        return LineSegmentService.doesPointLieOnTheRight(this, point);
    }


    public Pair<LineSegment, LineSegment> divideLineSegmentWithRatio(ANumber ratio)
    {
        return LineSegmentService.divideLineSegmentWithRatio(this, ratio);
    }


    public boolean doesLinePassThroughPointOfOrigin()
    {
        return LineSegmentService.doesLinePassThroughPointOfOrigin(this);
    }


    public boolean isEquipollentTo(LineSegment other)
    {
        return LineSegmentService.isEquipollentTo(this, other);
    }


    public Vector getAsVector()
    {
        return Vector.of(getStartPoint(), getEndPoint());
    }


    public ANumber[] getStartPointCoordinates()
    {
        return getStartPoint().getCoordinates();
    }


    public ANumber[] getEndPointCoordinates()
    {
        return getEndPoint().getCoordinates();
    }


    @Override
    public LineSegment clone() throws CloneNotSupportedException
    {
        return (LineSegment)CloningService.clone(this);
    }


    public LineSegment getCopy()
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
        return LineSegmentInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return LineSegmentInternalService.equals(this, object);
    }


    @Override
    public int compareTo(LineSegment other)
    {
        return LineSegmentInternalService.compareTo(this, other);
    }


    public Point getStartPoint()
    {
        return this.startPoint;
    }


    public void setStartPoint(Point startPoint)
    {
        this.startPoint = startPoint;
    }


    public Point getEndPoint()
    {
        return this.endPoint;
    }


    public void setEndPoint(Point endPoint)
    {
        this.endPoint = endPoint;
    }
}