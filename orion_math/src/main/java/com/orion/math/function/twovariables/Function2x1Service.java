package com.orion.math.function.twovariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;

public class Function2x1Service extends OrionService
{
    public static Function2x1<ANumber, ANumber, ANumber> getDouble(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.getDouble(f);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getHalf(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.getHalf(f);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquare(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.getSquare(f);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getSumOfSquares(Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return Function2x1ArithmeticService.getSumOfSquares(functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquareRoot(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.getSquareRoot(f);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquareRoot(Function2x1<ANumber, ANumber, ANumber> f, int precision)
    {
        return Function2x1ArithmeticService.getSquareRoot(f, precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getNthRoot(Function2x1<ANumber, ANumber, ANumber> f, int n)
    {
        return Function2x1ArithmeticService.getNthRoot(f, n);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getNthRoot(Function2x1<ANumber, ANumber, ANumber> f, int n, int precision)
    {
        return Function2x1ArithmeticService.getNthRoot(f, n, precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function2x1ArithmeticService.add(f, x);
    }


    public static ANumber add(ANumber x, ANumber y, Function2x1<ANumber, ANumber, ANumber>[] functions)
    {
        return Function2x1ArithmeticService.add(x, y, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return Function2x1ArithmeticService.add(f, functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> subtract(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function2x1ArithmeticService.subtract(f, x);
    }


    public static Function2x1<ANumber, ANumber, ANumber> subtract(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber> g)
    {
        return Function2x1ArithmeticService.subtract(f, g);
    }


    public static ANumber multiply(ANumber x, ANumber y, Function2x1<ANumber, ANumber, ANumber>[] functions)
    {
        return Function2x1ArithmeticService.multiply(x, y, functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> multiply(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function2x1ArithmeticService.multiply(f, x);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> multiply(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return Function2x1ArithmeticService.multiply(f, functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> divide(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function2x1ArithmeticService.divide(f, x);
    }


    public static Function2x1<ANumber, ANumber, ANumber> divide(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber> g)
    {
        return Function2x1ArithmeticService.divide(f, g);
    }


    public static Function2x1<ANumber, ANumber, ANumber> negate(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.negate(f);
    }


    public static Function2x1<ANumber, ANumber, ANumber> reciprocate(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.reciprocate(f);
    }


    public static Function2x1<ANumber, ANumber, ANumber> exponentiate(Function2x1<ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        return Function2x1ArithmeticService.exponentiate(f, exponent);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getAbsoluteValue(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return Function2x1ArithmeticService.getAbsoluteValue(f);
    }
}