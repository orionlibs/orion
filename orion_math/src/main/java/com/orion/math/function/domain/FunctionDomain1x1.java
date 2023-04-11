package com.orion.math.function.domain;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class FunctionDomain1x1 extends FunctionDomain
{
    private Interval intervalOfVariable1;
    private OrionSet<?> allowedValuesForVariable1;


    public FunctionDomain1x1(Interval intervalOfVariable1)
    {
        IntervalRules.isValid(intervalOfVariable1);
        this.intervalOfVariable1 = intervalOfVariable1;
    }


    public FunctionDomain1x1(OrionSet<?> allowedValuesForVariable1)
    {
        Assert.notEmpty(allowedValuesForVariable1, "The allowedValuesForVariable1 input cannot be null/empty.");
        this.allowedValuesForVariable1 = allowedValuesForVariable1;
    }


    public static FunctionDomain1x1 of(Interval intervalOfVariable1)
    {
        return new FunctionDomain1x1(intervalOfVariable1);
    }


    public static FunctionDomain1x1 of(OrionSet<?> allowedValuesForVariable1)
    {
        return new FunctionDomain1x1(allowedValuesForVariable1);
    }


    public Interval getIntervalOfVariable1()
    {
        return this.intervalOfVariable1;
    }


    public OrionSet<?> getAllowedValuesForVariable1()
    {
        return this.allowedValuesForVariable1;
    }
}