package com.orion.math.function;

import com.orion.math.MathObject;
import com.orion.math.function.tasks.GetIndexOfVariableTask;
import com.orion.math.function.tasks.checks.CanFunctionRunWithGivenIntervalTask;
import com.orion.math.function.tasks.checks.CanFunctionRunWithGivenValueTask;
import com.orion.math.function.tasks.checks.CanFunctionRunWithGivenValuesTask;
import com.orion.math.number.interval.Interval;

class FunctionInternalService implements MathObject
{
    static int getIndexOfVariable(Function f, int index)
    {
        return GetIndexOfVariableTask.run(f, index);
    }


    static boolean canFunctionRunWithGivenValue(Function f, Object value)
    {
        return CanFunctionRunWithGivenValueTask.run(f, value);
    }


    static boolean canFunctionRunWithGivenValues(Function f, Object value1, Object value2)
    {
        return CanFunctionRunWithGivenValuesTask.run(f, value1, value2);
    }


    static boolean canFunctionRunWithGivenValues(Function f, Object value1, Object value2, Object value3)
    {
        return CanFunctionRunWithGivenValuesTask.run(f, value1, value2, value3);
    }


    static boolean canFunctionRunWithGivenValues(Function f, Object value1, Object value2, Object value3, Object value4)
    {
        return CanFunctionRunWithGivenValuesTask.run(f, value1, value2, value3, value4);
    }


    static boolean canFunctionRunWithGivenInterval(Function f, Interval intervalToCheck)
    {
        return CanFunctionRunWithGivenIntervalTask.run(f, intervalToCheck);
    }
}