package com.orion.math.calculus.derivative.tasks.partial.function2x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetPartialDerivativeFunctionOnYForFunction2x1Task extends Orion
{
    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return run(f, Precision.precision, 1);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, int precision)
    {
        return run(f, precision, 1);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        FunctionRules.isValidDomainForVariable1(f.getDomain());

        if(f.getIndicesOfVariablesThatAreConstants()[1])
        {
            Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y) -> (ANumber.of(0));
            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            ANumber x = f.getDomain().getIntervalOfVariable1().getMidpoint();
            return run(f, x, precision, orderOfDerivative);
        }

    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        return run(f, x, Precision.precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber x, int precision)
    {
        return run(f, x, precision, 1);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber x, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        NumberRules.isNotNull(x);
        DifferentiationRules.isValid(orderOfDerivative);

        if(f.getIndicesOfVariablesThatAreConstants()[1])
        {
            Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x1, ANumber y) -> (ANumber.of(0));
            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            Function2x1IF<ANumber, ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), x, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(function, x, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(function, x, h);
                }

            }

            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }

    }


    private static Function2x1IF<ANumber, ANumber, ANumber> getFirstOrderDerivativeFunction(Function2x1IF<ANumber, ANumber, ANumber> f, ANumber x, ANumber h)
    {
        return (ANumber x1, ANumber y) -> (f.run(x, y.addGET(h)).subtractGET(f.run(x, y)).divideGET(h));
    }
}