package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;
import java.util.stream.IntStream;

public class DifferentiatePolynomialTask extends Orion
{
    public static Polynomial run(Polynomial polynomial)
    {
        DifferentiationRules.isValid(polynomial, 1);
        ANumber[] coefficients = new ANumber[polynomial.getDegree()];
        IntStream.range(0, polynomial.getDegree())
                        .forEach(i -> coefficients[i] = polynomial.getCoefficient(i + 1).multiplyGET(i + 1));
        return Polynomial.of(coefficients);
    }


    public static Polynomial run(Polynomial polynomial, int orderOfDerivative)
    {
        DifferentiationRules.isValid(polynomial, orderOfDerivative);
        Polynomial temp = polynomial.getCopy();

        for(int i = 1; i <= orderOfDerivative; i++)
        {
            temp = run(temp);
        }

        return temp;
    }
}