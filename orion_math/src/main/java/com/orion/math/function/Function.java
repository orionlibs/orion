package com.orion.math.function;

import com.orion.core.abstraction.Orion;
import com.orion.core.runnable.functions.OrionFunction;
import com.orion.math.MathObject;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain;
import com.orion.math.number.interval.Interval;

public class Function extends Orion implements MathObject
{
    private OrionFunction function;
    private FunctionDomain domain;
    private FunctionCodomain codomain;
    private boolean[] indicesOfVariablesThatAreConstants;
    private int numberOfVariables;


    public Function()
    {
    }


    public Function(OrionFunction function)
    {
        FunctionRules.isValid(function);
        this.function = function;
    }


    public Function(OrionFunction function, FunctionDomain domain, FunctionCodomain codomain)
    {
        FunctionRules.isValid(function, domain, codomain);
        this.function = function;
        this.domain = domain;
        this.codomain = codomain;
    }


    public Function(OrionFunction function, int numberOfVariables)
    {
        FunctionRules.isValid(function);
        this.function = function;
        this.indicesOfVariablesThatAreConstants = new boolean[numberOfVariables];
        this.numberOfVariables = numberOfVariables;
    }


    public Function(OrionFunction function, int numberOfVariables, FunctionDomain domain, FunctionCodomain codomain)
    {
        FunctionRules.isValid(function, domain, codomain);
        this.function = function;
        this.domain = domain;
        this.codomain = codomain;
        this.indicesOfVariablesThatAreConstants = new boolean[numberOfVariables];
        this.numberOfVariables = numberOfVariables;
    }


    public static Function of(OrionFunction function)
    {
        return new Function(function);
    }


    public static Function of(OrionFunction function, FunctionDomain domain, FunctionCodomain codomain)
    {
        return new Function(function, domain, codomain);
    }


    public static Function of(OrionFunction function, int numberOfVariables)
    {
        return new Function(function, numberOfVariables);
    }


    public static Function of(OrionFunction function, int numberOfVariables, FunctionDomain domain, FunctionCodomain codomain)
    {
        return new Function(function, numberOfVariables, domain, codomain);
    }


    public void setIndexOfVariableAsConstant(int index)
    {
        FunctionRules.isValid(function, index, numberOfVariables);
        indicesOfVariablesThatAreConstants[index] = true;
    }


    public int getIndexOfFirstVariable()
    {
        return FunctionInternalService.getIndexOfVariable(this, 1);
    }


    protected boolean canFunctionRunWithGivenValue(Object value)
    {
        return FunctionInternalService.canFunctionRunWithGivenValue(this, value);
    }


    protected boolean canFunctionRunWithGivenValues(Object value1, Object value2)
    {
        return FunctionInternalService.canFunctionRunWithGivenValues(this, value1, value2);
    }


    protected boolean canFunctionRunWithGivenValues(Object value1, Object value2, Object value3)
    {
        return FunctionInternalService.canFunctionRunWithGivenValues(this, value1, value2, value3);
    }


    protected boolean canFunctionRunWithGivenValues(Object value1, Object value2, Object value3, Object value4)
    {
        return FunctionInternalService.canFunctionRunWithGivenValues(this, value1, value2, value3, value4);
    }


    protected boolean canFunctionRunWithGivenInterval(Interval intervalToCheck)
    {
        return FunctionInternalService.canFunctionRunWithGivenInterval(this, intervalToCheck);
    }


    public OrionFunction getFunction()
    {
        return this.function;
    }


    public boolean[] getIndicesOfVariablesThatAreConstants()
    {
        return this.indicesOfVariablesThatAreConstants;
    }


    public void resetIndicesOfVariablesThatAreConstants()
    {
        this.indicesOfVariablesThatAreConstants = new boolean[numberOfVariables];
    }


    protected void setIndicesOfVariablesThatAreConstants(boolean[] indicesOfVariablesThatAreConstants)
    {
        this.indicesOfVariablesThatAreConstants = indicesOfVariablesThatAreConstants;
    }


    public int getNumberOfVariables()
    {
        return this.numberOfVariables;
    }


    public FunctionDomain getDomain()
    {
        return this.domain;
    }


    public FunctionCodomain getCodomain()
    {
        return this.codomain;
    }


    protected void setFunction(OrionFunction function)
    {
        this.function = function;
    }


    protected void setNumberOfVariables(int numberOfVariables)
    {
        this.numberOfVariables = numberOfVariables;
    }


    protected void setDomain(FunctionDomain domain)
    {
        this.domain = domain;
    }


    protected void setCodomain(FunctionCodomain codomain)
    {
        this.codomain = codomain;
    }
}