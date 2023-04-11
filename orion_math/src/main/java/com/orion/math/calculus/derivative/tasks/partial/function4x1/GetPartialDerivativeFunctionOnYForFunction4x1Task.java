package com.orion.math.calculus.derivative.tasks.partial.function4x1;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;

public class GetPartialDerivativeFunctionOnYForFunction4x1Task extends Orion
{
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return run(f, Precision.precision, 1);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        return run(f, precision, 1);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        FunctionRules.isValidDomainForVariable1(f.getDomain());
        FunctionRules.isValidDomainForVariable3(f.getDomain());
        FunctionRules.isValidDomainForVariable4(f.getDomain());

        if(f.getIndicesOfVariablesThatAreConstants()[1])
        {
            Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> function = (ANumber x, ANumber y, ANumber z, ANumber w) -> (ANumber.of(0));
            return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            ANumber x = f.getDomain().getIntervalOfVariable1().getMidpoint();
            ANumber z = f.getDomain().getIntervalOfVariable3().getMidpoint();
            ANumber w = f.getDomain().getIntervalOfVariable4().getMidpoint();
            return run(f, x, z, w, precision, orderOfDerivative);
        }

    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber z, ANumber w)
    {
        return run(f, x, z, w, Precision.precision);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber z, ANumber w, int precision)
    {
        return run(f, x, z, w, precision, 1);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber z, ANumber w, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(x, z, w);
        DifferentiationRules.isValid(orderOfDerivative);

        if(f.getIndicesOfVariablesThatAreConstants()[1])
        {
            Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> function = (ANumber x1, ANumber y, ANumber z1, ANumber w1) -> (ANumber.of(0));
            return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(function);
        }
        else
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> function = getFirstOrderDerivativeFunction(f.getFunctionCasted(), x, z, w, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(function, x, z, w, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(function, x, z, w, h);
                }

            }

            return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(function);
        }

    }


    private static Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> getFirstOrderDerivativeFunction(Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x, ANumber z, ANumber w, ANumber h)
    {
        return (ANumber x1, ANumber y, ANumber z1, ANumber w1) -> (f.run(x, y.addGET(h), z, w).subtractGET(f.run(x, y, z, w)).divideGET(h));
    }
}