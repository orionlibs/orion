package com.orion.math.linearalgebra.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class DoForwardSubstitutionForMatrixTask extends Orion
{
    public static Vector run(Matrix coefficients, Vector constants)
    {
        MatrixRules.isLowerTriangular(coefficients);
        MatrixRules.doMatrixRowsAndVectorSizeMatch(coefficients, constants);
        ANumber[] results = new ANumber[constants.getDimensions()];

        for(int i = 0; i < constants.getDimensions(); i++)
        {

            if(i == 0)
            {
                results[i] = constants.get(i).divideGET(coefficients.get(0, 0));
            }
            else
            {
                ANumber sum = ANumber.of(0);

                for(int j = 0; j < i; j++)
                {
                    sum.add(coefficients.get(i, j).multiplyGET(results[j]));
                }

                results[i] = constants.get(i).subtractGET(sum).divideGET(coefficients.get(i, i));
            }

        }

        return Vector.of(results);
    }
}