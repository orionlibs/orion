package com.orion.math.function.fourvariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;

public class Function4x1Service extends OrionService
{
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getDouble(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.getDouble(f);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getHalf(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.getHalf(f);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquare(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.getSquare(f);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSumOfSquares(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function4x1ArithmeticService.getSumOfSquares(functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.getSquareRoot(f);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        return Function4x1ArithmeticService.getSquareRoot(f, precision);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int n)
    {
        return Function4x1ArithmeticService.getNthRoot(f, n);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int n, int precision)
    {
        return Function4x1ArithmeticService.getNthRoot(f, n, precision);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function4x1ArithmeticService.add(f, x);
    }


    public static ANumber add(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return Function4x1ArithmeticService.add(x, y, z, w, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function4x1ArithmeticService.add(f, functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function4x1ArithmeticService.subtract(f, x);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> g)
    {
        return Function4x1ArithmeticService.subtract(f, g);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function4x1ArithmeticService.multiply(f, x);
    }


    public static ANumber multiply(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return Function4x1ArithmeticService.multiply(x, y, z, w, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return Function4x1ArithmeticService.multiply(f, functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        return Function4x1ArithmeticService.divide(f, x);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> g)
    {
        return Function4x1ArithmeticService.divide(f, g);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> negate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.negate(f);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> reciprocate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.reciprocate(f);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> exponentiate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        return Function4x1ArithmeticService.exponentiate(f, exponent);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getAbsoluteValue(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return Function4x1ArithmeticService.getAbsoluteValue(f);
    }
}