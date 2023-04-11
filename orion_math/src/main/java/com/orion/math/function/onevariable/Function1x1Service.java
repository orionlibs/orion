package com.orion.math.function.onevariable;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.core.tuple.Pair;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.codomain.FunctionCodomain;
import com.orion.math.function.domain.FunctionDomain1x1;
import com.orion.math.function.tasks.onevariable.ComposeFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.GetNValuesOfFunction1x1IncludingXValuesTask;
import com.orion.math.function.tasks.onevariable.GetNValuesOfFunction1x1Task;
import com.orion.math.function.tasks.onevariable.GetValueForComposedFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.IsFunction1x1InjectiveForXValuesTask;
import com.orion.math.function.tasks.onevariable.RestrictFunction1x1Task;
import com.orion.math.function.tasks.onevariable.RunPipelineOfFunctions1x1Task;
import com.orion.math.function.tasks.onevariable.checks.IsFunction1x1DecreasingForXValuesTask;
import com.orion.math.function.tasks.onevariable.checks.IsFunction1x1IncreasingForXValuesTask;
import com.orion.math.function.tasks.onevariable.checks.IsFunction1x1StrictlyDecreasingForXValuesTask;
import com.orion.math.function.tasks.onevariable.checks.IsFunction1x1StrictlyIncreasingForXValuesTask;
import com.orion.math.function.tasks.onevariable.roots.GetRootOfFunction1x1UsingNewtonRaphsonTask;
import com.orion.math.function.tasks.onevariable.roots.GetRootsOfFunction1x1UsingNewtonRaphsonTask;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.interpolation.InterpolationService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.precision.Precision;
import com.orion.math.polynomial.Polynomial;
import java.util.List;

public class Function1x1Service extends OrionService
{
    public static Function1x1<ANumber, ANumber> getDouble(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getDouble(f);
    }


    public static Function1x1<ANumber, ANumber> getHalf(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getHalf(f);
    }


    public static Function1x1<ANumber, ANumber> getSquare(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getSquare(f);
    }


    public static Function1x1<ANumber, ANumber> getInverse(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Assert.notNull(f.getDomain(), "The function domain cannot be null.");
        Assert.notNull(f.getDomain().getIntervalOfVariable1(), "The function domain interval cannot be null.");
        Pair<Vector, Vector> xAndYValues = getNValuesOfFunctionIncludingXValuesAsVectors(f, f.getDomain().getIntervalOfVariable1(), 10);
        Polynomial polynomial = InterpolationService.doPolynomialInterpolation(xAndYValues.getSecond(), xAndYValues.getFirst());
        FunctionDomain1x1 domain = FunctionDomain1x1.of(f.getCodomain().getInterval());
        FunctionCodomain codomain = FunctionCodomain.of(f.getDomain().getIntervalOfVariable1());
        return Function1x1.<ANumber, ANumber>of(polynomial.getAsFunction().getFunctionCasted(), domain, codomain);
    }


    public static ANumber compose(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        return GetValueForComposedFunctions1x1Task.run(x, functions);
    }


    public static Function1x1<ANumber, ANumber> compose(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> other)
    {
        return ComposeFunctions1x1Task.run(f, other);
    }


    public static Function1x1<ANumber, ANumber> compose(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>[] functions)
    {
        return ComposeFunctions1x1Task.run(f, functions);
    }


    public static ANumber add(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        return Function1x1ArithmeticService.add(x, functions);
    }


    public static Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        return Function1x1ArithmeticService.add(f, x);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> add(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>... functions)
    {
        return Function1x1ArithmeticService.add(f, functions);
    }


    public static Function1x1<ANumber, ANumber> add(List<Function1x1<ANumber, ANumber>> functions)
    {
        return Function1x1ArithmeticService.add(functions);
    }


    public static Function1x1<ANumber, ANumber> subtract(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        return Function1x1ArithmeticService.subtract(f, x);
    }


