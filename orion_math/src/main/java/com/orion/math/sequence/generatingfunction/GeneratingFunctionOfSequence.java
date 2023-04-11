package com.orion.math.sequence.generatingfunction;

import com.orion.core.abstraction.Orion;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.number.ANumber;
import com.orion.math.polynomial.Polynomial;

public abstract class GeneratingFunctionOfSequence extends Orion implements MathObject
{
    private MathObject expression;


    public GeneratingFunctionOfSequence()
    {
    }


    @SuppressWarnings("unchecked")
    public GeneratingFunctionOfSequence(MathObject expression)
    {
        GeneratingFunctionOfSequenceRules.isValid(expression);

        if(expression instanceof Polynomial)
        {
            setExpression(((Polynomial)expression).getAsFunction().getFunctionCasted());
        }
        else if(expression instanceof Function1x1IF)
        {
            setExpression((Function1x1IF<ANumber, ANumber>)expression);
        }

    }


    public MathObject getExpression()
    {
        return this.expression;
    }


    protected void setExpression(MathObject expression)
    {
        this.expression = expression;
    }
}