package com.orion.math.statement;

import com.orion.math.MathObject;
import com.orion.math.MathSymbol;

public abstract class MathStatement implements MathObject
{
    private MathSymbol statementSymbol;


    public MathStatement()
    {
    }


    public MathStatement(MathSymbol statementSymbol)
    {
        this.statementSymbol = statementSymbol;
    }


    public MathSymbol getStatementSymbol()
    {
        return this.statementSymbol;
    }
}