package com.orion.math.function.tasks.onevariable.arithmetics;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;
import java.util.stream.IntStream;

public class AddFunctionsWithWeightsTask extends Orion
{
    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> run(List<Function1x1<ANumber, ANumber>> functions, List<?> weights)
    {
        FunctionRules.areValidFunctions1x1(functions);
        NumberRules.doSizesMatch(functions, weights);
        Function1x1<ANumber, ANumber>[] sum = new Function1x1[1];
        sum[0] = Function1x1.of(x -> ANumber.of(0, 0));
        List<ANumber> weightsTemp = NumberService.getAsNumberList(weights);
        IntStream.range(0, functions.size()).forEach(i -> sum[0] = sum[0].add((functions.get(i)).multiply(weightsTemp.get(i))));
        return Function1x1.<ANumber, ANumber>of(sum[0].getFunctionCasted());
    }
}