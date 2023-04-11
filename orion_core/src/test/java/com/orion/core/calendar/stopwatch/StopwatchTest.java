package com.orion.core.calendar.stopwatch;

import com.orion.core.exception.InvalidArgumentException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

// @RunWith(PowerMockRunner.class)
// @RunWith(MockitoJUnitRunner.class)
// @PrepareForTest({CalendarService.class})
@TestInstance(Lifecycle.PER_CLASS)
public class StopwatchTest
{
    @BeforeAll
    public void setUp() throws Exception
    {
        //PowerMockito.mockStatic(CalendarService.class);
    }


    @Test
    public void test_stopwatch() throws InvalidArgumentException, InterruptedException
    {
        Stopwatch stopwatch = Stopwatch.of();
        stopwatch.startTimer();
        Thread.sleep(500);
        stopwatch.pauseTimer();
        System.out.println(stopwatch.getTimeLapsed());
        System.out.println(stopwatch.getTotalSecondsElapsed());
        System.out.println(stopwatch.getTotalMillisecondsElapsed());
        System.out.println(stopwatch.getNanosecondsElapsed());
        stopwatch.continueTimer();
        Thread.sleep(300);
        stopwatch.stopTimer();
        System.out.println("----------");
        System.out.println(stopwatch.getTimeLapsed());
        System.out.println(stopwatch.getTotalSecondsElapsed());
        System.out.println(stopwatch.getTotalMillisecondsElapsed());
        System.out.println(stopwatch.getNanosecondsElapsed());
    }
}