package com.orion.math.statement.expressions;

import com.orion.math.MathRule;

public class Expressions extends MathRule
{
    public static boolean isValid(MathExpression expression)
    {
        return expression != null
                        && expression.getExpression() != null;
    }


    public static boolean isNotValid(MathExpression expression)
    {
        return !isValid(expression);
    }
}