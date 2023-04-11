package com.orion.math.calculus.derivative.tasks.partial.functionNx1;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.math.calculus.derivative.DifferentiationRules;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.Functions;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.precision.Precision;
import java.util.List;

public class GetPartialDerivativeFunctionForFunctionNx1Task extends Orion
{
    public static FunctionNx1 run(FunctionNx1 f, ANumber[] values)
    {
        return run(f, values, Precision.precision);
    }


    public static FunctionNx1 run(FunctionNx1 f, List<ANumber> values)
    {

        if(f.getNumberOfVariables() == 1 && f.getIndicesOfVariablesThatAreConstants().length == 1)
        {
            return run(f, new ANumber[0], Precision.precision);
        }
        else
        {
            NumberRules.areNotNull(values);
            return run(f, values.toArray(new ANumber[0]), Precision.precision);
        }

    }


    public static FunctionNx1 run(FunctionNx1 f, ANumber[] values, int precision)
    {
        return run(f, values, precision, 1);
    }


    public static FunctionNx1 run(FunctionNx1 f, List<ANumber> values, int precision)
    {

        if(f.getNumberOfVariables() == 1 && f.getIndicesOfVariablesThatAreConstants().length == 1)
        {
            return run(f, new ANumber[0], Precision.precision);
        }
        else
        {
            NumberRules.areNotNull(values);
            return run(f, values.toArray(new ANumber[0]), precision, 1);
        }

    }


    public static FunctionNx1 run(FunctionNx1 f, List<ANumber> values, int precision, int orderOfDerivative)
    {

        if(f.getNumberOfVariables() == 1 && f.getIndicesOfVariablesThatAreConstants().length == 1)
        {
            return run(f, new ANumber[0], Precision.precision);
        }
        else
        {
            NumberRules.areNotNull(values);
            return run(f, values.toArray(new ANumber[0]), precision, 1);
        }

    }


    public static FunctionNx1 run(FunctionNx1 f, ANumber[] values, int precision, int orderOfDerivative)
    {
        FunctionRules.isValid(f);

        if(f.getNumberOfVariables() > 1)
        {
            NumberRules.areNotNull(values);
        }

        DifferentiationRules.isValid(orderOfDerivative);

        if(Functions.isThereOnly1Variable(f.getIndicesOfVariablesThatAreConstants()))
        {
            precision = Precision.getValidPrecision(precision);
            ANumber h = Precision.getEPSAsNumber(precision);
            FunctionNx1IF<ANumber, ANumber> function = getFirstOrderDerivativeFunction(f, f.getFunctionCasted(), values, h);

            if(orderOfDerivative == 2)
            {
                function = getFirstOrderDerivativeFunction(f, function, values, h);
            }
            else if(orderOfDerivative > 2)
            {

                for(int i = 1; i < orderOfDerivative; i++)
                {
                    function = getFirstOrderDerivativeFunction(f, function, values, h);
                }

            }

            return FunctionNx1.of(function, f.getIndicesOfVariablesThatAreConstants().length);
        }
        else
        {
            FunctionNx1IF<ANumber, ANumber> function = (ANumber[] x) -> (ANumber.of(0));
            return FunctionNx1.of(function, f.getIndicesOfVariablesThatAreConstants().length);
        }

    }


    private static FunctionNx1IF<ANumber, ANumber> getFirstOrderDerivativeFunction(FunctionNx1 originalF, FunctionNx1IF<ANumber, ANumber> f, ANumber[] values, ANumber h)
    {
        int indexOfVariable = originalF.getIndexOfFirstVariable();

        if(originalF.getNumberOfVariables() == 1 && originalF.getIndicesOfVariablesThatAreConstants().length == 1)
        {
            return (ANumber[] x) ->
            {
                ANumber[] xCopy = OrionArrayList.<ANumber>of(x).getCopy().getAsArray();
                xCopy[indexOfVariable] = x[indexOfVariable].addGET(h);
                return (f.run(xCopy).subtractGET(f.run(x)).divideGET(h));
            };
        }
        else
        {
            ANumber[] valuesCopy1 = OrionArrayList.<ANumber>of(values).getCopy().getAsArray();
            ANumber[] valuesCopy2 = OrionArrayList.<ANumber>of(values).getCopy().getAsArray();
            return (ANumber[] x) ->
            {
                valuesCopy1[indexOfVariable] = x[indexOfVariable].addGET(h);
                valuesCopy2[indexOfVariable] = x[indexOfVariable];
                return (f.run(valuesCopy1).subtractGET(f.run(valuesCopy2)).divideGET(h));
            };
        }

    }
}