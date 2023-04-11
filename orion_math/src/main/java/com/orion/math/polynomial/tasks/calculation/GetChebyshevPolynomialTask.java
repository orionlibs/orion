package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import java.util.ArrayList;
import java.util.List;

public class GetChebyshevPolynomialTask extends Orion
{
    public static Polynomial run(int degree)
    {
        List<ANumber> chebyshevCoefficients = new ArrayList<ANumber>();
        chebyshevCoefficients.add(ANumber.of(1));
        chebyshevCoefficients.add(ANumber.of(0));
        chebyshevCoefficients.add(ANumber.of(1));
        ANumber[] coefficients = new ANumber[3];
        coefficients[0] = ANumber.of(0);
        coefficients[1] = ANumber.of(2);
        coefficients[2] = ANumber.of(1);
        int maxDegree = (int)Math.floor(Math.sqrt(2.0 * chebyshevCoefficients.size())) - 1;

        if(degree > maxDegree)
        {
            chebyshevCoefficients = computeUpToDegree(degree, maxDegree, chebyshevCoefficients, coefficients);
        }

        int start = degree * (degree + 1) / 2;
        ANumber[] a = new ANumber[degree + 1];

        for(int i = 0; i <= degree; i++)
        {
            a[i] = chebyshevCoefficients.get(start + i);
        }

        return Polynomial.of(a);
    }


    private static List<ANumber> computeUpToDegree(int degree, int maxDegree, List<ANumber> chebyshevCoefficients, ANumber[] coefficients)
    {
        int startK = (maxDegree - 1) * maxDegree / 2;

        for(int k = maxDegree; k < degree; k++)
        {
            int startKm1 = startK;
            startK += k;
            ANumber ck = chebyshevCoefficients.get(startK);
            ANumber ckm1 = chebyshevCoefficients.get(startKm1);
            chebyshevCoefficients.add(ck.multiplyGET(coefficients[0]).subtractGET(ckm1.multiplyGET(coefficients[2])));

            for(int i = 1; i < k; ++i)
            {
                ANumber ckPrev = ck.getCopy();
                ck = chebyshevCoefficients.get(startK + i).getCopy();
                ckm1 = chebyshevCoefficients.get(startKm1 + i).getCopy();
                chebyshevCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])).subtractGET(ckm1.multiplyGET(coefficients[2])));
            }

            ANumber ckPrev = ck.getCopy();
            ck = chebyshevCoefficients.get(startK + k).getCopy();
            chebyshevCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])));
            chebyshevCoefficients.add(ck.multiplyGET(coefficients[1]));
        }

        return chebyshevCoefficients;
    }
}