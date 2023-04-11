package com.orion.math.series;

import com.orion.math.MathObject;
import com.orion.math.function.nvariables.FunctionNx1IF;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;

public abstract class Series implements MathObject
{
    private Function1x1IF<ANumber, ANumber> expression;
    private Function2x1IF<ANumber, ANumber, ANumber> doubleSumExpression;
    private FunctionNx1IF<ANumber, ANumber> nSumExpression;


    public Series()
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


    public Function2x1IF<ANumber, ANumber, ANumber> getDoubleSumExpression()
    {
        return this.doubleSumExpression;
    }


    protected void setDoubleSumExpression(Function2x1IF<ANumber, ANumber, ANumber> doubleSumExpression)
    {
        this.doubleSumExpression = doubleSumExpression;
    }


    public FunctionNx1IF<ANumber, ANumber> getNSumExpression()
    {
        return this.nSumExpression;
    }


    protected void setNSumExpression(FunctionNx1IF<ANumber, ANumber> nSumExpression)
    {
        this.nSumExpression = nSumExpression;
    }
}