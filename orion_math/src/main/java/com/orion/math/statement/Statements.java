package com.orion.math.statement;

import com.orion.math.MathRule;
import com.orion.math.statement.expressions.Expressions;
import com.orion.math.statement.expressions.equations.Equation;

public class Statements extends MathRule
{
    public static boolean isValid(MathStatement statement)
    {
        return statement != null;
    }


    public static boolean isValid(Equation equation)
    {
        boolean isValidStatement = isValid((MathStatement)equation);
        boolean isValidLeftExpression = Expressions.isValid(equation.getLeftExpression());
        boolean isValidRightExpression = Expressions.isValid(equation.getRightExpression());
        return isValidStatement && isValidLeftExpression && isValidRightExpression;
    }
}