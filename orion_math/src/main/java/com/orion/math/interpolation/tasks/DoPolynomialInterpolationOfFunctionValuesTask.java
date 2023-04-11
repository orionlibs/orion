package com.orion.math.interpolation.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.LinearAlgebraService;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;

public class DoPolynomialInterpolationOfFunctionValuesTask extends Orion
{
    public static Polynomial run(Vector xValues, Vector yValues)
    {
        VectorRules.doVectorSizesMatch(xValues, yValues);
        int n = xValues.getDimensions();
        ANumber[][] elements = new ANumber[n][n];

        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < n; j++)
            {
                elements[i][j] = xValues.get(i).exponentiateGET(j);
            }

        }

        Vector coefficients = LinearAlgebraService.solveSystemOfLinearEquationsUsingGaussJordanElimination(Matrix.of(elements), yValues);
        return Polynomial.of(coefficients);
    }
}