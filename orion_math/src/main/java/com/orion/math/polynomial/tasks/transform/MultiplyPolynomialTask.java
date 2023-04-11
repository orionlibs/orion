package com.orion.math.polynomial.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.streams.NumberArrayStream;
import java.util.stream.IntStream;

public class MultiplyPolynomialTask extends Orion
{
    public static Polynomial run(Polynomial polynomial, ANumber x)
    {
        PolynomialRules.isValid(polynomial);
        NumberRules.isNotNull(x);
        ANumber[] coefficients = polynomial.getCoefficientsCopy();
        IntStream.range(0, polynomial.getDegree() + 1)
                        .forEach(i -> coefficients[i] = polynomial.getCoefficient(i).multiplyGET(x));
        return Polynomial.of(coefficients);
    }


    public static Polynomial run(Polynomial polynomial1, Polynomial polynomial2)
    {
        PolynomialRules.isValid(polynomial1);
        PolynomialRules.isValid(polynomial2);
        int newDegree = polynomial1.getDegree() + polynomial2.getDegree();
        ANumber[] coefficients = new ANumber[newDegree + 1];
        NumberArrayStream.setZeroValue(coefficients);

        for(int i = 0; i < coefficients.length; i++)
        {

            for(int j = 0; j <= polynomial1.getDegree(); j++)
            {

                for(int k = 0; k <= polynomial2.getDegree(); k++)
                {

                    if(j + k == i)
                    {
                        coefficients[i].add(polynomial1.getCoefficient(j).multiplyGET(polynomial2.getCoefficient(k)));
                    }

                }

            }

        }

        return Polynomial.of(coefficients);
    }
}