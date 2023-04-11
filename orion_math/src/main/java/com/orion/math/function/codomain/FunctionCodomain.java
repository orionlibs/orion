package com.orion.math.function.codomain;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.MathObject;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class FunctionCodomain implements MathObject
{
    private Interval interval;
    private OrionSet<?> allowedYValues;


    public FunctionCodomain(Interval interval)
    {
        IntervalRules.isValid(interval);
        this.interval = interval;
    }


    public FunctionCodomain(OrionSet<?> allowedYValues)
    {
        Assert.notEmpty(allowedYValues, "The allowedYValues input cannot be null/empty.");
        this.allowedYValues = allowedYValues;
    }


    public static FunctionCodomain of(Interval interval)
    {
        return new FunctionCodomain(interval);
    }


    public static FunctionCodomain of(OrionSet<?> allowedYValues)
    {
        return new FunctionCodomain(allowedYValues);
    }


    public Interval getInterval()
    {
        return this.interval;
    }


    public OrionSet<?> getAllowedYValues()
    {
        return this.allowedYValues;
    }
}