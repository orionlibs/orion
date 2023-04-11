package com.orion.math.linearalgebra.matrix.tasks.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.EigenSystem;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.MatrixService;
import com.orion.math.linearalgebra.matrix.decomposition.EigenDecomposition;
import com.orion.math.linearalgebra.matrix.form.SchurFormMatrix;
import com.orion.math.linearalgebra.matrix.form.TridiagonalMatrixForm;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;

public class GetEigenDecompositionOfMatrixTask extends Orion
{
    public static EigenDecomposition run(Matrix x, int precision)
    {
        MatrixRules.isValidSquareMatrix(x);
        precision = Precision.getValidPrecision(precision);

        if(x.isSymmetric())
        {
            TridiagonalMatrixForm tridiagonalForm = x.transformToTridiagonalMatrix();
            EigenSystem eigensystem = MatrixService.getEigenvectorsOfTridiagonalMatrix(tridiagonalForm);
            return EigenDecomposition.of(eigensystem);
        }
        else
        {
            SchurFormMatrix schurFormMatrix = x.transformToSchurFormMatrix();
            double[][] matT = NumberArrayStream.getAsDoubleMatrix(schurFormMatrix.getT().getAsArrayOfArrays());
            double[] realEigenvalues = new double[matT.length];
            double[] imagEigenvalues = new double[matT.length];

            for(int i = 0; i < realEigenvalues.length; i++)
            {

                if(i == (realEigenvalues.length - 1) || matT[i + 1][i] < Math.pow(1.0, -12.0))
                {
                    realEigenvalues[i] = matT[i][i];
                }
                else
                {
                    double x1 = matT[i + 1][i + 1];
                    double p = 0.5 * (matT[i][i] - x1);
                    double z = Math.sqrt(Math.abs(p * p + matT[i + 1][i] * matT[i][i + 1]));
                    realEigenvalues[i] = x1 + p;
                    imagEigenvalues[i] = z;
                    realEigenvalues[i + 1] = x1 + p;
                    imagEigenvalues[i + 1] = -z;
                    i++;
                }

            }

            EigenSystem eigensystem = findEigenVectorsFromSchur(schurFormMatrix, realEigenvalues, imagEigenvalues, x);
            return EigenDecomposition.of(eigensystem);
        }

    }


