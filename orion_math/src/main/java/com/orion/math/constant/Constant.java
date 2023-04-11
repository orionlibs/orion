package com.orion.math.constant;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Constant implements MathObject, Cloneable
{
    private ANumber value;
    private boolean hasValueBeenSet = false;


    public Constant(ANumber value)
    {
        this.value = value;
        this.hasValueBeenSet = true;
    }


    public static Constant of(ANumber value)
    {
        return new Constant(value);
    }


    public void applyPrecision(int precision)
    {
        precision = Precision.getValidPrecision(precision);
        ANumber temp = getValue();
        temp.applyPrecision(precision);
        this.value = temp;
    }


    public ANumber halfGET()
    {
        return getValue().halfGET();
    }


    public ANumber doubleIt()
    {
        return getValue().doubleGET();
    }


    public ANumber getValue()
    {
        return this.value;
    }


    public ANumber getValueCopy()
    {
        return getValue().getCopy();
    }


    public boolean hasValueBeenSet()
    {
        return hasValueBeenSet;
    }


    @Override
    public Constant clone() throws CloneNotSupportedException
    {
        return (Constant)CloningService.clone(this);
    }


    public Constant getCopy()
    {

        try
        {
            return (Constant)super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }
}