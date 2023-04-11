package com.orion.math.function.fourvariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.fourvariables.tasks.arithmetics.AddFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.AddValuesOfFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.DivideFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.GetSumOfSquaresOfFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.MultiplyFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.MultiplyValuesOfFunctions4x1Task;
import com.orion.math.function.fourvariables.tasks.arithmetics.SubtractFunctions4x1Task;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class Function4x1ArithmeticService extends OrionService
{
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getDouble(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).doubleGET());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getHalf(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).halfGET());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquare(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).squareGET());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSumOfSquares(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return GetSumOfSquaresOfFunctions4x1Task.run(functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        return getSquareRoot(f, Precision.precision);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int precision)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> ((ANumber)f.run(x, y, z, w)).getSquareRoot(precision));
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int n)
    {
        return getNthRoot(f, n, Precision.precision);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, int n, int precision)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> ((ANumber)f.run(x, y, z, w)).getNthRoot(n, precision));
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    @SuppressWarnings("unchecked")
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1, w1) -> x);
        return add(f, Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static ANumber add(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return AddValuesOfFunctions4x1Task.run(x, y, z, w, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return AddFunctions4x1Task.run(f, functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1, w1) -> x);
        return subtract(f, Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> g)
    {
        return SubtractFunctions4x1Task.run(f, g);
    }


    @SuppressWarnings("unchecked")
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1, w1) -> x);
        return multiply(f, Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static ANumber multiply(ANumber x, ANumber y, ANumber z, ANumber w, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>[] functions)
    {
        return MultiplyValuesOfFunctions4x1Task.run(x, y, z, w, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... functions)
    {
        return MultiplyFunctions4x1Task.run(f, functions);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber x)
    {
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x1, y1, z1, w1) -> x);
        return divide(f, Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func));
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> g)
    {
        return DivideFunctions4x1Task.run(f, g);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> negate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).negateGET());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> reciprocate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).reciprocateGET());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> exponentiate(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f, ANumber exponent)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).exponentiateGET(exponent));
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }


    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getAbsoluteValue(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function4x1IF<ANumber, ANumber, ANumber, ANumber, ANumber> func = ((x, y, z, w) -> f.run(x, y, z, w).getAbsoluteValue());
        return Function4x1.<ANumber, ANumber, ANumber, ANumber, ANumber>of(func);
    }
}