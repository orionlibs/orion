package com.orion.core.calendar.stopwatch.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.Calendar;
import com.orion.core.calendar.stopwatch.Stopwatch;
import com.orion.core.exception.Assert;

public class GetTimeLapsedWithNanosecondsTask extends Orion
{
    public static String run(Stopwatch stopwatch, String timeElapsed)
    {
        Assert.notNull(stopwatch, "The stopwatch input cannot be null.");
        Assert.notEmpty(timeElapsed, "The timeElapsed input cannot be null/empty.");
        long totalSecondsElapsed = stopwatch.getTotalSecondsElapsed();
        long totalMinutesElapsed = stopwatch.getTotalMinutesElapsed();
        long totalHoursElapsed = stopwatch.getTotalHoursElapsed();
        long totalHoursInSeconds = totalHoursElapsed * Calendar.secondsInAMinute;
        long totalMinutesInSeconds = totalMinutesElapsed * Calendar.secondsInAMinute;
        totalSecondsElapsed += totalMinutesInSeconds + totalHoursInSeconds;
        long nanoseconds = stopwatch.getNanosecondsElapsed() - (totalSecondsElapsed * Calendar.nanosecondsInASecond);
        return timeElapsed + "." + nanoseconds;
    }
}