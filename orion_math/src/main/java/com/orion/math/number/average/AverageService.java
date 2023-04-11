package com.orion.math.number.average;

import com.orion.core.abstraction.OrionService;
import com.orion.core.exception.Assert;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.Functions;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1Service;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.average.tasks.GetArithmeticAverageVectorTask;
import com.orion.math.number.average.tasks.GetHarmonicAverageOfFunctions1x1Task;
import com.orion.math.number.average.tasks.GetHarmonicAverageTask;
import com.orion.math.number.average.tasks.GetQuadraticAverageTask;
import com.orion.math.number.precision.Precision;
import java.util.Arrays;
import java.util.List;

public class AverageService extends OrionService
{
    public static ANumber getArithmeticAverage(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return ArithmeticService.add(numbers).divideGET(numbers.length);
    }


    public static ANumber getArithmeticAverage(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return getArithmeticAverage(numbers.getAsArray());
    }


    public static ANumber getArithmeticAverage(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        return Functions.sum.run(numbers).divideGET(numbers.size());
    }


    public static Function1x1<ANumber, ANumber> getArithmeticAverageOfFunctions(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        return Function1x1Service.add(functions).divide(ANumber.of(functions.size()));
    }


    public static ANumber getWeightedArithmeticAverage(ANumber[] numbers, ANumber[] weights)
    {
        NumberRules.areNotNull(numbers);
        NumberRules.areNotNull(weights);
        return getWeightedArithmeticAverage(Arrays.asList(numbers), Arrays.asList(weights));
    }


    public static ANumber getWeightedArithmeticAverage(Vector numbers, ANumber[] weights)
    {
        VectorRules.isValid(numbers);
        NumberRules.areNotNull(weights);
        return getWeightedArithmeticAverage(numbers.getAsList(), Arrays.asList(weights));
    }


    public static ANumber getWeightedArithmeticAverage(ANumber[] numbers, Vector weights)
    {
        NumberRules.areNotNull(numbers);
        VectorRules.isValid(weights);
        return getWeightedArithmeticAverage(Arrays.asList(numbers), weights.getAsList());
    }


    public static ANumber getWeightedArithmeticAverage(List<ANumber> numbers, List<ANumber> weights)
    {
        NumberRules.doSizesMatch(numbers, weights);
        return ArithmeticService.addWithWeights(numbers, weights).divideGET(numbers.size());
    }


    public static Function1x1<ANumber, ANumber> getWeightedArithmeticAverageOfFunctions(List<Function1x1<ANumber, ANumber>> functions, List<ANumber> weights)
    {
        FunctionRules.areValidFunctions1x1(functions);
        Assert.notEmpty(weights, "The weights input cannot be null/empty.");
        Assert.areEqual(functions.size(), weights.size(), "The sizes do not match.");
        return Function1x1Service.addFunctionsWithWeights(functions, weights).divide(ANumber.of(functions.size()));
    }


    public static ANumber getGeometricAverage(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return ArithmeticService.multiply(numbers).getNthRoot(numbers.length);
    }


    public static ANumber getGeometricAverage(ANumber[] numbers, int precision)
    {
        NumberRules.areNotNull(numbers);
        precision = Precision.getValidPrecision(precision);
        return ArithmeticService.multiply(numbers).getNthRoot(numbers.length, precision);
    }


    public static ANumber getGeometricAverage(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        return ArithmeticService.multiply(numbers).getNthRoot(numbers.size());
    }


    public static ANumber getGeometricAverage(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return ArithmeticService.multiply(numbers).getNthRoot(numbers.getSize());
    }


    public static ANumber getGeometricAverage(List<ANumber> numbers, int precision)
    {
        NumberRules.areNotNull(numbers);
        precision = Precision.getValidPrecision(precision);
        return ArithmeticService.multiply(numbers).getNthRoot(numbers.size(), precision);
    }


    public static Function1x1<ANumber, ANumber> getGeometricAverageOfFunctions(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        return Function1x1Service.multiply(functions).getNthRoot(functions.size());
    }


    public static ANumber getHarmonicAverage(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return GetHarmonicAverageTask.run(Arrays.asList(numbers));
    }


    public static ANumber getHarmonicAverage(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        return GetHarmonicAverageTask.run(numbers);
    }


    public static ANumber getHarmonicAverage(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return GetHarmonicAverageTask.run(numbers.getAsList());
    }


    public static Function1x1<ANumber, ANumber> getHarmonicAverageOfFunctions(List<Function1x1<ANumber, ANumber>> functions)
    {
        return GetHarmonicAverageOfFunctions1x1Task.run(functions);
    }


    public static ANumber getQuadraticAverage(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return GetQuadraticAverageTask.run(Arrays.asList(numbers));
    }


    public static ANumber getQuadraticAverage(ANumber[] numbers, int precision)
    {
        NumberRules.areNotNull(numbers);
        return GetQuadraticAverageTask.run(Arrays.asList(numbers), precision);
    }


    public static ANumber getQuadraticAverage(List<ANumber> numbers)
    {
        NumberRules.areNotNull(numbers);
        return GetQuadraticAverageTask.run(numbers);
    }


    public static ANumber getQuadraticAverage(List<ANumber> numbers, int precision)
    {
        NumberRules.areNotNull(numbers);
        return GetQuadraticAverageTask.run(numbers, precision);
    }


    public static ANumber getQuadraticAverage(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return GetQuadraticAverageTask.run(numbers.getAsList());
    }


    public static ANumber getQuadraticAverage(Vector numbers, int precision)
    {
        VectorRules.isValid(numbers);
        return GetQuadraticAverageTask.run(numbers.getAsList(), precision);
    }


    public static Function1x1<ANumber, ANumber> getQuadraticAverageOfFunctions(List<Function1x1<ANumber, ANumber>> functions)
    {
        FunctionRules.areValidFunctions1x1(functions);
        Function1x1<ANumber, ANumber> oneOverN = Function1x1.of(x -> ANumber.of(functions.size()).reciprocateGET());
        Function1x1<ANumber, ANumber> sumOfSquares = Function1x1Service.getSumOfSquares(functions);
        return oneOverN.multiply(sumOfSquares).getSquareRoot();
    }


    public static Vector getArithmeticAverageVector(List<Vector> vectors)
    {
        return GetArithmeticAverageVectorTask.run(vectors);
    }


    public static Vector getArithmeticAverageVector(Vector[] vectors)
    {
        return GetArithmeticAverageVectorTask.run(Arrays.asList(vectors));
    }


    public static Vector getArithmeticAverageVector(Vector vector1, Vector vector2)
    {
        return GetArithmeticAverageVectorTask.run(Arrays.asList(vector1, vector2));
    }
}