    public static Function1x1<ANumber, ANumber> subtract(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> g)
    {
        return Function1x1ArithmeticService.subtract(f, g);
    }


    public static Function1x1<ANumber, ANumber> multiply(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        return Function1x1ArithmeticService.multiply(f, x);
    }


    public static ANumber multiply(ANumber x, Function1x1<ANumber, ANumber>[] functions)
    {
        return Function1x1ArithmeticService.multiply(x, functions);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> multiply(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber>... functions)
    {
        return Function1x1ArithmeticService.multiply(f, functions);
    }


    public static Function1x1<ANumber, ANumber> multiply(List<Function1x1<ANumber, ANumber>> functions)
    {
        return Function1x1ArithmeticService.multiply(functions);
    }


    public static Function1x1<ANumber, ANumber> divide(Function1x1<ANumber, ANumber> f, ANumber x)
    {
        return Function1x1ArithmeticService.divide(f, x);
    }


    public static Function1x1<ANumber, ANumber> divide(Function1x1<ANumber, ANumber> f, Function1x1<ANumber, ANumber> g)
    {
        return Function1x1ArithmeticService.divide(f, g);
    }


    @SuppressWarnings(
    {"unchecked"})
    public static Function1x1<ANumber, ANumber> getSumOfSquares(Function1x1<ANumber, ANumber>... functions)
    {
        return Function1x1ArithmeticService.getSumOfSquares(functions);
    }


    public static Function1x1<ANumber, ANumber> getSumOfSquares(List<Function1x1<ANumber, ANumber>> functions)
    {
        return Function1x1ArithmeticService.getSumOfSquares(functions);
    }


    public static Function1x1<ANumber, ANumber> getSquareRoot(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getSquareRoot(f);
    }


    public static Function1x1<ANumber, ANumber> getSquareRoot(Function1x1<ANumber, ANumber> f, int precision)
    {
        return Function1x1ArithmeticService.getSquareRoot(f, precision);
    }


    public static Function1x1<ANumber, ANumber> getNthRoot(Function1x1<ANumber, ANumber> f, int n)
    {
        return Function1x1ArithmeticService.getNthRoot(f, n);
    }


    public static Function1x1<ANumber, ANumber> getNthRoot(Function1x1<ANumber, ANumber> f, int n, int precision)
    {
        return Function1x1ArithmeticService.getNthRoot(f, n, precision);
    }


    public static ANumber[] getNValuesOfFunction(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        return GetNValuesOfFunction1x1Task.run(f, domain, numberOfSampleValues);
    }


    public static Vector getNValuesOfFunctionAsVector(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        return Vector.of(getNValuesOfFunction(f, domain, numberOfSampleValues));
    }


    public static Pair<ANumber[], ANumber[]> getNValuesOfFunctionIncludingXValues(Function1x1<ANumber, ANumber> f, Interval domain)
    {
        return GetNValuesOfFunction1x1IncludingXValuesTask.run(f, domain, 10);
    }


    public static Pair<ANumber[], ANumber[]> getNValuesOfFunctionIncludingXValues(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        return GetNValuesOfFunction1x1IncludingXValuesTask.run(f, domain, numberOfSampleValues);
    }


    public static Pair<Vector, Vector> getNValuesOfFunctionIncludingXValuesAsVectors(Function1x1<ANumber, ANumber> f, Interval domain)
    {
        Pair<ANumber[], ANumber[]> pair = getNValuesOfFunctionIncludingXValues(f, domain, 10);
        return Pair.<Vector, Vector>of(Vector.of(pair.getFirst()), Vector.of(pair.getSecond()));
    }


    public static Pair<Vector, Vector> getNValuesOfFunctionIncludingXValuesAsVectors(Function1x1<ANumber, ANumber> f, Interval domain, int numberOfSampleValues)
    {
        Pair<ANumber[], ANumber[]> pair = getNValuesOfFunctionIncludingXValues(f, domain, numberOfSampleValues);
        return Pair.<Vector, Vector>of(Vector.of(pair.getFirst()), Vector.of(pair.getSecond()));
    }


    public static boolean isFunctionInjectiveForXValues(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return IsFunction1x1InjectiveForXValuesTask.run(f, xValues);
    }


    public static boolean isInvertible(Function1x1<ANumber, ANumber> f, Interval intervalOfX)
    {
        return isFunctionInjectiveForXValues(f, f.getDomain().getIntervalOfVariable1().getAsArray(100));
    }


    public static boolean isInvertible(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return isFunctionInjectiveForXValues(f, xValues);
    }


    public static ANumber getRoot(Function1x1<ANumber, ANumber> f, ANumber x0)
    {
        return getRootUsingNewtonRaphson(f, x0, Precision.precision);
    }


    public static ANumber getRoot(Function1x1<ANumber, ANumber> f, ANumber x0, int precision)
    {
        return getRootUsingNewtonRaphson(f, x0, precision);
    }


    public static ANumber getRootUsingNewtonRaphson(Function1x1<ANumber, ANumber> f, ANumber x0)
    {
        return GetRootOfFunction1x1UsingNewtonRaphsonTask.run(f, x0, Precision.precision);
    }


    public static ANumber getRootUsingNewtonRaphson(Function1x1<ANumber, ANumber> f, ANumber x0, int precision)
    {
        return GetRootOfFunction1x1UsingNewtonRaphsonTask.run(f, x0, precision);
    }


    public static ANumber[] getRootsUsingNewtonRaphson(Function1x1<ANumber, ANumber> f, Interval intervalToSearchForRoots)
    {
        return GetRootsOfFunction1x1UsingNewtonRaphsonTask.run(f, intervalToSearchForRoots, Precision.precision);
    }


    public static ANumber[] getRootsUsingNewtonRaphson(Function1x1<ANumber, ANumber> f, Interval intervalToSearchForRoots, int precision)
    {
        return GetRootsOfFunction1x1UsingNewtonRaphsonTask.run(f, intervalToSearchForRoots, precision);
    }


    public static ANumber[] getRoots(Function1x1<ANumber, ANumber> f, Interval intervalToSearchForRoots)
    {
        return getRootsUsingNewtonRaphson(f, intervalToSearchForRoots, Precision.precision);
    }


    public static ANumber[] getRoots(Function1x1<ANumber, ANumber> f, Interval intervalToSearchForRoots, int precision)
    {
        return getRootsUsingNewtonRaphson(f, intervalToSearchForRoots, precision);
    }


    public static boolean getSignOfBolzanoTheorem(Function1x1<ANumber, ANumber> f, ANumber a, ANumber b)
    {
        FunctionRules.isValid(f);
        NumberRules.areNotNull(a, b);
        return f.run(a).multiplyGET(f.run(b)).isNegative();
    }


    public static ANumber getKroneckerDelta(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return (x.equal(y)) ? ANumber.of(1) : ANumber.of(0);
    }


    public static Polynomial getAsPolynomial(Function1x1<ANumber, ANumber> f, Interval intervalOfX)
    {
        return InterpolationService.doPolynomialInterpolation(f, intervalOfX);
    }


    public static Polynomial getAsPolynomial(Function1x1<ANumber, ANumber> f, Interval intervalOfX, int numberOfFunctionSampleValues)
    {
        return InterpolationService.doPolynomialInterpolation(f, intervalOfX, numberOfFunctionSampleValues);
    }


    public static Polynomial getAsPolynomial(IdentityFunction<ANumber> f, Interval intervalOfX)
    {
        FunctionRules.isValid(f);
        return InterpolationService.doPolynomialInterpolation(f.getFunctionCasted(), intervalOfX);
    }


    public static Polynomial getAsPolynomial(IdentityFunction<ANumber> f, Interval intervalOfX, int numberOfFunctionSampleValues)
    {
        FunctionRules.isValid(f);
        return InterpolationService.doPolynomialInterpolation(f.getFunctionCasted(), intervalOfX, numberOfFunctionSampleValues);
    }


    public static <T1, R1, R2> R2 runPipeline(Function1x1<T1, R1> f1, T1 valueForF1, Function1x1<R1, R2> f2)
    {
        FunctionRules.areValid(f1, f2);
        R1 y1 = f1.run(valueForF1);
        return f2.run(y1);
    }


    public static Object runPipeline(Function1x1<Object, Object>[] functions, Object valueForF1)
    {
        return RunPipelineOfFunctions1x1Task.run(functions, valueForF1);
    }


    public static Function1x1<Object, Object> restrictFunction(Function1x1<Object, Object> f, Interval newIntervalOfX)
    {
        return RestrictFunction1x1Task.run(f, newIntervalOfX);
    }


    public static boolean isIncreasingForXValues(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return IsFunction1x1IncreasingForXValuesTask.run(f, xValues);
    }


    public static boolean isStrictlyIncreasingForXValues(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return IsFunction1x1StrictlyIncreasingForXValuesTask.run(f, xValues);
    }


    public static boolean isDecreasingForXValues(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return IsFunction1x1DecreasingForXValuesTask.run(f, xValues);
    }


    public static boolean isStrictlyDecreasingForXValues(Function1x1<ANumber, ANumber> f, ANumber[] xValues)
    {
        return IsFunction1x1StrictlyDecreasingForXValuesTask.run(f, xValues);
    }


    public static Function1x1<ANumber, ANumber> negate(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.negate(f);
    }


    public static Function1x1<ANumber, ANumber> reciprocate(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.reciprocate(f);
    }


    public static Function1x1<ANumber, ANumber> getSineInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getSineInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getSineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getSineInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getArcsineAsRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArcsineAsRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getArcsineAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArcsineAsDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getCosineInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getCosineInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getCosineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getCosineInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getArccosineAsRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArccosineAsRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getArccosineAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArccosineAsDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getTangentInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getTangentInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getTangentInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getTangentInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getArctangentAsRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArctangentAsRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getArctangentAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getArctangentAsDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicSineInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicSineInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicSineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicSineInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicCosineInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicCosineInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicCosineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicCosineInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicTangentInRadians(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicTangentInRadians(f);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicTangentInDegrees(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1TrigonometryService.getHyperbolicTangentInDegrees(f);
    }


    public static Function1x1<ANumber, ANumber> getNeperianLogarithm(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getNeperianLogarithm(f);
    }


    public static Function1x1<ANumber, ANumber> getNeperianLogarithm(Function1x1<ANumber, ANumber> f, int precision)
    {
        return Function1x1ArithmeticService.getNeperianLogarithm(f, precision);
    }


    public static Function1x1<ANumber, ANumber> getLogarithm(Function1x1<ANumber, ANumber> f, ANumber base)
    {
        return Function1x1ArithmeticService.getLogarithm(f, base);
    }


    public static Function1x1<ANumber, ANumber> getLogarithm(Function1x1<ANumber, ANumber> f, ANumber base, int precision)
    {
        return Function1x1ArithmeticService.getLogarithm(f, base, precision);
    }


    public static Function1x1<ANumber, ANumber> exponentiate(Function1x1<ANumber, ANumber> f, ANumber exponent)
    {
        return Function1x1ArithmeticService.exponentiate(f, exponent);
    }


    public static Function1x1<ANumber, ANumber> getAbsoluteValue(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.getAbsoluteValue(f);
    }


    public static Function1x1<ANumber, ANumber> conjugate(Function1x1<ANumber, ANumber> f)
    {
        return Function1x1ArithmeticService.conjugate(f);
    }


    public static Function1x1<ANumber, ANumber> addFunctionsWithWeights(List<Function1x1<ANumber, ANumber>> functions, List<?> weights)
    {
        return Function1x1ArithmeticService.addFunctionsWithWeights(functions, weights);
    }
}