package com.orion.math.calculus.derivative;

import com.orion.core.abstraction.OrionService;
import com.orion.math.calculus.derivative.tasks.function1x1.GetDerivativeFunctionForFunction1x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function2x1.GetPartialDerivativeFunctionOnXForFunction2x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function2x1.GetPartialDerivativeFunctionOnYForFunction2x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function3x1.GetPartialDerivativeFunctionOnXForFunction3x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function3x1.GetPartialDerivativeFunctionOnYForFunction3x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function3x1.GetPartialDerivativeFunctionOnZForFunction3x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function4x1.GetPartialDerivativeFunctionOnWForFunction4x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function4x1.GetPartialDerivativeFunctionOnXForFunction4x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function4x1.GetPartialDerivativeFunctionOnYForFunction4x1Task;
import com.orion.math.calculus.derivative.tasks.partial.function4x1.GetPartialDerivativeFunctionOnZForFunction4x1Task;
import com.orion.math.calculus.derivative.tasks.partial.functionNx1.GetPartialDerivativeFunctionForFunctionNx1Task;
import com.orion.math.function.fourvariables.Function4x1;
import com.orion.math.function.nvariables.FunctionNx1;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.precision.Precision;
import java.util.List;

public class DifferentiationService extends OrionService
{
    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function1x1<ANumber, ANumber> differentiate(Function1x1 f)
    {
        return GetDerivativeFunctionForFunction1x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function1x1<ANumber, ANumber> differentiate(Function1x1 f, int precision)
    {
        return GetDerivativeFunctionForFunction1x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function1x1<ANumber, ANumber> differentiate(Function1x1 f, int precision, int orderOfDerivative)
    {
        return GetDerivativeFunctionForFunction1x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber differentiate(Function1x1 f, ANumber x)
    {
        return differentiate(f).run(x);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber differentiate(Function1x1 f, ANumber x, int precision)
    {
        return differentiate(f, precision, 1).run(x);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber differentiate(Function1x1 f, int orderOfDerivative, ANumber x)
    {
        return differentiate(f, Precision.precision, orderOfDerivative).run(x);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber differentiate(Function1x1 f, ANumber x, int precision, int orderOfDerivative)
    {
        return differentiate(f, precision, orderOfDerivative).run(x);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f, ANumber y)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f, y);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f, ANumber y, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f, y, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function2x1 f, ANumber y, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction2x1Task.run(f, y, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f, ANumber x)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f, x);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f, ANumber x, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f, x, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function2x1<ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function2x1 f, ANumber x, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction2x1Task.run(f, x, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f, ANumber y, ANumber z)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f, y, z);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f, ANumber y, ANumber z, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f, y, z, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function3x1 f, ANumber y, ANumber z, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction3x1Task.run(f, y, z, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f, ANumber x, ANumber z)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f, x, z);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f, ANumber x, ANumber z, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f, x, z, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function3x1 f, ANumber x, ANumber z, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction3x1Task.run(f, x, z, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f, ANumber x, ANumber y)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f, x, y);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f, ANumber x, ANumber y, int precision)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f, x, y, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function3x1<ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function3x1 f, ANumber x, ANumber y, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnZForFunction3x1Task.run(f, x, y, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f, ANumber y, ANumber z, ANumber w)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f, y, z, w);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f, ANumber y, ANumber z, ANumber w, int precision)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f, y, z, w, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnX(Function4x1 f, ANumber y, ANumber z, ANumber w, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnXForFunction4x1Task.run(f, y, z, w, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f, ANumber x, ANumber z, ANumber w)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f, x, z, w);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f, ANumber x, ANumber z, ANumber w, int precision)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f, x, z, w, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnY(Function4x1 f, ANumber x, ANumber z, ANumber w, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnYForFunction4x1Task.run(f, x, z, w, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f, ANumber x, ANumber y, ANumber w)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f, x, y, w);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f, ANumber x, ANumber y, ANumber w, int precision)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f, x, y, w, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnZ(Function4x1 f, ANumber x, ANumber y, ANumber w, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnZForFunction4x1Task.run(f, x, y, w, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f, int precision)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f, precision, orderOfDerivative);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f, ANumber x, ANumber y, ANumber z)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f, x, y, z);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f, ANumber x, ANumber y, ANumber z, int precision)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f, x, y, z, precision);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static Function4x1<ANumber, ANumber, ANumber, ANumber, ANumber> getPartialDerivativeOnW(Function4x1 f, ANumber x, ANumber y, ANumber z, int precision, int orderOfDerivative)
    {
        return GetPartialDerivativeFunctionOnWForFunction4x1Task.run(f, x, y, z, precision, orderOfDerivative);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, ANumber[] values)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, List<ANumber> values)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, ANumber[] values, int precision)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values, precision);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, List<ANumber> values, int precision)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values, precision);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, ANumber[] values, int orderOfDerivative, int precision)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values, precision, orderOfDerivative);
    }


    public static FunctionNx1 getPartialDerivative(FunctionNx1 f, List<ANumber> values, int orderOfDerivative, int precision)
    {
        return GetPartialDerivativeFunctionForFunctionNx1Task.run(f, values, precision, orderOfDerivative);
    }
}