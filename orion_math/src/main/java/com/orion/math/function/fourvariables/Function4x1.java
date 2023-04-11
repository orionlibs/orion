package com.orion.math.function.fourvariables;

import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain4x1;
import com.orion.math.number.ANumber;

public class Function4x1<T1, T2, T3, T4, R> extends Function
{
    public Function4x1(Function4x1IF<T1, T2, T3, T4, R> function)
    {
        super(function, 4);
    }


    public Function4x1(Function4x1IF<T1, T2, T3, T4, R> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
    }


    public Function4x1(Function4x1IF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        super(function, 4);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public Function4x1(Function4x1IF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        super(function, 4, domain, codomain);
        FunctionRules.isValid(function, indicesOfVariablesThatAreConstants, 4);
        setIndicesOfVariablesThatAreConstants(indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4, R> Function4x1<T1, T2, T3, T4, R> of(Function4x1IF<T1, T2, T3, T4, R> function)
    {
        return new Function4x1<T1, T2, T3, T4, R>(function);
    }


    public static <T1, T2, T3, T4, R> Function4x1<T1, T2, T3, T4, R> of(Function4x1IF<T1, T2, T3, T4, R> function, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4x1<T1, T2, T3, T4, R>(function, domain, codomain);
    }


    public static <T1, T2, T3, T4, R> Function4x1<T1, T2, T3, T4, R> of(Function4x1IF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants)
    {
        return new Function4x1<T1, T2, T3, T4, R>(function, indicesOfVariablesThatAreConstants);
    }


    public static <T1, T2, T3, T4, R> Function4x1<T1, T2, T3, T4, R> of(Function4x1IF<T1, T2, T3, T4, R> function, boolean[] indicesOfVariablesThatAreConstants, FunctionDomain4x1 domain, FunctionCodomain codomain)
    {
        return new Function4x1<T1, T2, T3, T4, R>(function, indicesOfVariablesThatAreConstants, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R run(T1 value1, T2 value2, T3 value3, T4 value4)
    {
        canFunctionRunWithGivenValues(value1, value2, value3, value4);
        return ((Function4x1IF<T1, T2, T3, T4, R>)getFunction()).run(value1, value2, value3, value4);
    }


    @SuppressWarnings("unchecked")
    public boolean isZeroFunction()
    {
        return ANumber.of(1).divideGET(((ANumber)run((T1)ANumber.of(1), (T2)ANumber.of(1), (T3)ANumber.of(1), (T4)ANumber.of(1)))).isInfinite();
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(ANumber x)
    {
        return Function4x1Service.add((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function4x1Service.add((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> add(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>... other)
    {
        return Function4x1Service.add((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(ANumber x)
    {
        return Function4x1Service.subtract((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> subtract(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function4x1Service.subtract((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(ANumber x)
    {
        return Function4x1Service.multiply((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> multiply(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function4x1Service.multiply((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(ANumber x)
    {
        return Function4x1Service.divide((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> divide(Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> other)
    {
        return Function4x1Service.divide((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getDouble()
    {
        return Function4x1Service.getDouble((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getHalf()
    {
        return Function4x1Service.getHalf((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquare()
    {
        return Function4x1Service.getSquare((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSumOfSquares()
    {
        return Function4x1Service.getSumOfSquares((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot()
    {
        return Function4x1Service.getSquareRoot((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getSquareRoot(int precision)
    {
        return Function4x1Service.getSquareRoot((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, precision);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(int n)
    {
        return Function4x1Service.getNthRoot((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, n);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getNthRoot(int n, int precision)
    {
        return Function4x1Service.getNthRoot((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, n, precision);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> negate()
    {
        return Function4x1Service.negate((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> reciprocate()
    {
        return Function4x1Service.reciprocate((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> exponentiate(ANumber exponent)
    {
        return Function4x1Service.exponentiate((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this, exponent);
    }


    @SuppressWarnings("unchecked")
    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getAbsoluteValue()
    {
        return Function4x1Service.getAbsoluteValue((Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber>)this);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX()
    {
        return DifferentiationService.getPartialDerivativeOnX(this);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnX(this, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z, ANumber w)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z, w);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z, w);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z, ANumber w, int precision)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z, w);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z, w, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnX(ANumber y, ANumber z, ANumber w, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(ANumber.of(true), y, z, w);
        return DifferentiationService.getPartialDerivativeOnX(this, y, z, w, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY()
    {
        return DifferentiationService.getPartialDerivativeOnY(this);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnY(this, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z, ANumber w)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z, w);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z, w);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z, ANumber w, int precision)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z, w);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z, w, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnY(ANumber x, ANumber z, ANumber w, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(x, ANumber.of(true), z, w);
        return DifferentiationService.getPartialDerivativeOnY(this, x, z, w, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ()
    {
        return DifferentiationService.getPartialDerivativeOnZ(this);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnZ(this, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnZ(this, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y, ANumber w)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true), w);
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y, w);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y, ANumber w, int precision)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true), w);
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y, w, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnZ(ANumber x, ANumber y, ANumber w, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(x, y, ANumber.of(true), w);
        return DifferentiationService.getPartialDerivativeOnZ(this, x, y, w, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW()
    {
        return DifferentiationService.getPartialDerivativeOnW(this);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW(int precision)
    {
        return DifferentiationService.getPartialDerivativeOnW(this, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW(int precision, int orderOfDerivative)
    {
        return DifferentiationService.getPartialDerivativeOnW(this, precision, orderOfDerivative);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW(ANumber x, ANumber y, ANumber z)
    {
        canFunctionRunWithGivenValues(x, y, z, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnW(this, x, y, z);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW(ANumber x, ANumber y, ANumber z, int precision)
    {
        canFunctionRunWithGivenValues(x, y, z, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnW(this, x, y, z, precision);
    }


    public Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> differentiateOnW(ANumber x, ANumber y, ANumber z, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValues(x, y, z, ANumber.of(true));
        return DifferentiationService.getPartialDerivativeOnW(this, x, y, z, precision, orderOfDerivative);
    }


    public FunctionDomain4x1 getDomain()
    {
        return (FunctionDomain4x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function4x1IF<T1, T2, T3, T4, R> getFunctionCasted()
    {
        return (Function4x1IF<T1, T2, T3, T4, R>)getFunction();
    }
}