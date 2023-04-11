package com.orion.math.geometry.shape.circle.arc;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class CircleArc implements MathObject, Cloneable
{
    private Point center;
    private ANumber radius;
    private Point startPoint;
    private Point endPoint;
    private ANumber angleInRadians;


    public CircleArc(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        this(center, radius, startPoint, endPoint, Precision.precision);
    }


    public CircleArc(Point center, ANumber radius, Point startPoint, Point endPoint, int precision)
    {
        CircleArcRules.isValid(center, radius, startPoint, endPoint);
        this.center = center;
        this.radius = radius;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.angleInRadians = getCircle().getAngleAsRadiansBetween(startPoint, endPoint, precision);
    }


    public CircleArc(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        this(center, radius, startPoint, angleInRadians, Precision.precision);
    }


    public CircleArc(Point center, ANumber radius, Point startPoint, ANumber angleInRadians, int precision)
    {
        CircleArcRules.isValid(center, radius, startPoint, angleInRadians);
        this.center = center;
        this.radius = radius;
        this.startPoint = startPoint;
        this.angleInRadians = TrigonometryService.normaliseRadians(angleInRadians);
        this.endPoint = getCircle().getCirclePointBasedOn(startPoint, this.angleInRadians, precision);
    }


    public static CircleArc of(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        return new CircleArc(center, radius, startPoint, endPoint);
    }


    public static CircleArc of(Point center, ANumber radius, Point startPoint, Point endPoint, int precision)
    {
        return new CircleArc(center, radius, startPoint, endPoint, precision);
    }


    public static CircleArc of(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        return new CircleArc(center, radius, startPoint, angleInRadians);
    }


    public static CircleArc of(Point center, ANumber radius, Point startPoint, ANumber angleInRadians, int precision)
    {
        return new CircleArc(center, radius, startPoint, angleInRadians, precision);
    }


    public Circle getCircle()
    {
        return Circle.of(center, radius);
    }


    public boolean isPointOnArc(Point point)
    {
        return CircleArcService.isPointOnArc(this, point);
    }


    public ANumber getLength()
    {
        return CircleArcService.getLength(this);
    }


    public ANumber getAreaFormedByArc()
    {
        return CircleArcService.getAreaFormedByArc(this);
    }


    public ANumber getAreaOfMinorSegmentFormedByArc()
    {
        return CircleArcService.getAreaOfMinorSegmentFormedByArc(this);
    }


    public ANumber getAreaOfMinorSegmentFormedByArc(int precision)
    {
        return CircleArcService.getAreaOfMinorSegmentFormedByArc(this, precision);
    }


    public ANumber getAreaOfMajorSegmentFormedByArc()
    {
        return CircleArcService.getAreaOfMajorSegmentFormedByArc(this);
    }


    public ANumber getAreaOfMajorSegmentFormedByArc(int precision)
    {
        return CircleArcService.getAreaOfMajorSegmentFormedByArc(this, precision);
    }


    @Override
    public CircleArc clone() throws CloneNotSupportedException
    {
        return (CircleArc)CloningService.clone(this);
    }


    public CircleArc getCopy()
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
        return CircleArcInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CircleArcInternalService.equals(this, object);
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


    public ANumber getAngleInRadians()
    {
        return this.angleInRadians;
    }
}