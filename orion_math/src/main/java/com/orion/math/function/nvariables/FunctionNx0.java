package com.orion.math.function.nvariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.number.ANumber;
import java.util.List;

public class FunctionNx0 extends Function
{
    public FunctionNx0(FunctionNx0IF<ANumber[]> function, int numberOfVariables)
    {
        super(function, numberOfVariables);
    }


    public FunctionNx0(FunctionNx0IF<ANumber[]> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, numberOfVariables);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, numberOfVariables);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static FunctionNx0 of(FunctionNx0IF<ANumber[]> function, int numberOfVariables)
    {
        return new FunctionNx0(function, numberOfVariables);
    }


    public static FunctionNx0 of(FunctionNx0IF<ANumber[]> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new FunctionNx0(function, numberOfVariables, indicesOfVariablesThatAreConstants);
    }


    @SuppressWarnings("unchecked")
    public void run(ANumber... values)
    {
        ((FunctionNx0IF<ANumber[]>)getFunction()).run(values);
    }


    public void run(List<ANumber> values)
    {
        run(values.toArray(new ANumber[0]));
    }
}