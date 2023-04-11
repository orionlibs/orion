package com.orion.math.function.nvariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;

public class FunctionNx1Service extends OrionService
{
    public static FunctionNx1 getDouble(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.getDouble(f);
    }


    public static FunctionNx1 getHalf(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.getHalf(f);
    }


    public static FunctionNx1 getSquare(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.getSquare(f);
    }


    public static FunctionNx1 getSumOfSquares(FunctionNx1... functions)
    {
        return FunctionNx1ArithmeticService.getSumOfSquares(functions);
    }


    public static FunctionNx1 getSquareRoot(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.getSquareRoot(f);
    }


    public static FunctionNx1 getSquareRoot(FunctionNx1 f, int precision)
    {
        return FunctionNx1ArithmeticService.getSquareRoot(f, precision);
    }


    public static FunctionNx1 getNthRoot(FunctionNx1 f, int n)
    {
        return FunctionNx1ArithmeticService.getNthRoot(f, n);
    }


    public static FunctionNx1 getNthRoot(FunctionNx1 f, int n, int precision)
    {
        return FunctionNx1ArithmeticService.getNthRoot(f, n, precision);
    }


    public static FunctionNx1 add(FunctionNx1 f, ANumber x)
    {
        return FunctionNx1ArithmeticService.add(f, x);
    }


    public static ANumber add(ANumber[] x, FunctionNx1[] functions)
    {
        return FunctionNx1ArithmeticService.add(x, functions);
    }


    public static FunctionNx1 add(FunctionNx1 f, FunctionNx1... functions)
    {
        return FunctionNx1ArithmeticService.add(f, functions);
    }


    public static FunctionNx1 add(FunctionNx1 f, FunctionNx1 g)
    {
        return FunctionNx1ArithmeticService.add(f, g);
    }


    public static FunctionNx1 subtract(FunctionNx1 f, ANumber x)
    {
        return FunctionNx1ArithmeticService.subtract(f, x);
    }


    public static FunctionNx1 subtract(FunctionNx1 f, FunctionNx1 g)
    {
        return FunctionNx1ArithmeticService.subtract(f, g);
    }


    public static FunctionNx1 multiply(FunctionNx1 f, ANumber x)
    {
        return FunctionNx1ArithmeticService.multiply(f, x);
    }


    public static ANumber multiply(ANumber[] x, FunctionNx1[] functions)
    {
        return FunctionNx1ArithmeticService.multiply(x, functions);
    }


    public static FunctionNx1 multiply(FunctionNx1 f, FunctionNx1... functions)
    {
        return FunctionNx1ArithmeticService.multiply(f, functions);
    }


    public static FunctionNx1 multiply(FunctionNx1 f, FunctionNx1 g)
    {
        return FunctionNx1ArithmeticService.multiply(f, g);
    }


    public static FunctionNx1 divide(FunctionNx1 f, ANumber x)
    {
        return FunctionNx1ArithmeticService.divide(f, x);
    }


    public static FunctionNx1 divide(FunctionNx1 f, FunctionNx1 g)
    {
        return FunctionNx1ArithmeticService.divide(f, g);
    }


    public static FunctionNx1 negate(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.negate(f);
    }


    public static FunctionNx1 reciprocate(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.reciprocate(f);
    }


    public static FunctionNx1 exponentiate(FunctionNx1 f, ANumber exponent)
    {
        return FunctionNx1ArithmeticService.exponentiate(f, exponent);
    }


    public static FunctionNx1 getAbsoluteValue(FunctionNx1 f)
    {
        return FunctionNx1ArithmeticService.getAbsoluteValue(f);
    }
}