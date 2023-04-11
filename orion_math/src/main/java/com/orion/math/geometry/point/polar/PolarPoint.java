package com.orion.math.geometry.point.polar;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class PolarPoint implements MathObject, Cloneable
{
    private ANumber distanceFromPointOfOrigin;
    private ANumber angleWithXAxis;


    public PolarPoint(ANumber distanceFromPointOfOrigin, ANumber angleWithXAxis)
    {
        PolarPointRules.isValid(distanceFromPointOfOrigin, angleWithXAxis);
        this.distanceFromPointOfOrigin = distanceFromPointOfOrigin;
        this.angleWithXAxis = angleWithXAxis;
    }


    public static PolarPoint of(ANumber distanceFromPointOfOrigin, ANumber angleWithXAxis)
    {
        return new PolarPoint(distanceFromPointOfOrigin, angleWithXAxis);
    }


    public Point getAsPoint()
    {
        return getAsPoint(Precision.precision);
    }


    public Point getAsPoint(int precision)
    {
        precision = Precision.getValidPrecision(precision);
        ANumber[] coordinates = new ANumber[2];
        coordinates[0] = getDistanceFromPointOfOrigin().multiplyGET(TrigonometryService.getCosineInRadians(getAngleWithXAxis(), precision));
        coordinates[1] = getDistanceFromPointOfOrigin().multiplyGET(TrigonometryService.getSineInRadians(getAngleWithXAxis(), precision));
        return Point.of(coordinates);
    }


    @Override
    public String toString()
    {
        return print();
    }


    public String print()
    {
        return PolarPointService.print(this);
    }


    @Override
    public int hashCode()
    {
        return PolarPointInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PolarPointInternalService.equals(this, object);
    }


    @Override
    public PolarPoint clone() throws CloneNotSupportedException
    {
        return (PolarPoint)CloningService.clone(this);
    }


    public PolarPoint getCopy()
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


    public ANumber getDistanceFromPointOfOrigin()
    {
        return this.distanceFromPointOfOrigin;
    }


    public ANumber getAngleWithXAxis()
    {
        return this.angleWithXAxis;
    }
}