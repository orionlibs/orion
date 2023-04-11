package com.orion.math.number;

import com.orion.math.MathObject;
import com.orion.math.number.tasks.EqualTask;
import com.orion.math.number.tasks.NumberEqualsTask;
import com.orion.math.number.tasks.NumberHashCodeTask;
import com.orion.math.number.tasks.check.IsNegativeNumberTask;
import com.orion.math.number.tasks.check.IsNumberGreaterThanOneTask;
import com.orion.math.number.tasks.check.IsNumberGreaterThanOrEqualToOneTask;
import com.orion.math.number.tasks.check.IsNumberLessThanOneTask;
import com.orion.math.number.tasks.check.IsNumberMinusOneTask;
import com.orion.math.number.tasks.check.IsNumberOneTask;
import com.orion.math.number.tasks.check.IsNumberZeroTask;
import com.orion.math.number.tasks.check.IsPositiveNumberTask;
import com.orion.math.number.tasks.query.GetModulusOfComplexNumberTask;
import com.orion.math.number.tasks.query.GetNumberTypeTask;
import com.orion.math.number.tasks.query.NumberCompareToTask;
import com.orion.math.number.tasks.transform.AddNumbersGETTask;
import com.orion.math.number.tasks.transform.DivideNumbersGETTask;
import com.orion.math.number.tasks.transform.ExponentiateNumberGETTask;
import com.orion.math.number.tasks.transform.MultiplyNumbersGETTask;
import com.orion.math.number.tasks.transform.SaveStringNumberValuesTask;
import com.orion.math.number.tasks.transform.SetNewNumberValuesGETTask;
import com.orion.math.number.tasks.transform.SetNewNumberValuesTask;
import com.orion.math.number.tasks.transform.SubtractNumbersGETTask;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

class NumberInternalService implements MathObject
{
    static boolean equals(ANumber x, Object y)
    {
        return NumberEqualsTask.run(x, y);
    }


    static boolean equal(Number x, Number y)
    {
        return equal(ANumber.of(x), ANumber.of(y));
    }


    static boolean equal(ANumber x, ANumber y)
    {
        return EqualTask.run(x, y);
    }


    static int hashCode(ANumber x)
    {
        return NumberHashCodeTask.run(x);
    }


    static int compareTo(ANumber x, ANumber y)
    {
        return NumberCompareToTask.run(x, y);
    }


    static int compareTo(ANumber x, Number y)
    {
        return NumberCompareToTask.run(x, y);
    }


    void saveNumberValues(ANumber x, String realValue, String imaginaryValue)
    {
        new SaveStringNumberValuesTask().run(x, realValue, imaginaryValue);
    }


    void saveNumberValues(ANumber x, String realValue, String imaginaryValue, int precision)
    {
        new SaveStringNumberValuesTask().run(x, realValue, imaginaryValue, precision);
    }


    void setNewValues(ANumber x, Number realValue, Number imaginaryValue)
    {
        new SetNewNumberValuesTask().run(x, realValue, imaginaryValue);
    }


    void setNewValues(ANumber x, Number realValue, Number imaginaryValue, int precision)
    {
        new SetNewNumberValuesTask().run(x, realValue, imaginaryValue, precision);
    }


    ANumber setNewValuesGET(ANumber x, Number realValue, Number imaginaryValue, int precision)
    {
        return new SetNewNumberValuesGETTask().run(x, realValue, imaginaryValue, precision);
    }


    ANumber addGET(ANumber x, List<?> numbers, boolean checkForNullNumbers)
    {
        return new AddNumbersGETTask().run(x, numbers, checkForNullNumbers);
    }


    ANumber addGET(ANumber x, List<?> numbers, int precision, boolean checkForNullNumbers)
    {
        return new AddNumbersGETTask().run(x, numbers, precision, checkForNullNumbers);
    }


    ANumber addGET(ANumber x, ANumber y)
    {
        return new AddNumbersGETTask().run(x, y);
    }


    ANumber addGET(ANumber x, ANumber y, int precision)
    {
        return new AddNumbersGETTask().run(x, y, precision);
    }


