package com.orion.math.function.fourvariables.tasks.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.fourvariables.Function4x1IF;
import com.orion.math.number.ANumber;
import java.util.stream.IntStream;

public class MultiplyFunctions4x1Task extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        FunctionRules.areValid(functions);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> function = (x, y, z, w) ->
        {
            ANumber value = ANumber.of(1);
            IntStream.range(0, functions.length).forEach(i -> value.multiply(functions[i].run(x, y, z, w)));
            return value;
        };
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(function);
    }


    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> run(Function4x1 f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functionsTemp = new Function4x1[functions.length + 1];
        functionsTemp[0] = f;
        IntStream.range(1, functions.length + 1).forEach(i -> functionsTemp[i] = functions[i - 1]);
        return run(functionsTemp);
    }
}