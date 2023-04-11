package com.orion.math.statement.expressions;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;

public class ExpressionRules extends MathRule
{
    public static void isNull(MathExpression expression)
    {
        Assert.notNull(expression, "The expression input cannot be null/empty.");
    }


    public static void isValid(MathExpression expression)
    {
        isNull(expression);
        Assert.notNull(expression.getExpression(), "Expression is null.");
    }
}