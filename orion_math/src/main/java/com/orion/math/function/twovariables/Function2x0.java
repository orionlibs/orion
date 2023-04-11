package com.orion.math.function.twovariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain2x1;

public class Function2x0<T1, T2> extends Function
{
    public Function2x0(Function2x0IF<T1, T2> function)
    {
        super(function, 2);
    }


    public Function2x0(Function2x0IF<T1, T2> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
    }


    public Function2x0(Function2x0IF<T1, T2> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 2);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function2x0(Function2x0IF<T1, T2> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2> Function2x0<T1, T2> of(Function2x0IF<T1, T2> function)
    {
        return new Function2x0<T1, T2>(function);
    }


    public static <T1, T2> Function2x0<T1, T2> of(Function2x0IF<T1, T2> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2x0<T1, T2>(function, domain, codomain);
    }


    public static <T1, T2> Function2x0<T1, T2> of(Function2x0IF<T1, T2> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function2x0<T1, T2>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2> Function2x0<T1, T2> of(Function2x0IF<T1, T2> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2x0<T1, T2>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public void run(T1 value1, T2 value2)
    {
        canFunctionRunWithGivenValues(value1, value2);
        ((Function2x0IF<T1, T2>)getFunction()).run(value1, value2);
    }


    public FunctionDomain2x1 getDomain()
    {
        return (FunctionDomain2x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function2x0IF<T1, T2> getFunctionCasted()
    {
        return (Function2x0IF<T1, T2>)getFunction();
    }
}