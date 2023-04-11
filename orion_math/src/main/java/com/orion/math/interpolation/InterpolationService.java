package com.orion.math.interpolation;

import com.orion.core.abstraction.OrionService;
import com.orion.core.tuple.Pair;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1Service;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.interpolation.tasks.DoBicubicSplineInterpolationOfFunctionValuesTask;
import com.orion.math.interpolation.tasks.DoLagrangeInterpolationOfFunctionValuesTask;
import com.orion.math.interpolation.tasks.DoPolynomialInterpolationOfFunctionValuesTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.polynomial.Polynomial;
import com.orion.math.polynomial.spline.PolynomialSpline;

public class InterpolationService extends OrionService
{
    public static PolynomialSpline interpolate(Vector xValues, Vector yValues)
    {
        return doBicubicSplineInterpolation(xValues, yValues);
    }


    public static Polynomial doPolynomialInterpolation(Vector xValues, Vector yValues)
    {
        return DoPolynomialInterpolationOfFunctionValuesTask.run(xValues, yValues);
    }


    public static Polynomial doPolynomialInterpolation(Function1x1<ANumber, ANumber> f, Interval intervalOfX)
    {
        Pair<ANumber[], ANumber[]> samples = Function1x1Service.getNValuesOfFunctionIncludingXValues(f, intervalOfX);
        return DoPolynomialInterpolationOfFunctionValuesTask.run(Vector.of(samples.getFirst()), Vector.of(samples.getSecond()));
    }


    public static Polynomial doPolynomialInterpolation(Function1x1<ANumber, ANumber> f, Interval intervalOfX, int numberOfFunctionSamples)
    {
        Pair<ANumber[], ANumber[]> samples = Function1x1Service.getNValuesOfFunctionIncludingXValues(f, intervalOfX, numberOfFunctionSamples);
        return DoPolynomialInterpolationOfFunctionValuesTask.run(Vector.of(samples.getFirst()), Vector.of(samples.getSecond()));
    }


    public static Polynomial doLagrangeInterpolation(Vector xValues, Vector yValues)
    {
        return DoLagrangeInterpolationOfFunctionValuesTask.run(xValues, yValues);
    }


    public static PolynomialSpline doBicubicSplineInterpolation(Vector xValues, Vector yValues)
    {
        return DoBicubicSplineInterpolationOfFunctionValuesTask.run(xValues, yValues);
    }
}