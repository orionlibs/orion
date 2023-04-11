package com.orion.math.number.interval.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class IsPointInsideIntervalTask extends Orion
{
    public static boolean run(Interval interval, ANumber x)
    {
        IntervalRules.isValid(interval);

        if(Numbers.isNotNull(x))
        {

            if(interval.isClosed())
            {
                return Numbers.isBetween(x, interval.getLeftEndpoint(), interval.getRightEndpoint());
            }
            else if(interval.isOpen())
            {
                return Numbers.isBetweenExclusive(x, interval.getLeftEndpoint(), interval.getRightEndpoint());
            }
            else if(interval.isLeftClosed())
            {
                return Numbers.isBetweenRightExclusive(x, interval.getLeftEndpoint(), interval.getRightEndpoint());
            }
            else if(interval.isRightClosed())
            {
                return Numbers.isBetweenLeftExclusive(x, interval.getLeftEndpoint(), interval.getRightEndpoint());
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}