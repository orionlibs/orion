package com.orion.math.function;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.PolynomialRules;
import com.orion.math.polynomial.PolynomialService;

public class PolynomialFunction extends Orion
{
    private static Function1x1<ANumber, ANumber> formula;
    private Polynomial polynomial;


    public PolynomialFunction(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        this.polynomial = polynomial;
        formula = polynomial.getAsFunction();
    }


    public static PolynomialFunction of(Polynomial polynomial)
    {
        return new PolynomialFunction(polynomial);
    }


    public ANumber run(ANumber value)
    {
        return formula.run(value);
    }


    public Polynomial differentiate()
    {
        return PolynomialService.differentiate(getPolynomial());
    }


    public Polynomial differentiate(int orderOfDerivative)
    {
        return PolynomialService.differentiate(getPolynomial(), orderOfDerivative);
    }


    public ANumber differentiate(ANumber x)
    {
        return PolynomialService.differentiate(getPolynomial(), x);
    }


    public ANumber differentiate(ANumber x, int orderOfDerivative)
    {
        return PolynomialService.differentiate(getPolynomial(), x, orderOfDerivative);
    }


    public Polynomial integrate()
    {
        return PolynomialService.integrate(getPolynomial());
    }


    public ANumber integrate(Interval integrationInterval)
    {
        return PolynomialService.integrate(getPolynomial(), integrationInterval);
    }


    public Polynomial getPolynomial()
    {
        return this.polynomial;
    }
}