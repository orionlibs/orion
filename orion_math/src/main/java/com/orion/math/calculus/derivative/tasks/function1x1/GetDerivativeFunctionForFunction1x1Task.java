package com.orion.math.calculus.derivative.tasks.function1x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class GetDerivativeFunctionForFunction1x1Task extends Orion
{
    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f)
    {
        return run(f, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f, int precision)
    {
        return run(f, precision, 1);
    }


    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        DifferentiationRules.isValid(orderOfDerivative);
        precision = Precision.getValidPrecision(precision);
        ANumber h = Precision.getEPSAsNumber(precision);
        Function1x1IF<ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), h);

        if(orderOfDerivative == 2)
        {
            function = getFirstOrderDerivativeFunction(function, h);
        }
        else
        {

            for(int i = 1; i < orderOfDerivative; i++)
            {
                function = getFirstOrderDerivativeFunction(function, h);
            }

        }

        return Function1x1.<ANumber, ANumber>of(function);
    }


    private static Function1x1IF<ANumber, ANumber> getFirstOrderDerivativeFunction(Function1x1IF<ANumber, ANumber> f, ANumber h)
    {
        return (ANumber x) -> (f.run(x.addGET(h)).subtractGET(f.run(x)).divideGET(h));
    }
}