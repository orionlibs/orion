package com.orion.math.linearalgebra.matrix.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;

public class SingularValueDecomposition extends Orion implements MathObject
{
    private Matrix u;
    private Matrix v;
    private Matrix s;


    public SingularValueDecomposition(Matrix u, Matrix v, Matrix s)
    {
        this.u = u;
        this.v = v;
        this.s = s;
    }


    public static SingularValueDecomposition of(Matrix u, Matrix v, Matrix s)
    {
        return new SingularValueDecomposition(u, v, s);
    }


    public Matrix getOriginalMatrix()
    {
        return getU().multiply(getS()).multiply(getV().transpose());
    }


    public Matrix getU()
    {
        return this.u;
    }


    public Matrix getV()
    {
        return this.v;
    }


    public Matrix getS()
    {
        return this.s;
    }
}