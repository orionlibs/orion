package com.orion.math.linearalgebra.matrix.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;

public class CholeskyDecomposition extends Orion implements MathObject
{
    private Matrix L;
    private Matrix LTranspose;


    public CholeskyDecomposition(Matrix L, Matrix LTranspose)
    {
        this.L = L;
        this.LTranspose = LTranspose;
    }


    public static CholeskyDecomposition of(Matrix L, Matrix LTranspose)
    {
        return new CholeskyDecomposition(L, LTranspose);
    }


    public Matrix getOriginalMatrix()
    {
        return getL().multiply(getLTranspose());
    }


    public Matrix getL()
    {
        return this.L;
    }


    public Matrix getLTranspose()
    {
        return this.LTranspose;
    }
}