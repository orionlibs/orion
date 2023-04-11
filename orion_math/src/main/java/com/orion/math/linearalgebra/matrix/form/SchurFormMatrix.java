package com.orion.math.linearalgebra.matrix.form;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;

public class SchurFormMatrix extends Orion implements MathObject
{
    private Matrix P;
    private Matrix T;
    private Matrix PTranspose;


    public SchurFormMatrix(Matrix P, Matrix T)
    {
        this.P = P;
        this.T = T;
        this.PTranspose = P.transpose();
    }


    public static SchurFormMatrix of(Matrix P, Matrix T)
    {
        return new SchurFormMatrix(P, T);
    }


    public Matrix getOriginalMatrix()
    {
        return P.multiply(T.multiply(PTranspose));
    }


    public Matrix getP()
    {
        return this.P;
    }


    public Matrix getT()
    {
        return this.T;
    }


    public Matrix getPTranspose()
    {
        return this.PTranspose;
    }
}