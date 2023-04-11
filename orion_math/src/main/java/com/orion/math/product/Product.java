package com.orion.math.product;

import com.orion.math.MathObject;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;

public abstract class Product implements MathObject
{
    private Function1x1IF<ANumber, ANumber> expression;
    private Function2x1IF<ANumber, ANumber, ANumber> doubleProductExpression;
    private FunctionNx1IF<ANumber, ANumber> nProductExpression;


    public Product()
    {
    }


    public Function1x1IF<ANumber, ANumber> getExpression()
    {
        return this.expression;
    }


    protected void setExpression(Function1x1IF<ANumber, ANumber> expression)
    {
        this.expression = expression;
    }


    public Function2x1IF<ANumber, ANumber, ANumber> getDoubleProductExpression()
    {
        return this.doubleProductExpression;
    }


    protected void setDoubleProductExpression(Function2x1IF<ANumber, ANumber, ANumber> doubleProductExpression)
    {
        this.doubleProductExpression = doubleProductExpression;
    }


    public FunctionNx1IF<ANumber, ANumber> getNProductExpression()
    {
        return this.nProductExpression;
    }


    protected void setNProductExpression(FunctionNx1IF<ANumber, ANumber> nProductExpression)
    {
        this.nProductExpression = nProductExpression;
    }
}