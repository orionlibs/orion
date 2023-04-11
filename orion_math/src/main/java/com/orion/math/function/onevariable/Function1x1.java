package com.orion.math.function.onevariable;

import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.calculus.integral.IntegrationService;
import com.orion.math.function.Function;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.precision.Precision;
import com.orion.math.polynomial.Polynomial;

public class Function1x1<T1, R> extends Function
{
    public static final Function1x1<ANumber, ANumber> Zero = Function1x1.<ANumber, ANumber>of(x -> ANumber.of(0));
    public static final Function1x1<ANumber, ANumber> One = Function1x1.<ANumber, ANumber>of(x -> ANumber.of(1));
    public static final Function1x1<ANumber, ANumber> IdentityFunction = Function1x1.<ANumber, ANumber>of(x -> x);


    public Function1x1(Function1x1IF<T1, R> function)
    {
        super(function, 1);
    }


    public Function1x1(Function1x1IF<T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        super(function, 1, domain, codomain);
    }


    public static <T1, R> Function1x1<T1, R> of(Function1x1IF<T1, R> function)
    {
        return new Function1x1<T1, R>(function);
    }


    public static <T1, R> Function1x1<T1, R> of(Function1x1IF<T1, R> function, FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new Function1x1<T1, R>(function, domain, codomain);
    }


    @SuppressWarnings("unchecked")
    public R run(T1 value)
    {
        canFunctionRunWithGivenValue(value);
        return ((Function1x1IF<T1, R>)getFunction()).run(value);
    }


    @SuppressWarnings("unchecked")
    public boolean isZeroFunction()
    {
        return ANumber.of(1).divideGET(((ANumber)run((T1)ANumber.of(1)))).isInfinite();
    }


