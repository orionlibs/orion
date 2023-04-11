package com.orion.math.statistics.data.quartile;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class QuartilesRules extends MathRule
{
    public static void isValid(Vector numbers)
    {
        VectorRules.isValid(numbers);
    }


    public static void isValid(Quartiles quartiles)
    {
        Assert.notNull(quartiles, "The quartiles input cannor be null.");
        isValid(quartiles.getNumbers());
    }
}