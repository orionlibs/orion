package com.orion.core.calendar.stopwatch.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.Calendar;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.stopwatch.Stopwatch;
import com.orion.core.exception.Assert;

public class GetTimeLapsedTask extends Orion
{
    public String run(Stopwatch stopwatch)
    {
        Assert.notNull(stopwatch, "The stopwatch input cannot be null.");
        long totalMillisecondsElapsed = stopwatch.getNanosecondsElapsed() / Calendar.nanosecondsInAMillisecond;
        long totalSecondsElapsed = stopwatch.getNanosecondsElapsed() / Calendar.nanosecondsInASecond;
        long totalMinutesElapsed = totalSecondsElapsed / Calendar.secondsInAMinute;
        long totalHoursElapsed = totalMinutesElapsed / Calendar.secondsInAMinute;
        totalSecondsElapsed = totalSecondsElapsed - (totalMinutesElapsed * Calendar.secondsInAMinute);
        stopwatch.setTotalMillisecondsElapsed(totalMillisecondsElapsed);
        stopwatch.setTotalSecondsElapsed(totalSecondsElapsed);
        stopwatch.setTotalMinutesElapsed(totalMinutesElapsed);
        stopwatch.setTotalHoursElapsed(totalHoursElapsed);
        String secondsElapsed = CalendarService.formatDateTimeUnitWith2Characters(totalSecondsElapsed);
        String minutesElapsed = CalendarService.formatDateTimeUnitWith2Characters(totalMinutesElapsed);
        String hoursElapsed = CalendarService.formatDateTimeUnitWith2Characters(totalHoursElapsed);
        return hoursElapsed + ":" + minutesElapsed + ":" + secondsElapsed;
    }
}