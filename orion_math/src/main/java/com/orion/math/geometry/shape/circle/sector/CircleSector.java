package com.orion.math.geometry.shape.circle.sector;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class CircleSector implements MathObject, Cloneable
{
    private Point center;
    private ANumber radius;
    private Point startPoint;
    private Point endPoint;
    private ANumber angleInRadians;


    public CircleSector(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        this(center, radius, startPoint, endPoint, Precision.precision);
    }


    public CircleSector(Point center, ANumber radius, Point startPoint, Point endPoint, int precision)
    {
        CircleSectorRules.isValid(center, radius, startPoint, endPoint);
        this.center = center;
        this.radius = radius;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.angleInRadians = getCircle().getAngleAsRadiansBetween(startPoint, endPoint, precision);
    }


    public CircleSector(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        this(center, radius, startPoint, angleInRadians, Precision.precision);
    }


    public CircleSector(Point center, ANumber radius, Point startPoint, ANumber angleInRadians, int precision)
    {
        CircleSectorRules.isValid(center, radius, startPoint, angleInRadians);
        this.center = center;
        this.radius = radius;
        this.startPoint = startPoint;
        this.angleInRadians = TrigonometryService.normaliseRadians(angleInRadians);
        this.endPoint = getCircle().getCirclePointBasedOn(startPoint, this.angleInRadians, precision);
    }


    public static CircleSector of(Point center, ANumber radius, Point startPoint, Point endPoint)
    {
        return new CircleSector(center, radius, startPoint, endPoint);
    }


    public static CircleSector of(Point center, ANumber radius, Point startPoint, Point endPoint, int precision)
    {
        return new CircleSector(center, radius, startPoint, endPoint, precision);
    }


    public static CircleSector of(Point center, ANumber radius, Point startPoint, ANumber angleInRadians)
    {
        return new CircleSector(center, radius, startPoint, angleInRadians);
    }


    public static CircleSector of(Point center, ANumber radius, Point startPoint, ANumber angleInRadians, int precision)
    {
        return new CircleSector(center, radius, startPoint, angleInRadians, precision);
    }


    public Circle getCircle()
    {
        return Circle.of(center, radius);
    }


    public ANumber getArea()
    {
        return CircleSectorService.getArea(this);
    }


    public boolean isPointOnSector(Point point)
    {
        return CircleSectorService.isPointOnSector(this, point);
    }


    @Override
    public CircleSector clone() throws CloneNotSupportedException
    {
        return (CircleSector)CloningService.clone(this);
    }


    public CircleSector getCopy()
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
        return CircleSectorInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CircleSectorInternalService.equals(this, object);
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