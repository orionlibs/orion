package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import java.util.List;
import java.util.stream.IntStream;

public class AddFunctions1x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function1x1IF<ANumber, ANumber> function = (ANumber x) ->
        {
            ANumber value = ANumber.of(0);
            IntStream.range(0, functions.length).forEach(i -> value.add(functions[i].run(x)));
            return value;
        };
        return Function1x1.<ANumber, ANumber>of(function);
    }


    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Function1x1<ANumber, ANumber> run(Function1x1 f, Function1x1<ANumber, ANumber>... functions)
    {
        Function1x1<ANumber, ANumber>[] functionsTemp = new Function1x1[functions.length + 1];
        functionsTemp[0] = f;
        IntStream.range(1, functions.length + 1).forEach(i -> functionsTemp[i] = functions[i - 1]);
        return run(functionsTemp);
    }


    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        return run(functions.toArray(new Function1x1[0]));
    }
}