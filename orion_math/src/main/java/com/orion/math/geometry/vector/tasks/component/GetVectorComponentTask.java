package com.orion.math.geometry.vector.tasks.component;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetVectorComponentTask extends Orion
{
    public static Vector run(Vector x, Axis axis)
    {
        Assert.notNull(axis, "The given axis input cannot be null.");
        return run(x, axis.getInt());
    }


    public static Vector run(Vector x, int axis)
    {
        VectorRules.isValid(x);
        NumberRules.isGreaterThan(axis, 0);
        ANumber[] newElements = new ANumber[x.getDimensions()];

        for(int i = 1; i <= x.getDimensions(); i++)
        {
            newElements[i - 1] = (i == axis) ? x.get(axis - 1).getCopy() : ANumber.of(0);
        }

        return Vector.of(newElements);
    }
}