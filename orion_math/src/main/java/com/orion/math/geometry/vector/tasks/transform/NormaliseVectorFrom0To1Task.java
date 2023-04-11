package com.orion.math.geometry.vector.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class NormaliseVectorFrom0To1Task extends Orion
{
    public static Vector run(Vector x)
    {
        VectorRules.isValid(x);
        ANumber minimum = x.getMinimum();
        ANumber maximum = x.getMaximum();
        ANumber range = maximum.subtractGET(minimum);

        if(range.isZero())
        {
            return x;
        }
        else
        {
            Vector y = x.getCopy();
            IntStream.range(0, y.getDimensions())
                            .forEach(i -> y.set(i, y.get(i).subtractGET(minimum).divideGET(range)));
            return y;
        }

    }
}