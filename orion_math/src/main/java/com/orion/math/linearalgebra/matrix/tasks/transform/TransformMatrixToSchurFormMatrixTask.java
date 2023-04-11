package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.form.HessenbergFormMatrix;
import com.orion.math.linearalgebra.matrix.form.SchurFormMatrix;
import com.orion.math.streams.NumberArrayStream;

public class TransformMatrixToSchurFormMatrixTask extends Orion
{
    public static SchurFormMatrix run(Matrix matrix)
    {
        MatrixRules.isValidSquareMatrix(matrix);
        HessenbergFormMatrix hessenbergFormMatrix = matrix.transformToHessenbergFormMatrix();
        double[][] matrixT = NumberArrayStream.getAsDoubleMatrix(hessenbergFormMatrix.getHessenbergMatrix().getAsArrayOfArrays());
        double[][] matrixP = NumberArrayStream.getAsDoubleMatrix(hessenbergFormMatrix.getP().getAsArrayOfArrays());
        int n = matrixT.length;
        int maxIterations = 200;
        double norm = getNorm(matrixT);
        ShiftInfo shift = new ShiftInfo();
        int iteration = 0;
        int iu = n - 1;

        while(iu >= 0)
        {
            int il = findSmallSubDiagonalElement(matrixT, iu, norm);

            if(il == iu)
            {
                matrixT[iu][iu] += shift.exShift;
                iu--;
                iteration = 0;
            }
            else if(il == iu - 1)
            {
                double p = (matrixT[iu - 1][iu - 1] - matrixT[iu][iu]) / 2.0;
                double q = p * p + matrixT[iu][iu - 1] * matrixT[iu - 1][iu];
                matrixT[iu][iu] += shift.exShift;
                matrixT[iu - 1][iu - 1] += shift.exShift;

                if(q >= 0)
                {
                    double z = Math.sqrt(Math.abs(q));

                    if(p >= 0)
                    {
                        z = p + z;
                    }
                    else
                    {
                        z = p - z;
                    }

                    double x = matrixT[iu][iu - 1];
                    double s = Math.abs(x) + Math.abs(z);
                    p = x / s;
                    q = z / s;
                    double r = Math.sqrt(p * p + q * q);
                    p /= r;
                    q /= r;

                    for(int j = iu - 1; j < n; j++)
                    {
                        z = matrixT[iu - 1][j];
                        matrixT[iu - 1][j] = q * z + p * matrixT[iu][j];
                        matrixT[iu][j] = q * matrixT[iu][j] - p * z;
                    }

                    for(int i = 0; i <= iu; i++)
                    {
                        z = matrixT[i][iu - 1];
                        matrixT[i][iu - 1] = q * z + p * matrixT[i][iu];
                        matrixT[i][iu] = q * matrixT[i][iu] - p * z;
                    }

                    for(int i = 0; i <= n - 1; i++)
                    {
                        z = matrixP[i][iu - 1];
                        matrixP[i][iu - 1] = q * z + p * matrixP[i][iu];
                        matrixP[i][iu] = q * matrixP[i][iu] - p * z;
                    }

                }

                iu -= 2;
                iteration = 0;
            }
            else
            {
                computeShift(matrixT, il, iu, iteration, shift);

                if(++iteration > maxIterations)
                {
                    return null;
                }

                double[] hVec = new double[3];
                int im = initQRStep(matrixT, il, iu, shift, hVec);
                performDoubleQRStep(matrixT, matrixP, il, im, iu, shift, hVec);
            }

        }

        return SchurFormMatrix.of(Matrix.of(NumberArrayStream.getAsNumberMatrix(matrixP)), Matrix.of(NumberArrayStream.getAsNumberMatrix(matrixT)));
    }


    private static double getNorm(double[][] matrixT)
    {
        double norm = 0.0;

        for(int i = 0; i < matrixT.length; i++)
        {

            for(int j = Math.max(i - 1, 0); j < matrixT.length; j++)
            {
                norm += Math.abs(matrixT[i][j]);
            }

        }

        return norm;
    }


    private static int findSmallSubDiagonalElement(double[][] matrixT, int startIdx, double norm)
    {
        int l = startIdx;

        while(l > 0)
        {
            double s = Math.abs(matrixT[l - 1][l - 1]) + Math.abs(matrixT[l][l]);

            if(s == 0.0)
            {
                s = norm;
            }

            if(Math.abs(matrixT[l][l - 1]) < Math.pow(2.0, -52.0) * s)
            {
                break;
            }

            l--;
        }

        return l;
    }


