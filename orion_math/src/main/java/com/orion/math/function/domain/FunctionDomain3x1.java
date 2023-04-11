package com.orion.math.function.domain;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class FunctionDomain3x1 extends FunctionDomain
{
    private Interval intervalOfVariable1;
    private Interval intervalOfVariable2;
    private Interval intervalOfVariable3;
    private OrionSet<?> allowedValuesForVariable1;
    private OrionSet<?> allowedValuesForVariable2;
    private OrionSet<?> allowedValuesForVariable3;


    public FunctionDomain3x1(Interval intervalOfVariable1, Interval intervalOfVariable2, Interval intervalOfVariable3)
    {
        IntervalRules.isValid(intervalOfVariable1);
        IntervalRules.isValid(intervalOfVariable2);
        IntervalRules.isValid(intervalOfVariable3);
        this.intervalOfVariable1 = intervalOfVariable1;
        this.intervalOfVariable2 = intervalOfVariable2;
        this.intervalOfVariable3 = intervalOfVariable3;
    }


    public FunctionDomain3x1(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2, OrionSet<?> allowedValuesForVariable3)
    {
        Assert.notEmpty(allowedValuesForVariable1, "The allowedValuesForVariable1 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable2, "The allowedValuesForVariable2 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable3, "The allowedValuesForVariable3 input cannot be null/empty.");
        this.allowedValuesForVariable1 = allowedValuesForVariable1;
        this.allowedValuesForVariable2 = allowedValuesForVariable2;
        this.allowedValuesForVariable3 = allowedValuesForVariable3;
    }


    public static FunctionDomain3x1 of(Interval intervalOfVariable1, Interval intervalOfVariable2, Interval intervalOfVariable3)
    {
        return new FunctionDomain3x1(intervalOfVariable1, intervalOfVariable2, intervalOfVariable3);
    }


    public static FunctionDomain3x1 of(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2, OrionSet<?> allowedValuesForVariable3)
    {
        return new FunctionDomain3x1(allowedValuesForVariable1, allowedValuesForVariable2, allowedValuesForVariable3);
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


    public Interval getIntervalOfVariable3()
    {
        return this.intervalOfVariable3;
    }


    public OrionSet<?> getAllowedValuesForVariable3()
    {
        return this.allowedValuesForVariable3;
    }
}