package com.orion.math.number;

import com.orion.math.MathRule;
import com.orion.math.constant.Constant;
import com.orion.math.number.services.NumberService;
import com.orion.math.number.tasks.check.DoesNumberHaveDecimalValueTask;
import com.orion.math.number.tasks.check.DoesNumberHaveIntegerValueTask;
import com.orion.math.number.tasks.check.DoesNumberHaveNaturalNumberValueTask;
import com.orion.math.number.tasks.check.IsNumberBetween2OthersExcludingFirstNumberTask;
import com.orion.math.number.tasks.check.IsNumberBetween2OthersExcludingSecondNumberTask;
import com.orion.math.number.tasks.check.IsNumberBetween2OthersExcludingThemTask;
import com.orion.math.number.tasks.check.IsNumberBetween2OthersTask;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Numbers extends MathRule
{
    public static BigDecimal getAsDecimal(Object x)
    {
        NumberRules.isNotNull(x);
        BigDecimal xValue = BigDecimal.ZERO;

        if(Numbers.isNumber(x))
        {
            xValue = new BigDecimal(((Number)x).toString());
        }
        else if(Numbers.isBigInteger(x))
        {
            xValue = new BigDecimal((BigInteger)x);
        }
        else if(Numbers.isBigDecimal(x))
        {
            xValue = (BigDecimal)x;
        }

        return xValue;
    }


    public static boolean isNaN(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.isNaN();
    }


    public static boolean isValidNumber(ANumber x)
    {
        return !isNaN(x);
    }


    public static boolean isEven(Number x)
    {
        NumberRules.isNotNull(x);
        BigDecimal temp = new BigDecimal(x.toString());
        return temp.remainder(BigDecimal.valueOf(2)).compareTo(BigDecimal.ZERO) == 0;
    }


    public static boolean isEven(ANumber x)
    {
        NumberRules.isNotNull(x);
        return isEven(x.get());
    }


    public static boolean isOdd(Number x)
    {
        return !isEven(x);
    }


    public static boolean isOdd(ANumber x)
    {
        return !isEven(x);
    }


    public static boolean isNumber(Object x)
    {
        return x instanceof Number;
    }


    public static boolean isAbstractNumber(Object x)
    {
        return x instanceof ANumber;
    }


    public static boolean isNull(Object x)
    {
        return x == null;
    }


    public static boolean isNotNull(Object x)
    {
        return x != null;
    }


    public static boolean areNull(ANumber x, ANumber y)
    {
        return isNull(x) || isNull(y);
    }


    public static boolean areNotNull(ANumber x, ANumber y)
    {
        return isNotNull(x) && isNotNull(y);
    }


    public static boolean areNotNull(Number x, Number y)
    {
        return isNotNull(x) && isNotNull(y);
    }


    public static boolean isBetween(Object x, Object minimum, Object maximum)
    {
        return IsNumberBetween2OthersTask.run(x, minimum, maximum);
    }


    public static boolean isNotBetween(Object x, Object minimum, Object maximum)
    {
        return !isBetween(x, minimum, maximum);
    }


    public static boolean isBetweenExclusive(Object x, Object minimum, Object maximum)
    {
        return IsNumberBetween2OthersExcludingThemTask.run(x, minimum, maximum);
    }


    public static boolean isBetweenRightExclusive(Object x, Object minimum, Object maximum)
    {
        return IsNumberBetween2OthersExcludingSecondNumberTask.run(x, minimum, maximum);
    }


    public static boolean isBetweenLeftExclusive(Object x, Object minimum, Object maximum)
    {
        return IsNumberBetween2OthersExcludingFirstNumberTask.run(x, minimum, maximum);
    }


    public static boolean isNotBetweenLeftExclusive(Object x, Object minimum, Object maximum)
    {
        return !isBetweenLeftExclusive(x, minimum, maximum);
    }


    public static boolean hasIntegerValue(Object x)
    {
        return DoesNumberHaveIntegerValueTask.run(x);
    }


    public static boolean imaginaryValueHasIntegerValue(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        return x.compareTo(new BigDecimal(x.toBigInteger())) == 0;
    }


    public static boolean hasNaturalNumberValue(Object x)
    {
        return DoesNumberHaveNaturalNumberValueTask.run(x);
    }


    public static boolean hasNotNaturalNumberValue(Object x)
    {
        return !hasNaturalNumberValue(x);
    }


    public static boolean haveNaturalNumberValue(List<ANumber> numbers)
    {
        NumberRules.isNotNull(numbers);

        for(ANumber x : numbers)
        {

            if(!hasNaturalNumberValue(x))
            {
                return false;
            }

        }

        return true;
    }


    public static boolean haveNaturalNumberValue(ANumber... numbers)
    {

        if(numbers != null && numbers.length > 0)
        {

            for(ANumber x : numbers)
            {

                if(!hasNaturalNumberValue(x))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static boolean hasDecimalValue(Object x)
    {
        return DoesNumberHaveDecimalValueTask.run(x);
    }


    public static boolean hasImaginaryValue(ANumber x)
    {
        NumberRules.isNotNull(x);
        return isNotZero(x.getImaginaryValue());
    }


    public static boolean isBigInteger(Object x)
    {
        return x instanceof BigInteger;
    }


    public static boolean isBigDecimal(Object x)
    {
        return x instanceof BigDecimal;
    }


    public static boolean hasDecimalPoint(String x)
    {
        return NumberService.hasDecimalPoint(x);
    }


    public static boolean hasNoDecimalPoint(String x)
    {
        return !hasDecimalPoint(x);
    }


    public static boolean hasDecimalDigits(BigDecimal x)
    {
        return NumberService.hasDecimalDigits(x);
    }


    public static boolean hasDecimalDigits(ANumber x)
    {
        return NumberService.hasDecimalDigits(x);
    }


    public static boolean hasRealValueDecimalDigits(ANumber x)
    {
        return NumberService.hasRealValueDecimalDigits(x);
    }


    public static boolean hasImaginaryValueDecimalDigits(ANumber x)
    {
        return NumberService.hasImaginaryValueDecimalDigits(x);
    }


    public static boolean isOne(Number x)
    {
        return NumberInternalService.isOne(x);
    }


    public static boolean isOne(ANumber x)
    {
        return NumberInternalService.isOne(x);
    }


    public static boolean isNotOne(ANumber x)
    {
        return !isOne(x);
    }


    public static boolean isMinusOne(ANumber x)
    {
        return NumberInternalService.isMinusOne(x);
    }


    public static boolean isNotMinusOne(ANumber x)
    {
        return !isMinusOne(x);
    }


    public static boolean isLessThanOne(Number x)
    {
        return NumberInternalService.isLessThanOne(x);
    }


    public static boolean isLessThanOne(ANumber x)
    {
        return NumberInternalService.isLessThanOne(x);
    }


    public static boolean isGreaterThanOne(Number x)
    {
        return NumberInternalService.isGreaterThanOne(x);
    }


    public static boolean isGreaterThanOne(ANumber x)
    {
        return NumberInternalService.isGreaterThanOne(x);
    }


    public static boolean isGreaterThanOrEqualToOne(Number x)
    {
        return NumberInternalService.isGreaterThanOrEqualToOne(x);
    }


    public static boolean isGreaterThanOrEqualToOne(ANumber x)
    {
        return NumberInternalService.isGreaterThanOrEqualToOne(x);
    }


    public static boolean isZero(Number x)
    {
        return NumberInternalService.isZero(x);
    }


    public static boolean isZero(ANumber x)
    {
        return NumberInternalService.isZero(x);
    }


    public static boolean isNotZero(Number x)
    {
        return !isZero(x);
    }


    public static boolean isNotZero(ANumber x)
    {
        return !isZero(x);
    }


    public static boolean isPositive(Number x)
    {
        return NumberInternalService.isPositive(x);
    }


    public static boolean isPositive(ANumber x)
    {
        return NumberInternalService.isPositive(x);
    }


    public static boolean isNegative(Number x)
    {
        return NumberInternalService.isNegative(x);
    }


    public static boolean isNegative(ANumber x)
    {
        return NumberInternalService.isNegative(x);
    }


    public static boolean isNonPositive(Number x)
    {
        return isNegative(x) || isZero(x);
    }


    public static boolean isNonPositive(ANumber x)
    {
        return isNegative(x) || isZero(x);
    }


    public static boolean areNonPositive(ANumber... numbers)
    {

        if(numbers == null || numbers.length == 0)
        {
            return false;
        }
        else
        {
            return Arrays.stream(numbers).filter(x -> isNegative(x) || isZero(x)).count() == numbers.length;
        }

    }


    public static boolean isNonNegative(Number x)
    {
        return isPositive(x) || isZero(x);
    }


    public static boolean isNonNegative(ANumber x)
    {
        return isPositive(x) || isZero(x);
    }


    public static boolean isLessThan(Number x, Number y)
    {
        return Numbers.getAsDecimal(x).compareTo(Numbers.getAsDecimal(y)) < 0;
    }


    public static boolean isLessThan(ANumber x, ANumber y)
    {
        NumberRules.areNotNull(x, y);
        return x.compareTo(y) < 0;
    }


    public static boolean isLessThan(ANumber x, Constant y)
    {
        NumberRules.isNotNull(x);
        NumberRules.isNotNull(y);
        return x.compareTo(y.getValue()) < 0;
    }


    public static boolean isLessThan(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return isLessThan(x.get(), y);
    }


    public static boolean isLessThan(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return isLessThan(x, y.get());
    }


    public static boolean isLessThanOrEqual(Number x, Number y)
    {
        return Numbers.getAsDecimal(x).compareTo(Numbers.getAsDecimal(y)) < 1;
    }


    public static boolean isLessThanOrEqual(ANumber x, ANumber y)
    {
        NumberRules.isNotNull(x);
        return x.compareTo(y) < 1;
    }


    public static boolean isLessThanOrEqual(ANumber x, Constant y)
    {
        NumberRules.isNotNull(x);
        NumberRules.isNotNull(y);
        return x.compareTo(y.getValue()) < 1;
    }


    public static boolean isLessThanOrEqual(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return isLessThanOrEqual(x.get(), y);
    }


    public static boolean isLessThanOrEqual(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return isLessThanOrEqual(x, y.get());
    }


    public static boolean isGreaterThan(Number x, Number y)
    {
        return Numbers.getAsDecimal(x).compareTo(Numbers.getAsDecimal(y)) > 0;
    }


    public static boolean isGreaterThan(ANumber x, ANumber y)
    {
        NumberRules.isNotNull(x);
        return x.compareTo(y) > 0;
    }


    public static boolean isGreaterThan(ANumber x, Constant y)
    {
        NumberRules.isNotNull(x);
        NumberRules.isNotNull(y);
        return x.compareTo(y.getValue()) > 0;
    }


    public static boolean isGreaterThan(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return isGreaterThan(x.get(), y);
    }


    public static boolean isGreaterThan(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return isGreaterThan(x, y.get());
    }


    public static boolean isGreaterThanOrEqual(Number x, Number y)
    {
        return Numbers.getAsDecimal(x).compareTo(Numbers.getAsDecimal(y)) > -1;
    }


    public static boolean isGreaterThanOrEqual(ANumber x, ANumber y)
    {
        NumberRules.isNotNull(x);
        return x.compareTo(y) > -1;
    }


    public static boolean isGreaterThanOrEqual(ANumber x, Constant y)
    {
        NumberRules.isNotNull(x);
        NumberRules.isNotNull(y);
        return x.compareTo(y.getValue()) > -1;
    }


    public static boolean isGreaterThanOrEqual(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return isGreaterThanOrEqual(x.get(), y);
    }


    public static boolean isGreaterThanOrEqual(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return isGreaterThanOrEqual(x, y.get());
    }


    public static boolean areEqual(ANumber[] numbers)
    {
        NumberRules.areNotNull(numbers);

        for(int i = 0; i < numbers.length - 1; i++)
        {

            for(int j = i + 1; j < numbers.length; j++)
            {

                if(numbers[i].notEqual(numbers[j]))
                {
                    return false;
                }

            }

        }

        return true;
    }


    public static boolean equal(Number x, Number y)
    {
        return NumberInternalService.equal(x, y);
    }


    public static boolean equal(ANumber x, ANumber y)
    {
        return NumberInternalService.equal(x, y);
    }


    public static boolean equal(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return NumberInternalService.equal(x.get(), y);
    }


    public static boolean equal(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return NumberInternalService.equal(x, y.get());
    }


    public static boolean notEqual(Number x, Number y)
    {
        return !equal(x, y);
    }


    public static boolean notEqual(ANumber x, ANumber y)
    {
        return !equal(x, y);
    }


    public static boolean notEqual(ANumber x, Number y)
    {
        NumberRules.isNotNull(x);
        return notEqual(x.get(), y);
    }


    public static boolean notEqual(Number x, ANumber y)
    {
        NumberRules.isNotNull(y);
        return notEqual(x, y.get());
    }


    public static boolean isFinite(ANumber x)
    {
        NumberRules.isNotNull(x);

        if(x.getNumberType().isNot(NumberType.NegativeInfinityNumber)
                        && x.getNumberType().isNot(NumberType.PositiveInfinityNumber)
                        && !"Infinity".contains(x.printRealValue()))
        {
            return true;
        }

        return false;
    }


    public static boolean isInfinite(ANumber x)
    {
        return !isFinite(x);
    }
}