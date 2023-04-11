package com.orion.math.statement;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.statement.expressions.ExpressionRules;
import com.orion.math.statement.expressions.equations.Equation;

public class StatementRules extends MathRule
{
    public static void isNull(MathStatement statement)
    {
        Assert.notNull(statement, "The statement input cannot be null.");
    }


    public static void isValid(MathStatement statement)
    {
        isNull(statement);
    }


    public static void isValid(Equation equation)
    {
        isValid((MathStatement)equation);
        ExpressionRules.isValid(equation.getLeftExpression());
        ExpressionRules.isValid(equation.getRightExpression());
    }
}