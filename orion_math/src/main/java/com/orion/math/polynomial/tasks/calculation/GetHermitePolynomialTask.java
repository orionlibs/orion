package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import java.util.ArrayList;
import java.util.List;

public class GetHermitePolynomialTask extends Orion
{
    public static Polynomial run(int degree)
    {
        List<ANumber> hermiteCoefficients = new ArrayList<ANumber>();
        hermiteCoefficients.add(ANumber.of(1));
        hermiteCoefficients.add(ANumber.of(0));
        hermiteCoefficients.add(ANumber.of(2));
        ANumber[] coefficients = new ANumber[3];
        coefficients[0] = ANumber.of(0);
        coefficients[1] = ANumber.of(2);
        coefficients[2] = ANumber.of(0);
        int maxDegree = (int)Math.floor(Math.sqrt(2.0 * hermiteCoefficients.size())) - 1;

        if(degree > maxDegree)
        {
            hermiteCoefficients = computeUpToDegree(degree, maxDegree, hermiteCoefficients, coefficients);
        }

        int start = degree * (degree + 1) / 2;
        ANumber[] a = new ANumber[degree + 1];

        for(int i = 0; i <= degree; i++)
        {
            a[i] = hermiteCoefficients.get(start + i);
        }

        return Polynomial.of(a);
    }


    private static List<ANumber> computeUpToDegree(int degree, int maxDegree, List<ANumber> hermiteCoefficients, ANumber[] coefficients)
    {
        int startK = (maxDegree - 1) * maxDegree / 2;

        for(int k = maxDegree; k < degree; k++)
        {
            int startKm1 = startK;
            startK += k;
            ANumber[] coefficients1 = coefficients;
            coefficients1[2] = ANumber.of(2 * k);
            ANumber ck = hermiteCoefficients.get(startK);
            ANumber ckm1 = hermiteCoefficients.get(startKm1);
            hermiteCoefficients.add(ck.multiplyGET(coefficients1[0]).subtractGET(ckm1.multiplyGET(coefficients1[2])));

            for(int i = 1; i < k; ++i)
            {
                ANumber ckPrev = ck.getCopy();
                ck = hermiteCoefficients.get(startK + i).getCopy();
                ckm1 = hermiteCoefficients.get(startKm1 + i).getCopy();
                hermiteCoefficients.add(ck.multiplyGET(coefficients1[0]).addGET(ckPrev.multiplyGET(coefficients1[1])).subtractGET(ckm1.multiplyGET(coefficients1[2])));
            }

            ANumber ckPrev = ck.getCopy();
            ck = hermiteCoefficients.get(startK + k).getCopy();
            hermiteCoefficients.add(ck.multiplyGET(coefficients1[0]).addGET(ckPrev.multiplyGET(coefficients1[1])));
            hermiteCoefficients.add(ck.multiplyGET(coefficients1[1]));
        }

        return hermiteCoefficients;
    }
}