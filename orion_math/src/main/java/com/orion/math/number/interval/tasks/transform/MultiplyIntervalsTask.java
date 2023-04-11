package com.orion.math.number.interval.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;
import java.util.Arrays;

public class MultiplyIntervalsTask extends Orion
{
    public static Interval run(Interval x, Interval other)
    {
        IntervalRules.areValid(x, other);
        ANumber a1a2 = x.getLeftEndpoint().multiplyGET(other.getLeftEndpoint());
        ANumber a1b2 = x.getLeftEndpoint().multiplyGET(other.getRightEndpoint());
        ANumber a2b1 = x.getRightEndpoint().multiplyGET(other.getLeftEndpoint());
        ANumber a2b2 = x.getRightEndpoint().multiplyGET(other.getRightEndpoint());
        ANumber newLeftEndpoint = ArithmeticService.getMinimum(Arrays.asList(a1a2, a1b2, a2b1, a2b2));
        ANumber newRightEndpoint = ArithmeticService.getMaximum(Arrays.asList(a1a2, a1b2, a2b1, a2b2));
        return Interval.of(newLeftEndpoint, newRightEndpoint);
    }
}