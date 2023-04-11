package com.orion.math.linearalgebra.matrix.tasks.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.decomposition.QRDecomposition;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.Arrays;
import java.util.stream.IntStream;

public class GetQRDecompositionOfMatrixTask extends Orion
{
    public static QRDecomposition run(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        precision = Precision.getValidPrecision(precision);
        int m = x.getNumberOfRows();
        int n = x.getNumberOfColumns();
        ANumber[][] qrt = x.transpose().getAsArrayOfArrays();
        ANumber[] rDiag = new ANumber[Math.min(m, n)];

        for(int minor = 0; minor < Math.min(qrt.length, qrt[0].length); minor++)
        {
            ANumber[] qrtMinor = qrt[minor];
            ANumber xNormSqr = ANumber.of(0);

            for(int i = minor; i < qrtMinor.length; i++)
            {
                ANumber c = qrtMinor[i];
                xNormSqr.add(c.squareGET());
            }

            ANumber a = (qrtMinor[minor].isPositive()) ? xNormSqr.getSquareRoot(precision).negateGET() : xNormSqr.getSquareRoot(precision);
            rDiag[minor] = a;

            if(a.isNotZero())
            {
                qrtMinor[minor] = qrtMinor[minor].subtractGET(a);

                for(int j = minor + 1; j < qrt.length; j++)
                {
                    ANumber[] qrtCol = qrt[j];
                    ANumber alpha = ANumber.of(0);

                    for(int i = minor; i < qrtCol.length; i++)
                    {
                        alpha.subtract(qrtCol[i].multiplyGET(qrtMinor[i]));
                    }

                    alpha.divide(a.multiplyGET(qrtMinor[minor]));

                    for(int i = minor; i < qrtCol.length; i++)
                    {
                        qrtCol[i] = qrtCol[i].subtractGET(alpha.multiplyGET(qrtMinor[i]));
                    }

                }

            }

        }

        n = qrt.length;
        m = qrt[0].length;
        ANumber[][] ra = new ANumber[m][n];
        IntStream.range(0, m).forEach(i -> Arrays.fill(ra[i], ANumber.of(0)));

        for(int i = Math.min(m, n) - 1; i >= 0; i--)
        {
            ra[i][i] = rDiag[i];

            for(int j = i + 1; j < n; j++)
            {
                ra[i][j] = qrt[j][i];
            }

        }

        Matrix R = Matrix.of(ra);
        ANumber[][] qta = new ANumber[m][m];
        IntStream.range(0, m).forEach(i -> Arrays.fill(qta[i], ANumber.of(0)));

        for(int minor = m - 1; minor >= Math.min(m, n); minor--)
        {
            qta[minor][minor] = ANumber.of(1);
        }

        for(int minor = Math.min(m, n) - 1; minor >= 0; minor--)
        {
            ANumber[] qrtMinor = qrt[minor];
            qta[minor][minor] = ANumber.of(1);

            if(qrtMinor[minor].isNotZero())
            {

                for(int j = minor; j < m; j++)
                {
                    ANumber alpha = ANumber.of(0);

                    for(int i = minor; i < m; i++)
                    {
                        alpha.subtract(qta[j][i].multiplyGET(qrtMinor[i]));
                    }

                    alpha.divide(rDiag[minor].multiplyGET(qrtMinor[minor]));

                    for(int i = minor; i < m; i++)
                    {
                        qta[j][i] = qta[j][i].addGET(alpha.negateGET().multiplyGET(qrtMinor[i]));
                    }

                }

            }

        }

        Matrix QTranspose = Matrix.of(qta);
        Matrix Q = QTranspose.transpose();
        ANumber[][] ha = new ANumber[m][n];

        for(int i = 0; i < m; ++i)
        {

            for(int j = 0; j < Math.min(i + 1, n); ++j)
            {
                ha[i][j] = qrt[j][i].divideGET(rDiag[j].negateGET());
            }

        }

        return QRDecomposition.of(Q, R, Matrix.of(ha), getRank(R, precision));
    }


    private static ANumber getRank(Matrix R, int precision)
    {
        Matrix RCopy = R.applyPrecisionGET(precision / 2);
        long rank = IntStream.range(0, R.getNumberOfRows()).filter(i -> RCopy.getRow(i).isNotZeroVector()).count();
        return ANumber.of(rank);
    }
}