package com.orion.math.function.threevariables;

import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain3x1;
import com.orion.math.number.ANumber;

public class Function3x1<T1, T2, T3, R> extends Function
{
    public Function3x1(Function3x1IF<T1, T2, T3, R> function)
    {
        super(function, 3);
    }


    public Function3x1(Function3x1IF<T1, T2, T3, R> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, 3, domain, codomain);
    }


    public Function3x1(Function3x1IF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 3);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function3x1(Function3x1IF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        super(function, 3, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 3);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, R> Function3x1<T1, T2, T3, R> of(Function3x1IF<T1, T2, T3, R> function)
    {
        return new Function3x1<T1, T2, T3, R>(function);
    }


    public static <T1, T2, T3, R> Function3x1<T1, T2, T3, R> of(Function3x1IF<T1, T2, T3, R> function, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3x1<T1, T2, T3, R>(function, domain, codomain);
    }


    public static <T1, T2, T3, R> Function3x1<T1, T2, T3, R> of(Function3x1IF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function3x1<T1, T2, T3, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, R> Function3x1<T1, T2, T3, R> of(Function3x1IF<T1, T2, T3, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain3x1 domain, FunctionCodomain codomain)
    {
        return new Function3x1<T1, T2, T3, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R run(T1 value1, T2 value2, T3 value3)
    {
        canFunctionRunWithGivenValues(value1, value2, value3);
        return ((Function3x1IF<T1, T2, T3, R>)getFunction()).run(value1, value2, value3);
    }


    @SuppressWarnings("unchecked")
    public boolean isZeroFunction()
    {
        return ANumber.of(1).divideGET(((ANumber)run((T1)ANumber.of(1), (T2)ANumber.of(1), (T3)ANumber.of(1)))).isInfinite();
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> add(ANumber x)
    {
        return Function3x1Service.add((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function3x1Service.add((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> add(Function3x1<ANumber, ANumber, ANumber, ANumber>... other)
    {
        return Function3x1Service.add((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(ANumber x)
    {
        return Function3x1Service.subtract((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> subtract(Function3x1<ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function3x1Service.subtract((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(ANumber x)
    {
        return Function3x1Service.multiply((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> multiply(Function3x1<ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function3x1Service.multiply((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> divide(ANumber x)
    {
        return Function3x1Service.divide((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> divide(Function3x1<ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function3x1Service.divide((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getDouble()
    {
        return Function3x1Service.getDouble((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getHalf()
    {
        return Function3x1Service.getHalf((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getSquare()
    {
        return Function3x1Service.getSquare((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getSumOfSquares()
    {
        return Function3x1Service.getSumOfSquares((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot()
    {
        return Function3x1Service.getSquareRoot((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getSquareRoot(int precision)
    {
        return Function3x1Service.getSquareRoot((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, precision);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(int n)
    {
        return Function3x1Service.getNthRoot((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, n);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getNthRoot(int n, int precision)
    {
        return Function3x1Service.getNthRoot((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, n, precision);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> negate()
    {
        return Function3x1Service.negate((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> reciprocate()
    {
        return Function3x1Service.reciprocate((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> exponentiate(ANumber exponent)
    {
        return Function3x1Service.exponentiate((Function3x1<ANumber, ANumber, ANumber, ANumber>)this, exponent);
    }


    @SuppressWarnings("unchecked")
    public Function3x1<ANumber, ANumber, ANumber, ANumber> getAbsoluteValue()
    {
        return Function3x1Service.getAbsoluteValue((Function3x1<ANumber, ANumber, ANumber, ANumber>)this);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX()
    {
        return DifferentiationService.getPartialDerivativeOnX(this);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision, orderOfDerivative);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z, int precision)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z, precision, orderOfDerivative);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY()
    {
        return DifferentiationService.getPartialDerivativeOnY(this);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision, orderOfDerivative);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z, int precision)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z, precision, orderOfDerivative);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ()
    {
        return DifferentiationService.getPartialDerivativeOnZ(this);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnZ(this, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnZ(this, precision, orderOfDerivative);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y, int precision)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y, precision);
    }


    public Function3x1<ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y, precision, orderOfDerivative);
    }


    public FunctionDomain3x1 getDomain()
    {
        return (FunctionDomain3x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function3x1IF<T1, T2, T3, R> getFunctionCasted()
    {
        return (Function3x1IF<T1, T2, T3, R>)getFunction();
    }
}