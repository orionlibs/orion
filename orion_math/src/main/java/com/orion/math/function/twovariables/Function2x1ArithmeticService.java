package com.orion.math.function.twovariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.twovariables.tasks.arithmetic.AddFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.AddValuesOfFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.DivideFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.GetSumOfSquaresOfFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.MultiplyFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.MultiplyValuesOfFunctions2x1Task;
import com.orion.math.function.twovariables.tasks.arithmetic.SubtractFunctions2x1Task;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Function2x1ArithmeticService extends OrionService
{
    public static Function2x1<ANumber, ANumber, ANumber> getDouble(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).doubleGET());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getHalf(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).halfGET());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquare(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).squareGET());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getSumOfSquares(Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return GetSumOfSquaresOfFunctions2x1Task.run(functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquareRoot(Function2x1<ANumber, ANumber, ANumber> f)
    {
        return getSquareRoot(f, Precision.precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getSquareRoot(Function2x1<ANumber, ANumber, ANumber> f, int precision)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> ((ANumber)f.run(x, y)).getSquareRoot(precision));
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getNthRoot(Function2x1<ANumber, ANumber, ANumber> f, int n)
    {
        return getNthRoot(f, n, Precision.precision);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getNthRoot(Function2x1<ANumber, ANumber, ANumber> f, int n, int precision)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> ((ANumber)f.run(x, y)).getNthRoot(n, precision));
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings("unchecked")
    public static Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x1, y1) -> x);
        return add(f, Function2x1.<ANumber, ANumber, ANumber>of(func));
    }


    public static ANumber add(ANumber x, ANumber y, Function2x1<ANumber, ANumber, ANumber>[] functions)
    {
        return AddValuesOfFunctions2x1Task.run(x, y, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return AddFunctions2x1Task.run(f, functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> subtract(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x1, y1) -> x);
        return subtract(f, Function2x1.<ANumber, ANumber, ANumber>of(func));
    }


    public static Function2x1<ANumber, ANumber, ANumber> subtract(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber> g)
    {
        return SubtractFunctions2x1Task.run(f, g);
    }


    public static ANumber multiply(ANumber x, ANumber y, Function2x1<ANumber, ANumber, ANumber>[] functions)
    {
        return MultiplyValuesOfFunctions2x1Task.run(x, y, functions);
    }


    @SuppressWarnings("unchecked")
    public static Function2x1<ANumber, ANumber, ANumber> multiply(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x1, y1) -> x);
        return multiply(f, Function2x1.<ANumber, ANumber, ANumber>of(func));
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> multiply(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber>... functions)
    {
        return MultiplyFunctions2x1Task.run(f, functions);
    }


    public static Function2x1<ANumber, ANumber, ANumber> divide(Function2x1<ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x1, y1) -> x);
        return divide(f, Function2x1.<ANumber, ANumber, ANumber>of(func));
    }


    public static Function2x1<ANumber, ANumber, ANumber> divide(Function2x1<ANumber, ANumber, ANumber> f, Function2x1<ANumber, ANumber, ANumber> g)
    {
        return DivideFunctions2x1Task.run(f, g);
    }


    public static Function2x1<ANumber, ANumber, ANumber> negate(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).negateGET());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> reciprocate(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).reciprocateGET());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> exponentiate(Function2x1<ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).exponentiateGET(exponent));
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }


    public static Function2x1<ANumber, ANumber, ANumber> getAbsoluteValue(Function2x1<ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function2x1IF<ANumber, ANumber, ANumber> func = ((x, y) -> f.run(x, y).getAbsoluteValue());
        return Function2x1.<ANumber, ANumber, ANumber>of(func);
    }
}