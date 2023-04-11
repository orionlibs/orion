package com.orion.math.polynomial.spline;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;

public class PolynomialSpline implements MathObject, Cloneable
{
    private Polynomial[] polynomials;
    private Vector knots;
    private Interval xValuesInterval;
    private ANumber intervalMinimum;
    private ANumber intervalMaximum;


    public PolynomialSpline(Polynomial[] polynomials, Vector knots)
    {
        PolynomialSplineRules.isValid(polynomials, knots);
        this.polynomials = polynomials;
        this.knots = knots;
        this.intervalMinimum = knots.get(knots.getFirstIndexOfMinimum());
        this.intervalMaximum = knots.get(knots.getFirstIndexOfMaximum());
        this.xValuesInterval = Interval.of(intervalMinimum, intervalMaximum);
    }


    public static PolynomialSpline of(Polynomial[] polynomials, Vector knots)
    {
        return new PolynomialSpline(polynomials, knots);
    }


    public ANumber getValueFor(ANumber x)
    {
        return PolynomialSplineService.getValueFor(this, x);
    }


    public Polynomial getPolynomial(int index)
    {
        return getPolynomials()[index];
    }


    public Polynomial getPolynomialCopy(int index)
    {
        return getPolynomials()[index].getCopy();
    }


    public ANumber getKnot(int degree)
    {
        return getKnots().get(degree);
    }


    public ANumber getKnotCopy(int degree)
    {
        return getKnot(degree).getCopy();
    }


    @Override
    public int hashCode()
    {
        return PolynomialSplineInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return PolynomialSplineInternalService.equals(this, object);
    }


    @Override
    public PolynomialSpline clone() throws CloneNotSupportedException
    {
        return (PolynomialSpline)CloningService.clone(this);
    }


    public PolynomialSpline getCopy()
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


    public Vector getKnots()
    {
        return this.knots;
    }


    public Vector getKnotsCopy()
    {
        return getKnots().getCopy();
    }


    public Polynomial[] getPolynomials()
    {
        return this.polynomials;
    }


    public Interval getxValuesInterval()
    {
        return this.xValuesInterval;
    }


    public ANumber getIntervalMinimum()
    {
        return this.intervalMinimum;
    }


    public ANumber getIntervalMaximum()
    {
        return this.intervalMaximum;
    }
}