package com.orion.math.polynomial.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;

public class GetValueForPolynomialTask extends Orion
{
    public static ANumber run(Polynomial polynomial, ANumber x)
    {
        PolynomialRules.isValid(polynomial);
        NumberRules.isNotNull(x);
        ANumber result = ANumber.of(0);

        for(int i = 0; i < polynomial.getDegree() + 1; i++)
        {

            if(i == 0)
            {
                result.add(polynomial.getCoefficient(i));
            }
            else if(i == 1)
            {
                result.add(polynomial.getCoefficient(i).multiplyGET(x));
            }
            else if(i == 2)
            {
                result.add(polynomial.getCoefficient(i).multiplyGET(x.squareGET()));
            }
            else
            {
                result.add(polynomial.getCoefficient(i).multiplyGET(x.exponentiateGET(i)));
            }

        }

        return result;
    }
}