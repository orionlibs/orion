package com.orion.math.variable;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;

public class NumberVariable extends Variable<ANumber>
{
    private Function1x1<ANumber, ANumber> function = Function1x1.of(x -> x);


    public NumberVariable()
    {
        super();
    }


    public NumberVariable(ANumber value)
    {
        super(value);
    }


    public static NumberVariable of()
    {
        return new NumberVariable();
    }


    public static NumberVariable of(ANumber value)
    {
        return new NumberVariable(value);
    }


    public ANumber run(ANumber x)
    {
        return getFunction().run(x);
    }


    public ANumber run(Number x)
    {
        return getFunction().run(ANumber.of(x));
    }


    @Override
    public ANumber getValue()
    {
        return (ANumber)getValue();
    }


    public void setValue(ANumber value)
    {
        super.setValue(value);
    }


    public Function1x1<ANumber, ANumber> getFunction()
    {
        return this.function;
    }
}