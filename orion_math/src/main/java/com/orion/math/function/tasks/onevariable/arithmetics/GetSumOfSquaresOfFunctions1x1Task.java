package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.stream.IntStream;

public class GetSumOfSquaresOfFunctions1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function1x1IF<ANumber, ANumber> f = (x ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].getSquare().run(x)));
            return value;
        });
        return Function1x1.<ANumber, ANumber>of(f);
    }


    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        return run(functions.toArray(new Function1x1[0]));
    }
}