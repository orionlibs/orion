package com.orion.math.number.interval;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.tasks.IntervalPrintTask;
import com.orion.math.number.interval.tasks.IsIntervalInsideIntervalTask;
import com.orion.math.number.interval.tasks.IsPointInsideIntervalTask;
import com.orion.math.number.interval.tasks.query.GetIntersectionBetween2IntervalsTask;
import com.orion.math.number.interval.tasks.query.GetIntersectionBetweenIntervalsTask;
import com.orion.math.number.interval.tasks.query.GetIntervalAsArrayTask;
import com.orion.math.number.interval.tasks.transform.DivideIntervalsTask;
import com.orion.math.number.interval.tasks.transform.MultiplyIntervalsTask;
import com.orion.math.number.interval.tasks.transform.SplitIntervalInHalfTask;
import com.orion.math.number.interval.tasks.transform.SplitIntervalInNTask;

public class IntervalService extends OrionService
{
    public static ANumber getMidpoint(Interval x)
    {
        IntervalRules.isValid(x);
        return x.getRightEndpoint().subtractGET(x.getLeftEndpoint()).halfGET();
    }


    public static Pair<Interval, Interval> splitInHalf(Interval x)
    {
        return SplitIntervalInHalfTask.run(x);
    }


    public static Interval[] splitInN(Interval x, int n)
    {
        return SplitIntervalInNTask.run(x, n);
    }


    public static String print(Interval interval)
    {
        return IntervalPrintTask.run(interval);
    }


    public static boolean isPointInsideInterval(Interval interval, ANumber x)
    {
        return IsPointInsideIntervalTask.run(interval, x);
    }


    public static boolean isPointOutsideInterval(Interval x, ANumber other)
    {
        return !isPointInsideInterval(x, other);
    }


    public static boolean isIntervalInside(Interval x, Interval other)
    {
        return IsIntervalInsideIntervalTask.run(x, other);
    }


    public static boolean isIntervalOutside(Interval x, Interval other)
    {
        return !isIntervalInside(x, other);
    }


    public static Interval getIntersection(Interval x, Interval other)
    {
        return GetIntersectionBetween2IntervalsTask.run(x, other);
    }


    public static Interval getIntersection(Interval... intervals)
    {
        return GetIntersectionBetweenIntervalsTask.run(intervals);
    }


    public static Interval reciprocate(Interval x)
    {
        IntervalRules.isValidForReciprocation(x);
        return Interval.of(x.getLeftEndpoint().reciprocateGET(), x.getRightEndpoint().reciprocateGET());
    }


    public static Interval add(Interval x, Interval other)
    {
        IntervalRules.areValid(x, other);
        return Interval.of(x.getLeftEndpoint().addGET(other.getLeftEndpoint()), x.getRightEndpoint().addGET(other.getRightEndpoint()));
    }


    public static Interval subtract(Interval x, Interval other)
    {
        IntervalRules.areValid(x, other);
        return Interval.of(x.getLeftEndpoint().addGET(other.getRightEndpoint()), x.getRightEndpoint().addGET(other.getLeftEndpoint()));
    }


    public static Interval multiply(Interval x, Interval other)
    {
        return MultiplyIntervalsTask.run(x, other);
    }


    public static Interval divide(Interval x, Interval other)
    {
        return DivideIntervalsTask.run(x, other);
    }


    public static ANumber[] getAsArray(Interval x)
    {
        return getAsArray(x, 100);
    }


    public static ANumber[] getAsArray(Interval x, int numberOfValuesToUse)
    {
        return GetIntervalAsArrayTask.run(x, numberOfValuesToUse);
    }
}