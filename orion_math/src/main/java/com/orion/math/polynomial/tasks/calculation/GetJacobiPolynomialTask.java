package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetJacobiPolynomialTask extends Orion
{
    public static Polynomial run(int degree, int firstExponent, int secondExponent)
    {
        JacobiKey key = new JacobiKey(firstExponent, secondExponent);
        Map<JacobiKey, List<ANumber>> jacobiCoefficientsMap = new HashMap<JacobiKey, List<ANumber>>();

        if(!jacobiCoefficientsMap.containsKey(key))
        {
            List<ANumber> list = new ArrayList<ANumber>();
            jacobiCoefficientsMap.put(key, list);
            list.add(ANumber.of(1));
            list.add(ANumber.of(firstExponent - secondExponent).halfGET());
            list.add(ANumber.of(2 + firstExponent + secondExponent).halfGET());
        }

        List<ANumber> jacobiCoefficients = jacobiCoefficientsMap.get(key);
        int maxDegree = (int)Math.floor(Math.sqrt(2.0 * jacobiCoefficients.size())) - 1;

        if(degree > maxDegree)
        {
            jacobiCoefficients = computeUpToDegree(degree, maxDegree, jacobiCoefficients, firstExponent, secondExponent);
        }

        int start = degree * (degree + 1) / 2;
        ANumber[] a = new ANumber[degree + 1];

        for(int i = 0; i <= degree; i++)
        {
            a[i] = jacobiCoefficients.get(start + i);
        }

        return Polynomial.of(a);
    }


    private static List<ANumber> computeUpToDegree(int degree, int maxDegree, List<ANumber> jacobiCoefficients, int firstExponent, int secondExponent)
    {
        int startK = (maxDegree - 1) * maxDegree / 2;

        for(int k = maxDegree; k < degree; k++)
        {
            int startKm1 = startK;
            startK += k;
            int k1 = k++;
            int kvw = k1 + firstExponent + secondExponent;
            int twoKvw = kvw + k1;
            int twoKvwM1 = twoKvw - 1;
            int twoKvwM2 = twoKvw - 2;
            int den = 2 * k1 * kvw * twoKvwM2;
            ANumber[] coefficients = new ANumber[3];
            coefficients[0] = ANumber.of(twoKvwM1 * (firstExponent * firstExponent - secondExponent * secondExponent)).divideGET(den);
            coefficients[1] = ANumber.of(twoKvwM1 * twoKvw * twoKvwM2).divideGET(den);
            coefficients[2] = ANumber.of(2 * (k + firstExponent - 1) * (k + secondExponent - 1) * twoKvw).divideGET(den);
            ANumber ck = jacobiCoefficients.get(startK);
            ANumber ckm1 = jacobiCoefficients.get(startKm1);
            jacobiCoefficients.add(ck.multiplyGET(coefficients[0]).subtractGET(ckm1.multiplyGET(coefficients[2])));

            for(int i = 1; i < k; ++i)
            {
                ANumber ckPrev = ck.getCopy();
                ck = jacobiCoefficients.get(startK + i).getCopy();
                ckm1 = jacobiCoefficients.get(startKm1 + i).getCopy();
                jacobiCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])).subtractGET(ckm1.multiplyGET(coefficients[2])));
            }

            ANumber ckPrev = ck.getCopy();
            ck = jacobiCoefficients.get(startK + k).getCopy();
            jacobiCoefficients.add(ck.multiplyGET(coefficients[0]).addGET(ckPrev.multiplyGET(coefficients[1])));
            jacobiCoefficients.add(ck.multiplyGET(coefficients[1]));
        }

        return jacobiCoefficients;
    }


    private static class JacobiKey
    {
        /** First exponent. */
        private final int v;
        /** Second exponent. */
        private final int w;


        /**
         * Simple constructor.
         * @param v first exponent
         * @param w second exponent
         */
        JacobiKey(final int v, final int w)
        {
            this.v = v;
            this.w = w;
        }


        /**
         * Get hash code.
         * @return hash code
         */
        @Override
        public int hashCode()
        {
            return (v << 16) ^ w;
        }


        /**
         * Check if the instance represent the same key as another instance.
         * @param key other key
         * @return true if the instance and the other key refer to the same polynomial
         */
        @Override
        public boolean equals(final Object key)
        {

            if((key == null) || !(key instanceof JacobiKey))
            {
                return false;
            }

            final JacobiKey otherK = (JacobiKey)key;
            return (v == otherK.v) && (w == otherK.w);
        }
    }
}