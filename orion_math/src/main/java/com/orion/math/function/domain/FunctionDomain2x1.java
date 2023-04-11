package com.orion.math.function.domain;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class FunctionDomain2x1 extends FunctionDomain
{
    private Interval intervalOfVariable1;
    private Interval intervalOfVariable2;
    private OrionSet<?> allowedValuesForVariable1;
    private OrionSet<?> allowedValuesForVariable2;


    public FunctionDomain2x1(Interval intervalOfVariable1, Interval intervalOfVariable2)
    {
        IntervalRules.isValid(intervalOfVariable1);
        IntervalRules.isValid(intervalOfVariable2);
        this.intervalOfVariable1 = intervalOfVariable1;
        this.intervalOfVariable2 = intervalOfVariable2;
    }


    public FunctionDomain2x1(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2)
    {
        Assert.notEmpty(allowedValuesForVariable1, "The allowedValuesForVariable1 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable2, "The allowedValuesForVariable2 input cannot be null/empty.");
        this.allowedValuesForVariable1 = allowedValuesForVariable1;
        this.allowedValuesForVariable2 = allowedValuesForVariable2;
    }


    public static FunctionDomain2x1 of(Interval intervalOfVariable1, Interval intervalOfVariable2)
    {
        return new FunctionDomain2x1(intervalOfVariable1, intervalOfVariable2);
    }


    public static FunctionDomain2x1 of(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2)
    {
        return new FunctionDomain2x1(allowedValuesForVariable1, allowedValuesForVariable2);
    }


    public Interval getIntervalOfVariable1()
    {
        return this.intervalOfVariable1;
    }


    public OrionSet<?> getAllowedValuesForVariable1()
    {
        return this.allowedValuesForVariable1;
    }


    public Interval getIntervalOfVariable2()
    {
        return this.intervalOfVariable2;
    }


    public OrionSet<?> getAllowedValuesForVariable2()
    {
        return this.allowedValuesForVariable2;
    }
}