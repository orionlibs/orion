package com.orion.math.function.tasks.onevariable.roots;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;

public class GetRootOfFunction1x1UsingNewtonRaphsonTask extends Orion
{
    public static ANumber run(Function1x1<ANumber, ANumber> f, ANumber x0, int precision)
    {
        FunctionRules.isValid(f);
        NumberRules.isNotNull(x0);
        precision = Precision.getValidPrecision(precision);
        ANumber EPS = Precision.getEPSAsNumber(precision);
        ANumber x = x0.getCopy();
        int limitOfRootApproximationIterations = 1000;

        if(f.run(x).getAbsoluteValue().isLessThanOrEqual(EPS))
        {
            return x;
        }
        else
        {
            ANumber temp = null;
            ANumber derivativeAtX = null;
            ANumber lastX = null;
            boolean rootFound = false;
            int rootApproximationIteration = 0;

            do
            {

                if(rootApproximationIteration == limitOfRootApproximationIterations)
                {
                    break;
                }

                derivativeAtX = DifferentiationService.differentiate(f, x, precision);

                if(derivativeAtX.isZero())
                {
                    break;
                }

                temp = f.run(x).divideGET(derivativeAtX);
                lastX = x.getCopy();
                x.subtract(temp);
                ++rootApproximationIteration;
                rootFound = true;
            }
            while(x.subtractGET(lastX).getAbsoluteValue().isGreaterThan(EPS));

            if(rootFound)
            {
                return x;
            }

            return x;
        }

    }


    public static ANumber run(Polynomial polynomial, ANumber x0, int precision)
    {
        PolynomialRules.isValid(polynomial);
        return run(polynomial.getAsFunction(), x0, precision);
    }
}