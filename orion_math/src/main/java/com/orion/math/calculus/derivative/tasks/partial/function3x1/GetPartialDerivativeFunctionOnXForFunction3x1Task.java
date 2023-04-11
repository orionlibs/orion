package com.orion.math.calculus.derivative.tasks.partial.function3x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetPartialDerivativeFunctionOnXForFunction3x1Task extends Orion
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
        FunctionRules.isValidDomainForVariable2(f.getDomain());
        FunctionRules.isValidDomainForVariable3(f.getDomain());

        if(f.getIndicesOfVariablesThatAreConstants()[0])
        {
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (ANumber x, ANumber y, ANumber z) -> (ANumber.of(0));
            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            ANumber y = f.getDomain().getIntervalOfVariable2().getMidpoint();
            ANumber z = f.getDomain().getIntervalOfVariable3().getMidpoint();
            return run(f, y, z, precision, orderOfDerivative);
        }

    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber y, ANumber z)
    {
        return run(f, y, z, Precision.precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber y, ANumber z, int precision)
    {
        return run(f, y, z, precision, 1);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber y, ANumber z, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(y, z);
        DifferentiationRules.isValid(orderOfDerivative);

        if(f.getIndicesOfVariablesThatAreConstants()[0])
        {
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (ANumber x, ANumber y1, ANumber z1) -> (ANumber.of(0));
            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), y, z, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(function, y, z, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(function, y, z, h);
                }

            }

            return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
        }

    }


    private static Function3x1IF<ANumber, ANumber, ANumber, ANumber> getFirstOrderDerivativeFunction(Function3x1IF<ANumber, ANumber, ANumber, ANumber> f, ANumber y, ANumber z, ANumber h)
    {
        return (ANumber x, ANumber y1, ANumber z1) -> (f.run(x.addGET(h), y, z).subtractGET(f.run(x, y, z)).divideGET(h));
    }
}