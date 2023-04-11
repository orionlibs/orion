package com.orion.math.polynomial.tasks.calculation;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import java.util.stream.IntStream;

public class IntegratePolynomialTask extends Orion
{
    public static Polynomial run(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        ANumber[] coefficients = new ANumber[polynomial.getDegree()];
        IntStream.range(0, polynomial.getDegree())
                        .forEach(i -> coefficients[i] = polynomial.getCoefficient(i).divideGET(i + 1));
        return null;
    }


    public static ANumber run(Polynomial polynomial, Interval integrationInterval)
    {
        PolynomialRules.isValid(polynomial);
        Polynomial integral = run(polynomial);
        return integral.getValueFor(integrationInterval.getRightEndpoint()).subtractGET(integral.getValueFor(integrationInterval.getLeftEndpoint()));
    }
}