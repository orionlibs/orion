package com.orion.math.number;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.number.fraction.Fraction;
import java.util.Arrays;
import java.util.List;

public class NumberRules extends MathRule
{
    public static void equal(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.notEqual(y), "x does not equal y.");
    }


    public static void notEqual(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.equal(y), "x should not equal y.");
    }


    public static void isBetween(Object x, Object minimum, Object maximum)
    {
        Assert.isFalse(Numbers.isNotBetween(x, minimum, maximum), "x is not within the interval range.");
    }


    public static void isBetweenLeftExclusive(Object x, Object minimum, Object maximum)
    {
        Assert.isFalse(Numbers.isNotBetweenLeftExclusive(x, minimum, maximum), "x is not within the interval range.");
    }


    public static void areBetween(List<Object> numbers, Object minimum, Object maximum)
    {
        areNotNull(numbers);
        numbers.forEach(x -> isBetween(x, minimum, maximum));
    }


    public static void areAllNaturalNumbers(List<ANumber> numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on nonnatural numbers.");
        Assert.areEqual(numbers.stream().filter(x -> Numbers.hasNaturalNumberValue(x)).count(), numbers.size(), "Cannot perform operation on nonnatural numbers.");
    }


    public static void areAllComplexNumbers(ANumber[] numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on noncomplex numbers.");
        Assert.areEqual(Arrays.stream(numbers).filter(x -> Numbers.hasImaginaryValue(x)).count(), numbers.length, "Cannot perform operation on noncomplex numbers.");
    }


    public static void areAllPositive(List<ANumber> numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on nonpositive numbers.");
        Assert.isNotZero(numbers.stream().filter(x -> Numbers.isPositive(x)).count(), "Cannot perform operation on nonpositive numbers.");
    }


    public static void areAllPositive(ANumber... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on nonpositive numbers.");
        areAllPositive(Arrays.asList(numbers));
    }


    public static void areNotNull(List<?> numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on null numbers.");
        Assert.isZero(numbers.stream().filter(x -> x == null).count(), "Cannot perform operation on null numbers.");
    }


    public static void isNot(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.equal(y), "Cannot perform operation on equal numbers.");
    }


    public static void isNotNull(List<?> numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on null list of numbers.");
    }


    public static void isNotEmpty(List<?> numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null/empty list of numbers.");
    }


    public static void isNotNull(ANumber[] numbers)
    {
        Assert.notNull(numbers, "Cannot perform operation on null array of numbers.");
    }


    public static void isNotEmpty(ANumber[] numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null/empty array of numbers.");
    }


    public static void isNotEmpty(Object[] numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null/empty array of numbers.");
    }


    public static void isNotNull(Object x)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
    }


    public static void areNotNull(ANumber... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> isNotNull(x));
    }


    public static void areNotNull(Number... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> isNotNull(x));
    }


    public static void areNotNull(String... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> isNotNull(x));
    }


    public static void areNotNull(ANumber x, ANumber y)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
        Assert.notNull(y, "Cannot perform operation on null numbers.");
    }


    public static void areNotNull(ANumber x, Number y)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
        Assert.notNull(y, "Cannot perform operation on null numbers.");
    }


    public static void isNotNull(Number x)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
    }


    public static void areNotNull(Number x, Number y)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
        Assert.notNull(y, "Cannot perform operation on null numbers.");
    }


    public static void areNotNull(Number x, ANumber y)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
        Assert.notNull(y, "Cannot perform operation on null numbers.");
    }


    public static void isNotNull(String value)
    {
        Assert.notNull(value, "Cannot perform operation on null/empty numbers.");
    }


    public static void isNotNull(Number x, NumberType numberType)
    {
        Assert.notNull(x, "Cannot perform operation on null numbers.");
        Assert.notNull(numberType, "Cannot perform operation on null numbers.");
    }


    public static void isNotNull(Fraction x)
    {
        Assert.notNull(x, "Cannot perform operation on null fractions.");
    }


    public static void areNotNull(Fraction x, Fraction y)
    {
        Assert.notNull(x, "Cannot perform operation on null fractions.");
        Assert.notNull(y, "Cannot perform operation on null fractions.");
    }


    public static void isPositive(ANumber x)
    {
        Assert.isFalse(Numbers.isNonPositive(x), "Cannot perform operation on nonpositive numbers.");
    }


    public static void isPositive(Number x)
    {
        Assert.isFalse(Numbers.isNonPositive(x), "Cannot perform operation on nonpositive numbers.");
    }


    public static void arePositive(ANumber x, ANumber y)
    {
        Assert.isFalse(Numbers.isNonPositive(x), "Cannot perform operation on nonpositive numbers.");
        Assert.isFalse(Numbers.isNonPositive(y), "Cannot perform operation on nonpositive numbers.");
    }


    public static void isNonPositive(ANumber x)
    {
        Assert.isFalse(Numbers.isPositive(x), "Cannot perform operation on positive numbers.");
    }


    public static void isNegative(ANumber x)
    {
        Assert.isFalse(Numbers.isNonNegative(x), "Cannot perform operation on nonnegative numbers.");
    }


    public static void isNonNegative(ANumber x)
    {
        Assert.isFalse(Numbers.isNegative(x), "Cannot perform operation on negative numbers.");
    }


    public static void isNonNegative(int x)
    {
        Assert.isFalse(Numbers.isNegative(x), "Cannot perform operation on negative numbers.");
    }


    public static void isNonNegativeInteger(ANumber x)
    {
        hasIntegerValue(x);
        Assert.isFalse(Numbers.isNegative(x), "Cannot perform operation on negative numbers.");
    }


    public static void isNonZero(ANumber x)
    {
        Assert.isFalse(Numbers.isZero(x), "Cannot perform operation on 0.");
    }


    public static void hasIntegerValue(ANumber x)
    {
        Assert.isFalse(!Numbers.hasIntegerValue(x), "Cannot perform operation on decimal numbers.");
    }


    public static void hasIntegerValue(Number x)
    {
        Assert.isFalse(!Numbers.hasIntegerValue(x), "Cannot perform operation on decimal numbers.");
    }


    public static void haveIntegerValue(ANumber... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> hasIntegerValue(x));
    }


    public static void haveNaturalNumberValue(ANumber... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> hasNaturalNumberValue(x));
    }


    public static void haveNaturalNumberValue(Number... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> hasNaturalNumberValue(x));
    }


    public static void haveNaturalNumberValue(List<ANumber> numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        numbers.forEach(x -> hasNaturalNumberValue(x));
    }


    public static void haveNonnegativeIntegerNumberValue(Number... numbers)
    {
        Assert.notEmpty(numbers, "Cannot perform operation on null numbers.");
        Arrays.stream(numbers).forEach(x -> hasNonnegativeIntegerNumberValue(x));
    }


    public static void hasNonnegativeIntegerNumberValue(ANumber x)
    {
        Assert.isFalse(Numbers.isNegative(x), "Cannot perform operation on negative or nonnatural numbers.");
        Assert.isFalse(!Numbers.hasIntegerValue(x), "Cannot perform operation on negative or nonnatural numbers.");
    }


    public static void hasNonnegativeIntegerNumberValue(Number x)
    {
        Assert.isFalse(Numbers.isNegative(x), "Cannot perform operation on negative or nonnatural numbers.");
        Assert.isFalse(!Numbers.hasIntegerValue(x), "Cannot perform operation on negative or nonnatural numbers.");
    }


    public static void hasNaturalNumberValue(ANumber x)
    {
        Assert.isFalse(!Numbers.hasNaturalNumberValue(x), "Cannot perform operation on nonnatural numbers.");
    }


    public static void hasNaturalNumberValue(Number x)
    {
        Assert.isFalse(!Numbers.hasNaturalNumberValue(x), "Cannot perform operation on nonnatural numbers.");
    }


    public static void isGreaterThan(Number x, Number y)
    {
        areNotNull(x, y);
        Assert.isFalse(ANumber.of(x).isLessThanOrEqual(y), "x has to be greater than y.");
    }


    public static void isGreaterThan(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.isLessThanOrEqual(y), "x has to be greater than y.");
    }


    public static void isGreaterThanOrEqual(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.isLessThan(y), "x has to be greater than or equal to y.");
    }


    public static void isGreaterThanOrEqual(Number x, Number y)
    {
        areNotNull(x, y);
        Assert.isFalse(ANumber.of(x).isLessThan(y), "x has to be greater than or equal to y.");
    }


    public static void doSizesMatch(List<?> numbers1, List<?> numbers2)
    {
        areNotNull(numbers1);
        areNotNull(numbers2);
        Assert.areEqual(numbers1.size(), numbers2.size(), "The sizes do not match.");
    }


    public static void doSizesMatch(ANumber[] numbers1, ANumber[] numbers2)
    {
        areNotNull(numbers1);
        areNotNull(numbers2);
        Assert.areEqual(numbers1.length, numbers2.length, "The sizes do not match.");
    }


    public static void isLessThan(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.isGreaterThanOrEqual(y), "x has to be less than y.");
    }


    public static void isLessThanOrEqual(ANumber x, ANumber y)
    {
        areNotNull(x, y);
        Assert.isFalse(x.isGreaterThan(y), "x has to be less than or equal to y.");
    }


    public static void isLessThan(Number x, Number y)
    {
        areNotNull(x, y);
        Assert.isFalse(ANumber.of(x).isGreaterThanOrEqual(ANumber.of(y)), "x has to be less than y.");
    }


    public static void isANumber(ANumber x)
    {
        isNotNull(x);
        Assert.isFalse(x.isNaN(), "x is not a number i.e. its real value is null.");
    }
}