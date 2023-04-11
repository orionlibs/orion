package com.orion.math.geometry.shape.circle.chord;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.shape.linesegment.LineSegment;
import com.orion.math.number.ANumber;

public class CircleChord implements MathObject, Cloneable
{
    private Point center;
    private ANumber radius;
    private Point startPoint;
    private Point endPoint;
    private LineSegment chordLineSegment;


    public CircleChord(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        CircleChordRules.isValid(center, radius, startPoint, endPoint);
        this.center = center;
        this.radius = radius;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.chordLineSegment = LineSegment.of(startPoint, endPoint);
    }


    public static CircleChord of(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        return new CircleChord(center, radius, startPoint, endPoint);
    }


    public Circle getCircle()
    {
        return Circle.of(center, radius);
    }


    public boolean isPointOnChord(Point point)
    {
        return CircleChordService.isPointOnChord(this, point);
    }


    public ANumber getLength()
    {
        return CircleChordService.getLength(this);
    }


    public ANumber getLength(int precision)
    {
        return CircleChordService.getLength(this, precision);
    }


    public boolean isDiameter()
    {
        return CircleChordService.isDiameter(this);
    }


    @Override
    public CircleChord clone() throws CloneNotSupportedException
    {
        return (CircleChord)CloningService.clone(this);
    }


    public CircleChord getCopy()
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
        return CircleChordInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CircleChordInternalService.equals(this, object);
    }


    public Point getCenter()
    {
        return this.center;
    }


    public ANumber getRadius()
    {
        return this.radius;
    }


    public Point getStartPoint()
    {
        return this.startPoint;
    }


    public Point getEndPoint()
    {
        return this.endPoint;
    }


    public LineSegment getChordLineSegment()
    {
        return this.chordLineSegment;
    }
}