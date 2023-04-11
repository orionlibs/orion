package com.orion.math.polynomial.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.streams.NumberArrayStream;
import java.util.stream.IntStream;

public class DividePolynomialTask extends Orion
{
    public static Polynomial run(Polynomial polynomial, ANumber x)
    {
        PolynomialRules.isValid(polynomial);
        NumberRules.isNotNull(x);
        NumberRules.isNonZero(x);
        ANumber[] coefficients = new ANumber[polynomial.getDegree() + 1];
        IntStream.range(0, polynomial.getDegree() + 1).forEach(i -> coefficients[i] = polynomial.getCoefficient(i).divideGET(x));
        return Polynomial.of(coefficients);
    }


    public static Pair<Polynomial, Polynomial> run(Polynomial x, Polynomial y)
    {
        PolynomialRules.isValid(x);
        PolynomialRules.isNotZero(y);

        if(y.getDegree() > x.getDegree())
        {
            return Pair.of(Polynomial.of(new ANumber[]
            {ANumber.of(0)}), y.getCopy());
        }
        else
        {
            Polynomial remainder = x.getCopy();
            int degreeOfQuotient = remainder.getDegree() - y.getDegree();
            ANumber[] quotientelements = new ANumber[degreeOfQuotient + 1];
            NumberArrayStream.setZeroValue(quotientelements);
            Polynomial quotient = Polynomial.of(quotientelements);

            while(remainder.isNotZero() && remainder.getDegree() >= y.getDegree())
            {
                ANumber[] temp = new ANumber[remainder.getDegree() - y.getDegree() + 1];
                NumberArrayStream.setZeroValue(temp);
                temp[temp.length - 1] = remainder.getNDegreeCoefficient().divideGET(y.getNDegreeCoefficient());
                Polynomial temp1 = Polynomial.of(temp);
                quotient = quotient.add(temp1);
                Polynomial temp2 = y.multiply(temp1);
                remainder = remainder.subtract(temp2);
            }

            return Pair.of(quotient, remainder);
        }

    }
}