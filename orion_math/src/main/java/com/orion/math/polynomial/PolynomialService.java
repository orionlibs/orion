package com.orion.math.polynomial;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.list.OrionList;
import com.orion.core.data.structure.list.type.OrionArrayList;
import com.orion.core.tuple.Pair;
import com.orion.core.tuple.Quadruple;
import com.orion.core.tuple.Triple;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.tasks.onevariable.roots.GetRootOfFunction1x1UsingNewtonRaphsonTask;
import com.orion.math.function.tasks.onevariable.roots.GetRootsOfFunction1x1UsingNewtonRaphsonTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.precision.Precision;
import com.orion.math.polynomial.tasks.calculation.DifferentiatePolynomialTask;
import com.orion.math.polynomial.tasks.calculation.GetChebyshevPolynomialTask;
import com.orion.math.polynomial.tasks.calculation.GetHermitePolynomialTask;
import com.orion.math.polynomial.tasks.calculation.GetJacobiPolynomialTask;
import com.orion.math.polynomial.tasks.calculation.GetLaguerrePolynomialTask;
import com.orion.math.polynomial.tasks.calculation.GetLegendrePolynomialTask;
import com.orion.math.polynomial.tasks.calculation.IntegratePolynomialTask;
import com.orion.math.polynomial.tasks.convert.GetPolynomialAsFunctionTask;
import com.orion.math.polynomial.tasks.query.GetNValuesOfPolynomialTask;
import com.orion.math.polynomial.tasks.query.GetValueForPolynomialTask;
import com.orion.math.polynomial.tasks.root.GetRootsOfCubicPolynomialTask;
import com.orion.math.polynomial.tasks.root.GetRootsOfQuadraticPolynomialTask;
import com.orion.math.polynomial.tasks.root.GetRootsOfQuarticPolynomialTask;
import com.orion.math.polynomial.tasks.transform.AddPolynomialTask;
import com.orion.math.polynomial.tasks.transform.DividePolynomialTask;
import com.orion.math.polynomial.tasks.transform.MultiplyPolynomialTask;
import com.orion.math.streams.NumberArrayStream;
import java.util.List;
import java.util.stream.IntStream;

public class PolynomialService extends OrionService
{
    public static Function1x1<ANumber, ANumber> getAsFunction(Polynomial polynomial)
    {
        return GetPolynomialAsFunctionTask.run(polynomial);
    }


    public static void normalise(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        ANumber[] coefficients = polynomial.getCoefficients();
        IntStream.range(0, coefficients.length - 1).forEach(i -> coefficients[i].divide(coefficients[coefficients.length - 1]));
        coefficients[coefficients.length - 1] = ANumber.of(1);
    }


    public static ANumber getRootOfLinearPolynomial(LinearPolynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        ANumber b = polynomial.getCoefficient(0);
        ANumber a = polynomial.getCoefficient(1);
        return b.negateGET().divideGET(a);
    }


    public static Pair<ANumber, ANumber> getRootsOfQuadraticPolynomial(QuadraticPolynomial polynomial)
    {
        return GetRootsOfQuadraticPolynomialTask.run(polynomial, Precision.precision);
    }


    public static Pair<ANumber, ANumber> getRootsOfQuadraticPolynomial(QuadraticPolynomial polynomial, int squareRootPrecision)
    {
        return GetRootsOfQuadraticPolynomialTask.run(polynomial, squareRootPrecision);
    }


    public static Triple<ANumber, ANumber, ANumber> getRootsOfCubicPolynomial(CubicPolynomial polynomial)
    {
        return GetRootsOfCubicPolynomialTask.run(polynomial, Precision.precision);
    }


    public static Triple<ANumber, ANumber, ANumber> getRootsOfCubicPolynomial(CubicPolynomial polynomial, int nthRootPrecision)
    {
        return GetRootsOfCubicPolynomialTask.run(polynomial, nthRootPrecision);
    }


    public static Quadruple<ANumber, ANumber, ANumber, ANumber> getRootsOfQuarticPolynomial(QuarticPolynomial polynomial)
    {
        return GetRootsOfQuarticPolynomialTask.run(polynomial, Precision.precision);
    }


    public static Quadruple<ANumber, ANumber, ANumber, ANumber> getRootsOfQuarticPolynomial(QuarticPolynomial polynomial, int nthRootPrecision)
    {
        return GetRootsOfQuarticPolynomialTask.run(polynomial, nthRootPrecision);
    }


    public static ANumber[] getRoots(Polynomial polynomial, Interval intervalToSearchForRoots)
    {
        return getRoots(polynomial, intervalToSearchForRoots, Precision.precision);
    }


    public static ANumber[] getNValuesOfPolynomial(Polynomial polynomial, Interval domain, int numberOfSampleValues)
    {
        return GetNValuesOfPolynomialTask.run(polynomial, domain, numberOfSampleValues);
    }


    public static ANumber[] getRoots(Polynomial polynomial, Interval intervalToSearchForRoots, int precision)
    {
        PolynomialRules.isValid(polynomial);

        if(polynomial.getDegree() == 1)
        {
            return new ANumber[]
            {getRootOfLinearPolynomial(LinearPolynomial.of(polynomial.getCoefficients()))};
        }
        else if(polynomial.getDegree() == 2)
        {
            Pair<ANumber, ANumber> roots = getRootsOfQuadraticPolynomial(QuadraticPolynomial.of(polynomial.getCoefficients()), precision);
            return new ANumber[]
            {roots.getFirst(), roots.getSecond()};
        }
        else if(polynomial.getDegree() == 3)
        {
            Triple<ANumber, ANumber, ANumber> roots = getRootsOfCubicPolynomial(CubicPolynomial.of(polynomial.getCoefficients()), precision);
            return new ANumber[]
            {roots.getFirst(), roots.getSecond(), roots.getThird()};
        }
        else if(polynomial.getDegree() == 4)
        {
            Quadruple<ANumber, ANumber, ANumber, ANumber> roots = getRootsOfQuarticPolynomial(QuarticPolynomial.of(polynomial.getCoefficients()), precision);
            return new ANumber[]
            {roots.getFirst(), roots.getSecond(), roots.getThird(), roots.getFourth()};
        }
        else
        {
            return GetRootsOfFunction1x1UsingNewtonRaphsonTask.run(polynomial.getAsFunction(), intervalToSearchForRoots, precision);
        }

    }


