package com.orion.math.function.nvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class AddFunctionsNx1Task extends Orion
{
    public static FunctionNx1 run(int numberOfVariables, FunctionNx1... functions)
    {
        FunctionRules.doNumberOfVariablesMatch(functions);
        FunctionNx1IF<ANumber, ANumber> function = (ANumber[] x) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].run(x)));
            return value;
        };
        return FunctionNx1.of(function, numberOfVariables);
    }


    public static FunctionNx1 run(int numberOfVariables, FunctionNx1 f, FunctionNx1... functions)
    {
        FunctionNx1[] functionsTemp = new FunctionNx1[functions.length + 1];
        functionsTemp[0] = f;
        IntStream.range(1, functions.length + 1).forEach(i -> functionsTemp[i] = functions[i - 1]);
        return run(numberOfVariables, functionsTemp);
    }


    public static FunctionNx1 run(int numberOfVariables, FunctionNx1 f, FunctionNx1 g)
    {
        FunctionNx1[] functionsTemp = new FunctionNx1[2];
        functionsTemp[0] = f;
        functionsTemp[1] = g;
        return run(numberOfVariables, functionsTemp);
    }
}