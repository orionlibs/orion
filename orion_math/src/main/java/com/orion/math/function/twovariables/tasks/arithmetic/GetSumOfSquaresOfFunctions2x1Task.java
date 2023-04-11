package com.orion.math.function.twovariables.tasks.arithmetic;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class GetSumOfSquaresOfFunctions2x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function2x1IF<ANumber, ANumber, ANumber> f = ((ANumber x, ANumber y) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].getSquare().run(x, y)));
            return value;
        });
        return Function2x1.<ANumber, ANumber, ANumber>of(f);
    }
}