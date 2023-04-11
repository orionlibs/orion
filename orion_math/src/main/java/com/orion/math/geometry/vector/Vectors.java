package com.orion.math.geometry.vector;

import com.orion.core.data.structure.list.OrionList;
import com.orion.math.MathObject;
import com.orion.math.geometry.Axis;
import com.orion.math.number.ANumber;

public class Vectors implements MathObject
{
    public static boolean doVectorSizesMatch(Vector vector1, Vector vector2)
    {
        return isValid(vector1) && isValid(vector2) && vector1.getSize() == vector2.getSize();
    }


    public static boolean isValid(OrionList<ANumber> elements)
    {
        return elements != null && elements.isNotEmpty();
    }


    public static boolean isValid(Vector vector)
    {
        return vector != null && isValid(vector.getElements());
    }


    public static boolean isNotValid(Vector vector)
    {
        return !isValid(vector);
    }


    public static Vector getBasisVector(int dimensions, Axis axis)
    {
        return VectorService.getBasisVector(dimensions, axis);
    }


    public static Vector getBasisVector(int dimensions, int axis)
    {
        return VectorService.getBasisVector(dimensions, axis);
    }
}