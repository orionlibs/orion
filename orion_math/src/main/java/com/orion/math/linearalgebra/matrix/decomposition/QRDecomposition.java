package com.orion.math.linearalgebra.matrix.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class QRDecomposition extends Orion implements MathObject
{
    private Matrix q;
    private Matrix r;
    private Matrix pivot;
    private ANumber rank;


    public QRDecomposition(Matrix q, Matrix r, Matrix pivot, ANumber rank)
    {
        this.q = q;
        this.r = r;
        this.pivot = pivot;
        this.rank = rank;
    }


    public static QRDecomposition of(Matrix q, Matrix r, Matrix pivot, ANumber rank)
    {
        return new QRDecomposition(q, r, pivot, rank);
    }


    public Matrix getQ()
    {
        return this.q;
    }


    public Matrix getR()
    {
        return this.r;
    }


    public Matrix getPivot()
    {
        return this.pivot;
    }


    public ANumber getRank()
    {
        return this.rank;
    }
}