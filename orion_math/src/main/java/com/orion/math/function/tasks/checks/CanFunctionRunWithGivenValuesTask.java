package com.orion.math.function.tasks.checks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.exception.InvalidArgumentException;
import com.orion.math.function.Function;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.domain.FunctionDomain2x1;
import com.orion.math.function.domain.FunctionDomain3x1;
import com.orion.math.function.domain.FunctionDomain4x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.Numbers;

public class CanFunctionRunWithGivenValuesTask extends Orion
{
    public static boolean run(Function f, Object value1, Object value2)
    {
        FunctionRules.isValid(f);
        Assert.notNull(value1, "The value1 input cannot be null.");
        Assert.notNull(value2, "The value2 input cannot be null.");
        boolean isValue1Valid = false;
        boolean isValue2Valid = false;

        if(f.getDomain() == null)
        {
            return true;
        }
        else
        {

            if(value1 instanceof ANumber && Numbers.isValidNumber((ANumber)value1))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1().isPointInsideInterval((ANumber)value1))
                        {
                            isValue1Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable1().contains(value1))
            {
                isValue1Valid = true;
            }

            if(value2 instanceof ANumber && Numbers.isValidNumber((ANumber)value2))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2().isPointInsideInterval((ANumber)value2))
                        {
                            isValue2Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable2().contains(value2))
            {
                isValue2Valid = true;
            }

        }

        if(isValue1Valid && isValue2Valid)
        {
            return true;
        }
        else
        {
            throw new InvalidArgumentException("The given values do not belong to the function's domain.");
        }

    }


    public static boolean run(Function f, Object value1, Object value2, Object value3)
    {
        FunctionRules.isValid(f);
        Assert.notNull(value1, "The value1 input cannot be null.");
        Assert.notNull(value2, "The value2 input cannot be null.");
        Assert.notNull(value3, "The value3 input cannot be null.");
        boolean isValue1Valid = false;
        boolean isValue2Valid = false;
        boolean isValue3Valid = false;

        if(f.getDomain() == null)
        {
            return true;
        }
        else
        {

            if(value1 instanceof ANumber && Numbers.isValidNumber((ANumber)value1))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1().isPointInsideInterval((ANumber)value1))
                        {
                            isValue1Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable1().contains(value1))
            {
                isValue1Valid = true;
            }

            if(value2 instanceof ANumber && Numbers.isValidNumber((ANumber)value2))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2().isPointInsideInterval((ANumber)value2))
                        {
                            isValue2Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable2().contains(value2))
            {
                isValue2Valid = true;
            }

            if(value3 instanceof ANumber && Numbers.isValidNumber((ANumber)value3))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain3x1)f.getDomain()).getIntervalOfVariable3() != null)
                    {

                        if(((FunctionDomain3x1)f.getDomain()).getIntervalOfVariable3().isPointInsideInterval((ANumber)value3))
                        {
                            isValue3Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain3x1)f.getDomain()).getAllowedValuesForVariable3().contains(value3))
            {
                isValue3Valid = true;
            }

        }

        if(isValue1Valid && isValue2Valid && isValue3Valid)
        {
            return true;
        }
        else
        {
            throw new InvalidArgumentException("The given values do not belong to the function's domain.");
        }

    }


    public static boolean run(Function f, Object value1, Object value2, Object value3, Object value4)
    {
        FunctionRules.isValid(f);
        Assert.notNull(value1, "The value1 input cannot be null.");
        Assert.notNull(value2, "The value2 input cannot be null.");
        Assert.notNull(value3, "The value3 input cannot be null.");
        Assert.notNull(value4, "The value4 input cannot be null.");
        boolean isValue1Valid = false;
        boolean isValue2Valid = false;
        boolean isValue3Valid = false;
        boolean isValue4Valid = false;

        if(f.getDomain() == null)
        {
            return true;
        }
        else
        {

            if(value1 instanceof ANumber && Numbers.isValidNumber((ANumber)value1))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable1().isPointInsideInterval((ANumber)value1))
                        {
                            isValue1Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable1().contains(value1))
            {
                isValue1Valid = true;
            }

            if(value2 instanceof ANumber && Numbers.isValidNumber((ANumber)value2))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2() != null)
                    {

                        if(((FunctionDomain2x1)f.getDomain()).getIntervalOfVariable2().isPointInsideInterval((ANumber)value2))
                        {
                            isValue2Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain2x1)f.getDomain()).getAllowedValuesForVariable2().contains(value2))
            {
                isValue2Valid = true;
            }

            if(value3 instanceof ANumber && Numbers.isValidNumber((ANumber)value3))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain3x1)f.getDomain()).getIntervalOfVariable3() != null)
                    {

                        if(((FunctionDomain3x1)f.getDomain()).getIntervalOfVariable3().isPointInsideInterval((ANumber)value3))
                        {
                            isValue3Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain3x1)f.getDomain()).getAllowedValuesForVariable3().contains(value3))
            {
                isValue3Valid = true;
            }

            if(value4 instanceof ANumber && Numbers.isValidNumber((ANumber)value4))
            {

                if(f.getDomain() != null)
                {

                    if(((FunctionDomain4x1)f.getDomain()).getIntervalOfVariable4() != null)
                    {

                        if(((FunctionDomain4x1)f.getDomain()).getIntervalOfVariable4().isPointInsideInterval((ANumber)value4))
                        {
                            isValue4Valid = true;
                        }

                    }

                }

            }
            else if(((FunctionDomain4x1)f.getDomain()).getAllowedValuesForVariable4().contains(value4))
            {
                isValue4Valid = true;
            }

        }

        if(isValue1Valid && isValue2Valid && isValue3Valid && isValue4Valid)
        {
            return true;
        }
        else
        {
            throw new InvalidArgumentException("The given values do not belong to the function's domain.");
        }

    }
}