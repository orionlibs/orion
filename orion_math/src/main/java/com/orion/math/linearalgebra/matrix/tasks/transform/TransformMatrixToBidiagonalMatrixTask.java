package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.form.BidiagonalMatrixForm;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;

public class TransformMatrixToBidiagonalMatrixTask extends Orion
{
    public static BidiagonalMatrixForm run(Matrix x)
    {
        MatrixRules.isValid(x);
        int m = x.getNumberOfRows();
        int n = x.getNumberOfColumns();
        int p = Math.min(m, n);
        ANumber[][] householderVectors = x.getAsArrayOfArraysCopy();
        ANumber[] main = new ANumber[p];
        NumberArrayStream.setZeroValue(main);
        ANumber[] secondary = new ANumber[p - 1];
        NumberArrayStream.setZeroValue(secondary);

        if(m >= n)
        {
            transformToUpperBidiagonal(householderVectors, main, secondary);
        }
        else
        {
            transformToLowerBidiagonal(householderVectors, main, secondary);
        }

        Matrix orthogonalMatrix1 = getOrthogonalMatrix1(householderVectors, main, secondary);
        Matrix orthogonalMatrix2 = getOrthogonalMatrix2(householderVectors, main, secondary);
        Matrix bidiagonallMatrix = getBidiagonalMatrix(householderVectors, main, secondary);
        return BidiagonalMatrixForm.of(orthogonalMatrix1, orthogonalMatrix2, bidiagonallMatrix);
    }


    private static void transformToUpperBidiagonal(ANumber[][] householderVectors, ANumber[] main, ANumber[] secondary)
    {
        int m = householderVectors.length;
        int n = householderVectors[0].length;

        for(int k = 0; k < n; k++)
        {
            ANumber xNormSqr = ANumber.of(0);

            for(int i = k; i < m; ++i)
            {
                ANumber c = householderVectors[i][k].getCopy();
                xNormSqr.add(c.squareGET());
            }

            ANumber[] hK = householderVectors[k];
            ANumber a = (hK[k].isPositive()) ? xNormSqr.getSquareRoot().negateGET() : xNormSqr.getSquareRoot();
            main[k] = a.getCopy();

            if(a.isNotZero())
            {
                hK[k].subtract(a);

                for(int j = k + 1; j < n; ++j)
                {
                    ANumber alpha = ANumber.of(0);

                    for(int i = k; i < m; ++i)
                    {
                        ANumber[] hI = householderVectors[i];
                        alpha.subtract(hI[j].multiplyGET(hI[k]));
                    }

                    alpha.divide(a.multiplyGET(householderVectors[k][k]));

                    for(int i = k; i < m; ++i)
                    {
                        ANumber[] hI = householderVectors[i];
                        hI[j].subtract(alpha.multiplyGET(hI[k]));
                    }

                }

            }

            if(k < n - 1)
            {
                xNormSqr = ANumber.of(0);

                for(int j = k + 1; j < n; ++j)
                {
                    ANumber c = hK[j].getCopy();
                    xNormSqr.add(c.squareGET());
                }

                ANumber b = (hK[k + 1].isPositive()) ? xNormSqr.getSquareRoot().negateGET() : xNormSqr.getSquareRoot();
                secondary[k] = b.getCopy();

                if(b.isNotZero())
                {
                    hK[k + 1].subtract(b);

                    for(int i = k + 1; i < m; ++i)
                    {
                        ANumber[] hI = householderVectors[i];
                        ANumber beta = ANumber.of(0);

                        for(int j = k + 1; j < n; ++j)
                        {
                            beta.subtract(hI[j].multiplyGET(hK[j]));
                        }

                        beta.divide(b.multiplyGET(hK[k + 1]));

                        for(int j = k + 1; j < n; ++j)
                        {
                            hI[j].subtract(beta.multiplyGET(hK[j]));
                        }

                    }

                }

            }

        }

    }


