package com.orion.math.statistics.regression.linear.multiple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.LinearAlgebraService;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.multiple.MultipleLinearRegressionCoefficients;
import com.orion.math.statistics.trainingset.MultifeatureTrainingSet;

public class GetInterceptAndSlopesForMultipleLinearRegressionTask extends Orion
{
    public static MultipleLinearRegressionCoefficients run(MultifeatureTrainingSet trainingSet)
    {
        int kPlus1 = trainingSet.getDataPoint(0).getDimensions() + 1;
        int n = trainingSet.getSize();
        ANumber[][] elements = new ANumber[kPlus1][kPlus1];
        ANumber[] constants = new ANumber[kPlus1];

        for(int i = 0; i < kPlus1; i++)
        {

            for(int j = 0; j < kPlus1; j++)
            {

                if(i == 0)
                {

                    if(j == 0)
                    {
                        elements[i][j] = ANumber.of(n);
                    }
                    else
                    {
                        ANumber sum = ANumber.of(0);

                        for(int k = 0; k < n; k++)
                        {
                            sum.add(trainingSet.getDataPoint(k).get(j - 1));
                        }

                        elements[i][j] = sum;
                    }

                }
                else
                {

                    if(j == 0)
                    {
                        ANumber sum = ANumber.of(0);

                        for(int k = 0; k < n; k++)
                        {
                            sum.add(trainingSet.getDataPoint(k).get(i - 1));
                        }

                        elements[i][j] = sum;
                    }
                    else
                    {
                        ANumber sum = ANumber.of(0);

                        for(int k = 0; k < n; k++)
                        {
                            sum.add(trainingSet.getDataPoint(k).get(i - 1).multiplyGET(trainingSet.getDataPoint(k).get(j - 1)));
                        }

                        elements[i][j] = sum;
                    }

                }

            }

            if(i == 0)
            {
                ANumber sum = ANumber.of(0);

                for(int k = 0; k < n; k++)
                {
                    sum.add(trainingSet.getClassForIndex(k));
                }

                constants[i] = sum;
            }
            else
            {
                ANumber sum = ANumber.of(0);

                for(int k = 0; k < n; k++)
                {
                    sum.add(trainingSet.getDataPoint(k).get(i - 1).multiplyGET(trainingSet.getClassForIndex(k)));
                }

                constants[i] = sum;
            }

        }

        Vector interceptAndSlopes = LinearAlgebraService.solveSystemOfLinearEquationsUsingGaussJordanElimination(Matrix.of(elements), constants);
        Vector slopes = Vector.of(interceptAndSlopes.getAsList().subList(1, interceptAndSlopes.getDimensions()));
        return MultipleLinearRegressionCoefficients.of(interceptAndSlopes.get(0), slopes);
    }
}