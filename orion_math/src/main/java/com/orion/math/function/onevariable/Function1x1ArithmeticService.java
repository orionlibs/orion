package com.orion.math.function.onevariable;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.Functions;
import com.orion.math.function.tasks.onevariable.arithmetics.AddFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.AddFunctionsWithWeightsTask;
import com.orion.math.function.tasks.onevariable.arithmetics.AddValuesOfFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.DivideFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.GetSumOfSquaresOfFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.MultiplyFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.MultiplyValuesOfFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.arithmetics.SubtractFunctions1x1Task;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.precision.Precision;
import java.util.List;

public class Function1x1ArithmeticService extends OrionService
{
    public static Function1x1<ANumber, ANumber> getDouble(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).doubleGET());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHalf(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).halfGET());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getSquare(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).squareGET());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static ANumber add(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        return AddValuesOfFunctions1x1Task.run(x, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        Function1x1IF<ANumber, ANumber> func = (x1 -> x);
        return add(f, Function1x1.<ANumber, ANumber>of(func));
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>... functions)
    {
        return AddFunctions1x1Task.run(f, functions);
    }


    public static Function1x1<ANumber, ANumber> add(List<Function1x1<ANumber, ANumber>> functions)
    {
        return AddFunctions1x1Task.run(functions);
    }


    public static Function1x1<ANumber, ANumber> subtract(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        Function1x1IF<ANumber, ANumber> func = (x1 -> x);
        return subtract(f, Function1x1.<ANumber, ANumber>of(func));
    }


    public static Function1x1<ANumber, ANumber> subtract(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> g)
    {
        return SubtractFunctions1x1Task.run(f, g);
    }


    @SuppressWarnings("unchecked")
    public static Function1x1<ANumber, ANumber> multiply(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        Function1x1IF<ANumber, ANumber> func = (x1 -> x);
        return multiply(f, Function1x1.<ANumber, ANumber>of(func));
    }


    public static ANumber multiply(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        return MultiplyValuesOfFunctions1x1Task.run(x, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> multiply(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>... functions)
    {
        return MultiplyFunctions1x1Task.run(f, functions);
    }


    public static Function1x1<ANumber, ANumber> multiply(List<Function1x1<ANumber, ANumber>> functions)
    {
        return MultiplyFunctions1x1Task.run(functions);
    }


    public static Function1x1<ANumber, ANumber> divide(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        Function1x1IF<ANumber, ANumber> func = (x1 -> x);
        return divide(f, Function1x1.<ANumber, ANumber>of(func));
    }


    public static Function1x1<ANumber, ANumber> divide(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> g)
    {
        return DivideFunctions1x1Task.run(f, g);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> getSumOfSquares(Function1x1<ANumber, ANumber>... functions)
    {
        return GetSumOfSquaresOfFunctions1x1Task.run(functions);
    }


    public static Function1x1<ANumber, ANumber> getSumOfSquares(List<Function1x1<ANumber, ANumber>> functions)
    {
        return GetSumOfSquaresOfFunctions1x1Task.run(functions);
    }


    public static Function1x1<ANumber, ANumber> getSquareRoot(Function1x1<ANumber, ANumber> f)
    {
        return getSquareRoot(f, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getSquareRoot(Function1x1<ANumber, ANumber> f, int precision)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> ((ANumber)f.run(x)).getSquareRoot(precision));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getNthRoot(Function1x1<ANumber, ANumber> f, int n)
    {
        return getNthRoot(f, n, Precision.precision);
    }


    public static Function1x1<ANumber, ANumber> getNthRoot(Function1x1<ANumber, ANumber> f, int n, int precision)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> ((ANumber)f.run(x)).getNthRoot(n, precision));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> negate(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).negateGET());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> reciprocate(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).reciprocateGET());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getNeperianLogarithm(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.ln.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getNeperianLogarithm(Function1x1<ANumber, ANumber> f, int precision)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> ArithmeticService.getNeperianLogarithm(f.run(x), precision));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getLogarithm(Function1x1<ANumber, ANumber> f, ANumber base)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> ArithmeticService.getLogarithm(base, f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getLogarithm(Function1x1<ANumber, ANumber> f, ANumber base, int precision)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> ArithmeticService.getLogarithm(base, f.run(x), precision));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> exponentiate(Function1x1<ANumber, ANumber> f, ANumber exponent)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).exponentiateGET(exponent));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getAbsoluteValue(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).getAbsoluteValue());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> conjugate(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> f.run(x).conjugate());
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> addFunctionsWithWeights(List<Function1x1<ANumber, ANumber>> functions, List<?> weights)
    {
        return AddFunctionsWithWeightsTask.run(functions, weights);
    }
}