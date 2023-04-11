package com.orion.math.function.tasks.onevariable;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;

public class ComposeFunctions1x1Task extends Orion
{
    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> other)
    {
        FunctionRules.areValid(f, other);
        Function1x1IF<ANumber, ANumber> function = (ANumber x) -> (f.run(other.run(x)));
        return Function1x1.<ANumber, ANumber>of(function);
    }


    public static Function1x1<ANumber, ANumber> run(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>[] functions)
    {
        FunctionRules.isValid(f);
        FunctionRules.areValid(functions);

        if(functions.length == 1)
        {
            return run(f, functions[0]);
        }
        else
        {
            Function1x1<ANumber, ANumber> composition = functions[functions.length - 1];

            for(int i = functions.length - 2; i >= 0; i--)
            {
                composition = run(functions[i], composition);
            }

            return run(f, composition);
        }

    }
}