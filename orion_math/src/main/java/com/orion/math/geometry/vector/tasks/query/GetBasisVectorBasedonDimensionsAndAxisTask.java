package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetBasisVectorBasedonDimensionsAndAxisTask extends Orion
{
    public static Vector run(int dimensions, Axis axis)
    {
        Assert.notNull(axis, "The given axis input cannot be null.");
        return run(dimensions, axis.getInt());
    }


    public static Vector run(int dimensions, int axis)
    {
        VectorRules.isValid(dimensions);
        NumberRules.isGreaterThan(axis, 0);
        ANumber[] newElements = new ANumber[dimensions];

        for(int i = 1; i <= dimensions; i++)
        {
            newElements[i - 1] = (i == axis) ? ANumber.of(1) : ANumber.of(0);
        }

        return Vector.of(newElements);
    }
}