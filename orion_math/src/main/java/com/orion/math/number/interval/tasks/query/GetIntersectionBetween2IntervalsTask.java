package com.orion.math.number.interval.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.Numbers;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class GetIntersectionBetween2IntervalsTask extends Orion
{
    public static Interval run(Interval interval, Interval other)
    {
        IntervalRules.areValid(interval, other);

        if(interval.getRightEndpoint().isLessThan(other.getLeftEndpoint())
                        || other.getRightEndpoint().isLessThan(interval.getLeftEndpoint()))
        {
            return Interval.of();
        }
        else
        {

            if(Numbers.isBetween(other.getLeftEndpoint(), interval.getLeftEndpoint(), interval.getRightEndpoint())
                            && Numbers.isBetween(other.getRightEndpoint(), interval.getLeftEndpoint(), interval.getRightEndpoint()))
            {
                return Interval.of(other.getLeftEndpointCopy(), other.getRightEndpointCopy());
            }
            else if(Numbers.isBetween(other.getLeftEndpoint(), interval.getLeftEndpoint(), interval.getRightEndpoint())
                            && other.getRightEndpoint().isGreaterThanOrEqual(interval.getRightEndpoint()))
            {
                return Interval.of(other.getLeftEndpointCopy(), interval.getRightEndpointCopy());
            }
            else if(Numbers.isBetween(interval.getLeftEndpoint(), other.getLeftEndpoint(), other.getRightEndpoint())
                            && Numbers.isBetween(interval.getRightEndpoint(), other.getLeftEndpoint(), other.getRightEndpoint()))
            {
                return Interval.of(interval.getLeftEndpointCopy(), interval.getRightEndpointCopy());
            }
            else if(Numbers.isBetween(interval.getLeftEndpoint(), other.getLeftEndpoint(), other.getRightEndpoint())
                            && interval.getRightEndpoint().isGreaterThanOrEqual(other.getRightEndpoint()))
            {
                return Interval.of(interval.getLeftEndpointCopy(), other.getRightEndpointCopy());
            }

        }

        return Interval.of();
    }
}