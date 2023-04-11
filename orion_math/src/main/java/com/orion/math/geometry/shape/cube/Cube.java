package com.orion.math.geometry.shape.cube;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;

public class Cube implements MathObject, Cloneable
{
    private ANumber lengthOfSide;


    public Cube(ANumber lengthOfSide)
    {
        CubeRules.isValid(lengthOfSide);
        this.lengthOfSide = lengthOfSide;
    }


    public static Cube of(ANumber lengthOfSide)
    {
        return new Cube(lengthOfSide);
    }


    public ANumber getSurfaceArea()
    {
        return CubeService.getSurfaceArea(this);
    }


    public ANumber getVolume()
    {
        return CubeService.getVolume(this);
    }


    public ANumber getFaceDiagonal()
    {
        return CubeService.getFaceDiagonal(this);
    }


    public ANumber getFaceDiagonal(int precision)
    {
        return CubeService.getFaceDiagonal(this, precision);
    }


    public ANumber getSpaceDiagonal()
    {
        return CubeService.getSpaceDiagonal(this);
    }


    public ANumber getSpaceDiagonal(int precision)
    {
        return CubeService.getSpaceDiagonal(this, precision);
    }


    @Override
    public Cube clone() throws CloneNotSupportedException
    {
        return (Cube)CloningService.clone(this);
    }


    public Cube getCopy()
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
        return CubeInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return CubeInternalService.equals(this, object);
    }


    public ANumber getLengthOfSide()
    {
        return this.lengthOfSide;
    }
}