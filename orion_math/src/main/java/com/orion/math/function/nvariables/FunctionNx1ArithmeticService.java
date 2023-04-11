package com.orion.math.function.nvariables;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.nvariables.tasks.arithmetics.AddFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.AddValuesOfFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.DivideFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.GetSumOfSquaresOfFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.MultiplyFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.MultiplyValuesOfFunctionsNx1Task;
import com.orion.math.function.nvariables.tasks.arithmetics.SubtractFunctionsNx1Task;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;

public class FunctionNx1ArithmeticService extends OrionService
{
    public static FunctionNx1 getDouble(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).doubleGET());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 getHalf(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).halfGET());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 getSquare(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).squareGET());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 getSumOfSquares(FunctionNx1... functions)
    {
        return GetSumOfSquaresOfFunctionsNx1Task.run(functions[0].getNumberOfVariables(), functions);
    }


    public static FunctionNx1 getSquareRoot(FunctionNx1 f)
    {
        return getSquareRoot(f, Precision.precision);
    }


    public static FunctionNx1 getSquareRoot(FunctionNx1 f, int precision)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> ((ANumber)f.run(x)).getSquareRoot(precision));
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 getNthRoot(FunctionNx1 f, int n)
    {
        return getNthRoot(f, n, Precision.precision);
    }


    public static FunctionNx1 getNthRoot(FunctionNx1 f, int n, int precision)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> ((ANumber)f.run(x)).getNthRoot(n, precision));
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 add(FunctionNx1 f, ANumber x)
    {
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x1) -> x);
        return add(f, FunctionNx1.of(func, f.getNumberOfVariables()));
    }


    public static ANumber add(ANumber[] x, FunctionNx1[] functions)
    {
        return AddValuesOfFunctionsNx1Task.run(x, functions[0].getNumberOfVariables(), functions);
    }


    public static FunctionNx1 add(FunctionNx1 f, FunctionNx1... functions)
    {
        return AddFunctionsNx1Task.run(f.getNumberOfVariables(), f, functions);
    }


    public static FunctionNx1 add(FunctionNx1 f, FunctionNx1 g)
    {
        return AddFunctionsNx1Task.run(f.getNumberOfVariables(), f, g);
    }


    public static FunctionNx1 subtract(FunctionNx1 f, ANumber x)
    {
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x1) -> x);
        return subtract(f, FunctionNx1.of(func, f.getNumberOfVariables()));
    }


    public static FunctionNx1 subtract(FunctionNx1 f, FunctionNx1 g)
    {
        return SubtractFunctionsNx1Task.run(f, g, f.getNumberOfVariables());
    }


    public static FunctionNx1 multiply(FunctionNx1 f, ANumber x)
    {
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x1) -> x);
        return multiply(f, FunctionNx1.of(func, f.getNumberOfVariables()));
    }


    public static ANumber multiply(ANumber[] x, FunctionNx1[] functions)
    {
        return MultiplyValuesOfFunctionsNx1Task.run(x, functions[0].getNumberOfVariables(), functions);
    }


    public static FunctionNx1 multiply(FunctionNx1 f, FunctionNx1... functions)
    {
        return MultiplyFunctionsNx1Task.run(f.getNumberOfVariables(), f, functions);
    }


    public static FunctionNx1 multiply(FunctionNx1 f, FunctionNx1 g)
    {
        return MultiplyFunctionsNx1Task.run(f.getNumberOfVariables(), f, g);
    }


    public static FunctionNx1 divide(FunctionNx1 f, ANumber x)
    {
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x1) -> x);
        return divide(f, FunctionNx1.of(func, f.getNumberOfVariables()));
    }


    public static FunctionNx1 divide(FunctionNx1 f, FunctionNx1 g)
    {
        return DivideFunctionsNx1Task.run(f, g, f.getNumberOfVariables());
    }


    public static FunctionNx1 negate(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).negateGET());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 reciprocate(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).reciprocateGET());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 exponentiate(FunctionNx1 f, ANumber exponent)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).exponentiateGET(exponent));
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }


    public static FunctionNx1 getAbsoluteValue(FunctionNx1 f)
    {
        FunctionRules.isValid(f);
        FunctionNx1IF<ANumber, ANumber> func = ((ANumber[] x) -> f.run(x).getAbsoluteValue());
        return FunctionNx1.of(func, f.getNumberOfVariables());
    }
}