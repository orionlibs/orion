package com.orion.math.geometry.shape.circle.disk;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.point.Point;
import com.orion.math.geometry.shape.circle.Circle;
import com.orion.math.number.ANumber;

public class Disk implements MathObject, Cloneable
{
    private Point center;
    private ANumber radius;
    private Function2x1<ANumber, ANumber, ANumber> formula;


    public Disk(Point center, ANumber radius)
    {
        DiskRules.isValid(center, radius);
        this.center = center;
        this.radius = radius;
        Function2x1IF<ANumber, ANumber, ANumber> formulaFunction = (ANumber x, ANumber y) ->
        {
            return x.subtractGET(center.getX()).squareGET().addGET(y.subtractGET(center.getY()).squareGET()).subtractGET(radius.squareGET());
        };
        formula = new Function2x1<ANumber, ANumber, ANumber>(formulaFunction);
    }


    public static Disk of(Point center, ANumber radius)
    {
        return new Disk(center, radius);
    }


    public Circle getCircle()
    {
        return Circle.of(center, radius);
    }


    public boolean isPointInsideDisk(Point point)
    {
        return DiskService.isPointInsideDisk(this, point);
    }


    public boolean isPointOnDisk(Point point)
    {
        return DiskService.isPointInsideDisk(this, point);
    }


    public boolean isPointInsideOrOnDisk(Point point)
    {
        return DiskService.isPointInsideOrOnDisk(this, point);
    }


    @Override
    public Disk clone() throws CloneNotSupportedException
    {
        return (Disk)CloningService.clone(this);
    }


    public Disk getCopy()
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
        return DiskInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return DiskInternalService.equals(this, object);
    }


    public Point getCenter()
    {
        return this.center;
    }


    public ANumber getRadius()
    {
        return this.radius;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFormula()
    {
        return this.formula;
    }
}