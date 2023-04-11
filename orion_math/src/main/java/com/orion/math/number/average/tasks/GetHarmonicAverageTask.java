package com.orion.math.number.average.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.util.List;

public class GetHarmonicAverageTask extends Orion
{
    public static ANumber run(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        ANumber sum = ANumber.of(0);
        numbers.forEach(x -> sum.add(x.reciprocateGET()));
        return ANumber.of(numbers.size()).divideGET(sum);
    }
}