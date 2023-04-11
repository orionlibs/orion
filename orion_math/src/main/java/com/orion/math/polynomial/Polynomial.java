package com.orion.math.polynomial;

import com.orion.core.object.CloningService;
import com.orion.core.tuple.Pair;
import com.orion.math.MathObject;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import java.util.List;
import java.util.stream.IntStream;

public class Polynomial implements MathObject, Cloneable
{
    //coefficients array has the form: a0 + a1x + ... + anx^n
    private ANumber[] coefficients;
    private int degree;


    public Polynomial()
    {
    }


    public Polynomial(ANumber[] coefficients)
    {
        buildPolynomial(coefficients);
    }


    public Polynomial(Vector coefficients)
    {
        PolynomialRules.isValid(coefficients);
        buildPolynomial(coefficients.getElements().getAsArray());
    }


    public Polynomial(List<ANumber> coefficients)
    {
        PolynomialRules.isValid(coefficients);
        buildPolynomial(coefficients.toArray(new ANumber[0]));
    }


    public static Polynomial of(ANumber[] coefficients)
    {
        return new Polynomial(coefficients);
    }


    public static Polynomial of(Vector coefficients)
    {
        return new Polynomial(coefficients);
    }


    public static Polynomial of(List<ANumber> coefficients)
    {
        return new Polynomial(coefficients);
    }


    private void buildPolynomial(ANumber[] coefficients)
    {
        PolynomialRules.isValid(coefficients);
        int maximumIndexWithNonZeroCoefficient = 0;

        for(int i = coefficients.length - 1; i >= 0; i--)
        {

            if(coefficients[i].isNotZero())
            {
                maximumIndexWithNonZeroCoefficient = i;
                break;
            }

        }

        ANumber[] temp = new ANumber[maximumIndexWithNonZeroCoefficient + 1];
        IntStream.range(0, maximumIndexWithNonZeroCoefficient + 1).forEach(i -> temp[i] = coefficients[i]);
        this.coefficients = temp;
        this.degree = maximumIndexWithNonZeroCoefficient;
    }


    public Function1x1<ANumber, ANumber> getAsFunction()
    {
        return PolynomialService.getAsFunction(this);
    }


    public void normalise()
    {
        PolynomialService.normalise(this);
    }


    public Polynomial normaliseGET()
    {
        Polynomial temp = getCopy();
        temp.normalise();
        return temp;
    }


    public ANumber getValueFor(ANumber x)
    {
        return PolynomialService.getValueFor(this, x);
    }


    public ANumber getValueFor(Number x)
    {
        NumberRules.isNotNull(x);
        return getValueFor(ANumber.of(x));
    }


    public void negate()
    {
        PolynomialService.negate(this);
    }


    public Polynomial negateGET()
    {
        Polynomial temp = getCopy();
        temp.negate();
        return temp;
    }


    public Polynomial add(Polynomial other)
    {
        return PolynomialService.add(this, other);
    }


    public Polynomial add(Polynomial[] others)
    {
        return PolynomialService.add(this, others);
    }


    public Polynomial add(List<Polynomial> others)
    {
        return PolynomialService.add(this, others);
    }


    public Polynomial subtract(Polynomial other)
    {
        return PolynomialService.subtract(this, other);
    }


    public Polynomial multiply(ANumber x)
    {
        return PolynomialService.multiply(this, x);
    }


    public Polynomial multiply(Polynomial other)
    {
        return PolynomialService.multiply(this, other);
    }


    public Polynomial divide(ANumber x)
    {
        return PolynomialService.divide(this, x);
    }


    public Pair<Polynomial, Polynomial> divide(Polynomial y)
    {
        return PolynomialService.divide(this, y);
    }


    public Polynomial getCauchyPolynomial()
    {
        return PolynomialService.getCauchyPolynomial(this);
    }


    public ANumber[] getRoots(Interval intervalOfValuesToSearch)
    {
        return PolynomialService.getRoots(this, intervalOfValuesToSearch);
    }


    public ANumber[] getRoots(Interval intervalOfValuesToSearch, int precision)
    {
        return PolynomialService.getRoots(this, intervalOfValuesToSearch, precision);
    }


    public Polynomial differentiate()
    {
        return PolynomialService.differentiate(this);
    }


    public Polynomial differentiate(int orderOfDerivative)
    {
        return PolynomialService.differentiate(this, orderOfDerivative);
    }


    public ANumber differentiate(ANumber x)
    {
        return PolynomialService.differentiate(this, x);
    }


    public ANumber differentiate(ANumber x, int orderOfDerivative)
    {
        return PolynomialService.differentiate(this, x, orderOfDerivative);
    }


    public Polynomial integrate()
    {
        return PolynomialService.integrate(this);
    }


    public ANumber integrate(Interval integrationInterval)
    {
        return PolynomialService.integrate(this, integrationInterval);
    }


    public ANumber[] getNValuesOfPolynomial(Interval domain, int numberOfSampleValues)
    {
        return PolynomialService.getNValuesOfPolynomial(this, domain, numberOfSampleValues);
    }


    public boolean isZero()
    {
        return PolynomialService.isZero(this);
    }


    public boolean isNotZero()
    {
        return PolynomialService.isNotZero(this);
    }


    public ANumber getZeroDegreeCoefficient()
    {
        return getCoefficients()[0];
    }


    public ANumber getNDegreeCoefficient()
    {
        return getCoefficients()[getDegree()];
    }


    public ANumber getCoefficient(int degree)
    {
        PolynomialRules.isValidDegree(this, degree);
        return getCoefficients()[degree];
    }


    public ANumber getCoefficientCopy(int degree)
    {
        PolynomialRules.isValidDegree(this, degree);
        return getCoefficients()[degree].getCopy();
    }


    @Override
    public int hashCode()
    {
        return PolynomialInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PolynomialInternalService.equals(this, object);
    }


    @Override
    public Polynomial clone() throws CloneNotSupportedException
    {
        return (Polynomial)CloningService.clone(this);
    }


    public Polynomial getCopy()
    {

        try
        {
            return this.clone();
        }
        catch(CloneNotSupportedException e)
        {
            e.printStackTrace();
        }

        return null;
    }


    public int getDegree()
    {
        return this.degree;
    }


    public ANumber[] getCoefficients()
    {
        return this.coefficients;
    }


    public ANumber[] getCoefficientsCopy()
    {
        ANumber[] temp = new ANumber[getDegree() + 1];
        IntStream.range(0, getDegree() + 1).forEach(i -> temp[i] = getCoefficient(i).getCopy());
        return temp;
    }


    protected void setDegree(int degree)
    {
        this.degree = degree;
    }


    protected void setCoefficients(ANumber[] coefficients)
    {
        this.coefficients = coefficients;
    }
}