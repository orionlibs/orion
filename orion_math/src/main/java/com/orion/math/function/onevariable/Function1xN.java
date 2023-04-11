package com.orion.math.function.onevariable;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;

public class Function1xN<T1, R> extends Function
{
    public Function1xN(Function1xNIF<T1, R> function)
    {
        super(function, 1);
    }


    public Function1xN(Function1xNIF<T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        super(function, 1, domain, codomain);
    }


    public Function1xN(Function1xNIF<T1, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 1);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 1);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function1xN(Function1xNIF<T1, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        super(function, 1, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 1);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, R> Function1xN<T1, R> of(Function1xNIF<T1, R> function)
    {
        return new Function1xN<T1, R>(function);
    }


    public static <T1, R> Function1xN<T1, R> of(Function1xNIF<T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new Function1xN<T1, R>(function, domain, codomain);
    }


    public static <T1, R> Function1xN<T1, R> of(Function1xNIF<T1, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function1xN<T1, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, R> Function1xN<T1, R> of(Function1xNIF<T1, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new Function1xN<T1, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R[] run(T1 value)
    {
        canFunctionRunWithGivenValue(value);
        return ((Function1xNIF<T1, R>)getFunction()).run(value);
    }


    public FunctionDomain1x1 getDomain()
    {
        return (FunctionDomain1x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function1xNIF<T1, R> getFunctionCasted()
    {
        return (Function1xNIF<T1, R>)getFunction();
    }
}