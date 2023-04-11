package com.orion.math.geometry.shape.cube;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class CubeService extends OrionService
{
    public static ANumber getSurfaceArea(Cube x)
    {
        CubeRules.isValid(x);
        return x.getLengthOfSide().squareGET().multiplyGET(6);
    }


    public static ANumber getVolume(Cube x)
    {
        CubeRules.isValid(x);
        return x.getLengthOfSide().exponentiateGET(3);
    }


    public static ANumber getFaceDiagonal(Cube x)
    {
        return getFaceDiagonal(x, Precision.precision);
    }


    public static ANumber getFaceDiagonal(Cube x, int precision)
    {
        CubeRules.isValid(x);
        return x.getLengthOfSide().multiplyGET(ANumber.of(2).getSquareRoot(precision));
    }


    public static ANumber getSpaceDiagonal(Cube x)
    {
        return getSpaceDiagonal(x, Precision.precision);
    }


    public static ANumber getSpaceDiagonal(Cube x, int precision)
    {
        CubeRules.isValid(x);
        return x.getLengthOfSide().multiplyGET(ANumber.of(3).getSquareRoot(precision));
    }
}