    public boolean isNotZeroFunction()
    {
        return !isZeroFunction();
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> add(ANumber x)
    {
        return Function1x1Service.add((Function1x1<ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber> other)
    {
        return Function1x1Service.add((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber>... other)
    {
        return Function1x1Service.add((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> subtract(ANumber x)
    {
        return Function1x1Service.subtract((Function1x1<ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> subtract(Function1x1<ANumber, ANumber> other)
    {
        return Function1x1Service.subtract((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> multiply(ANumber x)
    {
        return Function1x1Service.multiply((Function1x1<ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> multiply(Function1x1<ANumber, ANumber> other)
    {
        return Function1x1Service.multiply((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> divide(ANumber x)
    {
        return Function1x1Service.divide((Function1x1<ANumber, ANumber>)this, x);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> divide(Function1x1<ANumber, ANumber> other)
    {
        return Function1x1Service.divide((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getDouble()
    {
        return Function1x1Service.getDouble((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHalf()
    {
        return Function1x1Service.getHalf((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSquare()
    {
        return Function1x1Service.getSquare((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSumOfSquares()
    {
        return Function1x1Service.getSumOfSquares((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSquareRoot()
    {
        return Function1x1Service.getSquareRoot((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSquareRoot(int precision)
    {
        return Function1x1Service.getSquareRoot((Function1x1<ANumber, ANumber>)this, precision);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getNthRoot(int n)
    {
        return Function1x1Service.getNthRoot((Function1x1<ANumber, ANumber>)this, n);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getNthRoot(int n, int precision)
    {
        return Function1x1Service.getNthRoot((Function1x1<ANumber, ANumber>)this, n, precision);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> negate()
    {
        return Function1x1Service.negate((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> reciprocate()
    {
        return Function1x1Service.reciprocate((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> compose(Function1x1<ANumber, ANumber> other)
    {
        return Function1x1Service.compose((Function1x1<ANumber, ANumber>)this, other);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> compose(Function1x1<ANumber, ANumber>[] functions)
    {
        return Function1x1Service.compose((Function1x1<ANumber, ANumber>)this, functions);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getInverse()
    {
        return Function1x1Service.getInverse((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSineInRadians()
    {
        return Function1x1Service.getSineInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getSineInDegrees()
    {
        return Function1x1Service.getSineInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArcsineAsRadians()
    {
        return Function1x1Service.getArcsineAsRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArcsineAsDegrees()
    {
        return Function1x1Service.getArcsineAsDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getCosineInRadians()
    {
        return Function1x1Service.getCosineInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getCosineInDegrees()
    {
        return Function1x1Service.getCosineInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArccosineAsRadians()
    {
        return Function1x1Service.getArccosineAsRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArccosineAsDegrees()
    {
        return Function1x1Service.getArccosineAsDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getTangentInRadians()
    {
        return Function1x1Service.getTangentInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getTangentInDegrees()
    {
        return Function1x1Service.getTangentInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArctangentAsRadians()
    {
        return Function1x1Service.getArctangentAsRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getArctangentAsDegrees()
    {
        return Function1x1Service.getArctangentAsDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicSineInRadians()
    {
        return Function1x1Service.getHyperbolicSineInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicSineInDegrees()
    {
        return Function1x1Service.getHyperbolicSineInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicCosineInRadians()
    {
        return Function1x1Service.getHyperbolicCosineInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicCosineInDegrees()
    {
        return Function1x1Service.getHyperbolicCosineInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicTangentInRadians()
    {
        return Function1x1Service.getHyperbolicTangentInRadians((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getHyperbolicTangentInDegrees()
    {
        return Function1x1Service.getHyperbolicTangentInDegrees((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getNeperianLogarithm()
    {
        return Function1x1Service.getNeperianLogarithm((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getNeperianLogarithm(int precision)
    {
        return Function1x1Service.getNeperianLogarithm((Function1x1<ANumber, ANumber>)this, precision);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getLogarithm(ANumber base)
    {
        return Function1x1Service.getLogarithm((Function1x1<ANumber, ANumber>)this, base);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getLogarithm(ANumber base, int precision)
    {
        return Function1x1Service.getLogarithm((Function1x1<ANumber, ANumber>)this, base, precision);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> exponentiate(ANumber exponent)
    {
        return Function1x1Service.exponentiate((Function1x1<ANumber, ANumber>)this, exponent);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> getAbsoluteValue()
    {
        return Function1x1Service.getAbsoluteValue((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public Function1x1<ANumber, ANumber> conjugate()
    {
        return Function1x1Service.conjugate((Function1x1<ANumber, ANumber>)this);
    }


    @SuppressWarnings("unchecked")
    public boolean isFunctionInjectiveForXValues(ANumber[] xValues)
    {
        return Function1x1Service.isFunctionInjectiveForXValues((Function1x1<ANumber, ANumber>)this, xValues);
    }


    @SuppressWarnings("unchecked")
    public boolean isInvertible()
    {
        return Function1x1Service.isInvertible((Function1x1<ANumber, ANumber>)this, getDomain().getIntervalOfVariable1());
    }


    public Function1x1<ANumber, ANumber> differentiate()
    {
        return DifferentiationService.differentiate(this);
    }


    public Function1x1<ANumber, ANumber> differentiate(int precision)
    {
        return DifferentiationService.differentiate(this, precision);
    }


    public Function1x1<ANumber, ANumber> differentiate(int precision, int orderOfDerivative)
    {
        return DifferentiationService.differentiate(this, precision, orderOfDerivative);
    }


    public ANumber differentiate(ANumber x)
    {
        canFunctionRunWithGivenValue(x);
        return differentiate().run(x);
    }


    public ANumber differentiate(ANumber x, int precision)
    {
        canFunctionRunWithGivenValue(x);
        return differentiate(precision, 1).run(x);
    }


    public ANumber differentiate(int orderOfDerivative, ANumber x)
    {
        canFunctionRunWithGivenValue(x);
        return differentiate(Precision.precision, orderOfDerivative).run(x);
    }


    public ANumber differentiate(ANumber x, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValue(x);
        return differentiate(precision, orderOfDerivative).run(x);
    }


    public ANumber integrate(Interval integrationInterval)
    {
        canFunctionRunWithGivenInterval(integrationInterval);
        return IntegrationService.integrate(this, integrationInterval);
    }


    public ANumber integrate(Interval integrationInterval, int iterations)
    {
        canFunctionRunWithGivenInterval(integrationInterval);
        return IntegrationService.integrate(this, integrationInterval, iterations);
    }


    @SuppressWarnings("unchecked")
    public Polynomial getAsPolynomial(Interval intervalOfX)
    {
        return Function1x1Service.getAsPolynomial((Function1x1<ANumber, ANumber>)this, intervalOfX);
    }


    @SuppressWarnings("unchecked")
    public Polynomial getAsPolynomial(Interval intervalOfX, int numberOfFunctionSampleValues)
    {
        return Function1x1Service.getAsPolynomial((Function1x1<ANumber, ANumber>)this, intervalOfX, numberOfFunctionSampleValues);
    }


    public FunctionDomain1x1 getDomain()
    {
        return (FunctionDomain1x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function1x1IF<T1, R> getFunctionCasted()
    {
        return (Function1x1IF<T1, R>)getFunction();
    }
}