package com.orion.math.number.services.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.services.NumberService;
import java.util.List;

public class IsUglyNumberTask extends Orion
{
    public static boolean run(ANumber x)
    {
        NumberRules.hasNaturalNumberValue(x);
        List<ANumber> factors = NumberService.getPrimeDivisors(x);
        return factors.size() == 3 && factors.contains(ANumber.of(2))
                        && factors.contains(ANumber.of(3))
                        && factors.contains(ANumber.of(5));
    }
}