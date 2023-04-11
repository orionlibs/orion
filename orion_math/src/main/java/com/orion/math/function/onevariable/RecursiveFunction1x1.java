package com.orion.math.function.onevariable;

import com.orion.math.function.Function;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.function.twovariables.Function2x1IF;

public class RecursiveFunction1x1<T1, R> extends Function
{
    @SuppressWarnings("rawtypes")
    public RecursiveFunction1x1(Function2x1IF<Function2x1IF, T1, R> function)
    {
        super(function, 1);
    }


    @SuppressWarnings("rawtypes")
    public RecursiveFunction1x1(Function2x1IF<Function2x1IF, T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        super(function, 1, domain, codomain);
    }


    @SuppressWarnings("rawtypes")
    public static <T1, R> RecursiveFunction1x1<T1, R> of(Function2x1IF<Function2x1IF, T1, R> function)
    {
        return new RecursiveFunction1x1<T1, R>(function);
    }


    @SuppressWarnings("rawtypes")
    public static <T1, R> RecursiveFunction1x1<T1, R> of(Function2x1IF<Function2x1IF, T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new RecursiveFunction1x1<T1, R>(function, domain, codomain);
    }


    @SuppressWarnings(
    {"unchecked", "rawtypes"})
    public R run(T1 value)
    {
        canFunctionRunWithGivenValue(value);
        return ((Function2x1IF<Function2x1IF, T1, R>)getFunction()).run((Function2x1IF<Function2x1IF, T1, R>)getFunction(), value);
    }
}