package com.orion.math;

public class MathSymbol implements MathObject
{
    private String symbol;


    public MathSymbol(String symbol)
    {
        setSymbol(symbol);
    }


    public static MathSymbol of(String symbol)
    {
        return new MathSymbol(symbol);
    }


    public String getSymbol()
    {
        return symbol;
    }


    public void setSymbol(String symbol)
    {
        this.symbol = symbol;
    }
}