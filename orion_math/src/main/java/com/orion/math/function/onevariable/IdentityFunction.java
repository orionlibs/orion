package com.orion.math.function.onevariable;

import com.orion.math.calculus.integral.IntegrationService;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;

public class IdentityFunction<T1> extends Function
{
    public IdentityFunction()
    {
        Function1x1IF<T1, T1> f = (T1 x) -> (x);
        setFunction(f);
        setIndicesOfVariablesThatAreConstants(new boolean[1]);
        setNumberOfVariables(1);
    }


    public IdentityFunction(FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        Function1x1IF<T1, T1> f = (T1 x) -> (x);
        setFunction(f);
        setIndicesOfVariablesThatAreConstants(new boolean[1]);
        setNumberOfVariables(1);
        FunctionRules.isValid(getFunction(), domain, codomain);
        setDomain(domain);
        setCodomain(codomain);
    }


    public static <T1> IdentityFunction<T1> of()
    {
        return new IdentityFunction<T1>();
    }


    public static <T1> IdentityFunction<T1> of(FunctionDomain1x1 domain, FunctionCodomain codomain)
    {
        return new IdentityFunction<T1>(domain, codomain);
    }


    public T1 run(T1 value)
    {
        canFunctionRunWithGivenValue(value);
        return value;
    }


    public ANumber differentiate(ANumber x)
    {
        canFunctionRunWithGivenValue(x);
        return ANumber.of(1);
    }


    public ANumber differentiate(ANumber x, int precision)
    {
        canFunctionRunWithGivenValue(x);
        return ANumber.of(1);
    }


    public ANumber differentiate(int orderOfDerivative, ANumber x)
    {
        canFunctionRunWithGivenValue(x);
        return (orderOfDerivative == 1) ? ANumber.of(1) : ANumber.of(0);
    }


    public ANumber differentiate(ANumber x, int precision, int orderOfDerivative)
    {
        canFunctionRunWithGivenValue(x);
        return (orderOfDerivative == 1) ? ANumber.of(1) : ANumber.of(0);
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
        return Function1x1Service.getAsPolynomial((IdentityFunction<ANumber>)this, intervalOfX);
    }


    @SuppressWarnings("unchecked")
    public Polynomial getAsPolynomial(Interval intervalOfX, int numberOfFunctionSampleValues)
    {
        return Function1x1Service.getAsPolynomial((IdentityFunction<ANumber>)this, intervalOfX, numberOfFunctionSampleValues);
    }


    public FunctionDomain1x1 getDomain()
    {
        return (FunctionDomain1x1)super.getDomain();
    }


    @SuppressWarnings("unchecked")
    public Function1x1<T1, T1> getFunctionCasted()
    {
        return Function1x1.<T1, T1>of((Function1x1IF<T1, T1>)getFunction());
    }
}