    ANumber addGET(ANumber x, Number y)
    {
        return new AddNumbersGETTask().run(x, y);
    }


    ANumber addGET(ANumber x, Number y, int precision)
    {
        return new AddNumbersGETTask().run(x, y, precision);
    }


    ANumber addOneGET(ANumber x)
    {
        ANumber newNumber = x.getCopy();
        newNumber.setRealValue(newNumber.get().add(BigDecimal.ONE));
        return newNumber;
    }


    ANumber subtractGET(ANumber x, ANumber y)
    {
        return new SubtractNumbersGETTask().run(x, y);
    }


    ANumber subtractGET(ANumber x, Number y)
    {
        return new SubtractNumbersGETTask().run(x, y);
    }


    ANumber multiplyGET(ANumber x, List<?> numbers, boolean checkForNullNumbers)
    {
        return new MultiplyNumbersGETTask().run(x, numbers, checkForNullNumbers);
    }


    ANumber multiplyGET(ANumber x, List<?> numbers, int precision, boolean checkForNullNumbers)
    {
        return new MultiplyNumbersGETTask().run(x, numbers, precision, checkForNullNumbers);
    }


    ANumber multiplyGET(ANumber x, ANumber y)
    {
        return new MultiplyNumbersGETTask().run(x, y);
    }


    ANumber multiplyGET(ANumber x, Number y)
    {
        return new MultiplyNumbersGETTask().run(x, y);
    }


    ANumber divideGET(ANumber x, ANumber y)
    {
        return new DivideNumbersGETTask().run(x, y);
    }


    ANumber divideGET(ANumber x, Number y)
    {
        return new DivideNumbersGETTask().run(x, y);
    }


    ANumber exponentiateGET(ANumber base, ANumber exponent)
    {
        return new ExponentiateNumberGETTask().run(base, exponent);
    }


    ANumber exponentiateGET(ANumber base, Number exponent)
    {
        return new ExponentiateNumberGETTask().run(base, exponent);
    }


    ANumber getModulus(ANumber x)
    {
        return GetModulusOfComplexNumberTask.run(x);
    }


    static NumberType getNumberType(ANumber x)
    {
        return GetNumberTypeTask.run(x);
    }


    static BigInteger getImaginaryValueAsBigInteger(ANumber x)
    {
        return x.getImaginaryValue().toBigInteger();
    }


    static BigInteger getRealValueAsBigInteger(ANumber x)
    {
        return x.get().toBigInteger();
    }


    static boolean isZero(Number x)
    {
        return IsNumberZeroTask.run(x);
    }


    static boolean isZero(ANumber x)
    {
        return isZero(x.get()) && isZero(x.getImaginaryValue());
    }


    static boolean isOne(Number x)
    {
        return IsNumberOneTask.run(x);
    }


    static boolean isMinusOne(Number x)
    {
        return IsNumberMinusOneTask.run(x);
    }


    static boolean isOne(ANumber x)
    {
        return isOne(x.get());
    }


    static boolean isMinusOne(ANumber x)
    {
        return isMinusOne(x.get());
    }


    static boolean isLessThanOne(Number x)
    {
        return IsNumberLessThanOneTask.run(x);
    }


    static boolean isLessThanOne(ANumber x)
    {
        return isLessThanOne(x.get());
    }


    static boolean isGreaterThanOne(Number x)
    {
        return IsNumberGreaterThanOneTask.run(x);
    }


    static boolean isGreaterThanOne(ANumber x)
    {
        return isGreaterThanOne(x.get());
    }


    static boolean isGreaterThanOrEqualToOne(Number x)
    {
        return IsNumberGreaterThanOrEqualToOneTask.run(x);
    }


    static boolean isGreaterThanOrEqualToOne(ANumber x)
    {
        return isGreaterThanOrEqualToOne(x.get());
    }


    static boolean isPositive(Number x)
    {
        return IsPositiveNumberTask.run(x);
    }


    static boolean isPositive(ANumber x)
    {
        return isPositive(x.get());
    }


    static boolean isNegative(Number x)
    {
        return IsNegativeNumberTask.run(x);
    }


    static boolean isNegative(ANumber x)
    {
        return isNegative(x.get());
    }
}