    private static void computeShift(double[][] matrixT, int l, int idx, int iteration, ShiftInfo shift)
    {
        shift.x = matrixT[idx][idx];
        shift.y = shift.w = 0.0;

        if(l < idx)
        {
            shift.y = matrixT[idx - 1][idx - 1];
            shift.w = matrixT[idx][idx - 1] * matrixT[idx - 1][idx];
        }

        if(iteration == 10)
        {
            shift.exShift += shift.x;

            for(int i = 0; i <= idx; i++)
            {
                matrixT[i][i] -= shift.x;
            }

            double s = Math.abs(matrixT[idx][idx - 1]) + Math.abs(matrixT[idx - 1][idx - 2]);
            shift.x = 0.75 * s;
            shift.y = 0.75 * s;
            shift.w = -0.4375 * s * s;
        }

        if(iteration == 30)
        {
            double s = (shift.y - shift.x) / 2.0;
            s = s * s + shift.w;

            if(s > 0.0)
            {
                s = Math.sqrt(s);

                if(shift.y < shift.x)
                {
                    s = -s;
                }

                s = shift.x - shift.w / ((shift.y - shift.x) / 2.0 + s);

                for(int i = 0; i <= idx; i++)
                {
                    matrixT[i][i] -= s;
                }

                shift.exShift += s;
                shift.x = shift.y = shift.w = 0.964;
            }

        }

    }


    private static int initQRStep(double[][] matrixT, int il, int iu, ShiftInfo shift, double[] hVec)
    {
        int im = iu - 2;

        while(im >= il)
        {
            double z = matrixT[im][im];
            double r = shift.x - z;
            double s = shift.y - z;
            hVec[0] = (r * s - shift.w) / matrixT[im + 1][im] + matrixT[im][im + 1];
            hVec[1] = matrixT[im + 1][im + 1] - z - r - s;
            hVec[2] = matrixT[im + 2][im + 1];

            if(im == il)
            {
                break;
            }

            double lhs = Math.abs(matrixT[im][im - 1]) * (Math.abs(hVec[1]) + Math.abs(hVec[2]));
            double rhs = Math.abs(hVec[0]) * (Math.abs(matrixT[im - 1][im - 1]) + Math.abs(z) + Math.abs(matrixT[im + 1][im + 1]));

            if(lhs < Math.pow(.0, -52.0) * rhs)
            {
                break;
            }

            im--;
        }

        return im;
    }


    private static void performDoubleQRStep(double[][] matrixT, double[][] matrixP, int il, int im, int iu, ShiftInfo shift, double[] hVec)
    {
        int n = matrixT.length;
        double p = hVec[0];
        double q = hVec[1];
        double r = hVec[2];

        for(int k = im; k <= iu - 1; k++)
        {
            boolean notlast = k != (iu - 1);

            if(k != im)
            {
                p = matrixT[k][k - 1];
                q = matrixT[k + 1][k - 1];
                r = notlast ? matrixT[k + 2][k - 1] : 0.0;
                shift.x = Math.abs(p) + Math.abs(q) + Math.abs(r);

                if(shift.x <= Math.pow(2.0, -52.0))
                {
                    continue;
                }

                p /= shift.x;
                q /= shift.x;
                r /= shift.x;
            }

            double s = Math.sqrt(p * p + q * q + r * r);

            if(p < 0.0)
            {
                s = -s;
            }

            if(s != 0.0)
            {

                if(k != im)
                {
                    matrixT[k][k - 1] = -s * shift.x;
                }
                else if(il != im)
                {
                    matrixT[k][k - 1] = -matrixT[k][k - 1];
                }

                p += s;
                shift.x = p / s;
                shift.y = q / s;
                double z = r / s;
                q /= p;
                r /= p;

                for(int j = k; j < n; j++)
                {
                    p = matrixT[k][j] + q * matrixT[k + 1][j];

                    if(notlast)
                    {
                        p += r * matrixT[k + 2][j];
                        matrixT[k + 2][j] -= p * z;
                    }

                    matrixT[k][j] -= p * shift.x;
                    matrixT[k + 1][j] -= p * shift.y;
                }

                for(int i = 0; i <= Math.min(iu, k + 3); i++)
                {
                    p = shift.x * matrixT[i][k] + shift.y * matrixT[i][k + 1];

                    if(notlast)
                    {
                        p += z * matrixT[i][k + 2];
                        matrixT[i][k + 2] -= p * r;
                    }

                    matrixT[i][k] -= p;
                    matrixT[i][k + 1] -= p * q;
                }

                int high = matrixT.length - 1;

                for(int i = 0; i <= high; i++)
                {
                    p = shift.x * matrixP[i][k] + shift.y * matrixP[i][k + 1];

                    if(notlast)
                    {
                        p += z * matrixP[i][k + 2];
                        matrixP[i][k + 2] -= p * r;
                    }

                    matrixP[i][k] -= p;
                    matrixP[i][k + 1] -= p * q;
                }

            }

        }

        for(int i = im + 2; i <= iu; i++)
        {
            matrixT[i][i - 2] = 0.0;

            if(i > im + 2)
            {
                matrixT[i][i - 3] = 0.0;
            }

        }

    }


    private static class ShiftInfo
    {
        double x;
        double y;
        double w;
        double exShift;
    }
}