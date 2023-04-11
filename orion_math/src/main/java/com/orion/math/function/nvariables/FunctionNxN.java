package com.orion.math.function.nvariables;

import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.number.ANumber;
import java.util.List;

public class FunctionNxN extends Function
{
    public FunctionNxN(FunctionNxNIF<ANumber[], ANumber> function, int numberOfVariables)
    {
        super(function, numberOfVariables);
    }


    public FunctionNxN(FunctionNxNIF<ANumber[], ANumber> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, numberOfVariables);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, numberOfVariables);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static FunctionNxN of(FunctionNxNIF<ANumber[], ANumber> function, int numberOfVariables)
    {
        return new FunctionNxN(function, numberOfVariables);
    }


    public static FunctionNxN of(FunctionNxNIF<ANumber[], ANumber> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new FunctionNxN(function, numberOfVariables, indicesOfVariablesThatAreConstants);
    }


    @SuppressWarnings("unchecked")
    public ANumber[] run(ANumber... values)
    {
        return (ANumber[])((FunctionNxNIF<ANumber[], ANumber>)getFunction()).run(values);
    }


    public ANumber[] run(List<ANumber> values)
    {
        return run(values.toArray(new ANumber[0]));
    }
}