    public static ANumber getRootUsingNewtonRaphson(Polynomial polynomial, ANumber x0)
    {
        return GetRootOfFunction1x1UsingNewtonRaphsonTask.run(polynomial, x0, Precision.precision);
    }


    public static ANumber getRootUsingNewtonRaphson(Polynomial polynomial, ANumber x0, int precision)
    {
        return GetRootOfFunction1x1UsingNewtonRaphsonTask.run(polynomial, x0, precision);
    }


    public static ANumber[] getRootsUsingNewtonRaphson(Polynomial polynomial, Interval intervalToSearchForRoots)
    {
        return GetRootsOfFunction1x1UsingNewtonRaphsonTask.run(polynomial.getAsFunction(), intervalToSearchForRoots, Precision.precision);
    }


    public static ANumber[] getRootsUsingNewtonRaphson(Polynomial polynomial, Interval intervalToSearchForRoots, int precision)
    {
        return GetRootsOfFunction1x1UsingNewtonRaphsonTask.run(polynomial.getAsFunction(), intervalToSearchForRoots, precision);
    }


    public static ANumber getValueFor(Polynomial polynomial, ANumber x)
    {
        return GetValueForPolynomialTask.run(polynomial, x);
    }


    public static void negate(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        NumberArrayStream.negateAll(polynomial.getCoefficients());
    }


    public static Polynomial add(Polynomial polynomial1, Polynomial polynomial2)
    {
        return AddPolynomialTask.run(polynomial1, polynomial2);
    }


    public static Polynomial add(Polynomial polynomial1, Polynomial[] polynomials)
    {
        return AddPolynomialTask.run(polynomial1, polynomials);
    }


    public static Polynomial add(Polynomial polynomial1, List<Polynomial> polynomials)
    {
        return AddPolynomialTask.run(polynomial1, polynomials);
    }


    public static Polynomial subtract(Polynomial polynomial1, Polynomial polynomial2)
    {
        return AddPolynomialTask.run(polynomial1, polynomial2.negateGET());
    }


    public static Polynomial multiply(Polynomial polynomial, ANumber x)
    {
        return MultiplyPolynomialTask.run(polynomial, x);
    }


    public static Polynomial multiply(Polynomial polynomial1, Polynomial polynomial2)
    {
        return MultiplyPolynomialTask.run(polynomial1, polynomial2);
    }


    public static Polynomial divide(Polynomial polynomial, ANumber x)
    {
        return DividePolynomialTask.run(polynomial, x);
    }


    public static Pair<Polynomial, Polynomial> divide(Polynomial x, Polynomial y)
    {
        return DividePolynomialTask.run(x, y);
    }


    public static Polynomial getCauchyPolynomial(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        ANumber[] coefficients = ArithmeticService.getAbsoluteValues(polynomial.getCoefficients());
        coefficients[polynomial.getDegree()].negate();
        return Polynomial.of(coefficients);
    }


    public static Polynomial differentiate(Polynomial polynomial)
    {
        return DifferentiatePolynomialTask.run(polynomial);
    }


    public static Polynomial differentiate(Polynomial polynomial, int orderOfDerivative)
    {
        return DifferentiatePolynomialTask.run(polynomial, orderOfDerivative);
    }


    public static ANumber differentiate(Polynomial polynomial, ANumber x)
    {
        return differentiate(polynomial).getValueFor(x);
    }


    public static ANumber differentiate(Polynomial polynomial, ANumber x, int orderOfDerivative)
    {
        return differentiate(polynomial, orderOfDerivative).getValueFor(x);
    }


    public static Polynomial integrate(Polynomial polynomial)
    {
        return IntegratePolynomialTask.run(polynomial);
    }


    public static ANumber integrate(Polynomial polynomial, Interval integrationInterval)
    {
        return IntegratePolynomialTask.run(polynomial, integrationInterval);
    }


    public static boolean isZero(Polynomial polynomial)
    {
        PolynomialRules.isValid(polynomial);
        OrionList<ANumber> coefficients = OrionArrayList.of(polynomial.getCoefficients());
        return !coefficients.findAny((ANumber coefficient) -> coefficient.isNotZero());
    }


    public static boolean isNotZero(Polynomial polynomial)
    {
        return !isZero(polynomial);
    }


    public static Polynomial getChebyshevPolynomial(int degree)
    {
        return GetChebyshevPolynomialTask.run(degree);
    }


    public static Polynomial getHermitePolynomial(int degree)
    {
        return GetHermitePolynomialTask.run(degree);
    }


    public static Polynomial getLaguerrePolynomial(int degree)
    {
        return GetLaguerrePolynomialTask.run(degree);
    }


    public static Polynomial getLegendrePolynomial(int degree)
    {
        return GetLegendrePolynomialTask.run(degree);
    }


    public static Polynomial getJacobiPolynomial(int degree, int firstExponent, int secondExponent)
    {
        return GetJacobiPolynomialTask.run(degree, firstExponent, secondExponent);
    }
}