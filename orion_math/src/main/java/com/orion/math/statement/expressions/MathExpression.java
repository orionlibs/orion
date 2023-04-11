package com.orion.math.statement.expressions;

import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.statement.MathStatement;

public class MathExpression extends MathStatement
{
    private Function1x1<ANumber, ANumber> expression;


    public MathExpression()
    {
    }


    public MathExpression(Function1x1<ANumber, ANumber> expression)
    {
        this.expression = expression;
    }


    public static MathExpression of()
    {
        return new MathExpression();
    }


    public static MathExpression of(Function1x1<ANumber, ANumber> expression)
    {
        return new MathExpression(expression);
    }


    public ANumber evaluate(ANumber variableValue)
    {
        NumberRules.isNotNull(variableValue);
        return getExpression().run(variableValue);
    }


    public Function1x1<ANumber, ANumber> getExpression()
    {
        return this.expression;
    }


    public void setExpression(Function1x1<ANumber, ANumber> expression)
    {
        this.expression = expression;
    }
}