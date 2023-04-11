package com.orion.math.function.nvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetSumOfSquaresOfFunctionsNx1Task extends Orion
{
    public static FunctionNx1 run(int numberOfVariables, FunctionNx1... functions)
    {
        FunctionRules.doNumberOfVariablesMatch(functions);
        FunctionNx1IF<ANumber, ANumber> f = ((ANumber[] x) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].getSquare().run(x)));
            return value;
        });
        return FunctionNx1.of(f, numberOfVariables);
    }
}