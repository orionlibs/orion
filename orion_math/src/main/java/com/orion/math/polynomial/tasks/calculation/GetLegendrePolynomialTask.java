package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import java.util.ArrayList;
import java.util.List;

public class GetLegendrePolynomialTask extends Orion
{
    public static Polynomial run(int degree)
    {
        List<ANumber> legendreCoefficients = new ArrayList<ANumber>();
        legendreCoefficients.add(ANumber.of(1));
        legendreCoefficients.add(ANumber.of(0));
        legendreCoefficients.add(ANumber.of(1));
        int maxDegree = (int)Math.floor(Math.sqrt(2.0 * legendreCoefficients.size())) - 1;

        if(degree > maxDegree)
        {
            legendreCoefficients = computeUpToDegree(degree, maxDegree, legendreCoefficients);
        }

        int start = degree * (degree + 1) / 2;
        ANumber[] a = new ANumber[degree + 1];

        for(int i = 0; i <= degree; i++)
        {
            a[i] = legendreCoefficients.get(start + i);
        }

        return Polynomial.of(a);
    }


    private static List<ANumber> computeUpToDegree(int degree, int maxDegree, List<ANumber> legendreCoefficients)
    {
        int startK = (maxDegree - 1) * maxDegree / 2;

        for(int k = maxDegree; k < degree; k++)
        {
            int startKm1 = startK;
            startK += k;
            ANumber[] coefficients = new ANumber[3];
            coefficients[0] = ANumber.of(0);
            coefficients[1] = ANumber.of(2 * k + 1).divideGET(k + 1);
            coefficients[2] = ANumber.of(k).divideGET(k + 1);
            ANumber ck = legendreCoefficients.get(startK);
            ANumber ckm1 = legendreCoefficients.get(startKm1);
            legendreCoefficients.add(ck.multiplyGET(coefficients[0]).subtractGET(ckm1.multiplyGET(coefficients[2])));

            for(int i = 1; i < k; ++i)
            {
                ANumber ckPrev = ck.getCopy();
                ck = legendreCoefficients.get(startK + i).getCopy();
                ckm1 = legendreCoefficients.get(startKm1 + i).getCopy();
                legendreCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])).subtractGET(ckm1.multiplyGET(coefficients[2])));
            }

            ANumber ckPrev = ck.getCopy();
            ck = legendreCoefficients.get(startK + k).getCopy();
            legendreCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])));
            legendreCoefficients.add(ck.multiplyGET(coefficients[1]));
        }

        return legendreCoefficients;
    }
}