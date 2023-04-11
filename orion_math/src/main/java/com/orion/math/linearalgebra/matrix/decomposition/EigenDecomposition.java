package com.orion.math.linearalgebra.matrix.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.linearalgebra.matrix.EigenSystem;
import com.orion.math.linearalgebra.matrix.Matrix;

public class EigenDecomposition extends Orion implements MathObject
{
    private EigenSystem eigensystem;
    private Matrix eigenvectors;
    private Matrix eigenvaluesDiagonalMatrix;


    public EigenDecomposition(EigenSystem eigensystem)
    {
        this.eigensystem = eigensystem;
        this.eigenvectors = eigensystem.getEigenvectors();
        this.eigenvaluesDiagonalMatrix = generateEigenvaluesDiagonalMatrix(eigensystem);
    }


    public static EigenDecomposition of(EigenSystem eigensystem)
    {
        return new EigenDecomposition(eigensystem);
    }


    private Matrix generateEigenvaluesDiagonalMatrix(EigenSystem eigensystem)
    {
        return Matrix.ofDiagonal(eigensystem.getRealEigenvalues());
    }


    public Matrix getOriginalMatrix()
    {
        return eigenvectors.multiply(eigenvaluesDiagonalMatrix.multiply(eigenvectors.transpose()));
    }


    public EigenSystem getEigensystem()
    {
        return this.eigensystem;
    }


    public Matrix getEigenvectors()
    {
        return this.eigenvectors;
    }


    public Matrix getEigenvaluesDiagonalMatrix()
    {
        return this.eigenvaluesDiagonalMatrix;
    }
}