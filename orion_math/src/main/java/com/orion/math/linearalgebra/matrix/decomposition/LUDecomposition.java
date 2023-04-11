package com.orion.math.linearalgebra.matrix.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;

public class LUDecomposition extends Orion implements MathObject
{
    private Matrix lower;
    private Matrix upper;
    private Vector pivot;


    public LUDecomposition(Matrix lower, Matrix upper, Vector pivot)
    {
        this.lower = lower;
        this.upper = upper;
        this.pivot = pivot;
    }


    public static LUDecomposition of(Matrix lower, Matrix upper, Vector pivot)
    {
        return new LUDecomposition(lower, upper, pivot);
    }


    public Matrix getLower()
    {
        return this.lower;
    }


    public Matrix getUpper()
    {
        return this.upper;
    }


    public Vector getPivot()
    {
        return this.pivot;
    }
}