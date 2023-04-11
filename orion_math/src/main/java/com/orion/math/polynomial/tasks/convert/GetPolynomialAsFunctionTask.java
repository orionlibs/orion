package com.orion.math.polynomial.tasks.convert;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;

public class GetPolynomialAsFunctionTask extends Orion
{
    public static Function1x1<ANumber, ANumber> run(Polynomial polynomial)
    {
        Function1x1IF<ANumber, ANumber> function = (ANumber x) ->
        {
            ANumber value = ANumber.of(0);

            for(int i = 0; i < polynomial.getCoefficients().length; i++)
            {
                ANumber coefficient = polynomial.getCoefficients()[i];
                ANumber iTemp = ANumber.of(i);
                Function1x1IF<ANumber, ANumber> monomialFunction = (ANumber x1) -> coefficient.multiplyGET(x1.exponentiateGET(iTemp));
                Function1x1<ANumber, ANumber> monomial = Function1x1.<ANumber, ANumber>of(monomialFunction);
                value.add(monomial.run(x));
            }

            return value;
        };
        return Function1x1.<ANumber, ANumber>of(function);
    }
}