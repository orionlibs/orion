package com.orion.math.number.services;

import com.orion.core.abstraction.OrionService;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.NumberType;
import com.orion.math.number.Numbers;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.fraction.Fraction;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.services.tasks.GetArgumentOfComplexNumberTask;
import com.orion.math.number.services.tasks.GetNumbersAsNumberListTask;
import com.orion.math.number.services.tasks.PrintNumberTask;
import com.orion.math.number.services.tasks.check.IsHeptagonalNumberTask;
import com.orion.math.number.services.tasks.check.IsHexagonalNumberTask;
import com.orion.math.number.services.tasks.check.IsOctagonalNumberTask;
import com.orion.math.number.services.tasks.check.IsPandigitalNumberTask;
import com.orion.math.number.services.tasks.check.IsPentagonalNumberTask;
import com.orion.math.number.services.tasks.check.IsSquareNumberTask;
import com.orion.math.number.services.tasks.check.IsTriangleNumberTask;
import com.orion.math.number.services.tasks.check.IsUglyNumberTask;
import com.orion.math.number.services.tasks.check.IsValidNumberTask;
import com.orion.math.number.services.tasks.convert.ConvertNumberToFractionTask;
import com.orion.math.number.services.tasks.convert.GetComplexNumberFromPolarCoordinatesTask;
import com.orion.math.number.services.tasks.convert.TrimZerosInNumberTask;
import com.orion.math.number.services.tasks.query.GetCeilingOfNumberTask;
import com.orion.math.number.services.tasks.query.GetClosestIntegerOfNumberTask;
import com.orion.math.number.services.tasks.query.GetDivisorsOfNumberTask;
import com.orion.math.number.services.tasks.query.GetFloorOfNumberTask;
import com.orion.math.number.services.tasks.query.GetGreatestCommonDivisorOf2NumbersBasedOnTheirFactorsTask;
import com.orion.math.number.services.tasks.query.GetGreatestCommonDivisorOfNumbersTask;
import com.orion.math.number.services.tasks.query.GetIntegerPartOfNumberTask;
import com.orion.math.number.services.tasks.query.GetNumberOfDecimalDigitsOfNumberTask;
import com.orion.math.number.services.tasks.query.GetNumberTypeBasedOnValueTask;
import com.orion.math.number.services.tasks.query.GetOrderOfMagnitudeOfNumberTask;
import com.orion.math.number.services.tasks.query.GetParityOfNumberTask;
import com.orion.math.number.services.tasks.query.GetRandomNumberTask;
import com.orion.math.number.services.tasks.query.GetSumOfDigitsOfNumberTask;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberService extends OrionService
{
    public static List<ANumber> getAsNumberList(List<?> numbers)
    {
        return GetNumbersAsNumberListTask.run(numbers);
    }


    public static boolean isValidNumber(Number x)
    {
        return isValidNumber(x.toString());
    }


    public static boolean isValidNumber(String value)
    {
        return IsValidNumberTask.run(value);
    }


    public static BigDecimal trimZeros(BigDecimal x)
    {
        NumberRules.isNotNull(x);
        return x.stripTrailingZeros();
    }


    public static void trimZeros(ANumber x)
    {
        TrimZerosInNumberTask.run(x);
    }


    public static String print(ANumber x)
    {
        return PrintNumberTask.run(x);
    }


    public static int getNumberOfDecimalDigits(String x)
    {
        return GetNumberOfDecimalDigitsOfNumberTask.run(x);
    }


    public static int getNumberOfDecimalDigits(BigDecimal x)
    {
        return GetNumberOfDecimalDigitsOfNumberTask.run(x);
    }


    public static int getNumberOfDecimalDigitsOfRealValue(ANumber x)
    {
        return GetNumberOfDecimalDigitsOfNumberTask.run(x.printRealValue());
    }


    public static int getNumberOfDecimalDigitsOfImaginaryValue(ANumber x)
    {
        return GetNumberOfDecimalDigitsOfNumberTask.run(x.printImaginaryValue());
    }


    public static boolean hasDecimalPoint(String x)
    {
        return x != null && x.indexOf(".") >= 0;
    }


    public static boolean hasDecimalDigits(BigDecimal x)
    {
        return GetNumberOfDecimalDigitsOfNumberTask.run(x.toPlainString()) > 0;
    }


    public static boolean hasDecimalDigits(ANumber x)
    {
        return getNumberOfDecimalDigitsOfRealValue(x) > 0 || getNumberOfDecimalDigitsOfImaginaryValue(x) > 0;
    }


    public static boolean hasRealValueDecimalDigits(ANumber x)
    {
        return getNumberOfDecimalDigitsOfRealValue(x) > 0;
    }


    public static boolean hasImaginaryValueDecimalDigits(ANumber x)
    {
        return getNumberOfDecimalDigitsOfImaginaryValue(x) > 0;
    }


    public static Fraction convertNumberToFraction(Number x)
    {
        return ConvertNumberToFractionTask.run(x);
    }


    public static Fraction convertNumberToFraction(Number x, int precision)
    {
        return ConvertNumberToFractionTask.run(x, Precision.getValidPrecision(precision));
    }


    public static void addFraction(Fraction fraction1, Fraction fraction2)
    {
        NumberRules.areNotNull(fraction1, fraction2);
        fraction1.addFraction(fraction2);
    }


    public static void subtractFraction(Fraction fraction1, Fraction fraction2)
    {
        NumberRules.areNotNull(fraction1, fraction2);
        fraction1.subtractFraction(fraction2);
    }


    public static void simplifyFraction(Fraction fraction)
    {
        NumberRules.isNotNull(fraction);
        fraction.simplifyFraction();
    }


    public static Number getIntegerPart(Number x)
    {
        return GetIntegerPartOfNumberTask.run(x);
    }


    public static BigInteger getIntegerPartAsBigInteger(Number x)
    {
        Number integerPart = getIntegerPart(x);

        if(Numbers.isBigInteger(integerPart))
        {
            return (BigInteger)integerPart;
        }
        else if(Numbers.isBigDecimal(integerPart))
        {
            return ((BigDecimal)integerPart).setScale(0, RoundingMode.DOWN).toBigInteger();
        }

        return null;
    }


    public static ANumber getSquareNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.exponentiateGET(2);
    }


    public static boolean isSquareNumber(ANumber order)
    {
        return IsSquareNumberTask.run(order);
    }


    public static ANumber getTriangleNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.multiplyGET(order.addOneGET()).halfGET();
    }


    public static boolean isTriangleNumber(ANumber order)
    {
        return IsTriangleNumberTask.run(order);
    }


    public static ANumber getPentagonalNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.multiplyGET(order.multiplyGET(3).subtractOneGET()).halfGET();
    }


    public static boolean isPentagonalNumber(ANumber order)
    {
        return IsPentagonalNumberTask.run(order);
    }


    public static ANumber getHexagonalNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.multiplyGET(order.doubleGET().subtractOneGET());
    }


    public static boolean isHexagonalNumber(ANumber order)
    {
        return IsHexagonalNumberTask.run(order);
    }


    public static ANumber getHeptagonalNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.multiplyGET(order.multiplyGET(5).subtractGET(3)).halfGET();
    }


    public static boolean isHeptagonalNumber(ANumber order)
    {
        return IsHeptagonalNumberTask.run(order);
    }


    public static ANumber getOctagonalNumber(ANumber order)
    {
        NumberRules.isNotNull(order);
        return order.multiplyGET(order.multiplyGET(3).subtractGET(2));
    }


    public static boolean isOctagonalNumber(ANumber order)
    {
        return IsOctagonalNumberTask.run(order);
    }


    public static boolean isPandigitalNumber(ANumber x)
    {
        return IsPandigitalNumberTask.run(x);
    }


    public static ANumber getCeiling(ANumber x)
    {
        return GetCeilingOfNumberTask.run(x);
    }


    public static ANumber getFloor(ANumber x)
    {
        return GetFloorOfNumberTask.run(x);
    }


    public static ANumber getRandomNumber()
    {
        return ANumber.of(Math.random());
    }


    public static ANumber getRandomNumber(Number start, Number end)
    {
        return GetRandomNumberTask.run(ANumber.of(start), ANumber.of(end));
    }


    public static ANumber getRandomNumber(ANumber start, ANumber end)
    {
        return GetRandomNumberTask.run(start, end);
    }


    public static ANumber[] getArrayOfRandomNumbers(Number start, Number end, int numberOfRandomNumbersToGenerate)
    {
        return GetRandomNumberTask.run(ANumber.of(start), ANumber.of(end), numberOfRandomNumbersToGenerate);
    }


    public static ANumber[] getArrayOfRandomNumbers(ANumber start, ANumber end, int numberOfRandomNumbersToGenerate)
    {
        return GetRandomNumberTask.run(start, end, numberOfRandomNumbersToGenerate);
    }


    public static List<ANumber> getListOfRandomNumbers(Number start, Number end, int numberOfRandomNumbersToGenerate)
    {
        return Arrays.asList(getArrayOfRandomNumbers(start, end, numberOfRandomNumbersToGenerate));
    }


    public static List<ANumber> getListOfRandomNumbers(ANumber start, ANumber end, int numberOfRandomNumbersToGenerate)
    {
        return Arrays.asList(getArrayOfRandomNumbers(start, end, numberOfRandomNumbersToGenerate));
    }


    public static ANumber getClosestInteger(ANumber x)
    {
        return GetClosestIntegerOfNumberTask.run(x, getCeiling(x), getFloor(x));
    }


    public static int getSignum(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.get().signum();
    }


    public static NumberType getNumberTypeBasedOnValue(ANumber x)
    {
        return getNumberTypeBasedOnValue(x.get());
    }


    public static NumberType getNumberTypeBasedOnValue(Number x)
    {
        return GetNumberTypeBasedOnValueTask.run(x);
    }


    public static ANumber conjugate(ANumber x)
    {
        NumberRules.isNotNull(x);
        return ANumber.of(x.get(), x.getImaginaryValue().negate());
    }


    public static ANumber getComplexNumberFromPolarCoordinates(ANumber length, ANumber angle)
    {
        return GetComplexNumberFromPolarCoordinatesTask.run(length, angle);
    }


    public static ANumber getArgument(ANumber x)
    {
        return GetArgumentOfComplexNumberTask.run(x);
    }


    public static ANumber[] convertNumbersToANumberObjects(Number[] numbers)
    {
        NumberRules.areNotNull(numbers);
        ANumber[] result = new ANumber[numbers.length];
        IntStream.range(0, numbers.length).forEach(i -> result[i] = ANumber.of(numbers[i]));
        return result;
    }


    public static ANumber[] convertNumberStringsToANumberObjects(String[] numbers)
    {
        NumberRules.areNotNull(numbers);
        ANumber[] result = new ANumber[numbers.length];
        IntStream.range(0, numbers.length).forEach(i -> result[i] = ANumber.of(numbers[i]));
        return result;
    }


    public static ANumber getPowerOf2GreaterOrEqualToThisNumber(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getLogarithm(2).getCeiling();
    }


    public static boolean getParity(ANumber x)
    {
        return GetParityOfNumberTask.run(x);
    }


    public static boolean hasOddParity(ANumber x)
    {
        return getParity(x);
    }


    public static boolean hasEvenParity(ANumber x)
    {
        return !getParity(x);
    }


    public static ANumber reverseDigits(ANumber x)
    {
        NumberRules.isNotNull(x);
        return ANumber.of(new StringBuilder(x.getAsInteger().toString()).reverse().toString());
    }


    public static boolean isPowerOf2(ANumber x)
    {
        NumberRules.isNotNull(x);
        return x.getLogarithm(2).hasIntegerValue();
    }


    public static boolean isNotPowerOf2(ANumber x)
    {
        return !isPowerOf2(x);
    }


    public static boolean isUgly(ANumber x)
    {
        return IsUglyNumberTask.run(x);
    }


    public static ANumber getSumOfDigits(ANumber x)
    {
        return GetSumOfDigitsOfNumberTask.run(x);
    }


    public static boolean isCongruentModuloN(ANumber x, ANumber y, ANumber n)
    {
        NumberRules.haveIntegerValue(x, y, n);
        return x.subtractGET(y).isDividedBy(n);
    }


    public static boolean isHalfInteger(ANumber x)
    {
        NumberRules.isNotNull(x);
        return Numbers.hasIntegerValue(x.doubleGET());
    }


    public static ANumber getOrderOfMagnitude(ANumber x)
    {
        return GetOrderOfMagnitudeOfNumberTask.run(x);
    }


    public static List<ANumber> getDivisors(ANumber x)
    {
        return GetDivisorsOfNumberTask.run(x);
    }


    public static List<ANumber> getPrimeDivisors(ANumber x)
    {
        NumberRules.isPositive(x);
        NumberRules.hasIntegerValue(x);
        return getDivisors(x).stream().filter(divisor -> divisor.isPrime()).collect(Collectors.toList());
    }


    public static ANumber getNumberOfDivisors(ANumber x)
    {
        return ANumber.of(getDivisors(x).size());
    }


    public static ANumber getGreatestCommonDivisor(ANumber x, ANumber y)
    {
        return GetGreatestCommonDivisorOfNumbersTask.run(x, y);
    }


    public static ANumber getGreatestCommonDivisor(List<ANumber> numbers)
    {
        return GetGreatestCommonDivisorOfNumbersTask.run(numbers);
    }


    public static ANumber getGreatestCommonDivisorOf2NumbersBasedOnTheirFactors(List<ANumber> factorsOfX, List<ANumber> factorsOfY)
    {
        return GetGreatestCommonDivisorOf2NumbersBasedOnTheirFactorsTask.run(factorsOfX, factorsOfY);
    }


    public static ANumber getLeastCommonMultiple(ANumber x, ANumber y)
    {
        Numbers.haveNaturalNumberValue(x, y);
        ANumber gcd = getGreatestCommonDivisor(x, y);
        return ArithmeticService.multiplyGET(x, y).getAbsoluteValue().divideGET(gcd);
    }


    public static ANumber getLeastCommonMultiple(List<ANumber> numbers)
    {
        Numbers.haveNaturalNumberValue(numbers);
        ANumber gcd = getGreatestCommonDivisor(numbers);
        return ArithmeticService.multiply(numbers).getAbsoluteValue().divideGET(gcd);
    }


    public static boolean isMultipleOf(ANumber x, ANumber other)
    {
        Numbers.haveNaturalNumberValue(x, other);
        return ArithmeticService.isDividedBy(x, other);
    }


    public static boolean areCommensurable(ANumber x, ANumber y, ANumber z)
    {
        Numbers.haveNaturalNumberValue(x, y, z);
        return isMultipleOf(x, z) && isMultipleOf(y, z);
    }
}