    private static EigenSystem findEigenVectorsFromSchur(SchurFormMatrix schurFormMatrix, double[] realEigenvalues, double[] imagEigenvalues, Matrix originalMatrix)
    {
        double epsilon = Math.pow(1.0, -12.0);
        double[][] matrixT = NumberArrayStream.getAsDoubleMatrix(schurFormMatrix.getT().getAsArrayOfArrays());
        double[][] matrixP = NumberArrayStream.getAsDoubleMatrix(schurFormMatrix.getP().getAsArrayOfArrays());
        int n = matrixT.length;
        double norm = 0.0;

        for(int i = 0; i < n; i++)
        {

            for(int j = Math.max(i - 1, 0); j < n; j++)
            {
                norm += Math.abs(matrixT[i][j]);
            }

        }

        // we can not handle a matrix with zero norm
        if(norm <= epsilon)
        {
            return null;
        }

        double r = 0.0;
        double s = 0.0;
        double z = 0.0;

        for(int idx = n - 1; idx >= 0; idx--)
        {
            double p = realEigenvalues[idx];
            double q = imagEigenvalues[idx];

            if(q == 0.0)
            {
                int l = idx;
                matrixT[idx][idx] = 1.0;

                for(int i = idx - 1; i >= 0; i--)
                {
                    double w = matrixT[i][i] - p;
                    r = 0.0;

                    for(int j = l; j <= idx; j++)
                    {
                        r += matrixT[i][j] * matrixT[j][idx];
                    }

                    if(imagEigenvalues[i] < 0)
                    {
                        z = w;
                        s = r;
                    }
                    else
                    {
                        l = i;

                        if(imagEigenvalues[i] == 0.0)
                        {

                            if(w != 0.0)
                            {
                                matrixT[i][idx] = -r / w;
                            }
                            else
                            {
                                matrixT[i][idx] = -r / (epsilon * norm);
                            }

                        }
                        else
                        {
                            double x = matrixT[i][i + 1];
                            double y = matrixT[i + 1][i];
                            q = (realEigenvalues[i] - p) * (realEigenvalues[i] - p) + imagEigenvalues[i] * imagEigenvalues[i];
                            double t = (x * s - z * r) / q;
                            matrixT[i][idx] = t;

                            if(Math.abs(x) > Math.abs(z))
                            {
                                matrixT[i + 1][idx] = (-r - w * t) / x;
                            }
                            else
                            {
                                matrixT[i + 1][idx] = (-s - y * t) / z;
                            }

                        }

                        double t = Math.abs(matrixT[i][idx]);

                        if((epsilon * t) * t > 1)
                        {

                            for(int j = i; j <= idx; j++)
                            {
                                matrixT[j][idx] /= t;
                            }

                        }

                    }

                }

            }
            else if(q < 0.0)
            {
                int l = idx - 1;

                if(Math.abs(matrixT[idx][idx - 1]) > Math.abs(matrixT[idx - 1][idx]))
                {
                    matrixT[idx - 1][idx - 1] = q / matrixT[idx][idx - 1];
                    matrixT[idx - 1][idx] = -(matrixT[idx][idx] - p) / matrixT[idx][idx - 1];
                }
                else
                {
                    ANumber temp1 = ANumber.of(0.0, -matrixT[idx - 1][idx]);
                    ANumber temp2 = ANumber.of(matrixT[idx - 1][idx - 1] - p, q);
                    ANumber temp3 = temp1.divideGET(temp2);
                    matrixT[idx - 1][idx - 1] = temp3.getRealValue().doubleValue();
                    matrixT[idx - 1][idx] = temp3.getImaginaryValue().doubleValue();
                }

                matrixT[idx][idx - 1] = 0.0;
                matrixT[idx][idx] = 1.0;

                for(int i = idx - 2; i >= 0; i--)
                {
                    double ra = 0.0;
                    double sa = 0.0;

                    for(int j = l; j <= idx; j++)
                    {
                        ra += matrixT[i][j] * matrixT[j][idx - 1];
                        sa += matrixT[i][j] * matrixT[j][idx];
                    }

                    double w = matrixT[i][i] - p;

                    if(imagEigenvalues[i] < 0)
                    {
                        z = w;
                        r = ra;
                        s = sa;
                    }
                    else
                    {
                        l = i;

                        if(imagEigenvalues[i] == 0.0)
                        {
                            ANumber temp1 = ANumber.of(-ra, -sa);
                            ANumber temp2 = ANumber.of(w, q);
                            ANumber temp3 = temp1.divideGET(temp2);
                            matrixT[i][idx - 1] = temp3.getRealValue().doubleValue();
                            matrixT[i][idx] = temp3.getImaginaryValue().doubleValue();
                        }
                        else
                        {
                            double x = matrixT[i][i + 1];
                            double y = matrixT[i + 1][i];
                            double vr = (realEigenvalues[i] - p) * (realEigenvalues[i] - p) + imagEigenvalues[i] * imagEigenvalues[i] - q * q;
                            double vi = (realEigenvalues[i] - p) * 2.0 * q;

                            if(vr == 0.0 && vi == 0.0)
                            {
                                vr = epsilon * norm * (Math.abs(w) + Math.abs(q) + Math.abs(x) + Math.abs(y) + Math.abs(z));
                            }

                            ANumber temp1 = ANumber.of(x * r - z * ra + q * sa, x * s - z * sa - q * ra);
                            ANumber temp2 = ANumber.of(vr, vi);
                            ANumber temp3 = temp1.divideGET(temp2);
                            matrixT[i][idx - 1] = temp3.getRealValue().doubleValue();
                            matrixT[i][idx] = temp3.getImaginaryValue().doubleValue();

                            if(Math.abs(x) > (Math.abs(z) + Math.abs(q)))
                            {
                                matrixT[i + 1][idx - 1] = (-ra - w * matrixT[i][idx - 1] + q * matrixT[i][idx]) / x;
                                matrixT[i + 1][idx] = (-sa - w * matrixT[i][idx] - q * matrixT[i][idx - 1]) / x;
                            }
                            else
                            {
                                ANumber temp4 = ANumber.of(-r - y * matrixT[i][idx - 1], -s - y * matrixT[i][idx]);
                                ANumber temp5 = ANumber.of(z, q);
                                ANumber temp6 = temp4.divideGET(temp5);
                                matrixT[i + 1][idx - 1] = temp6.getRealValue().doubleValue();
                                matrixT[i + 1][idx] = temp6.getImaginaryValue().doubleValue();
                            }

                        }

                        double t = Math.max(Math.abs(matrixT[i][idx - 1]), Math.abs(matrixT[i][idx]));

                        if((epsilon * t) * t > 1)
                        {

                            for(int j = i; j <= idx; j++)
                            {
                                matrixT[j][idx - 1] /= t;
                                matrixT[j][idx] /= t;
                            }

                        }

                    }

                }

            }

        }

        for(int j = n - 1; j >= 0; j--)
        {

            for(int i = 0; i <= n - 1; i++)
            {
                z = 0.0;

                for(int k = 0; k <= Math.min(j, n - 1); k++)
                {
                    z += matrixP[i][k] * matrixT[k][j];
                }

                matrixP[i][j] = z;
            }

        }

        double[][] eigenvectors = new double[n][n];
        double[] tmp = new double[n];

        for(int i = 0; i < n; i++)
        {

            for(int j = 0; j < n; j++)
            {
                tmp[j] = matrixP[j][i];
            }

            eigenvectors[i] = tmp;
        }

        return EigenSystem.of(originalMatrix, Matrix.of(NumberArrayStream.getAsNumberMatrix(eigenvectors)).transpose(), Vector.of(NumberArrayStream.getAsNumberArray(realEigenvalues)), Vector.of(NumberArrayStream.getAsNumberArray(imagEigenvalues)));
    }
}