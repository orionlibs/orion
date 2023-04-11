package com.orion.math.linearalgebra.matrix.form;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;

public class HessenbergFormMatrix extends Orion implements MathObject
{
    private Matrix hessenbergMatrix;
    private Matrix P;
    private Matrix PTranspose;
    private Matrix householderVectors;


    public HessenbergFormMatrix(Matrix hessenbergMatrix, Matrix P, Matrix householderVectors)
    {
        this.hessenbergMatrix = hessenbergMatrix;
        this.P = P;
        this.PTranspose = P.transpose();
        this.householderVectors = householderVectors;
    }


    public static HessenbergFormMatrix of(Matrix hessenbergMatrix, Matrix P, Matrix householderVectors)
    {
        return new HessenbergFormMatrix(hessenbergMatrix, P, householderVectors);
    }


    public Matrix getOriginalMatrix()
    {
        return P.multiply(hessenbergMatrix.multiply(PTranspose));
    }


    public Matrix getHessenbergMatrix()
    {
        return this.hessenbergMatrix;
    }


    public Matrix getP()
    {
        return this.P;
    }


    public Matrix getPTranspose()
    {
        return this.PTranspose;
    }


    public Matrix getHouseholderVectors()
    {
        return this.householderVectors;
    }
}