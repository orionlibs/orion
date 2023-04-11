package com.orion.math.number.interval.tasks.transform;

import com.orion.core.abstraction.Orion;
import com.orion.core.tuple.Pair;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class SplitIntervalInHalfTask extends Orion
{
    public static Pair<Interval, Interval> run(Interval interval)
    {
        IntervalRules.isValid(interval);
        Interval first = Interval.of(interval.getLeftEndpointCopy(), interval.getRightEndpoint().halfGET(), interval.isLeftClosed(), true);
        Interval second = Interval.of(interval.getRightEndpointCopy().halfGET(), interval.getRightEndpointCopy(), true, interval.isRightClosed());
        return new Pair<Interval, Interval>(first, second);
    }
}