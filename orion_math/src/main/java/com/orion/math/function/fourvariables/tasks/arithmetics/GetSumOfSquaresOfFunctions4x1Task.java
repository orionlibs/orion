package com.orion.math.function.fourvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetSumOfSquaresOfFunctions4x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> f = ((x, y, z, w) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].getSquare().run(x, y, z, w)));
            return value;
        });
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(f);
    }
}