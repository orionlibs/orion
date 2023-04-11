package com.orion.math.linearalgebra.matrix.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.EigenSystem;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.form.TridiagonalMatrixForm;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;

public class GetEigenvectorsOfTridiagonalMatrixTask extends Orion
{
    public static EigenSystem run(TridiagonalMatrixForm form)
    {
        MatrixRules.isValidSquareMatrix(form.getQ());
        ANumber[] main1 = form.getMainDiagonalOfTridiagonalMatrix().getAsArrayCopy();
        int n = main1.length;
        double[] main = NumberArrayStream.getAsDoubleArray(main1);
        double[][] z = NumberArrayStream.getAsDoubleMatrix(form.getQ().getAsArrayOfArrays());
        double[] secondary = NumberArrayStream.getAsDoubleArray(form.getSkewDiagonalOfTridiagonalMatrix().getAsArray());
        double[] realEigenvalues = new double[n];
        double[] imagEigenvalues = new double[n];
        double[][] eigenvectors = new double[n][n];
        double[] e = new double[n];
        int maxIterations = 100;

        for(int i = 0; i < n - 1; i++)
        {
            realEigenvalues[i] = main[i];
            e[i] = secondary[i];
        }

        realEigenvalues[n - 1] = main[n - 1];
        e[n - 1] = 0.0;
        double maxAbsoluteValue = 0.0;

        for(int i = 0; i < n; i++)
        {

            if(Math.abs(realEigenvalues[i]) > maxAbsoluteValue)
            {
                maxAbsoluteValue = Math.abs(realEigenvalues[i]);
            }

            if(Math.abs(e[i]) > maxAbsoluteValue)
            {
                maxAbsoluteValue = Math.abs(e[i]);
            }

        }

        if(maxAbsoluteValue != 0.0)
        {
            double tolerance = Precision.getEPSAsNumber().getAsDouble() * maxAbsoluteValue;

            for(int i = 0; i < n; i++)
            {

                if(Math.abs(realEigenvalues[i]) <= tolerance)
                {
                    realEigenvalues[i] = 0.0;
                }

                if(Math.abs(e[i]) <= tolerance)
                {
                    e[i] = 0.0;
                }

            }

        }

        for(int j = 0; j < n; j++)
        {
            int its = 0;
            int m = 0;

            do
            {

                for(m = j; m < n - 1; m++)
                {
                    double delta = Math.abs(realEigenvalues[m]) + Math.abs(realEigenvalues[m + 1]);

                    if(Math.abs(e[m]) + delta == delta)
                    {
                        break;
                    }

                }

                if(m != j)
                {

                    if(its == maxIterations)
                    {
                        return null;
                    }

                    its++;
                    double q = (realEigenvalues[j + 1] - realEigenvalues[j]) / (e[j] * 2.0);
                    double t = Math.sqrt(q * q + 1);

                    if(q < 0.0)
                    {
                        q = realEigenvalues[m] - realEigenvalues[j] + e[j] / (q - t);
                    }
                    else
                    {
                        q = realEigenvalues[m] - realEigenvalues[j] + e[j] / (q + t);
                    }

                    double u = 0.0;
                    double s = 1.0;
                    double c = 1.0;
                    int i = 0;

                    for(i = m - 1; i >= j; i--)
                    {
                        double p = s * e[i];
                        double h = c * e[i];

                        if(Math.abs(p) >= Math.abs(q))
                        {
                            c = q / p;
                            t = Math.sqrt(c * c + 1);
                            e[i + 1] = p * t;
                            s = 1.0 / t;
                            c *= s;
                        }
                        else
                        {
                            s = p / q;
                            t = Math.sqrt(s * s + 1);
                            e[i + 1] = q * t;
                            c = 1.0 / t;
                            s *= c;
                        }

                        if(e[i + 1] == 0.0)
                        {
                            realEigenvalues[i + 1] -= u;
                            e[m] = 0.0;
                            break;
                        }

                        q = realEigenvalues[i + 1] - u;
                        t = (realEigenvalues[i] - q) * s + c * h * 2.0;
                        u = s * t;
                        realEigenvalues[i + 1] = q + u;
                        q = c * t - h;

                        for(int ia = 0; ia < n; ia++)
                        {
                            p = z[ia][i + 1];
                            z[ia][i + 1] = s * z[ia][i] + c * p;
                            z[ia][i] = c * z[ia][i] - s * p;
                        }

                    }

                    if(t == 0.0 && i >= j)
                    {
                        continue;
                    }

                    realEigenvalues[j] -= u;
                    e[j] = q;
                    e[m] = 0.0;
                }

            }
            while(m != j);

        }

        for(int i = 0; i < n; i++)
        {
            int k = i;
            double p = realEigenvalues[i];

            for(int j = i + 1; j < n; j++)
            {

                if(realEigenvalues[j] > p)
                {
                    k = j;
                    p = realEigenvalues[j];
                }

            }

            if(k != i)
            {
                realEigenvalues[k] = realEigenvalues[i];
                realEigenvalues[i] = p;

                for(int j = 0; j < n; j++)
                {
                    p = z[j][i];
                    z[j][i] = z[j][k];
                    z[j][k] = p;
                }

            }

        }

        maxAbsoluteValue = 0.0;

        for(int i = 0; i < n; i++)
        {

            if(Math.abs(realEigenvalues[i]) > maxAbsoluteValue)
            {
                maxAbsoluteValue = Math.abs(realEigenvalues[i]);
            }

        }

        if(maxAbsoluteValue != 0.0)
        {
            double tolerance = maxAbsoluteValue * Precision.getEPSAsNumber().getAsDouble();

            for(int i = 0; i < n; i++)
            {

                if(Math.abs(realEigenvalues[i]) < tolerance)
                {
                    realEigenvalues[i] = 0.0;
                }

            }

        }

        for(int i = 0; i < n; i++)
        {
            double[] temp = new double[n];

            for(int j = 0; j < n; j++)
            {
                temp[j] = z[j][i];
            }

            eigenvectors[i] = temp;
        }

        ANumber[][] eigenvectors1 = NumberArrayStream.getAsNumberMatrix(eigenvectors);
        ANumber[] realEigenvalues1 = NumberArrayStream.getAsNumberArray(realEigenvalues);
        ANumber[] imagEigenvalues1 = NumberArrayStream.getAsNumberArray(imagEigenvalues);
        return EigenSystem.of(form.getQ(), Matrix.of(eigenvectors1).transpose(), Vector.of(realEigenvalues1), Vector.of(imagEigenvalues1));
    }
}