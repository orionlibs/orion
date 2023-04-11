package com.orion.math.function.domain;

import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.exception.Assert;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;

public class FunctionDomain4x1 extends FunctionDomain
{
    private Interval intervalOfVariable1;
    private Interval intervalOfVariable2;
    private Interval intervalOfVariable3;
    private Interval intervalOfVariable4;
    private OrionSet<?> allowedValuesForVariable1;
    private OrionSet<?> allowedValuesForVariable2;
    private OrionSet<?> allowedValuesForVariable3;
    private OrionSet<?> allowedValuesForVariable4;


    public FunctionDomain4x1(Interval intervalOfVariable1, Interval intervalOfVariable2, Interval intervalOfVariable3, Interval intervalOfVariable4)
    {
        IntervalRules.isValid(intervalOfVariable1);
        IntervalRules.isValid(intervalOfVariable2);
        IntervalRules.isValid(intervalOfVariable3);
        IntervalRules.isValid(intervalOfVariable4);
        this.intervalOfVariable1 = intervalOfVariable1;
        this.intervalOfVariable2 = intervalOfVariable2;
        this.intervalOfVariable3 = intervalOfVariable3;
        this.intervalOfVariable4 = intervalOfVariable4;
    }


    public FunctionDomain4x1(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2, OrionSet<?> allowedValuesForVariable3, OrionSet<?> allowedValuesForVariable4)
    {
        Assert.notEmpty(allowedValuesForVariable1, "The allowedValuesForVariable1 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable2, "The allowedValuesForVariable2 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable3, "The allowedValuesForVariable3 input cannot be null/empty.");
        Assert.notEmpty(allowedValuesForVariable4, "The allowedValuesForVariable4 input cannot be null/empty.");
        this.allowedValuesForVariable1 = allowedValuesForVariable1;
        this.allowedValuesForVariable2 = allowedValuesForVariable2;
        this.allowedValuesForVariable3 = allowedValuesForVariable3;
        this.allowedValuesForVariable4 = allowedValuesForVariable4;
    }


    public static FunctionDomain4x1 of(Interval intervalOfVariable1, Interval intervalOfVariable2, Interval intervalOfVariable3, Interval intervalOfVariable4)
    {
        return new FunctionDomain4x1(intervalOfVariable1, intervalOfVariable2, intervalOfVariable3, intervalOfVariable4);
    }


    public static FunctionDomain4x1 of(OrionSet<?> allowedValuesForVariable1, OrionSet<?> allowedValuesForVariable2, OrionSet<?> allowedValuesForVariable3, OrionSet<?> allowedValuesForVariable4)
    {
        return new FunctionDomain4x1(allowedValuesForVariable1, allowedValuesForVariable2, allowedValuesForVariable3, allowedValuesForVariable4);
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


    public Interval getIntervalOfVariable4()
    {
        return this.intervalOfVariable4;
    }


    public OrionSet<?> getAllowedValuesForVariable4()
    {
        return this.allowedValuesForVariable4;
    }
}