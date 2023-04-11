package com.orion.math.function.onevariable;

import com.orion.math.function.Function;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;

public class Function1x0<T1> extends Function
{
    public Function1x0(Function1x0IF<T1> function)
    {
        super(function, 1);
    }


    public Function1x0(Function1x0IF<T1> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        super(function, 1, domain, codomain);
    }


    public static <T1> Function1x0<T1> of(Function1x0IF<T1> function)
    {
        return new Function1x0<T1>(function);
    }


    public static <T1> Function1x0<T1> of(Function1x0IF<T1> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new Function1x0<T1>(function, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public void run(T1 value)
    {
        canFunctionRunWithGivenValue(value);
        ((Function1x0IF<T1>)getFunction()).run(value);
    }


    public FunctionDomain1x1 getDomain()
    {
        return (FunctionDomain1x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function1x0IF<T1> getFunctionCasted()
    {
        return (Function1x0IF<T1>)getFunction();
    }
}