package com.orion.math.number;

import com.orion.core.object.CloningService;
import com.orion.math.MathObject;
import com.orion.math.constant.Constant;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.arithmetic.DivisionResult;
import com.orion.math.number.fraction.Fraction;
import com.orion.math.number.precision.Precision;
import com.orion.math.number.services.NumberService;
import com.orion.math.number.services.PrecisionService;
import com.orion.math.primenumber.PrimeNumberService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ANumber implements MathObject, Cloneable, Comparable<ANumber>
{
    private BigDecimal realValue = BigDecimal.ZERO;
    private BigDecimal imaginaryValue = BigDecimal.ZERO;
    private int precision = Precision.precision;
    private boolean isValidNumber;
    private boolean isFinite;


    public ANumber()
    {
        this("0", "0");
    }


    public ANumber(boolean isNaN)
    {

        if(isNaN)
        {
            setRealValueAsNull();
            setImaginaryValueAsNull();
        }

    }


    public ANumber(Number realValue)
    {
        this(realValue, BigDecimal.ZERO);
    }


    public ANumber(Number realValue, Number imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.toString(), imaginaryValue.toString());
    }


    public ANumber(ANumber realValue, ANumber imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.get().toString(), imaginaryValue.get().toString());
    }


    public ANumber(Number realValue, ANumber imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.toString(), imaginaryValue.get().toPlainString());
    }


    public ANumber(ANumber realValue, Number imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().saveNumberValues(this, realValue.get().toPlainString(), imaginaryValue.toString());
    }


    public ANumber(String realValue)
    {
        this(realValue, "0");
    }


    public ANumber(String realValue, String imaginaryValue)
    {
        new NumberInternalService().saveNumberValues(this, realValue, imaginaryValue);
    }


    public static ANumber of()
    {
        return new ANumber();
    }


    public static ANumber of(boolean isNaN)
    {
        return new ANumber(isNaN);
    }


    public static ANumber of(String realValue)
    {
        return new ANumber(realValue);
    }


    public static ANumber of(String realValue, String imaginaryValue)
    {
        return new ANumber(realValue, imaginaryValue);
    }


    public static ANumber of(Number realValue)
    {
        return new ANumber(realValue);
    }


    public static ANumber ofPrecision(Number realValue, int precision)
    {
        ANumber temp = new ANumber(realValue);
        temp.applyPrecision(precision);
        return temp;
    }


    public static ANumber of(Number realValue, Number imaginaryValue)
    {
        return new ANumber(realValue, imaginaryValue);
    }


    public static ANumber of(ANumber realValue, ANumber imaginaryValue)
    {
        return new ANumber(realValue, imaginaryValue);
    }


    public static ANumber of(Number realValue, ANumber imaginaryValue)
    {
        return new ANumber(realValue, imaginaryValue);
    }


    public static ANumber of(ANumber realValue, Number imaginaryValue)
    {
        return new ANumber(realValue, imaginaryValue);
    }


    public static ANumber ofPolarCoordinates(ANumber modulus, ANumber argument)
    {
        return new ANumber(modulus.multiplyGET(argument.getCosine()), modulus.multiplyGET(argument.getSine()));
    }


    public static ANumber ofNaN()
    {
        return new ANumber(true);
    }


    public static ANumber ofMin()
    {
        return new ANumber("-999999999999999999999999999999999999999999999999999999999999999999999999999999.0");
    }


    public static ANumber ofMax()
    {
        return new ANumber("999999999999999999999999999999999999999999999999999999999999999999999999999999.0");
    }


    public void trimZeros()
    {
        NumberService.trimZeros(this);
    }


    public void applyPrecision()
    {
        PrecisionService.applyPrecision(this);
    }


    public ANumber applyPrecisionGET()
    {
        ANumber copy = getCopy();
        copy.applyPrecision();
        return copy;
    }


    public void applyPrecision(int precision)
    {
        new PrecisionService().applyPrecision(this, precision);
    }


    public ANumber applyPrecisionGET(int precision)
    {
        ANumber copy = getCopy();
        copy.applyPrecision(precision);
        return copy;
    }


    public String printRealValue()
    {
        return get().toPlainString();
    }


    public String printImaginaryValue()
    {
        return getImaginaryValue().toPlainString();
    }


    public String print()
    {
        return NumberService.print(this);
    }


    @Override
    public String toString()
    {
        return print();
    }


    public int getNumberOfDecimalDigitsOfRealValue()
    {
        return NumberService.getNumberOfDecimalDigitsOfRealValue(this);
    }


    public int getNumberOfDecimalDigitsOfImaginaryValue()
    {
        return NumberService.getNumberOfDecimalDigitsOfImaginaryValue(this);
    }


    public boolean hasDecimalDigits()
    {
        return Numbers.hasDecimalDigits(this);
    }


    public boolean hasIntegerValue()
    {
        return Numbers.hasIntegerValue(this);
    }


    public boolean hasInfiniteValue()
    {
        return hasPositiveInfiniteValue() || hasNegativeInfiniteValue();
    }


    public boolean hasPositiveInfiniteValue()
    {
        return isGreaterThanOrEqual(ANumber.ofMax());
    }


    public boolean hasNegativeInfiniteValue()
    {
        return isLessThanOrEqual(ANumber.ofMin());
    }


    public boolean imaginaryValueHasIntegerValue()
    {
        return Numbers.imaginaryValueHasIntegerValue(getImaginaryValue());
    }


    public boolean hasDecimalValue()
    {
        return Numbers.hasDecimalValue(this);
    }


    public boolean hasRealValueDecimalDigits()
    {
        return Numbers.hasRealValueDecimalDigits(this);
    }


    public boolean hasImaginaryValueDecimalDigits()
    {
        return Numbers.hasImaginaryValueDecimalDigits(this);
    }


    public boolean isComplexNumber()
    {
        return getNumberType().is(NumberType.ComplexNumber);
    }


    public boolean isPositiveInfiniteNumber()
    {
        return getNumberType().is(NumberType.PositiveInfinityNumber) || equal(ofMax());
    }


    public boolean isNegativeInfiniteNumber()
    {
        return getNumberType().is(NumberType.NegativeInfinityNumber) || equal(ofMin());
    }


    public boolean isNaN()
    {
        return getRealValue() == null;
    }


    public boolean isZero()
    {
        return Numbers.isZero(this);
    }


    public boolean isNotZero()
    {
        return !isZero();
    }


    public boolean isOne()
    {
        return Numbers.isOne(this);
    }


    public boolean isNotOne()
    {
        return Numbers.isNotOne(this);
    }


    public boolean isMinusOne()
    {
        return Numbers.isMinusOne(this);
    }


    public boolean isNotMinusOne()
    {
        return !isMinusOne();
    }


    public boolean isPositive()
    {
        return Numbers.isPositive(this);
    }


    public boolean isNegative()
    {
        return !isPositive() && isNotZero();
    }


    public boolean isNonPositive()
    {
        return Numbers.isNonPositive(this);
    }


    public boolean isNonNegative()
    {
        return Numbers.isNonNegative(this);
    }


    public boolean isPrime()
    {
        return PrimeNumberService.isPrimeNumber(this);
    }


    public void negate()
    {
        ArithmeticService.negate(this);
    }


    public ANumber negateGET()
    {
        ANumber copy = getCopy();
        copy.negate();
        return copy;
    }


    public void reciprocate()
    {
        ArithmeticService.reciprocate(this);
    }


    public ANumber reciprocateGET()
    {
        ANumber newNumber = getCopy();
        newNumber.reciprocate();
        return newNumber;
    }


    public BigDecimal getModulusAsDecimal()
    {
        return new NumberInternalService().getModulus(this).get();
    }


    public ANumber getModulus()
    {
        return new NumberInternalService().getModulus(this);
    }


    public void setNewValues(Number realValue, Number imaginaryValue, int precision)
    {
        new NumberInternalService().setNewValues(this, realValue, imaginaryValue, precision);
    }


    public void setNewValues(Number realValue, Number imaginaryValue)
    {
        setNewValues(realValue, imaginaryValue, Precision.precision);
    }


    public void setNewValues(ANumber realValue, ANumber imaginaryValue)
    {
        NumberRules.areNotNull(realValue, imaginaryValue);
        new NumberInternalService().setNewValues(this, realValue.get(), imaginaryValue.get());
    }


    public void setNewValues(ANumber newValue)
    {
        NumberRules.isNotNull(newValue);
        new NumberInternalService().setNewValues(this, newValue.get(), newValue.getImaginaryValue());
    }


    public boolean divides(ANumber other)
    {
        return ArithmeticService.divides(this, other);
    }


    public boolean divides(Number other)
    {
        return ArithmeticService.divides(this, other);
    }


    public boolean isDividedBy(ANumber other)
    {
        return ArithmeticService.isDividedBy(this, other);
    }


    public boolean isDividedBy(Number other)
    {
        return ArithmeticService.isDividedBy(this, other);
    }


    public void round()
    {
        ANumber roundedNumber = ArithmeticService.round(this);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumber roundGET()
    {
        return ArithmeticService.round(this);
    }


    public void round(int precision)
    {
        ANumber roundedNumber = ArithmeticService.round(this, precision);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumber roundGET(int precision)
    {
        return ArithmeticService.round(this, precision);
    }


    public void round(RoundingMode roundingMode)
    {
        ANumber roundedNumber = ArithmeticService.round(this, roundingMode);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumber roundGET(RoundingMode roundingMode)
    {
        return ArithmeticService.round(this, roundingMode);
    }


    public void round(int precision, RoundingMode roundingMode)
    {
        ANumber roundedNumber = ArithmeticService.round(this, precision, roundingMode);
        setRealValue(roundedNumber.get());
        setImaginaryValue(roundedNumber.getImaginaryValue());
    }


    public ANumber roundGET(int precision, RoundingMode roundingMode)
    {
        return ArithmeticService.round(this, precision, roundingMode);
    }


    public int getSignum()
    {
        return get().signum();
    }


    public boolean isEven()
    {
        return Numbers.isEven(this);
    }


    public boolean isOdd()
    {
        return Numbers.isOdd(this);
    }


    public boolean isLessThan(ANumber other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThan(Number other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThan(Constant other)
    {
        return Numbers.isLessThan(this, other);
    }


    public boolean isLessThanOrEqual(ANumber other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isLessThanOrEqual(Number other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isLessThanOrEqual(Constant other)
    {
        return Numbers.isLessThanOrEqual(this, other);
    }


    public boolean isGreaterThan(ANumber other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThan(Number other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThan(Constant other)
    {
        return Numbers.isGreaterThan(this, other);
    }


    public boolean isGreaterThanOrEqual(ANumber other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean isGreaterThanOrEqual(Number other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean isGreaterThanOrEqual(Constant other)
    {
        return Numbers.isGreaterThanOrEqual(this, other);
    }


    public boolean equal(ANumber other)
    {
        return equals(other);
    }


    public boolean equal(Number other)
    {
        return equals(ANumber.of(other));
    }


    public boolean notEqual(ANumber other)
    {
        return !equal(other);
    }


    public boolean notEqual(Number other)
    {
        return !equal(other);
    }


    public Fraction getRealValueAsFraction()
    {
        return NumberService.convertNumberToFraction(get());
    }


    public Fraction getImaginaryValueAsFraction()
    {
        return NumberService.convertNumberToFraction(getImaginaryValue());
    }


    public Fraction getAsFraction()
    {
        return getRealValueAsFraction();
    }


    public void addOne()
    {
        setRealValue(get().add(BigDecimal.ONE));
    }


    public ANumber addOneGET()
    {
        return new NumberInternalService().addOneGET(this);
    }


    public void subtractOne()
    {
        setRealValue(get().subtract(BigDecimal.ONE));
    }


    public ANumber subtractOneGET()
    {
        ANumber newNumber = getCopy();
        newNumber.setRealValue(newNumber.get().subtract(BigDecimal.ONE));
        return newNumber;
    }


    public void half()
    {
        setRealValue(get().divide(BigDecimal.valueOf(2)));
        setImaginaryValue(getImaginaryValue().divide(BigDecimal.valueOf(2)));
    }


    public void half(int precision)
    {
        setRealValue(get().divide(BigDecimal.valueOf(2)));
        setImaginaryValue(getImaginaryValue().divide(BigDecimal.valueOf(2)));
        applyPrecision(precision);
    }


    public ANumber halfGET()
    {
        ANumber newNumber = getCopy();
        newNumber.half();
        return newNumber;
    }


    public ANumber halfGET(int precision)
    {
        ANumber newNumber = getCopy();
        newNumber.half(precision);
        return newNumber;
    }


    public ANumber addGET(ANumber other)
    {
        return new NumberInternalService().addGET(this, other);
    }


    public ANumber addGET(Number other)
    {
        return new NumberInternalService().addGET(this, other);
    }


    public ANumber addGET(List<?> others, boolean checkForNullNumbers)
    {
        return new NumberInternalService().addGET(this, others, checkForNullNumbers);
    }


    public ANumber addGET(List<?> others, int precision, boolean checkForNullNumbers)
    {
        return new NumberInternalService().addGET(this, others, precision, checkForNullNumbers);
    }


    public void add(List<?> others)
    {
        ANumber newNumber = addGET(others, false);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(List<?> others, int precision, boolean checkForNullNumbers)
    {
        ANumber newNumber = addGET(others, precision, checkForNullNumbers);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(ANumber other)
    {
        ANumber newNumber = addGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void add(Number other)
    {
        ANumber newNumber = addGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumber subtractGET(ANumber other)
    {
        return new NumberInternalService().subtractGET(this, other);
    }


    public ANumber subtractGET(Number other)
    {
        return new NumberInternalService().subtractGET(this, other);
    }


    public void subtract(ANumber other)
    {
        ANumber newNumber = subtractGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void subtract(Number other)
    {
        ANumber newNumber = subtractGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumber multiplyGET(ANumber other)
    {
        return new NumberInternalService().multiplyGET(this, other);
    }


    public ANumber multiplyGET(Number other)
    {
        return new NumberInternalService().multiplyGET(this, other);
    }


    public ANumber multiplyGET(List<?> others, boolean checkForNullNumbers)
    {
        return new NumberInternalService().multiplyGET(this, others, checkForNullNumbers);
    }


    public void multiply(List<?> others)
    {
        ANumber newNumber = multiplyGET(others, false);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void multiply(ANumber other)
    {
        ANumber newNumber = multiplyGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void multiply(Number other)
    {
        ANumber newNumber = multiplyGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumber divideGET(ANumber other)
    {
        return new NumberInternalService().divideGET(this, other);
    }


    public ANumber divideGET(Number other)
    {
        return new NumberInternalService().divideGET(this, other);
    }


    public void divide(ANumber other)
    {
        ANumber newNumber = divideGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void divide(Number other)
    {
        ANumber newNumber = divideGET(other);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public DivisionResult divideAndRemainder(ANumber other)
    {
        return ArithmeticService.divideAndRemainder(this, other);
    }


    public DivisionResult divideAndRemainder(Number other)
    {
        return ArithmeticService.divideAndRemainder(this, other);
    }


    public ANumber getMinimum(ANumber other)
    {
        return ArithmeticService.getMinimum(Arrays.asList(this, other));
    }


    public ANumber getMinimum(Number other)
    {
        return ArithmeticService.getMinimum(Arrays.asList(this, other));
    }


    public ANumber getMinimum(List<ANumber> others)
    {
        List<ANumber> numbers = new ArrayList<>();
        numbers.add(this);
        numbers.addAll(others);
        return ArithmeticService.getMinimum(others);
    }


    public ANumber getMaximum(ANumber other)
    {
        return ArithmeticService.getMaximum(Arrays.asList(this, other));
    }


    public ANumber getMaximum(Number other)
    {
        return ArithmeticService.getMaximum(Arrays.asList(this, other));
    }


    public ANumber getMaximum(List<ANumber> others)
    {
        List<ANumber> numbers = new ArrayList<>();
        numbers.add(this);
        numbers.addAll(others);
        return ArithmeticService.getMaximum(others);
    }


    public ANumber getSine()
    {
        return TrigonometryService.getSineInRadians(this);
    }


    public ANumber getSine(int precision)
    {
        return TrigonometryService.getSineInRadians(this, precision);
    }


    public ANumber getArcsine()
    {
        return TrigonometryService.getArcsineAsRadians(this);
    }


    public ANumber getArcsine(int precision)
    {
        return TrigonometryService.getArcsineAsRadians(this, precision);
    }


    public ANumber getSineInDegrees()
    {
        return TrigonometryService.getSineInDegrees(this);
    }


    public ANumber getSineInDegrees(int precision)
    {
        return TrigonometryService.getSineInDegrees(this, precision);
    }


    public ANumber getCosine()
    {
        return TrigonometryService.getCosineInRadians(this);
    }


    public ANumber getCosine(int precision)
    {
        return TrigonometryService.getCosineInRadians(this, precision);
    }


    public ANumber getCosineInDegrees()
    {
        return TrigonometryService.getCosineInDegrees(this);
    }


    public ANumber getCosineInDegrees(int precision)
    {
        return TrigonometryService.getCosineInDegrees(this, precision);
    }


    public ANumber getArccosine()
    {
        return TrigonometryService.getArccosineAsRadians(this);
    }


    public ANumber getArccosine(int precision)
    {
        return TrigonometryService.getArccosineAsRadians(this, precision);
    }


    public ANumber getTangent()
    {
        return TrigonometryService.getTangentInRadians(this);
    }


    public ANumber getTangent(int precision)
    {
        return TrigonometryService.getTangentInRadians(this, precision);
    }


    public ANumber getTangentInDegrees()
    {
        return TrigonometryService.getTangentInDegrees(this);
    }


    public ANumber getTangentInDegrees(int precision)
    {
        return TrigonometryService.getTangentInDegrees(this, precision);
    }


    public ANumber getArctan()
    {
        return TrigonometryService.getArctangentAsRadians(this);
    }


    public ANumber getArctan(int precision)
    {
        return TrigonometryService.getArctangentAsRadians(this, precision);
    }


    public ANumber getCeiling()
    {
        return NumberService.getCeiling(this);
    }


    public ANumber getFloor()
    {
        return NumberService.getFloor(this);
    }


    public ANumber getNthRoot(int n)
    {
        return ArithmeticService.getNthRoot(this, n);
    }


    public ANumber getNthRoot(int n, int precision)
    {
        return ArithmeticService.getNthRoot(this, n, precision);
    }


    public ANumber getNeperianLogarithm()
    {
        return ArithmeticService.getNeperianLogarithm(this);
    }


    public ANumber getNeperianLogarithm(int precision)
    {
        return ArithmeticService.getNeperianLogarithm(this, precision);
    }


    public ANumber getLogarithm(ANumber base)
    {
        return ArithmeticService.getLogarithm(base, this);
    }


    public ANumber getLogarithm(Number base)
    {
        return ArithmeticService.getLogarithm(base, this);
    }


    public ANumber getLogarithm(ANumber base, int precision)
    {
        return ArithmeticService.getLogarithm(base, this, precision);
    }


    public ANumber getLogarithm(Number base, int precision)
    {
        return ArithmeticService.getLogarithm(base, this, precision);
    }


    public ANumber exponentiateGET(ANumber exponent)
    {
        return new NumberInternalService().exponentiateGET(this, exponent);
    }


    public ANumber exponentiateGET(Number exponent)
    {
        return new NumberInternalService().exponentiateGET(this, exponent);
    }


    public void exponentiate(ANumber exponent)
    {
        ANumber newNumber = exponentiateGET(exponent);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public void exponentiate(Number exponent)
    {
        ANumber newNumber = exponentiateGET(exponent);
        setRealValue(newNumber.get());
        setImaginaryValue(newNumber.getImaginaryValue());
    }


    public ANumber squareGET()
    {
        return multiplyGET(this);
    }


    public void square()
    {
        multiply(this);
    }


    public ANumber doubleGET()
    {
        return multiplyGET(2);
    }


    public void doubleIt()
    {
        multiply(2);
    }


    public ANumber getSquareRoot()
    {
        return getNthRoot(2);
    }


    public ANumber getSquareRoot(int precision)
    {
        return getNthRoot(2, precision);
    }


    public ANumber getAbsoluteValue()
    {
        return ArithmeticService.getAbsoluteValue(this);
    }


    public ANumber getRemainderOfDivision(ANumber divisor)
    {
        return ArithmeticService.getRemainderOfDivision(this, divisor);
    }


    public ANumber getRemainderOfDivision(Number divisor)
    {
        return ArithmeticService.getRemainderOfDivision(this, divisor);
    }


    public ANumber conjugate()
    {
        return NumberService.conjugate(this);
    }


    public ANumber getArgument()
    {
        return NumberService.getArgument(this);
    }


    public ANumber getPowerOf2GreaterOrEqualToThisNumber()
    {
        return NumberService.getPowerOf2GreaterOrEqualToThisNumber(this);
    }


    public boolean getParity()
    {
        return NumberService.getParity(this);
    }


    public boolean hasOddParity()
    {
        return NumberService.hasOddParity(this);
    }


    public boolean hasEvenParity()
    {
        return NumberService.hasEvenParity(this);
    }


    public ANumber reverseDigits()
    {
        return NumberService.reverseDigits(this);
    }


    public boolean isPowerOf2()
    {
        return NumberService.isPowerOf2(this);
    }


    public boolean isNotPowerOf2()
    {
        return NumberService.isNotPowerOf2(this);
    }


    public boolean isUgly()
    {
        return NumberService.isUgly(this);
    }


    public ANumber getSumOfDigits()
    {
        return NumberService.getSumOfDigits(this);
    }


    public boolean isCongruentModuloN(ANumber y, ANumber n)
    {
        return NumberService.isCongruentModuloN(this, y, n);
    }


    public boolean isHalfInteger()
    {
        return NumberService.isHalfInteger(this);
    }


    public ANumber getOrderOfMagnitude()
    {
        return NumberService.getOrderOfMagnitude(this);
    }


    public ANumber getIntegerPart()
    {
        ANumber temp = getCopy();
        temp.setRealValue(new BigDecimal(getAsBigInteger()));
        temp.setImaginaryValue(new BigDecimal(getImaginaryValueAsBigInteger()));
        return temp;
    }


    public ANumber getDecimalPart()
    {
        return ANumber.of(this.subtractGET(getIntegerPart()).get());
    }


    public void reset()
    {
        setRealValue(BigDecimal.ZERO);
        setImaginaryValue(BigDecimal.ZERO);
        setPrecision(Precision.precision);
    }


    public ANumber resetGET()
    {
        ANumber newNumber = this.getCopy();
        newNumber.reset();
        return newNumber;
    }


    @Override
    public int hashCode()
    {
        return NumberInternalService.hashCode(this);
    }


    @Override
    public boolean equals(Object object)
    {
        return NumberInternalService.equals(this, object);
    }


    @Override
    public int compareTo(ANumber other)
    {
        return NumberInternalService.compareTo(this, other);
    }


    public int compareTo(Number other)
    {
        return NumberInternalService.compareTo(this, other);
    }


    public BigInteger getAsInteger()
    {
        return NumberInternalService.getRealValueAsBigInteger(this);
    }


    public int getAsInt()
    {
        return getAsInteger().intValue();
    }


    public long getAsLong()
    {
        return getAsInteger().longValue();
    }


    public double getAsDouble()
    {
        return get().doubleValue();
    }


    public BigDecimal get()
    {
        return getRealValue();
    }


    public BigDecimal getAsDecimalCopy()
    {
        return new BigDecimal(get().toPlainString());
    }


    public ANumber getAsANumber()
    {
        return ANumber.of(get());
    }


    public ANumber getAsANumberCopy()
    {
        return ANumber.of(getAsDecimalCopy());
    }


    public BigInteger getAsBigInteger()
    {
        return NumberInternalService.getRealValueAsBigInteger(this);
    }


    public BigDecimal getRealValue()
    {
        return realValue;
    }


    public void setRealValue(BigDecimal realValue)
    {
        this.realValue = realValue;
    }


    public void setRealValue(ANumber realValue)
    {
        this.realValue = realValue.get();
    }


    public void setRealValueAsNull()
    {
        this.realValue = null;
    }


    public BigInteger getImaginaryValueAsBigInteger()
    {
        return NumberInternalService.getImaginaryValueAsBigInteger(this);
    }


    public BigDecimal getImaginaryValueCopy()
    {
        return new BigDecimal(getImaginaryValue().toPlainString());
    }


    public ANumber getImaginaryValueAsANumber()
    {
        return ANumber.of(getImaginaryValue());
    }


    public ANumber getImaginaryValueAsANumberCopy()
    {
        return ANumber.of(getImaginaryValueCopy());
    }


    public BigDecimal getImaginaryValue()
    {
        return imaginaryValue;
    }


    public void setImaginaryValue(BigDecimal imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue;
    }


    public void setImaginaryValue(ANumber imaginaryValue)
    {
        this.imaginaryValue = imaginaryValue.get();
    }


    public void setImaginaryValueAsNull()
    {
        this.imaginaryValue = null;
    }


    public int getPrecision()
    {
        return precision;
    }


    public void setPrecision(int precision)
    {
        this.precision = precision;
    }


    public boolean isValidNumber()
    {
        return this.isValidNumber;
    }


    public void setValidNumber(boolean isValidNumber)
    {
        this.isValidNumber = isValidNumber;
    }


    public NumberType getNumberType()
    {
        return NumberInternalService.getNumberType(this);
    }


    @Override
    public ANumber clone() throws CloneNotSupportedException
    {
        return (ANumber)CloningService.clone(this);
    }


    public ANumber getCopy()
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


    public boolean isFinite()
    {
        return this.isFinite;
    }


    public boolean isInfinite()
    {
        return !isFinite();
    }
}