package com.orion.math.number.interval;

public class EmptyInterval extends Interval
{
    public EmptyInterval()
    {
        super();
    }


    public static EmptyInterval of()
    {
        return new EmptyInterval();
    }
}