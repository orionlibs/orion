package com.orion.math.function.twovariables;

import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain2x1;
import com.orion.math.number.ANumber;

public class Function2x1<T1, T2, R> extends Function
{
    public Function2x1(Function2x1IF<T1, T2, R> function)
    {
        super(function, 2);
    }


    public Function2x1(Function2x1IF<T1, T2, R> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
    }


    public Function2x1(Function2x1IF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 2);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function2x1(Function2x1IF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        super(function, 2, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 2);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, R> Function2x1<T1, T2, R> of(Function2x1IF<T1, T2, R> function)
    {
        return new Function2x1<T1, T2, R>(function);
    }


    public static <T1, T2, R> Function2x1<T1, T2, R> of(Function2x1IF<T1, T2, R> function, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2x1<T1, T2, R>(function, domain, codomain);
    }


    public static <T1, T2, R> Function2x1<T1, T2, R> of(Function2x1IF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function2x1<T1, T2, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, R> Function2x1<T1, T2, R> of(Function2x1IF<T1, T2, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain2x1 domain, FunctionCodomain codomain)
    {
        return new Function2x1<T1, T2, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R run(T1 value1, T2 value2)
    {
        canFunctionRunWithGivenValues(value1, value2);
        return ((Function2x1IF<T1, T2, R>)getFunction()).run(value1, value2);
    }


    @SuppressWarnings("unchecked")
    public boolean isZeroFunction()
    {
        return ANumber.of(1).divideGET(((ANumber)run((T1)ANumber.of(1), (T2)ANumber.of(1)))).isInfinite();
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> add(ANumber x)
    {
        return Function2x1Service.add((Function2x1<ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber> other)
    {
        return Function2x1Service.add((Function2x1<ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> add(Function2x1<ANumber, ANumber, ANumber>... other)
    {
        return Function2x1Service.add((Function2x1<ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> subtract(ANumber x)
    {
        return Function2x1Service.subtract((Function2x1<ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> subtract(Function2x1<ANumber, ANumber, ANumber> other)
    {
        return Function2x1Service.subtract((Function2x1<ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> multiply(ANumber x)
    {
        return Function2x1Service.multiply((Function2x1<ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> multiply(Function2x1<ANumber, ANumber, ANumber> other)
    {
        return Function2x1Service.multiply((Function2x1<ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> divide(ANumber x)
    {
        return Function2x1Service.divide((Function2x1<ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> divide(Function2x1<ANumber, ANumber, ANumber> other)
    {
        return Function2x1Service.divide((Function2x1<ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getDouble()
    {
        return Function2x1Service.getDouble((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getHalf()
    {
        return Function2x1Service.getHalf((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getSquare()
    {
        return Function2x1Service.getSquare((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getSumOfSquares()
    {
        return Function2x1Service.getSumOfSquares((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getSquareRoot()
    {
        return Function2x1Service.getSquareRoot((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getSquareRoot(int precision)
    {
        return Function2x1Service.getSquareRoot((Function2x1<ANumber, ANumber, ANumber>)this, precision);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getNthRoot(int n)
    {
        return Function2x1Service.getNthRoot((Function2x1<ANumber, ANumber, ANumber>)this, n);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getNthRoot(int n, int precision)
    {
        return Function2x1Service.getNthRoot((Function2x1<ANumber, ANumber, ANumber>)this, n, precision);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> negate()
    {
        return Function2x1Service.negate((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> reciprocate()
    {
        return Function2x1Service.reciprocate((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> exponentiate(ANumber exponent)
    {
        return Function2x1Service.exponentiate((Function2x1<ANumber, ANumber, ANumber>)this, exponent);
    }


    @SuppressWarnings("unchecked")
    public Function2x1<ANumber, ANumber, ANumber> getAbsoluteValue()
    {
        return Function2x1Service.getAbsoluteValue((Function2x1<ANumber, ANumber, ANumber>)this);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX()
    {
        return DifferentiationService.getPartialDerivativeOnX(this);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision, orderOfDerivative);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX(ANumber y)
    {
        canFunctionRunWithGivenValue(y);
        return DifferentiationService.getPartialDerivativeOnX(this, y);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX(ANumber y, int precision)
    {
        canFunctionRunWithGivenValue(y);
        return DifferentiationService.getPartialDerivativeOnX(this, y, precision);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnX(ANumber y, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValue(y);
        return DifferentiationService.getPartialDerivativeOnX(this, y, precision, orderOfDerivative);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY()
    {
        return DifferentiationService.getPartialDerivativeOnY(this);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision, orderOfDerivative);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY(ANumber x)
    {
        canFunctionRunWithGivenValue(x);
        return DifferentiationService.getPartialDerivativeOnY(this, x);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY(ANumber x, int precision)
    {
        canFunctionRunWithGivenValue(x);
        return DifferentiationService.getPartialDerivativeOnY(this, x, precision);
    }


    public Function2x1<ANumber, ANumber, ANumber> differentiateOnY(ANumber x, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValue(x);
        return DifferentiationService.getPartialDerivativeOnX(this, x, precision, orderOfDerivative);
    }


    public FunctionDomain2x1 getDomain()
    {
        return (FunctionDomain2x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function2x1IF<T1, T2, R> getFunctionCasted()
    {
        return (Function2x1IF<T1, T2, R>)getFunction();
    }
}