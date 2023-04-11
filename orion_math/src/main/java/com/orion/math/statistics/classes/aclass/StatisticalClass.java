package com.orion.math.statistics.classes.aclass;

import com.orion.core.abstraction.Orion;
import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;

public class StatisticalClass extends Orion implements MathObject, Cloneable
{
    private Vector values;
    private ANumber classIntervalWidth;
    private Interval classInterval;
    private ANumber mimimumValue;
    private ANumber maximumValue;


    public StatisticalClass(Vector values, ANumber classIntervalWidth)
    {
        StatisticalClassRules.isValid(values, classIntervalWidth);
        this.values = values;
        this.mimimumValue = values.getMinimum();
        this.maximumValue = values.getMaximum();
        this.classIntervalWidth = classIntervalWidth;
    }


    public static StatisticalClass of(Vector values, ANumber classIntervalWidth)
    {
        return new StatisticalClass(values, classIntervalWidth);
    }


    public ANumber getClassIntervalMidpoint()
    {
        return classInterval.getMidpoint();
    }


    public int getNumberOfValues()
    {
        return values.getDimensions();
    }


    public ANumber getNumberOfValuesAsNumber()
    {
        return ANumber.of(getNumberOfValues());
    }


    @Override
    public StatisticalClass clone() throws CloneNotSupportedException
    {
        return (StatisticalClass)CloningService.clone(this);
    }


    public StatisticalClass getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public int hashCode()
    {
        return StatisticalClassInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return StatisticalClassInternalService.equals(this, object);
    }


    public Vector getValues()
    {
        return this.values;
    }


    public ANumber getClassIntervalWidth()
    {
        return this.classIntervalWidth;
    }


    public ANumber getMimimumValue()
    {
        return this.mimimumValue;
    }


    public ANumber getMaximumValue()
    {
        return this.maximumValue;
    }


    public Interval getClassInterval()
    {
        return this.classInterval;
    }
}