    private static void transformToLowerBidiagonal(ANumber[][] householderVectors, ANumber[] main, ANumber[] secondary)
    {
        int m = householderVectors.length;
        int n = householderVectors[0].length;

        for(int k = 0; k < m; k++)
        {
            ANumber[] hK = householderVectors[k];
            ANumber xNormSqr = ANumber.of(0);

            for(int j = k; j < n; ++j)
            {
                ANumber c = hK[j].getCopy();
                xNormSqr.add(c.squareGET());
            }

            ANumber a = (hK[k].isPositive()) ? xNormSqr.getSquareRoot().negateGET() : xNormSqr.getSquareRoot();
            main[k] = a.getCopy();

            if(a.isNotZero())
            {
                hK[k].subtract(a);

                for(int i = k + 1; i < m; ++i)
                {
                    ANumber[] hI = householderVectors[i];
                    ANumber alpha = ANumber.of(0);

                    for(int j = k; j < n; ++j)
                    {
                        alpha.subtract(hI[j].multiplyGET(hK[j]));
                    }

                    alpha.divide(a.multiplyGET(householderVectors[k][k]));

                    for(int j = k; j < n; ++j)
                    {
                        hI[j].subtract(alpha.multiplyGET(hK[j]));
                    }

                }

            }

            if(k < m - 1)
            {
                ANumber[] hKp1 = householderVectors[k + 1];
                xNormSqr = ANumber.of(0);

                for(int i = k + 1; i < m; ++i)
                {
                    ANumber c = householderVectors[i][k].getCopy();
                    xNormSqr.add(c.squareGET());
                }

                ANumber b = (hKp1[k].isPositive()) ? xNormSqr.getSquareRoot().negateGET() : xNormSqr.getSquareRoot();
                secondary[k] = b.getCopy();

                if(b.isNotZero())
                {
                    hKp1[k].subtract(b);

                    for(int j = k + 1; j < n; ++j)
                    {
                        ANumber beta = ANumber.of(0);

                        for(int i = k + 1; i < m; ++i)
                        {
                            ANumber[] hI = householderVectors[i];
                            beta.subtract(hI[j].multiplyGET(hI[k]));
                        }

                        beta.divide(b.multiplyGET(hKp1[k]));

                        for(int i = k + 1; i < m; ++i)
                        {
                            ANumber[] hI = householderVectors[i];
                            hI[j].subtract(beta.multiplyGET(hI[k]));
                        }

                    }

                }

            }

        }

    }


    private static Matrix getOrthogonalMatrix1(ANumber[][] householderVectors, ANumber[] main, ANumber[] secondary)
    {
        int m = householderVectors.length;
        int n = householderVectors[0].length;
        int p = main.length;
        int diagOffset = (m >= n) ? 0 : 1;
        ANumber[] diagonal = (m >= n) ? main : secondary;
        ANumber[][] ua = new ANumber[m][m];
        NumberArrayStream.setZeroValue(ua);

        for(int k = m - 1; k >= p; k--)
        {
            ua[k][k] = ANumber.of(1);
        }

        for(int k = p - 1; k >= diagOffset; k--)
        {
            ANumber[] hK = householderVectors[k];
            ua[k][k] = ANumber.of(1);

            if(hK[k - diagOffset].isNotZero())
            {

                for(int j = k; j < m; j++)
                {
                    ANumber alpha = ANumber.of(0);

                    for(int i = k; i < m; i++)
                    {
                        alpha.subtract(ua[i][j].multiplyGET(householderVectors[i][k - diagOffset]));
                    }

                    alpha.divide(diagonal[k - diagOffset].multiplyGET(hK[k - diagOffset]));

                    for(int i = k; i < m; i++)
                    {
                        ua[i][j].add(alpha.multiplyGET(householderVectors[i][k - diagOffset]).negateGET());
                    }

                }

            }

        }

        if(diagOffset > 0)
        {
            ua[0][0] = ANumber.of(1);
        }

        return Matrix.of(ua);
    }


    private static Matrix getOrthogonalMatrix2(ANumber[][] householderVectors, ANumber[] main, ANumber[] secondary)
    {
        int m = householderVectors.length;
        int n = householderVectors[0].length;
        int p = main.length;
        int diagOffset = (m >= n) ? 1 : 0;
        ANumber[] diagonal = (m >= n) ? secondary : main;
        ANumber[][] va = new ANumber[n][n];
        NumberArrayStream.setZeroValue(va);

        for(int k = n - 1; k >= p; k--)
        {
            va[k][k] = ANumber.of(1);
        }

        for(int k = p - 1; k >= diagOffset; k--)
        {
            ANumber[] hK = householderVectors[k - diagOffset];
            va[k][k] = ANumber.of(1);

            if(hK[k].isNotZero())
            {

                for(int j = k; j < n; j++)
                {
                    ANumber beta = ANumber.of(0);

                    for(int i = k; i < n; i++)
                    {
                        beta.subtract(va[i][j].multiplyGET(hK[i]));
                    }

                    beta.divide(diagonal[k - diagOffset].multiplyGET(hK[k]));

                    for(int i = k; i < n; i++)
                    {
                        va[i][j].add(beta.multiplyGET(hK[i]).negateGET());
                    }

                }

            }

        }

        if(diagOffset > 0)
        {
            va[0][0] = ANumber.of(1);
        }

        return Matrix.of(va);
    }


    private static Matrix getBidiagonalMatrix(ANumber[][] householderVectors, ANumber[] main, ANumber[] secondary)
    {
        int m = householderVectors.length;
        int n = householderVectors[0].length;
        ANumber[][] ba = new ANumber[m][n];
        NumberArrayStream.setZeroValue(ba);

        for(int i = 0; i < main.length; ++i)
        {
            ba[i][i] = main[i].getCopy();

            if(m < n)
            {

                if(i > 0)
                {
                    ba[i][i - 1] = secondary[i - 1].getCopy();
                }

            }
            else if(i < main.length - 1)
            {
                ba[i][i + 1] = secondary[i].getCopy();
            }

        }

        return Matrix.of(ba);
    }
}