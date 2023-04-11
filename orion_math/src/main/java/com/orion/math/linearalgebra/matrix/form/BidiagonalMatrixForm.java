package com.orion.math.linearalgebra.matrix.form;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.Matrix;

public class BidiagonalMatrixForm extends Orion implements MathObject
{
    private Matrix orthogonalMatrix1;
    private Matrix orthogonalMatrix2;
    private Matrix bidiagonalMatrix;


    public BidiagonalMatrixForm(Matrix orthogonalMatrix1, Matrix orthogonalMatrix2, Matrix bidiagonalMatrix)
    {
        this.orthogonalMatrix1 = orthogonalMatrix1;
        this.orthogonalMatrix2 = orthogonalMatrix2;
        this.bidiagonalMatrix = bidiagonalMatrix;
    }


    public static BidiagonalMatrixForm of(Matrix orthogonalMatrix1, Matrix orthogonalMatrix2, Matrix bidiagonalMatrix)
    {
        return new BidiagonalMatrixForm(orthogonalMatrix1, orthogonalMatrix2, bidiagonalMatrix);
    }


    public Matrix getOriginalMatrix()
    {
        return orthogonalMatrix1.multiply(bidiagonalMatrix.multiply(orthogonalMatrix2.transpose()));
    }


    public Matrix getOrthogonalMatrix1()
    {
        return this.orthogonalMatrix1;
    }


    public Matrix getOrthogonalMatrix2()
    {
        return this.orthogonalMatrix2;
    }


    public Matrix getBidiagonalMatrix()
    {
        return this.bidiagonalMatrix;
    }
}