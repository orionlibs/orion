package com.orion.math.function.fourvariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain4x1;

public class Function4xN<T1, T2, T3, T4, R> extends Function
{
    public Function4xN(Function4xNIF<T1, T2, T3, T4, R> function)
    {
        super(function, 4);
    }


    public Function4xN(Function4xNIF<T1, T2, T3, T4, R> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
    }


    public Function4xN(Function4xNIF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 4);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function4xN(Function4xNIF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4, R> Function4xN<T1, T2, T3, T4, R> of(Function4xNIF<T1, T2, T3, T4, R> function)
    {
        return new Function4xN<T1, T2, T3, T4, R>(function);
    }


    public static <T1, T2, T3, T4, R> Function4xN<T1, T2, T3, T4, R> of(Function4xNIF<T1, T2, T3, T4, R> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4xN<T1, T2, T3, T4, R>(function, domain, codomain);
    }


    public static <T1, T2, T3, T4, R> Function4xN<T1, T2, T3, T4, R> of(Function4xNIF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function4xN<T1, T2, T3, T4, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4, R> Function4xN<T1, T2, T3, T4, R> of(Function4xNIF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4xN<T1, T2, T3, T4, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R[] run(T1 value1, T2 value2, T3 value3, T4 value4)
    {
        canFunctionRunWithGivenValues(value1, value2, value3, value4);
        return ((Function4xNIF<T1, T2, T3, T4, R>)getFunction()).run(value1, value2, value3, value4);
    }


    public FunctionDomain4x1 getDomain()
    {
        return (FunctionDomain4x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function4xNIF<T1, T2, T3, T4, R> getFunctionCasted()
    {
        return (Function4xNIF<T1, T2, T3, T4, R>)getFunction();
    }
}