package com.orion.math.linearalgebra.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.function.BackwardSubstitutionFunction;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixIsSingularException;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.stream.IntStream;

public class SolveSystemOfLinearEquationsUsingGaussJordanEliminationTask extends Orion
{
    public static Vector run(Matrix coefficients, ANumber[] constants, int precision) throws MatrixIsSingularException
    {
        MatrixRules.isValid(coefficients);
        Assert.notNull(constants, "The given constants array input cannot be null/empty.");
        Assert.hasLength(constants, coefficients.getNumberOfRows(), "Constants array's size is different that the number of rows of the matrix.");
        final int precision1 = Precision.getValidPrecision(precision);
        Matrix coefficientsCopy = coefficients.getCopy();
        coefficientsCopy.forAll((Integer i, Integer j) -> coefficientsCopy.get(i, j).applyPrecision(precision1));
        ANumber[] constantsCopy = new ANumber[constants.length];
        IntStream.range(0, constants.length).forEach(i -> constantsCopy[i] = constants[i].applyPrecisionGET(precision1));
        return run(coefficientsCopy, constantsCopy);
    }


    public static Vector run(Matrix coefficients, ANumber[] constants) throws MatrixIsSingularException
    {
        MatrixRules.isValid(coefficients);
        Assert.notNull(constants, "The given constants array input cannot be null/empty.");
        Assert.hasLength(constants, coefficients.getNumberOfRows(), "Constants array's size is different that the number of rows of the matrix.");
        int n = constants.length;
        ANumber[][] coefficients1 = coefficients.getAsArrayOfArraysCopy();
        ANumber EPS = Precision.getEPSAsNumber();

        for(int p = 0; p < n; p++)
        {
            int max = p;

            for(int i = p + 1; i < n; i++)
            {

                if(coefficients1[i][p].getAbsoluteValue().isGreaterThan(coefficients1[max][p].getAbsoluteValue()))
                {
                    max = i;
                }

            }

            ANumber[] temp = coefficients1[p];
            coefficients1[p] = coefficients1[max];
            coefficients1[max] = temp;
            ANumber t = constants[p];
            constants[p] = constants[max];
            constants[max] = t;

            if(coefficients1[p][p].getAbsoluteValue().isLessThanOrEqual(EPS))
            {
                throw new MatrixIsSingularException("The given matrix cannot be singular.");
            }

            for(int i = p + 1; i < n; i++)
            {
                ANumber alpha = coefficients1[i][p].divideGET(coefficients1[p][p]);
                constants[i] = constants[i].subtractGET(alpha.multiplyGET(constants[p]));

                for(int j = p; j < n; j++)
                {
                    coefficients1[i][j] = coefficients1[i][j].subtractGET(alpha.multiplyGET(coefficients1[p][j]));
                }

            }

        }

        return BackwardSubstitutionFunction.run(Matrix.of(coefficients1).getUpperTriangularPart(), Vector.of(constants));
    }


    public static Vector run(Matrix coefficients, Vector constants) throws MatrixIsSingularException
    {
        VectorRules.isValid(constants);
        return run(coefficients, constants.getAsArray());
    }


    public static Vector run(Matrix coefficients, Vector constants, int precision) throws MatrixIsSingularException
    {
        VectorRules.isValid(constants);
        return run(coefficients, constants.getAsArray(), precision);
    }
}