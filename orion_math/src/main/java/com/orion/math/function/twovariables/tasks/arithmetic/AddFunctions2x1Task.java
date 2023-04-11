package com.orion.math.function.twovariables.tasks.arithmetic;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class AddFunctions2x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].run(x, y)));
            return value;
        };
        return Function2x1.<ANumber, ANumber, ANumber>of(function);
    }


    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Function2x1<ANumber, ANumber, ANumber> run(Function2x1 f, Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        Function2x1<ANumber, ANumber, ANumber>[] functionsTemp = new Function2x1[functions.length + 1];
        functionsTemp[0] = f;
        IntStream.range(1, functions.length + 1).forEach(i -> functionsTemp[i] = functions[i - 1]);
        return run(functionsTemp);
    }
}