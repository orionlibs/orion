package com.orion.math.number.arithmetic;

import com.orion.core.abstraction.OrionService;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.stream.OrionStream;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.arithmetic.tasks.GetEToThePowerOfTask;
import com.orion.math.number.arithmetic.tasks.GetFactorialTask;
import com.orion.math.number.arithmetic.tasks.GetIntegralRootTask;
import com.orion.math.number.arithmetic.tasks.GetMaximumNumberTask;
import com.orion.math.number.arithmetic.tasks.GetMinimumNumberTask;
import com.orion.math.number.arithmetic.tasks.GetNeperianLogarithmTask;
import com.orion.math.number.arithmetic.tasks.GetNthRootOfNumberTask;
import com.orion.math.number.arithmetic.tasks.cumulativity.GetNumbersCumulativeSumArrayTask;
import com.orion.math.number.arithmetic.tasks.cumulativity.GetNumbersCumulativeSumOfSquaresArrayTask;
import com.orion.math.number.arithmetic.tasks.transform.AddNumbersTask;
import com.orion.math.number.arithmetic.tasks.transform.AddNumbersWithWeightsTask;
import com.orion.math.number.arithmetic.tasks.transform.GetAbsoluteValueOfNumberTask;
import com.orion.math.number.arithmetic.tasks.transform.MultiplyNumbersTask;
import com.orion.math.number.arithmetic.tasks.transform.ReciprocateNumberTask;
import com.orion.math.number.arithmetic.tasks.transform.RoundNumberTask;
import com.orion.math.number.precision.Precision;
import com.orion.math.set.SetRules;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ArithmeticService extends OrionService
{
    public static void negate(ANumber x)
    {
        NumberRules.isNotNull(x);
        x.setRealValue(x.get().negate());
        x.setImaginaryValue(x.getImaginaryValue().negate());
    }


    public static ANumber[] getAbsoluteValues(List<ANumber> numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return OrionStream.getAsArray(numbers.stream().map(x -> x.getAbsoluteValue()), ANumber.class);
    }


    public static ANumber[] getAbsoluteValues(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return getAbsoluteValues(Arrays.asList(numbers));
    }


    public static ANumber getSumOfSquares(List<ANumber> numbers)
    {
        NumberRules.isNotEmpty(numbers);
        ANumber sumOfSquares = ANumber.of(0);
        numbers.forEach(x -> sumOfSquares.add(x.squareGET()));
        return sumOfSquares;
    }


    public static ANumber getSumOfSquares(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return getSumOfSquares(Arrays.asList(numbers));
    }


    public static ANumber[] getCumulativeSumArray(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return getCumulativeSumArray(Arrays.asList(numbers));
    }


    public static ANumber[] getCumulativeSumArray(List<ANumber> numbers)
    {
        return GetNumbersCumulativeSumArrayTask.run(numbers);
    }


    public static ANumber[] getCumulativeSumOfSquaresArray(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return getCumulativeSumOfSquaresArray(Arrays.asList(numbers));
    }


    public static ANumber[] getCumulativeSumOfSquaresArray(List<ANumber> numbers)
    {
        return GetNumbersCumulativeSumOfSquaresArrayTask.run(numbers);
    }


    public static ANumber addWithWeights(List<?> numbers, List<?> weights)
    {
        return addWithWeights(numbers, weights, false);
    }


    public static ANumber addWithWeights(List<?> numbers, List<?> weights, int precision)
    {
        return addWithWeights(numbers, weights, false, precision);
    }


    public static ANumber addWithWeights(List<?> numbers, List<?> weights, boolean checkForNullNumbers)
    {
        return AddNumbersWithWeightsTask.run(numbers, weights, checkForNullNumbers);
    }


    public static ANumber addWithWeights(List<?> numbers, List<?> weights, boolean checkForNullNumbers, int precision)
    {
        return AddNumbersWithWeightsTask.run(numbers, weights, checkForNullNumbers, precision);
    }


    public static ANumber add(List<?> numbers)
    {
        return add(numbers, false);
    }


    public static ANumber add(List<?> numbers, int precision)
    {
        return add(numbers, false, precision);
    }


    public static ANumber add(List<?> numbers, boolean checkForNullNumbers)
    {
        return AddNumbersTask.run(numbers, checkForNullNumbers);
    }


    public static ANumber add(List<?> numbers, boolean checkForNullNumbers, int precision)
    {
        return AddNumbersTask.run(numbers, checkForNullNumbers, precision);
    }


    public static ANumber add(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return add(Arrays.asList(numbers));
    }


    public static ANumber add(Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return add(Arrays.asList(numbers));
    }


    public static ANumber add(int precision, Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return add(Arrays.asList(numbers), false, precision);
    }


    public static ANumber add(boolean checkForNullNumbers, Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return add(Arrays.asList(numbers), checkForNullNumbers);
    }


    public static ANumber add(boolean checkForNullNumbers, int precision, Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return add(Arrays.asList(numbers), checkForNullNumbers, precision);
    }


    public static void add(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        x.add(y);
    }


    public static ANumber addGET(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.addGET(y);
    }


    public static ANumber round(ANumber x)
    {
        return round(x, Precision.precision);
    }


    public static ANumber round(ANumber x, int precision)
    {
        return round(x, precision, null);
    }


    public static ANumber round(ANumber x, RoundingMode roundingMode)
    {
        return round(x, Precision.precision, roundingMode);
    }


    public static ANumber round(ANumber x, int precision, RoundingMode roundingMode)
    {
        return RoundNumberTask.run(x, precision, roundingMode);
    }


    public static void reciprocate(ANumber x)
    {
        ReciprocateNumberTask.run(x);
    }


    public static ANumber reciprocateGET(ANumber x)
    {
        ANumber copy = x.getCopy();
        reciprocate(copy);
        return copy;
    }


    public static ANumber getMinimum(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return getMinimum(Arrays.asList(x, y), false);
    }


    public static ANumber getMinimum(Number x, Number y)
    {
        NumberRules.areNotNull(x, y);
        return getMinimum(Arrays.asList(x, y), false);
    }


    public static ANumber getMinimum(List<?> numbers)
    {
        return getMinimum(numbers, false);
    }


    public static ANumber getMinimum(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return getMinimum(Arrays.asList(numbers), false);
    }


    public static ANumber getMinimum(OrionSet<ANumber> numbers)
    {
        SetRules.isValid(numbers);
        NumberRules.areNotNull(numbers.getAsList());
        return getMinimum(numbers, false);
    }


    public static ANumber getMinimum(OrionSet<ANumber> numbers, boolean checkForNullNumbers)
    {
        SetRules.isValid(numbers);
        NumberRules.areNotNull(numbers.getAsList());
        return getMinimum(new ArrayList<ANumber>(numbers), checkForNullNumbers);
    }


    public static ANumber getMinimum(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.areNotNull(numbers);
        return GetMinimumNumberTask.run(numbers, checkForNullNumbers);
    }


    public static ANumber getMaximum(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return getMaximum(Arrays.asList(x, y), false);
    }


    public static ANumber getMaximum(Number x, Number y)
    {
        NumberRules.areNotNull(x, y);
        return getMaximum(Arrays.asList(x, y), false);
    }


    public static ANumber getMaximum(List<?> numbers)
    {
        return getMaximum(numbers, false);
    }


    public static ANumber getMaximum(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);
        return getMaximum(Arrays.asList(numbers), false);
    }


    public static ANumber getMaximum(OrionSet<ANumber> numbers)
    {
        SetRules.isValid(numbers);
        NumberRules.areNotNull(numbers.getAsList());
        return getMaximum(numbers, false);
    }


    public static ANumber getMaximum(OrionSet<ANumber> numbers, boolean checkForNullNumbers)
    {
        SetRules.isValid(numbers);
        NumberRules.areNotNull(numbers.getAsList());
        return getMaximum(new ArrayList<ANumber>(numbers), checkForNullNumbers);
    }


    public static ANumber getMaximum(List<?> numbers, boolean checkForNullNumbers)
    {
        NumberRules.areNotNull(numbers);
        return GetMaximumNumberTask.run(numbers, checkForNullNumbers);
    }


    public static ANumber getFactorial(ANumber n)
    {
        return GetFactorialTask.run(n);
    }


    public static ANumber getAbsoluteValue(ANumber n)
    {
        return GetAbsoluteValueOfNumberTask.run(n);
    }


    public static void divide(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        x.divide(y);
    }


    public static ANumber[] divide(ANumber[] x, ANumber y)
    {
        NumberRules.areNotNull(x);
        NumberRules.isNotNull(y);
        ANumber[] result = new ANumber[x.length];
        IntStream.range(0, x.length).forEach(i -> result[i] = x[i].divideGET(y));
        return result;
    }


    public static ANumber divideGET(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.divideGET(y);
    }


    public static boolean divides(ANumber divisor, ANumber x)
    {
        return getRemainderOfDivision(x, divisor).isZero();
    }


    public static boolean divides(ANumber divisor, Number x)
    {
        return getRemainderOfDivision(x, divisor).isZero();
    }


    public static boolean divides(Number divisor, ANumber x)
    {
        return getRemainderOfDivision(x, divisor).isZero();
    }


    public static boolean isDividedBy(ANumber x, ANumber divisor)
    {
        return divides(divisor, x);
    }


    public static boolean isDividedBy(ANumber x, Number divisor)
    {
        return divides(divisor, x);
    }


    public static ANumber getRemainderOfDivision(ANumber x, ANumber divisor)
    {
        NumberRules.areNotNull(x, divisor);
        return ANumber.of(x.get().remainder(divisor.get(), MathContext.UNLIMITED));
    }


    public static ANumber getRemainderOfDivision(ANumber x, Number divisor)
    {
        NumberRules.isNotNull(divisor);
        return getRemainderOfDivision(x, ANumber.of(divisor));
    }


    public static ANumber getRemainderOfDivision(Number x, ANumber divisor)
    {
        NumberRules.isNotNull(x);
        return getRemainderOfDivision(ANumber.of(x), divisor);
    }


    public static DivisionResult divideAndRemainder(ANumber x, ANumber y)
    {
        ANumber quotient = divideGET(x, y);
        quotient.setRealValue(new BigDecimal(quotient.getAsInteger()));
        ANumber remainder = getRemainderOfDivision(x, y);
        remainder.setRealValue(new BigDecimal(remainder.getAsInteger()));
        return DivisionResult.builder()
                        .quotient(quotient)
                        .remainder(remainder)
                        .build();
    }


    public static DivisionResult divideAndRemainder(ANumber x, Number y)
    {
        return divideAndRemainder(x, ANumber.of(y));
    }


    public static ANumber getEToThePowerOf(ANumber x)
    {
        return getEToThePowerOf(x, 25);
    }


    public static ANumber getEToThePowerOf(ANumber x, int precision)
    {
        return GetEToThePowerOfTask.run(x, Precision.getValidPrecision(precision));
    }


    public static ANumber getIntegralRoot(ANumber x, ANumber index)
    {
        return getIntegralRoot(x, index, Precision.precision);
    }


    public static ANumber getIntegralRoot(ANumber x, ANumber index, int precision)
    {
        return GetIntegralRootTask.run(x, index, Precision.getValidPrecision(precision));
    }


    public static ANumber getNeperianLogarithm(ANumber x)
    {
        return getNeperianLogarithm(x, Precision.precision);
    }


    public static ANumber getNeperianLogarithm(ANumber x, int precision)
    {
        return GetNeperianLogarithmTask.run(x, Precision.getValidPrecision(precision));
    }


    public static ANumber getLogarithm(ANumber base, ANumber x)
    {
        return getLogarithm(base, x, Precision.precision);
    }


    public static ANumber getLogarithm(Number base, ANumber x)
    {
        return getLogarithm(base, x, Precision.precision);
    }


    public static ANumber getLogarithm(ANumber base, ANumber x, int precision)
    {
        NumberRules.isNot(base, ANumber.of(1));
        ANumber logX = getNeperianLogarithm(x, precision);
        ANumber logBase = getNeperianLogarithm(base, precision);
        return logX.divideGET(logBase);
    }


    public static ANumber getLogarithm(Number base, ANumber x, int precision)
    {
        NumberRules.isNotNull(base);
        return getLogarithm(ANumber.of(base), x, precision);
    }


    public static ANumber getLogarithmBase2(ANumber x)
    {
        return getLogarithmBase2(x, Precision.precision);
    }


    public static ANumber getLogarithmBase2(ANumber x, int precision)
    {
        ANumber logX = getNeperianLogarithm(x, precision);
        ANumber logBase = getNeperianLogarithm(ANumber.of(2), precision);
        return logX.divideGET(logBase);
    }


    public static ANumber getLogarithmBase10(ANumber x)
    {
        return getLogarithmBase10(x, Precision.precision);
    }


    public static ANumber getLogarithmBase10(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(precision <= Precision.precision)
        {
            return ANumber.of(Math.log10(x.get().doubleValue()));
        }
        else
        {
            ANumber logX = getNeperianLogarithm(x, precision);
            ANumber logBase = getNeperianLogarithm(ANumber.of(10), precision);
            return logX.divideGET(logBase);
        }

    }


    public static ANumber multiply(List<?> numbers)
    {
        return new MultiplyNumbersTask().run(numbers, false);
    }


    public static ANumber multiply(List<?> numbers, int precision)
    {
        return multiply(numbers, false, precision);
    }


    public static ANumber multiply(List<?> numbers, boolean checkForNullNumbers)
    {
        return new MultiplyNumbersTask().run(numbers, checkForNullNumbers);
    }


    public static ANumber multiply(List<?> numbers, boolean checkForNullNumbers, int precision)
    {
        return new MultiplyNumbersTask().run(numbers, checkForNullNumbers, precision);
    }


    public static ANumber multiply(Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return multiply(Arrays.asList(numbers), false);
    }


    public static ANumber multiply(ANumber[] numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return multiply(Arrays.asList(numbers), false);
    }


    public static ANumber multiply(int precision, Object... numbers)
    {
        return multiply(false, precision, numbers);
    }


    public static ANumber multiply(Vector numbers)
    {
        VectorRules.isValid(numbers);
        return multiply(numbers.getAsList(), false);
    }


    public static ANumber multiply(boolean checkForNullNumbers, Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return multiply(Arrays.asList(numbers), checkForNullNumbers);
    }


    public static ANumber multiply(boolean checkForNullNumbers, int precision, Object... numbers)
    {
        NumberRules.isNotEmpty(numbers);
        return multiply(Arrays.asList(numbers), checkForNullNumbers, precision);
    }


    public static void multiply(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        x.multiply(y);
    }


    public static ANumber multiplyGET(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.multiplyGET(y);
    }


    public static ANumber getNthRoot(ANumber x, int n)
    {
        return getNthRoot(x, n, Precision.precision);
    }


    public static ANumber getNthRoot(ANumber x, int n, int precision)
    {
        return GetNthRootOfNumberTask.run(x, n, precision);
    }


    public static void subtract(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        x.subtract(y);
    }


    public static ANumber subtractGET(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.subtractGET(y);
    }


    public static ANumber getJordanProduct(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.multiplyGET(y).addGET(y.multiplyGET(x)).halfGET();
    }
}