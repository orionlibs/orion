package com.orion.math.function.fourvariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain4x1;

public class Function4x0<T1, T2, T3, T4> extends Function
{
    public Function4x0(Function4x0IF<T1, T2, T3, T4> function)
    {
        super(function, 4);
    }


    public Function4x0(Function4x0IF<T1, T2, T3, T4> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
    }


    public Function4x0(Function4x0IF<T1, T2, T3, T4> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 4);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function4x0(Function4x0IF<T1, T2, T3, T4> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4> Function4x0<T1, T2, T3, T4> of(Function4x0IF<T1, T2, T3, T4> function)
    {
        return new Function4x0<T1, T2, T3, T4>(function);
    }


    public static <T1, T2, T3, T4> Function4x0<T1, T2, T3, T4> of(Function4x0IF<T1, T2, T3, T4> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4x0<T1, T2, T3, T4>(function, domain, codomain);
    }


    public static <T1, T2, T3, T4> Function4x0<T1, T2, T3, T4> of(Function4x0IF<T1, T2, T3, T4> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function4x0<T1, T2, T3, T4>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4> Function4x0<T1, T2, T3, T4> of(Function4x0IF<T1, T2, T3, T4> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4x0<T1, T2, T3, T4>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public void run(T1 value1, T2 value2, T3 value3, T4 value4)
    {
        canFunctionRunWithGivenValues(value1, value2, value3, value4);
        ((Function4x0IF<T1, T2, T3, T4>)getFunction()).run(value1, value2, value3, value4);
    }


    public FunctionDomain4x1 getDomain()
    {
        return (FunctionDomain4x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function4x0IF<T1, T2, T3, T4> getFunctionCasted()
    {
        return (Function4x0IF<T1, T2, T3, T4>)getFunction();
    }
}