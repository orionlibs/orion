package com.orion.math.geometry.vector.functional;

import com.orion.core.data.structure.list.OrionList;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;

public class VectorsOfFunction1x1 implements MathObject
{
    public static boolean doVectorSizesMatch(VectorOfFunction1x1 vector1, VectorOfFunction1x1 vector2)
    {
        return isValid(vector1) && isValid(vector2) && vector1.getSize() == vector2.getSize();
    }


    public static boolean isValid(OrionList<Function1x1<ANumber, ANumber>> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isValid(VectorOfFunction1x1 vector)
    {
        return vector != null && isValid(vector.getElements());
    }
}