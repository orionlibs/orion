package com.orion.math.function.threevariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class MultiplyFunctions3x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> function = (x, y, z) ->
        {
            ANumber value = ANumber.of(1);
            IntStream.range(0, functions.length).forEach(i -> value.multiply(functions[i].run(x, y, z)));
            return value;
        };
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(function);
    }


    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> run(Function3x1 f, Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        Function3x1<ANumber, ANumber, ANumber, ANumber>[] functionsTemp = new Function3x1[functions.length + 1];
        functionsTemp[0] = f;
        IntStream.range(1, functions.length + 1).forEach(i -> functionsTemp[i] = functions[i - 1]);
        return run(functionsTemp);
    }
}