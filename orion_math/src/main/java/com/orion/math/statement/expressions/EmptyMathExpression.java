package com.orion.math.statement.expressions;

public class EmptyMathExpression extends MathExpression
{
    public EmptyMathExpression()
    {
    }


    public static EmptyMathExpression of()
    {
        return new EmptyMathExpression();
    }
}