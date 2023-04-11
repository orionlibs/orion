package com.orion.math.geometry.shape.cube;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class CubeRules extends MathRule
{
    public static void isValid(ANumber lengthOfSide)
    {
        NumberRules.isPositive(lengthOfSide);
    }


    public static void isValid(Cube cube)
    {
        Assert.notNull(cube, "The cube input cannot be null.");
        isValid(cube.getLengthOfSide());
    }
}