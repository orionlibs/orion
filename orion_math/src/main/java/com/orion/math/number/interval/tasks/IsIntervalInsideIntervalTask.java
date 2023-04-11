package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IsIntervalInsideIntervalTask extends Orion
{
    public static boolean run(Interval interval, Interval other)
    {
        IntervalRules.isValid(interval);
        IntervalRules.isValid(other);

        if(interval.isClosed())
        {
            return interval.getLeftEndpoint().isLessThanOrEqual(other.getLeftEndpoint())
                            && interval.getRightEndpoint().isGreaterThanOrEqual(other.getRightEndpoint());
        }
        else if(interval.isOpen())
        {
            return interval.getLeftEndpoint().isLessThan(other.getLeftEndpoint())
                            && interval.getRightEndpoint().isGreaterThan(other.getRightEndpoint());
        }
        else if(interval.isLeftClosed())
        {
            return interval.getLeftEndpoint().isLessThanOrEqual(other.getLeftEndpoint())
                            && interval.getRightEndpoint().isGreaterThan(other.getRightEndpoint());
        }
        else if(interval.isRightClosed())
        {
            return interval.getLeftEndpoint().isLessThan(other.getLeftEndpoint())
                            && interval.getRightEndpoint().isGreaterThanOrEqual(other.getRightEndpoint());
        }
        else
        {
            return false;
        }

    }
}