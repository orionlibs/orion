package com.orion.math.linearalgebra;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixIsSingularException;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.tasks.DoBackwardSubstitutionForMatrixTask;
import com.orion.math.linearalgebra.tasks.DoForwardSubstitutionForMatrixTask;
import com.orion.math.linearalgebra.tasks.SolveSystemOfLinearEquationsUsingGaussJordanEliminationTask;
import com.orion.math.linearalgebra.tasks.SolveSystemOfLinearEquationsUsingQRDecompositionTask;
import com.orion.math.number.ANumber;
import java.util.Arrays;

public class LinearAlgebraService extends OrionService
{
    public static Vector solveSystemOfLinearEquationsUsingGaussJordanElimination(Matrix coefficients, Vector constants) throws MatrixIsSingularException
    {
        return SolveSystemOfLinearEquationsUsingGaussJordanEliminationTask.run(coefficients, constants);
    }


    public static Vector solveSystemOfLinearEquationsUsingGaussJordanElimination(Matrix coefficients, ANumber[] constants) throws MatrixIsSingularException
    {
        return SolveSystemOfLinearEquationsUsingGaussJordanEliminationTask.run(coefficients, constants);
    }


    public static Vector solveSystemOfLinearEquationsUsingGaussJordanElimination(Matrix coefficients) throws MatrixIsSingularException
    {
        MatrixRules.isValid(coefficients);
        ANumber[] constants = new ANumber[coefficients.getNumberOfRows()];
        Arrays.fill(constants, ANumber.of(0));
        return SolveSystemOfLinearEquationsUsingGaussJordanEliminationTask.run(coefficients, constants);
    }


    public static Vector solveSystemOfLinearEquationsUsingQRDecomposition(Matrix coefficients, Vector constants)
    {
        return SolveSystemOfLinearEquationsUsingQRDecompositionTask.run(coefficients, constants);
    }


    public static Vector solveSystemOfLinearEquationsUsingQRDecomposition(Matrix coefficients, ANumber[] constants)
    {
        return SolveSystemOfLinearEquationsUsingQRDecompositionTask.run(coefficients, constants);
    }


    public static Vector solveSystemOfLinearEquationsUsingQRDecomposition(Matrix coefficients)
    {
        MatrixRules.isValid(coefficients);
        ANumber[] constants = new ANumber[coefficients.getNumberOfRows()];
        Arrays.fill(constants, ANumber.of(0));
        return SolveSystemOfLinearEquationsUsingQRDecompositionTask.run(coefficients, constants);
    }


    public static Vector doForwardSubstitution(Matrix coefficients, Vector constants)
    {
        return DoForwardSubstitutionForMatrixTask.run(coefficients, constants);
    }


    public static Vector doBackwardSubstitution(Matrix coefficients, Vector constants)
    {
        return DoBackwardSubstitutionForMatrixTask.run(coefficients, constants);
    }
}