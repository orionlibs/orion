package com.orion.math.function.threevariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.threevariables.tasks.arithmetics.AddFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.AddValuesOfFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.DivideFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.GetSumOfSquaresOfFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.MultiplyFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.MultiplyValuesOfFunctions3x1Task;
import com.orion.math.function.threevariables.tasks.arithmetics.SubtractFunctions3x1Task;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Function3x1ArithmeticService extends OrionService
{
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getDouble(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).doubleGET());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getHalf(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).halfGET());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquare(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).squareGET());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSumOfSquares(Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return GetSumOfSquaresOfFunctions3x1Task.run(functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        return getSquareRoot(f, Precision.precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> ((ANumber)f.run(x, y, z)).getSquareRoot(precision));
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int n)
    {
        return getNthRoot(f, n, Precision.precision);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(Function3x1<ANumber, ANumber, ANumber, ANumber> f, int n, int precision)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> ((ANumber)f.run(x, y, z)).getNthRoot(n, precision));
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings("unchecked")
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1) -> x);
        return add(f, Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static ANumber add(ANumber x, ANumber y, ANumber z, Function3x1<ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return AddValuesOfFunctions3x1Task.run(x, y, z, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return AddFunctions3x1Task.run(f, functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1) -> x);
        return subtract(f, Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber> g)
    {
        return SubtractFunctions3x1Task.run(f, g);
    }


    @SuppressWarnings("unchecked")
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1) -> x);
        return multiply(f, Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static ANumber multiply(ANumber x, ANumber y, ANumber z, Function3x1<ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return MultiplyValuesOfFunctions3x1Task.run(x, y, z, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return MultiplyFunctions3x1Task.run(f, functions);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> divide(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1) -> x);
        return divide(f, Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> divide(Function3x1<ANumber, ANumber, ANumber, ANumber> f, Function3x1<ANumber, ANumber, ANumber, ANumber> g)
    {
        return DivideFunctions3x1Task.run(f, g);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> negate(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).negateGET());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> reciprocate(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).reciprocateGET());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> exponentiate(Function3x1<ANumber, ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).exponentiateGET(exponent));
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getAbsoluteValue(Function3x1<ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function3x1IF<ANumber, ANumber, ANumber, ANumber> func = ((x, y, z) -> f.run(x, y, z).getAbsoluteValue());
        return Function3x1.<ANumber, ANumber, ANumber, ANumber>of(func);
    }
}