package com.orion.math.calculus.derivative.tasks.partial.function3x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetPartialDerivativeFunctionOnZForFunction3x1Task extends Orion
{
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return run(f, Precision.precision, 1);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        return run(f, precision, 1);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        FunctionRules.isValidDomainForVariable1(f.getDomain());
        FunctionRules.isValidDomainForVariable2(f.getDomain());

        if(f.getIndicesOfVariablesThatAreConstants()[2])
        {
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (ANumber x, ANumber y, ANumber z) -> (ANumber.of(0));
            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            ANumber x = f.getDomain().getIntervalOfVariable1().getMidpoint();
            ANumber y = f.getDomain().getIntervalOfVariable2().getMidpoint();
            return run(f, x, y, precision, orderOfDerivative);
        }

    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber y)
    {
        return run(f, x, y, Precision.precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber y, int precision)
    {
        return run(f, x, y, precision, 1);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber y, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(x, y);
        DifferentiationRules.isValid(orderOfDerivative);

        if(f.getIndicesOfVariablesThatAreConstants()[2])
        {
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (ANumber x1, ANumber y1, ANumber z) -> (ANumber.of(0));
            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), x, y, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(function, x, y, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(function, x, y, h);
                }

            }

            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }

    }


    private static Function3x1IF<ANumber, ANumber, ANumber, ANumber> getFirstOrderDerivativeFunction(Function3x1IF<ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber y, ANumber h)
    {
        return (ANumber x1, ANumber y1, ANumber z) -> (f.run(x, y, z.addGET(h)).subtractGET(f.run(x, y, z)).divideGET(h));
    }
}