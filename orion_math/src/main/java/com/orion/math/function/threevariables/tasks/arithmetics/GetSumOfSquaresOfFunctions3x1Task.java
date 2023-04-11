package com.orion.math.function.threevariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetSumOfSquaresOfFunctions3x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> f = ((x, y, z) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].getSquare().run(x, y, z)));
            return value;
        });
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(f);
    }
}