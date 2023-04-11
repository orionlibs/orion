package com.orion.math.number.precision;

import com.orion.math.MathObject;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import java.math.BigDecimal;

public class Precision implements MathObject
{
    public static final int DefaultPrecision = 15;
    public static final BigDecimal SystemEPS = initialiseAndGetDefaultTolerance();
    public static final ANumber SystemEPSAsNumber = ANumber.of(SystemEPS);
    public static final BigDecimal DefaultEPS = getEPS(DefaultPrecision);
    public static final ANumber DefaultEPSAsNumber = ANumber.of(DefaultEPS);
    public static int precision = DefaultPrecision;


    private static BigDecimal initialiseAndGetDefaultTolerance()
    {
        double dTemp = 0.5;

        while(1 + dTemp > 1)
        {
            dTemp /= 2;
        }

        return new BigDecimal(Double.toString(dTemp));
    }


    public static BigDecimal getEPS(int precision)
    {
        return BigDecimal.valueOf(5).movePointLeft(precision);
    }


    public static BigDecimal getTolerance(int precision)
    {
        return getTolerance(precision);
    }


    public static ANumber getEPSAsNumber(int precision)
    {
        return ANumber.of(getEPS(precision));
    }


    public static ANumber getToleranceAsNumber(int precision)
    {
        return getEPSAsNumber(precision);
    }


    public static ANumber getEPSAsNumber()
    {
        return ANumber.of(getEPS(precision));
    }


    public static ANumber getToleranceAsNumber()
    {
        return getEPSAsNumber(precision);
    }


    public static boolean isValid(int precision)
    {
        return precision > 0;
    }


    public static int getValidPrecision(int precision)
    {

        if(isValid(precision))
        {
            return precision;
        }
        else
        {
            return Precision.precision;
        }

    }


    public static int getValidPrecision(int precision1, int precision2)
    {

        if(isValid(precision1) && isValid(precision2))
        {
            return Math.max(precision1, precision2);
        }
        else if(isValid(precision1) && !isValid(precision2))
        {
            return getValidPrecision(precision1);
        }
        else if(!isValid(precision1) && isValid(precision2))
        {
            return getValidPrecision(precision2);
        }
        else
        {
            return Precision.precision;
        }

    }


    public static int getValidPrecision(ANumber x, Number y)
    {
        NumberRules.isNotNull(y);
        return getValidPrecision(x, ANumber.of(y));
    }


    public static int getValidPrecision(Number x, ANumber y)
    {
        NumberRules.isNotNull(x);
        return getValidPrecision(ANumber.of(x), y);
    }


    public static int getValidPrecision(Number x, Number y)
    {
        NumberRules.areNotNull(x, y);
        return getValidPrecision(ANumber.of(x), ANumber.of(y));
    }


    public static int getValidPrecision(ANumber x, ANumber y)
    {
        int maxNumberOfDecimalDigitsOfRealValue = Math.max(x.getNumberOfDecimalDigitsOfRealValue(), y.getNumberOfDecimalDigitsOfRealValue());
        int maxNumberOfDecimalDigitsOfImaginaryValue = Math.max(x.getNumberOfDecimalDigitsOfImaginaryValue(), y.getNumberOfDecimalDigitsOfImaginaryValue());
        return Math.max(maxNumberOfDecimalDigitsOfRealValue, maxNumberOfDecimalDigitsOfImaginaryValue);
    }


    public static int getValidPrecisionForMultiplicationOrDivision(ANumber x, ANumber y)
    {
        int realValuePrecision = x.getNumberOfDecimalDigitsOfRealValue() + y.getNumberOfDecimalDigitsOfRealValue();
        int imaginaryValuePrecision = x.getNumberOfDecimalDigitsOfImaginaryValue() + y.getNumberOfDecimalDigitsOfImaginaryValue();
        int precision = getValidPrecision(realValuePrecision, imaginaryValuePrecision);

        if(precision == 0)
        {
            return getValidPrecision(precision, Precision.precision);
        }
        else
        {
            return precision + 2;
        }

    }


    public static int getValidPrecision(ANumber x, ANumber y, int defaultPrecision)
    {
        int maxNumberOfDecimalDigits = getValidPrecision(x, y);
        int maxPrecision = Math.max(maxNumberOfDecimalDigits, defaultPrecision);

        if(isValid(maxPrecision))
        {
            return maxPrecision;
        }
        else
        {
            return Precision.precision;
        }

    }
}