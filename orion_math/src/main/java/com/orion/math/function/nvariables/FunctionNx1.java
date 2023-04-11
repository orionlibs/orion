package com.orion.math.function.nvariables;

import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FunctionNx1 extends Function
{
    public FunctionNx1(FunctionNx1IF<ANumber, ANumber> function, int numberOfVariables)
    {
        super(function, numberOfVariables);
    }


    public FunctionNx1(FunctionNx1IF<ANumber, ANumber> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, numberOfVariables);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, numberOfVariables);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static FunctionNx1 of(FunctionNx1IF<ANumber, ANumber> function, int numberOfVariables)
    {
        return new FunctionNx1(function, numberOfVariables);
    }


    public static FunctionNx1 of(FunctionNx1IF<ANumber, ANumber> function, int numberOfVariables, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new FunctionNx1(function, numberOfVariables, indicesOfVariablesThatAreConstants);
    }


    @SuppressWarnings("unchecked")
    public ANumber run(ANumber[] values)
    {
        return (ANumber)((FunctionNx1IF<ANumber, ANumber>)getFunction()).run(values);
    }


    public ANumber run(List<ANumber> values)
    {
        return run(values.toArray(new ANumber[0]));
    }


    public boolean isZeroFunction()
    {
        List<ANumber> values = new ArrayList<>();
        IntStream.range(0, getNumberOfVariables()).forEach(i -> values.add(ANumber.of(1)));
        return ANumber.of(1).divideGET(((ANumber)run(values))).isInfinite();
    }


    public FunctionNx1 add(ANumber x)
    {
        return FunctionNx1Service.add(this, x);
    }


    public FunctionNx1 add(FunctionNx1 other)
    {
        return FunctionNx1Service.add(this, other);
    }


    public FunctionNx1 add(FunctionNx1... other)
    {
        return FunctionNx1Service.add(this, other);
    }


    public FunctionNx1 subtract(ANumber x)
    {
        return FunctionNx1Service.subtract(this, x);
    }


    public FunctionNx1 subtract(FunctionNx1 other)
    {
        return FunctionNx1Service.subtract(this, other);
    }


    public FunctionNx1 multiply(ANumber x)
    {
        return FunctionNx1Service.multiply(this, x);
    }


    public FunctionNx1 multiply(FunctionNx1 other)
    {
        return FunctionNx1Service.multiply(this, other);
    }


    public FunctionNx1 divide(ANumber x)
    {
        return FunctionNx1Service.divide(this, x);
    }


    public FunctionNx1 divide(FunctionNx1 other)
    {
        return FunctionNx1Service.divide(this, other);
    }


    public FunctionNx1 getDouble()
    {
        return FunctionNx1Service.getDouble((FunctionNx1)this);
    }


    public FunctionNx1 getHalf()
    {
        return FunctionNx1Service.getHalf((FunctionNx1)this);
    }


    public FunctionNx1 getSquare()
    {
        return FunctionNx1Service.getSquare((FunctionNx1)this);
    }


    public FunctionNx1 getSumOfSquares()
    {
        return FunctionNx1Service.getSumOfSquares(this);
    }


    public FunctionNx1 getSquareRoot()
    {
        return FunctionNx1Service.getSquareRoot(this);
    }


    public FunctionNx1 getSquareRoot(int precision)
    {
        return FunctionNx1Service.getSquareRoot(this, precision);
    }


    public FunctionNx1 getNthRoot(int n)
    {
        return FunctionNx1Service.getNthRoot(this, n);
    }


    public FunctionNx1 getNthRoot(int n, int precision)
    {
        return FunctionNx1Service.getNthRoot(this, n, precision);
    }


    public FunctionNx1 negate()
    {
        return FunctionNx1Service.negate(this);
    }


    public FunctionNx1 reciprocate()
    {
        return FunctionNx1Service.reciprocate((FunctionNx1)this);
    }


    public FunctionNx1 exponentiate(ANumber exponent)
    {
        return FunctionNx1Service.exponentiate((FunctionNx1)this, exponent);
    }


    public FunctionNx1 getAbsoluteValue()
    {
        return FunctionNx1Service.getAbsoluteValue((FunctionNx1)this);
    }


    public FunctionNx1 differentiate(ANumber[] values)
    {
        return DifferentiationService.getPartialDerivative(this, values);
    }


    public FunctionNx1 differentiate(List<ANumber> values)
    {
        return DifferentiationService.getPartialDerivative(this, values);
    }


    public FunctionNx1 differentiateOnX(ANumber[] values, int precision)
    {
        return DifferentiationService.getPartialDerivative(this, values, precision);
    }


    public FunctionNx1 differentiateOnX(List<ANumber> values, int precision)
    {
        return DifferentiationService.getPartialDerivative(this, values, precision);
    }


    public FunctionNx1 differentiateOnX(ANumber[] values, int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivative(this, values, precision, orderOfDerivative);
    }


    public FunctionNx1 differentiateOnX(List<ANumber> values, int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivative(this, values, precision, orderOfDerivative);
    }


    @SuppressWarnings("unchecked")
    public FunctionNx1IF<ANumber, ANumber> getFunctionCasted()
    {
        return (FunctionNx1IF<ANumber, ANumber>)getFunction();
    }
}