package com.orion.math.function.threevariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;

public class Function3x1Service extends OrionService
{
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getDouble(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.getDouble(f);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getHalf(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.getHalf(f);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquare(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.getSquare(f);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSumOfSquares(Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function3x1ArithmeticService.getSumOfSquares(functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.getSquareRoot(f);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        return Function3x1ArithmeticService.getSquareRoot(f, precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int n)
    {
        return Function3x1ArithmeticService.getNthRoot(f, n);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int n, int precision)
    {
        return Function3x1ArithmeticService.getNthRoot(f, n, precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function3x1ArithmeticService.add(f, x);
    }


    public static ANumber add(ANumber x, ANumber y, ANumber z, Function3x1<ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return Function3x1ArithmeticService.add(x, y, z, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function3x1ArithmeticService.add(f, functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function3x1ArithmeticService.subtract(f, x);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber> g)
    {
        return Function3x1ArithmeticService.subtract(f, g);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function3x1ArithmeticService.multiply(f, x);
    }


    public static ANumber multiply(ANumber x, ANumber y, ANumber z, Function3x1<ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return Function3x1ArithmeticService.multiply(x, y, z, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function3x1ArithmeticService.multiply(f, functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> divide(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function3x1ArithmeticService.divide(f, x);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> divide(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber> g)
    {
        return Function3x1ArithmeticService.divide(f, g);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> negate(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.negate(f);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> reciprocate(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.reciprocate(f);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> exponentiate(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        return Function3x1ArithmeticService.exponentiate(f, exponent);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getAbsoluteValue(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function3x1ArithmeticService.getAbsoluteValue(f);
    }
}