package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.form.HessenbergFormMatrix;
import com.orion.math.streams.NumberArrayStream;

public class TransformMatrixToHessenbergFormMatrixTask extends Orion
{
    public static HessenbergFormMatrix run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        double[][] householderVectors = NumberArrayStream.getAsDoubleMatrix(x.getAsArrayOfArrays());
        double[] ort = new double[x.getNumberOfRows()];
        int n = householderVectors.length;
        int high = n - 1;

        for(int m = 1; m <= high - 1; m++)
        {
            double scale = 0.0;

            for(int i = m; i <= high; i++)
            {
                scale += Math.abs(householderVectors[i][m - 1]);
            }

            if(scale != 0.0)
            {
                double h = 0.0;

                for(int i = high; i >= m; i--)
                {
                    ort[i] = householderVectors[i][m - 1] / scale;
                    h += ort[i] * ort[i];
                }

                double g = (ort[m] > 0) ? -Math.sqrt(h) : Math.sqrt(h);
                h -= ort[m] * g;
                ort[m] -= g;

                for(int j = m; j < n; j++)
                {
                    double f = 0.0;

                    for(int i = high; i >= m; i--)
                    {
                        f += ort[i] * householderVectors[i][j];
                    }

                    f /= h;

                    for(int i = m; i <= high; i++)
                    {
                        householderVectors[i][j] -= f * ort[i];
                    }

                }

                for(int i = 0; i <= high; i++)
                {
                    double f = 0.0;

                    for(int j = high; j >= m; j--)
                    {
                        f += ort[j] * householderVectors[i][j];
                    }

                    f /= h;

                    for(int j = m; j <= high; j++)
                    {
                        householderVectors[i][j] -= f * ort[j];
                    }

                }

                ort[m] = scale * ort[m];
                householderVectors[m][m - 1] = scale * g;
            }

        }

        return HessenbergFormMatrix.of(getHessenbergMatrix(householderVectors), getP(householderVectors, ort), Matrix.of(NumberArrayStream.getAsNumberMatrix(householderVectors)));
    }


    private static Matrix getHessenbergMatrix(double[][] householderVectors)
    {
        int m = householderVectors.length;
        final double[][] h = new double[m][m];

        for(int i = 0; i < m; ++i)
        {

            if(i > 0)
            {
                h[i][i - 1] = householderVectors[i][i - 1];
            }

            for(int j = i; j < m; ++j)
            {
                h[i][j] = householderVectors[i][j];
            }

        }

        return Matrix.of(NumberArrayStream.getAsNumberMatrix(h));
    }


    private static Matrix getP(double[][] householderVectors, double[] ort)
    {
        int n = householderVectors.length;
        int high = n - 1;
        double[][] pa = new double[n][n];

        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < n; j++)
            {
                pa[i][j] = (i == j) ? 1.0 : 0.0;
            }

        }

        for(int m = high - 1; m >= 1; m--)
        {

            if(householderVectors[m][m - 1] != 0.0)
            {

                for(int i = m + 1; i <= high; i++)
                {
                    ort[i] = householderVectors[i][m - 1];
                }

                for(int j = m; j <= high; j++)
                {
                    double g = 0.0;

                    for(int i = m; i <= high; i++)
                    {
                        g += ort[i] * pa[i][j];
                    }

                    g = (g / ort[m]) / householderVectors[m][m - 1];

                    for(int i = m; i <= high; i++)
                    {
                        pa[i][j] += g * ort[i];
                    }

                }

            }

        }

        return Matrix.of(NumberArrayStream.getAsNumberMatrix(pa));
    }
}