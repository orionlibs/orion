package com.orion.math.statement.expressions.equations;

import com.orion.math.statement.MathStatement;
import com.orion.math.statement.expressions.EmptyMathExpression;
import com.orion.math.statement.expressions.MathExpression;

public class Inequality extends MathStatement
{
    private MathExpression leftExpression;
    private MathExpression rightExpression;


    public Inequality()
    {
        this(new EmptyMathExpression(), new EmptyMathExpression());
    }


    public Inequality(MathExpression leftExpression, MathExpression rightExpression)
    {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
    }


    public static Inequality of()
    {
        return new Inequality();
    }


    public static Inequality of(MathExpression leftExpression, MathExpression rightExpression)
    {
        return new Inequality(leftExpression, rightExpression);
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