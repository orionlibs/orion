package com.orion.math.function.threevariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain3x1;

public class Function3x0<T1, T2, T3> extends Function
{
    public Function3x0(Function3x0IF<T1, T2, T3> function)
    {
        super(function, 3);
    }


    public Function3x0(Function3x0IF<T1, T2, T3> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, domain, codomain);
    }


    public Function3x0(Function3x0IF<T1, T2, T3> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 3);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function3x0(Function3x0IF<T1, T2, T3> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, 3, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3> Function3x0<T1, T2, T3> of(Function3x0IF<T1, T2, T3> function)
    {
        return new Function3x0<T1, T2, T3>(function);
    }


    public static <T1, T2, T3> Function3x0<T1, T2, T3> of(Function3x0IF<T1, T2, T3> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3x0<T1, T2, T3>(function, domain, codomain);
    }


    public static <T1, T2, T3> Function3x0<T1, T2, T3> of(Function3x0IF<T1, T2, T3> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function3x0<T1, T2, T3>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3> Function3x0<T1, T2, T3> of(Function3x0IF<T1, T2, T3> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3x0<T1, T2, T3>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public void run(T1 value1, T2 value2, T3 value3)
    {
        canFunctionRunWithGivenValues(value1, value2, value3);
        ((Function3x0IF<T1, T2, T3>)getFunction()).run(value1, value2, value3);
    }


    public FunctionDomain3x1 getDomain()
    {
        return (FunctionDomain3x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function3x0IF<T1, T2, T3> getFunctionCasted()
    {
        return (Function3x0IF<T1, T2, T3>)getFunction();
    }
}