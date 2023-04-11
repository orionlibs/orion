package com.orion.math.geometry.vector.functional.tasks.component;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.Axis;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1;
import com.orion.math.geometry.vector.functional.VectorOfFunction1x1Rules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetVectorOfFunction1x1ComponentTask extends Orion
{
    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, Axis axis)
    {
        Assert.notNull(axis, "The given axis input cannot be null.");
        return run(x, axis.getInt());
    }


    public static VectorOfFunction1x1 run(VectorOfFunction1x1 x, int axis)
    {
        VectorOfFunction1x1Rules.isValid(x);
        NumberRules.isGreaterThan(axis, 0);
        Function1x1<ANumber, ANumber>[] newElements = new Function1x1[x.getDimensions()];

        for(int i = 1; i <= x.getDimensions(); i++)
        {
            newElements[i - 1] = (i == axis) ? x.get(axis - 1) : Function1x1.Zero;
        }

        return VectorOfFunction1x1.of(newElements);
    }
}