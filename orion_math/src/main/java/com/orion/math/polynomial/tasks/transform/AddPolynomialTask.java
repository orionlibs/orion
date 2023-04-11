package com.orion.math.polynomial.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class AddPolynomialTask extends Orion
{
    public static Polynomial run(Polynomial polynomial1, Polynomial polynomial2)
    {
        PolynomialRules.isValid(polynomial1);
        PolynomialRules.isValid(polynomial2);
        ANumber[] coefficients = null;

        if(polynomial1.getDegree() >= polynomial2.getDegree())
        {
            coefficients = polynomial1.getCoefficientsCopy();

            for(int i = 0; i <= polynomial2.getDegree(); i++)
            {
                coefficients[i].add(polynomial2.getCoefficient(i));
            }

        }
        else
        {
            coefficients = polynomial2.getCoefficientsCopy();

            for(int i = 0; i <= polynomial1.getDegree(); i++)
            {
                coefficients[i].add(polynomial1.getCoefficient(i));
            }

        }

        return Polynomial.of(coefficients);
    }


    public static Polynomial run(Polynomial polynomial1, Polynomial[] polynomials)
    {
        PolynomialRules.areValid(polynomials);
        return run(polynomial1, Arrays.asList(polynomials));
    }


    public static Polynomial run(Polynomial polynomial1, List<Polynomial> polynomials)
    {
        PolynomialRules.isValid(polynomial1);
        PolynomialRules.areValid(polynomials);
        PolynomialRules.doDegreesMatch(polynomial1, polynomials);
        ANumber[] coefficients = polynomial1.getCoefficientsCopy();
        IntStream.range(0, coefficients.length).forEach(i -> coefficients[i].add(polynomials.get(i).getCoefficient(i)));
        return Polynomial.of(coefficients);
    }
}