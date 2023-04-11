package com.orion.math.statement.expressions.equations;

import com.orion.math.statement.MathStatement;
import com.orion.math.statement.expressions.EmptyMathExpression;
import com.orion.math.statement.expressions.MathExpression;

public class Equation extends MathStatement
{
    private MathExpression leftExpression;
    private MathExpression rightExpression;


    public Equation()
    {
        this(new EmptyMathExpression(), new EmptyMathExpression());
    }


    public Equation(MathExpression leftExpression, MathExpression rightExpression)
    {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }


    public static Equation of()
    {
        return new Equation();
    }


    public static Equation of(MathExpression leftExpression, MathExpression rightExpression)
    {
        return new Equation(leftExpression, rightExpression);
    }


    public MathExpression getLeftExpression()
    {
        return leftExpression;
    }


    public MathExpression getRightExpression()
    {
        return rightExpression;
    }
}