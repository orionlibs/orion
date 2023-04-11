package com.orion.math.linearalgebra.matrix.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.form.TridiagonalMatrixForm;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;
import java.util.Arrays;

public class TransformMatrixToTridiagonalMatrixTask extends Orion
{
    public static TridiagonalMatrixForm run(Matrix x)
    {
        MatrixRules.isValidSquareMatrix(x);
        int m = x.getNumberOfRows();
        ANumber[][] householderVectors = x.getAsArrayOfArraysCopy();
        ANumber[] main = new ANumber[m];
        NumberArrayStream.setZeroValue(main);
        ANumber[] secondary = new ANumber[m - 1];
        NumberArrayStream.setZeroValue(secondary);
        ANumber[] z = new ANumber[m];
        NumberArrayStream.setZeroValue(z);

        for(int k = 0; k < m - 1; k++)
        {
            ANumber[] hK = householderVectors[k];
            main[k] = hK[k].getCopy();
            ANumber xNormSqr = ANumber.of(0);

            for(int j = k + 1; j < m; ++j)
            {
                ANumber c = hK[j].getCopy();
                xNormSqr.add(c.squareGET());
            }

            ANumber a = xNormSqr.getSquareRoot();

            if(hK[k + 1].isPositive())
            {
                a.negate();
            }

            secondary[k] = a.getCopy();

            if(a.isNotZero())
            {
                hK[k + 1].subtract(a);
                ANumber beta = ANumber.of(-1).divideGET(a.multiplyGET(hK[k + 1]));
                Arrays.fill(z, k + 1, m, ANumber.of(0));

                for(int i = k + 1; i < m; ++i)
                {
                    ANumber[] hI = householderVectors[i];
                    ANumber hKI = hK[i].getCopy();
                    ANumber zI = hI[i].multiplyGET(hKI);

                    for(int j = i + 1; j < m; ++j)
                    {
                        ANumber hIJ = hI[j].getCopy();
                        zI.add(hIJ.multiplyGET(hK[j]));
                        z[j].add(hIJ.multiplyGET(hKI));
                    }

                    z[i] = beta.multiplyGET(z[i].addGET(zI));
                }

                ANumber gamma = ANumber.of(0);

                for(int i = k + 1; i < m; ++i)
                {
                    gamma.add(z[i].multiplyGET(hK[i]));
                }

                gamma.multiply(beta.halfGET());

                for(int i = k + 1; i < m; ++i)
                {
                    z[i].subtract(gamma.multiplyGET(hK[i]));
                }

                for(int i = k + 1; i < m; ++i)
                {
                    ANumber[] hI = householderVectors[i];

                    for(int j = i; j < m; ++j)
                    {
                        hI[j].subtract(hK[i].multiplyGET(z[j]).addGET(z[i].multiplyGET(hK[j])));
                    }

                }

            }

        }

        main[m - 1] = householderVectors[m - 1][m - 1].getCopy();
        return TridiagonalMatrixForm.of(getTridiagonalMatrix(main, secondary), getQTranspose(householderVectors, secondary), Matrix.of(householderVectors), Vector.of(main), Vector.of(secondary));
    }


    private static Matrix getTridiagonalMatrix(ANumber[] main, ANumber[] secondary)
    {
        int m = main.length;
        ANumber[][] ta = new ANumber[m][m];
        NumberArrayStream.setZeroValue(ta);

        for(int i = 0; i < m; ++i)
        {
            ta[i][i] = main[i].getCopy();

            if(i > 0)
            {
                ta[i][i - 1] = secondary[i - 1].getCopy();
            }

            if(i < main.length - 1)
            {
                ta[i][i + 1] = secondary[i].getCopy();
            }

        }

        return Matrix.of(ta);
    }


    private static Matrix getQTranspose(ANumber[][] householderVectors, ANumber[] secondary)
    {
        int m = householderVectors.length;
        ANumber[][] qta = new ANumber[m][m];
        NumberArrayStream.setZeroValue(qta);

        for(int k = m - 1; k >= 1; --k)
        {
            ANumber[] hK = householderVectors[k - 1];
            qta[k][k] = ANumber.of(1);

            if(hK[k].isNotZero())
            {
                ANumber inv = secondary[k - 1].multiplyGET(hK[k]).reciprocateGET();
                ANumber beta = secondary[k - 1].reciprocateGET();
                qta[k][k] = beta.multiplyGET(hK[k]).addOneGET();

                for(int i = k + 1; i < m; ++i)
                {
                    qta[k][i] = beta.multiplyGET(hK[i]);
                }

                for(int j = k + 1; j < m; ++j)
                {
                    beta = ANumber.of(0);

                    for(int i = k + 1; i < m; ++i)
                    {
                        beta.add(qta[j][i].multiplyGET(hK[i]));
                    }

                    beta.multiply(inv);
                    qta[j][k] = beta.multiplyGET(hK[k]);

                    for(int i = k + 1; i < m; ++i)
                    {
                        qta[j][i].add(beta.multiplyGET(hK[i]));
                    }

                }

            }

        }

        qta[0][0] = ANumber.of(1);
        return Matrix.of(qta);
    }
}