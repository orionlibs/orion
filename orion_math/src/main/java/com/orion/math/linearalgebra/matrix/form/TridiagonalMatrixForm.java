package com.orion.math.linearalgebra.matrix.form;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;

public class TridiagonalMatrixForm extends Orion implements MathObject
{
    private Matrix tridiagonalMatrix;
    private Matrix Q;
    private Matrix QTranspose;
    private Matrix householderVectors;
    private Vector mainDiagonalOfTridiagonalMatrix;
    private Vector skewDiagonalOfTridiagonalMatrix;


    public TridiagonalMatrixForm(Matrix tridiagonalMatrix, Matrix QTranspose, Matrix householderVectors, Vector mainDiagonalOfTridiagonalMatrix, Vector skewDiagonalOfTridiagonalMatrix)
    {
        this.tridiagonalMatrix = tridiagonalMatrix;
        this.Q = QTranspose.transpose();
        this.QTranspose = QTranspose;
        this.householderVectors = householderVectors;
        this.mainDiagonalOfTridiagonalMatrix = mainDiagonalOfTridiagonalMatrix;
        this.skewDiagonalOfTridiagonalMatrix = skewDiagonalOfTridiagonalMatrix;
    }


    public static TridiagonalMatrixForm of(Matrix tridiagonalMatrix, Matrix QTranspose, Matrix householderVectors, Vector mainDiagonalOfTridiagonalMatrix, Vector skewDiagonalOfTridiagonalMatrix)
    {
        return new TridiagonalMatrixForm(tridiagonalMatrix, QTranspose, householderVectors, mainDiagonalOfTridiagonalMatrix, skewDiagonalOfTridiagonalMatrix);
    }


    public Matrix getOriginalMatrix()
    {
        return Q.multiply(tridiagonalMatrix.multiply(QTranspose));
    }


    public Matrix getTridiagonalMatrix()
    {
        return this.tridiagonalMatrix;
    }


    public Matrix getQ()
    {
        return this.Q;
    }


    public Matrix getQTranspose()
    {
        return this.QTranspose;
    }


    public Matrix getHouseholderVectors()
    {
        return this.householderVectors;
    }


    public Vector getMainDiagonalOfTridiagonalMatrix()
    {
        return this.mainDiagonalOfTridiagonalMatrix;
    }


    public Vector getSkewDiagonalOfTridiagonalMatrix()
    {
        return this.skewDiagonalOfTridiagonalMatrix;
    }
}