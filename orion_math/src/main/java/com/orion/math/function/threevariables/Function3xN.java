package com.orion.math.function.threevariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain3x1;

public class Function3xN<T1, T2, T3, R> extends Function
{
    public Function3xN(Function3xNIF<T1, T2, T3, R> function)
    {
        super(function, 3);
    }


    public Function3xN(Function3xNIF<T1, T2, T3, R> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, 3, domain, codomain);
    }


    public Function3xN(Function3xNIF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 3);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function3xN(Function3xNIF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, 3, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, R> Function3xN<T1, T2, T3, R> of(Function3xNIF<T1, T2, T3, R> function)
    {
        return new Function3xN<T1, T2, T3, R>(function);
    }


    public static <T1, T2, T3, R> Function3xN<T1, T2, T3, R> of(Function3xNIF<T1, T2, T3, R> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3xN<T1, T2, T3, R>(function, domain, codomain);
    }


    public static <T1, T2, T3, R> Function3xN<T1, T2, T3, R> of(Function3xNIF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function3xN<T1, T2, T3, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, R> Function3xN<T1, T2, T3, R> of(Function3xNIF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3xN<T1, T2, T3, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R[] run(T1 value1, T2 value2, T3 value3)
    {
        canFunctionRunWithGivenValues(value1, value2, value3);
        return ((Function3xNIF<T1, T2, T3, R>)getFunction()).run(value1, value2, value3);
    }


    public FunctionDomain3x1 getDomain()
    {
        return (FunctionDomain3x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function3xNIF<T1, T2, T3, R> getFunctionCasted()
    {
        return (Function3xNIF<T1, T2, T3, R>)getFunction();
    }
}