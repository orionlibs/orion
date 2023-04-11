package com.orion.math.linearalgebra.matrix.tasks.decomposition;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.shape.triangle.TriangleService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.linearalgebra.matrix.decomposition.SingularValueDecomposition;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import com.orion.math.streams.NumberArrayStream;
import java.util.stream.IntStream;

public class GetSingularValueDecompositionOfMatrixTask extends Orion
{
    public static SingularValueDecomposition run(Matrix x, int precision)
    {
        MatrixRules.isValid(x);
        precision = Precision.getValidPrecision(precision);
        ANumber EPS = Precision.getEPSAsNumber(precision);
        ANumber TINY = EPS.getCopy();
        int m = x.getNumberOfRows();
        int n = x.getNumberOfColumns();
        ANumber[] singularValues = new ANumber[n];
        NumberArrayStream.setZeroValue(singularValues);
        ANumber[][] U = new ANumber[m][n];
        NumberArrayStream.setZeroValue(U);
        ANumber[][] UTranspose = new ANumber[n][m];
        NumberArrayStream.setZeroValue(UTranspose);
        ANumber[][] V = new ANumber[n][n];
        NumberArrayStream.setZeroValue(V);
        ANumber[][] VTranspose = new ANumber[n][n];
        NumberArrayStream.setZeroValue(VTranspose);
        ANumber[][] A = new ANumber[m][m];
        NumberArrayStream.setZeroValue(A);
        ANumber[] e = new ANumber[n];
        NumberArrayStream.setZeroValue(e);
        ANumber[] work = new ANumber[m];
        NumberArrayStream.setZeroValue(work);
        int nct = Math.min(m - 1, n);
        int nrt = Math.max(0, n - 2);

        if(m < n)
        {
            A = x.transpose().getAsArrayOfArrays();
        }
        else
        {
            A = x.getAsArrayOfArraysCopy();
        }

        for(int k = 0; k < Math.max(nct, nrt); k++)
        {

            if(k < nct)
            {
                singularValues[k] = ANumber.of(0);

                for(int i = k; i < m; i++)
                {
                    singularValues[k] = TriangleService.getHypotenuseIgnoreErrors(singularValues[k], A[i][k], precision);
                }

                if(singularValues[k].isNotZero())
                {

                    if(A[k][k].isNegative())
                    {
                        singularValues[k].negate();
                    }

                    for(int i = k; i < m; i++)
                    {
                        A[i][k].divide(singularValues[k]);
                    }

                    A[k][k].addOne();
                }

                singularValues[k].negate();
            }

            for(int j = k + 1; j < n; j++)
            {

                if(k < nct && singularValues[k].isNotZero())
                {
                    ANumber t = ANumber.of(0);

                    for(int i = k; i < m; i++)
                    {
                        t.add(A[i][k].multiplyGET(A[i][j]));
                    }

                    t = t.negateGET().divideGET(A[k][k]);

                    for(int i = k; i < m; i++)
                    {
                        A[i][j].add(t.multiplyGET(A[i][k]));
                    }

                }

                e[j] = A[k][j];
            }

            if(k < nct)
            {

                for(int i = k; i < m; i++)
                {
                    U[i][k] = A[i][k];
                }

            }

            if(k < nrt)
            {
                e[k] = ANumber.of(0);

                for(int i = k + 1; i < n; i++)
                {
                    e[k] = TriangleService.getHypotenuseIgnoreErrors(e[k], e[i], precision);
                }

                if(e[k].isNotZero())
                {

                    if(e[k + 1].isNegative())
                    {
                        e[k].negate();
                    }

                    for(int i = k + 1; i < n; i++)
                    {
                        e[i].divide(e[k]);
                    }

                    e[k + 1].addOne();
                }

                e[k].negate();

                if(k + 1 < m && e[k].isNotZero())
                {
                    IntStream.range(k + 1, m).forEach(i -> work[i] = ANumber.of(0));

                    for(int j = k + 1; j < n; j++)
                    {

                        for(int i = k + 1; i < m; i++)
                        {
                            work[i].add(e[j].multiplyGET(A[i][j]));
                        }

                    }

                    for(int j = k + 1; j < n; j++)
                    {
                        ANumber t = e[j].negateGET().divideGET(e[k + 1]);

                        for(int i = k + 1; i < m; i++)
                        {
                            A[i][j].add(t.multiplyGET(work[i]));
                        }

                    }

                }

                for(int i = k + 1; i < n; i++)
                {
                    V[i][k] = e[i];
                }

            }

        }

        int p = n;

        if(nct < n)
        {
            singularValues[nct] = A[nct][nct];
        }

        if(m < p)
        {
            singularValues[p - 1] = ANumber.of(0);
        }

        if(nrt + 1 < p)
        {
            e[nrt] = A[nrt][p - 1];
        }

        e[p - 1] = ANumber.of(0);

        for(int j = nct; j < n; j++)
        {

            for(int i = 0; i < m; i++)
            {
                U[i][j] = ANumber.of(0);
            }

            U[j][j] = ANumber.of(1);
        }

        for(int k = nct - 1; k >= 0; k--)
        {

            if(singularValues[k].isNotZero())
            {

                for(int j = k + 1; j < n; j++)
                {
                    ANumber t = ANumber.of(0);

                    for(int i = k; i < m; i++)
                    {
                        t.add(U[i][k].multiplyGET(U[i][j]));
                    }

                    t = t.negateGET().divideGET(U[k][k]);

                    for(int i = k; i < m; i++)
                    {
                        U[i][j].add(t.multiplyGET(U[i][k]));
                    }

                }

                for(int i = k; i < m; i++)
                {
                    U[i][k].negate();
                }

                U[k][k].addOne();

                for(int i = 0; i < k - 1; i++)
                {
                    U[i][k] = ANumber.of(0);
                }

            }
            else
            {

                for(int i = 0; i < m; i++)
                {
                    U[i][k] = ANumber.of(0);
                }

                U[k][k] = ANumber.of(1);
            }

        }

        for(int k = n - 1; k >= 0; k--)
        {

            if(k < nrt && e[k].isNotZero())
            {

                for(int j = k + 1; j < n; j++)
                {
                    ANumber t = ANumber.of(0);

                    for(int i = k + 1; i < n; i++)
                    {
                        t.add(V[i][k].multiplyGET(V[i][j]));
                    }

                    t = t.negateGET().divideGET(V[k + 1][k]);

                    for(int i = k + 1; i < n; i++)
                    {
                        V[i][j].add(t.multiplyGET(V[i][k]));
                    }

                }

            }

            for(int i = 0; i < n; i++)
            {
                V[i][k] = ANumber.of(0);
            }

            V[k][k] = ANumber.of(1);
        }

        int pp = p - 1;

        while(p > 0)
        {
            int k;
            int kase;

            for(k = p - 2; k >= 0; k--)
            {
                ANumber threshold = TINY.addGET(EPS.multiplyGET(singularValues[k].getAbsoluteValue().addGET(singularValues[k + 1].getAbsoluteValue())));

                if(e[k].getAbsoluteValue().isLessThanOrEqual(threshold))
                {
                    e[k] = ANumber.of(0);
                    break;
                }

            }

            if(k == p - 2)
            {
                kase = 4;
            }
            else
            {
                int ks;

                for(ks = p - 1; ks >= k; ks--)
                {

                    if(ks == k)
                    {
                        break;
                    }

                    ANumber t = ANumber.of(0);

                    if(ks != p)
                    {
                        t = e[ks].getAbsoluteValue();
                    }

                    if(ks != k + 1)
                    {
                        t.add(e[ks - 1].getAbsoluteValue());
                    }

                    if(singularValues[ks].getAbsoluteValue().isLessThanOrEqual(TINY.addGET(EPS.multiplyGET(t))))
                    {
                        singularValues[ks] = ANumber.of(0);
                        break;
                    }

                }

                if(ks == k)
                {
                    kase = 3;
                }
                else if(ks == p - 1)
                {
                    kase = 1;
                }
                else
                {
                    kase = 2;
                    k = ks;
                }

            }

            k++;

            if(kase == 1)
            {
                ANumber f = e[p - 2];
                e[p - 2] = ANumber.of(0);

                for(int j = p - 2; j >= k; j--)
                {
                    ANumber t = TriangleService.getHypotenuseIgnoreErrors(singularValues[j], f, precision);
                    ANumber cs = singularValues[j].divideGET(t);
                    ANumber sn = f.divideGET(t);
                    singularValues[j] = t;

                    if(j != k)
                    {
                        f = sn.negateGET().multiplyGET(e[j - 1]);
                        e[j - 1] = cs.multiplyGET(e[j - 1]);
                    }

                    for(int i = 0; i < n; i++)
                    {
                        t = cs.multiplyGET(V[i][j]).addGET(sn.multiplyGET(V[i][p - 1]));
                        V[i][p - 1] = sn.negateGET().multiplyGET(V[i][j]).addGET(cs.multiplyGET(V[i][p - 1]));
                        V[i][j] = t;
                    }

                }

            }
            else if(kase == 2)
            {
                ANumber f = e[k - 1];
                e[k - 1] = ANumber.of(0);

                for(int j = k; j < p; j++)
                {
                    ANumber t = TriangleService.getHypotenuseIgnoreErrors(singularValues[j], f, precision);
                    ANumber cs = singularValues[j].divideGET(t);
                    ANumber sn = f.divideGET(t);
                    singularValues[j] = t;
                    f = sn.negateGET().multiplyGET(e[j]);
                    e[j] = cs.multiplyGET(e[j]);

                    for(int i = 0; i < m; i++)
                    {
                        t = cs.multiplyGET(U[i][j]).addGET(sn.multiplyGET(U[i][k - 1]));
                        U[i][k - 1] = sn.negateGET().multiplyGET(U[i][j]).addGET(cs.multiplyGET(U[i][k - 1]));
                        U[i][j] = t;
                    }

                }

            }
            else if(kase == 3)
            {
                ANumber maxPm1Pm2 = ArithmeticService.getMaximum(singularValues[p - 1].getAbsoluteValue(), singularValues[p - 2].getAbsoluteValue());
                ANumber max1 = ArithmeticService.getMaximum(maxPm1Pm2, e[p - 2].getAbsoluteValue());
                ANumber max2 = ArithmeticService.getMaximum(max1, singularValues[k].getAbsoluteValue());
                ANumber scale = ArithmeticService.getMaximum(max2, e[k].getAbsoluteValue());
                ANumber sp = singularValues[p - 1].divideGET(scale);
                ANumber spm1 = singularValues[p - 2].divideGET(scale);
                ANumber epm1 = e[p - 2].divideGET(scale);
                ANumber sk = singularValues[k].divideGET(scale);
                ANumber ek = e[k].divideGET(scale);
                ANumber b = spm1.addGET(sp).multiplyGET(spm1.subtractGET(sp)).addGET(epm1.squareGET()).halfGET();
                ANumber c = sp.squareGET().multiplyGET(epm1.squareGET());
                ANumber shift = ANumber.of(0);

                if(b.isNotZero() || c.isNotZero())
                {
                    shift = b.squareGET().addGET(c).getSquareRoot(precision);

                    if(b.isNegative())
                    {
                        shift.negate();
                    }

                    shift = c.divideGET(b.addGET(shift));
                }

                ANumber f = sk.addGET(sp).multiplyGET(sk.subtractGET(sp)).addGET(shift);
                ANumber g = sk.multiplyGET(ek);

                for(int j = k; j < p - 1; j++)
                {
                    ANumber t = TriangleService.getHypotenuseIgnoreErrors(f, g, precision);
                    ANumber cs = f.divideGET(t);
                    ANumber sn = g.divideGET(t);

                    if(j != k)
                    {
                        e[j - 1] = t;
                    }

                    f = cs.multiplyGET(singularValues[j]).addGET(sn.multiplyGET(e[j]));
                    e[j] = cs.multiplyGET(e[j]).subtractGET(sn.multiplyGET(singularValues[j]));
                    g = sn.multiplyGET(singularValues[j + 1]);
                    singularValues[j + 1] = cs.multiplyGET(singularValues[j + 1]);

                    for(int i = 0; i < n; i++)
                    {
                        t = cs.multiplyGET(V[i][j]).addGET(sn.multiplyGET(V[i][j + 1]));
                        V[i][j + 1] = sn.negateGET().multiplyGET(V[i][j]).addGET(cs.multiplyGET(V[i][j + 1]));
                        V[i][j] = t;
                    }

                    t = TriangleService.getHypotenuseIgnoreErrors(f, g, precision);
                    cs = f.divideGET(t);
                    sn = g.divideGET(t);
                    singularValues[j] = t;
                    f = cs.multiplyGET(e[j]).addGET(sn.multiplyGET(singularValues[j + 1]));
                    singularValues[j + 1] = sn.negateGET().multiplyGET(e[j]).addGET(cs.multiplyGET(singularValues[j + 1]));
                    g = sn.multiplyGET(e[j + 1]);
                    e[j + 1] = cs.multiplyGET(e[j + 1]);

                    if(j < m - 1)
                    {

                        for(int i = 0; i < m; i++)
                        {
                            t = cs.multiplyGET(U[i][j]).addGET(sn.multiplyGET(U[i][j + 1]));
                            U[i][j + 1] = sn.negateGET().multiplyGET(U[i][j]).addGET(cs.multiplyGET(U[i][j + 1]));
                            U[i][j] = t;
                        }

                    }

                }

                e[p - 2] = f;
            }
            else
            {

                if(singularValues[k].isNonPositive())
                {
                    singularValues[k] = singularValues[k].isNegative() ? singularValues[k].negateGET() : ANumber.of(0);

                    for(int i = 0; i <= pp; i++)
                    {
                        V[i][k].negate();
                    }

                }

                while(k < pp)
                {

                    if(singularValues[k].isGreaterThanOrEqual(singularValues[k + 1]))
                    {
                        break;
                    }

                    ANumber t = singularValues[k];
                    singularValues[k] = singularValues[k + 1];
                    singularValues[k + 1] = t;

                    if(k < n - 1)
                    {

                        for(int i = 0; i < n; i++)
                        {
                            t = V[i][k + 1];
                            V[i][k + 1] = V[i][k];
                            V[i][k] = t;
                        }

                    }

                    if(k < m - 1)
                    {

                        for(int i = 0; i < m; i++)
                        {
                            t = U[i][k + 1];
                            U[i][k + 1] = U[i][k];
                            U[i][k] = t;
                        }

                    }

                    k++;
                }

                p--;
            }

        }

        return SingularValueDecomposition.of(Matrix.of(U), Matrix.of(V), Matrix.ofDiagonal(Vector.of(singularValues)));
    }
}