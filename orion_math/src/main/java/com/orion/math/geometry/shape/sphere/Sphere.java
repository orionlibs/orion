package com.orion.math.geometry.shape.sphere;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.geometry.point.Point;
import com.orion.math.number.ANumber;

public class Sphere implements MathObject, Cloneable
{
    private Point center;
    private ANumber radius;
    private Function3x1<ANumber, ANumber, ANumber, ANumber> formula;


    public Sphere(Point center, ANumber radius)
    {
        SphereRules.isValid(center, radius);
        this.center = center;
        this.radius = radius;
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y, ANumber z) ->
        {
            return x.squareGET().addGET(y.squareGET()).addGET(z.squareGET()).subtractGET(radius.squareGET());
        };
        formula = new Function3x1<ANumber, ANumber, ANumber, ANumber>(formulaFunction);
    }


    public static Sphere of(Point center, ANumber radius)
    {
        return new Sphere(center, radius);
    }


    public ANumber getArea()
    {
        return SphereService.getArea(this);
    }


    public ANumber getVolume()
    {
        return SphereService.getVolume(this);
    }


    public boolean isPointInsideSphere(Point point)
    {
        return SphereService.isPointInsideSphere(this, point);
    }


    public boolean isPointInsideSphere(Point point, int precision)
    {
        return SphereService.isPointInsideSphere(this, point, precision);
    }


    public boolean isPointOnSphere(Point point)
    {
        return SphereService.isPointOnSphere(this, point);
    }


    public boolean isPointOnSphere(Point point, int precision)
    {
        return SphereService.isPointOnSphere(this, point, precision);
    }


    public boolean isPointInsideOrOnSphere(Point point)
    {
        return SphereService.isPointInsideOrOnSphere(this, point);
    }


    public boolean isPointInsideOrOnSphere(Point point, int precision)
    {
        return SphereService.isPointInsideOrOnSphere(this, point, precision);
    }


    @Override
    public Sphere clone() throws CloneNotSupportedException
    {
        return (Sphere)CloningService.clone(this);
    }


    public Sphere getCopy()
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
        return SphereInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return SphereInternalService.equals(this, object);
    }


    public Point getCenter()
    {
        return this.center;
    }


    public ANumber getRadius()
    {
        return this.radius;
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }
}