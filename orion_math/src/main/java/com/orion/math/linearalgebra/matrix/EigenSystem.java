package com.orion.math.linearalgebra.matrix;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;

public class EigenSystem extends Orion implements MathObject
{
    private Matrix originalMatrix;
    private Matrix eigenvectors;
    private Vector realEigenvalues;
    private Vector imaginaryEigenvalues;


    public EigenSystem(Matrix originalMatrix, Matrix eigenvectors, Vector realEigenvalues, Vector imaginaryEigenvalues)
    {
        this.originalMatrix = originalMatrix;
        this.eigenvectors = eigenvectors;
        this.realEigenvalues = realEigenvalues;
        this.imaginaryEigenvalues = imaginaryEigenvalues;
    }


    public static EigenSystem of(Matrix originalMatrix, Matrix eigenvectors, Vector realEigenvalues, Vector imaginaryEigenvalues)
    {
        return new EigenSystem(originalMatrix, eigenvectors, realEigenvalues, imaginaryEigenvalues);
    }


    public Matrix getOriginalMatrix()
    {
        return this.originalMatrix;
    }


    public Matrix getEigenvectors()
    {
        return this.eigenvectors;
    }


    public Vector getRealEigenvalues()
    {
        return this.realEigenvalues;
    }


    public Vector getImaginaryEigenvalues()
    {
        return this.imaginaryEigenvalues;
    }
}