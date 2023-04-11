package com.orion.math.number.interval;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;
import java.util.Arrays;

public class IntervalRules extends MathRule
{
    public static void isLessThan(ANumber x, ANumber y)
    {
        Assert.isFalse(!Numbers.areNotNull(x, y), "Cannot compare null numbers.");
        Assert.isFalse(!Numbers.isLessThan(x, y), "Left endpoint of interval has to be less than the right endpoint.");
    }


    public static void isLessThan(Number x, Number y)
    {
        Assert.isFalse(!Numbers.areNotNull(x, y), "Cannot compare null numbers.");
        Assert.isFalse(!Numbers.isLessThan(x, y), "Left endpoint of interval has to be less than the right endpoint.");
    }


    public static void isValid(ANumber x, ANumber y)
    {
        isLessThan(x, y);
    }


    public static void isValid(Number x, Number y)
    {
        isLessThan(x, y);
    }


    public static void isValid(Interval interval)
    {
        Assert.notNull(interval, "The interval input cannot be null.");
        isValid(interval.getLeftEndpoint(), interval.getRightEndpoint());
    }


    public static void areValid(Interval... intervals)
    {
        Assert.notEmpty(intervals, "The interval input cannot be null/empty.");
        Arrays.stream(intervals).forEach(interval -> isValid(interval));
    }


    public static void isValidForReciprocation(Interval interval)
    {
        isValid(interval);
        Assert.isFalse(interval.getLeftEndpoint().isZero(), "Cannot reciprocate interval, because the left endpoint is zero.");
        Assert.isFalse(interval.getRightEndpoint().isZero(), "Cannot reciprocate interval, because the right endpoint is zero.");
    }
}