package com.orion.math.function.twovariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain2x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;

public class Function2xN<T1, T2, R> extends Function
{
    public Function2xN(Function2xNIF<T1, T2, R> function)
    {
        super(function, 2);
    }


    public Function2xN(Function2xNIF<T1, T2, R> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
    }


    public Function2xN(Function2xNIF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 2);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function2xN(Function2xNIF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, R> Function2xN<T1, T2, R> of(Function2xNIF<T1, T2, R> function)
    {
        return new Function2xN<T1, T2, R>(function);
    }


    public static <T1, T2, R> Function2xN<T1, T2, R> of(Function2xNIF<T1, T2, R> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2xN<T1, T2, R>(function, domain, codomain);
    }


    public static <T1, T2, R> Function2xN<T1, T2, R> of(Function2xNIF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function2xN<T1, T2, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, R> Function2xN<T1, T2, R> of(Function2xNIF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2xN<T1, T2, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R[] run(T1 value1, T2 value2)
    {
        canFunctionRunWithGivenValues(value1, value2);
        return ((Function2xNIF<T1, T2, R>)getFunction()).run(value1, value2);
    }


    @SuppressWarnings("unchecked")
    public boolean isZeroFunction()
    {
        ANumber[] result = (ANumber[])run((T1)ANumber.of(1), (T2)ANumber.of(1));
        return Vector.of(result).isZeroVector();
    }


    public FunctionDomain2x1 getDomain()
    {
        return (FunctionDomain2x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function2xNIF<T1, T2, R> getFunctionCasted()
    {
        return (Function2xNIF<T1, T2, R>)getFunction();
    }
}