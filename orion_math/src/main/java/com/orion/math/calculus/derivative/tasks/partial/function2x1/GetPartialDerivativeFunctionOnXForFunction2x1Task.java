package com.orion.math.calculus.derivative.tasks.partial.function2x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetPartialDerivativeFunctionOnXForFunction2x1Task extends Orion
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
        FunctionRules.isValidDomainForVariable2(f.getDomain());

        if(f.getIndicesOfVariablesThatAreConstants()[0])
        {
            Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y) -> (ANumber.of(0));
            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            ANumber y = f.getDomain().getIntervalOfVariable2().getMidpoint();
            return run(f, y, precision, orderOfDerivative);
        }

    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber y)
    {
        return run(f, y, Precision.precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber y, int precision)
    {
        return run(f, y, precision, 1);
    }


    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber> f, ANumber y, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        NumberRules.isNotNull(y);
        DifferentiationRules.isValid(orderOfDerivative);

        if(f.getIndicesOfVariablesThatAreConstants()[0])
        {
            Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y1) -> (ANumber.of(0));
            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            Function2x1IF<ANumber, ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), y, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(function, y, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(function, y, h);
                }

            }

            return Function2x1.<ANumber, ANumber, ANumber>of(function);
        }

    }


    private static Function2x1IF<ANumber, ANumber, ANumber> getFirstOrderDerivativeFunction(Function2x1IF<ANumber, ANumber, ANumber> f, ANumber y, ANumber h)
    {
        return (ANumber x, ANumber y1) -> (f.run(x.addGET(h), y).subtractGET(f.run(x, y)).divideGET(h));
    }
}