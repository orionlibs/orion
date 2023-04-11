package com.orion.math.geometry.trigonometry;

import com.orion.core.abstraction.OrionService;
import com.orion.math.constant.Constants;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.geometry.trigonometry.tasks.GetCosineInRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.GetSineInRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.NormaliseRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.getangle.GetArccosineAsRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.getangle.GetArcsineAsRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.getangle.GetArctangentAsRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.hyperbolic.GetHyperbolicCosineInRadiansTask;
import com.orion.math.geometry.trigonometry.tasks.hyperbolic.GetHyperbolicSineInRadiansTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.number.precision.Precision;

public class TrigonometryService extends OrionService
{
    public static ANumber getSineInRadians(ANumber x)
    {
        return getSineInRadians(x, Precision.precision);
    }


    public static ANumber getSineInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(x.isComplexNumber())
        {
            ANumber newRealValue = getSineInRadians(x.getAsANumber(), precision);
            newRealValue.multiply(getHyperbolicCosineInRadians(x.getImaginaryValueAsANumber(), precision));
            ANumber newImaginaryValue = getCosineInRadians(x.getAsANumber(), precision);
            newImaginaryValue.multiply(getHyperbolicSineInRadians(x.getImaginaryValueAsANumber(), precision));
            newImaginaryValue.negate();
            return ANumber.of(newRealValue, newImaginaryValue);
        }
        else
        {
            return GetSineInRadiansTask.run(x, precision);
        }

    }


    public static ANumber getSineInDegrees(ANumber x)
    {
        return getSineInDegrees(x, Precision.precision);
    }


    public static ANumber getSineInDegrees(ANumber x, int precision)
    {
        return GetSineInRadiansTask.run(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicSineInRadians(ANumber x)
    {
        return getHyperbolicSineInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicSineInRadians(ANumber x, int precision)
    {
        return GetHyperbolicSineInRadiansTask.run(x, precision);
    }


    public static ANumber getHyperbolicSineInDegrees(ANumber x)
    {
        return getHyperbolicSineInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicSineInDegrees(ANumber x, int precision)
    {
        return GetHyperbolicSineInRadiansTask.run(convertDegreesToRadians(x), precision);
    }


    public static ANumber getCosineInRadians(ANumber x)
    {
        return getCosineInRadians(x, Precision.DefaultPrecision);
    }


    public static ANumber getCosineInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(x.isComplexNumber())
        {
            ANumber newRealValue = getCosineInRadians(x.getAsANumber(), precision);
            newRealValue.multiply(getHyperbolicCosineInRadians(x.getImaginaryValueAsANumber(), precision));
            ANumber newImaginaryValue = getSineInRadians(x.getAsANumber(), precision);
            newImaginaryValue.multiply(getHyperbolicSineInRadians(x.getImaginaryValueAsANumber(), precision));
            newImaginaryValue.negate();
            return ANumber.of(newRealValue, newImaginaryValue);
        }
        else
        {
            return GetCosineInRadiansTask.run(x, precision);
        }

    }


    public static ANumber getCosineInDegrees(ANumber x)
    {
        return getCosineInDegrees(x, Precision.precision);
    }


    public static ANumber getCosineInDegrees(ANumber x, int precision)
    {
        return GetCosineInRadiansTask.run(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicCosineInRadians(ANumber x)
    {
        return getHyperbolicCosineInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicCosineInRadians(ANumber x, int precision)
    {
        return GetHyperbolicCosineInRadiansTask.run(x, precision);
    }


    public static ANumber getHyperbolicCosineInDegrees(ANumber x)
    {
        return getHyperbolicCosineInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicCosineInDegrees(ANumber x, int precision)
    {
        return GetHyperbolicCosineInRadiansTask.run(convertDegreesToRadians(x), precision);
    }


    public static ANumber getSecantInRadians(ANumber x)
    {
        return getSecantInRadians(x, Precision.precision);
    }


    public static ANumber getSecantInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);
        return getCosineInRadians(x, precision).reciprocateGET();
    }


    public static ANumber getSecantInDegrees(ANumber x)
    {
        return getSecantInDegrees(x, Precision.precision);
    }


    public static ANumber getSecantInDegrees(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);
        return getCosineInRadians(convertDegreesToRadians(x), precision).reciprocateGET();
    }


    public static ANumber getCosecantInRadians(ANumber x)
    {
        return getCosecantInRadians(x, Precision.precision);
    }


    public static ANumber getCosecantInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);
        return getSineInRadians(x, precision).reciprocateGET();
    }


    public static ANumber getCosecantInDegrees(ANumber x)
    {
        return getCosecantInDegrees(x, Precision.precision);
    }


    public static ANumber getCosecantInDegrees(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);
        return getSineInRadians(convertDegreesToRadians(x), precision).reciprocateGET();
    }


    public static ANumber getTangentInRadians(ANumber x)
    {
        return getTangentInRadians(x, Precision.precision);
    }


    public static ANumber getTangentInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(precision <= Precision.precision)
        {
            return ANumber.of(Math.tan(x.applyPrecisionGET(precision).get().doubleValue()));
        }
        else
        {
            return getSineInRadians(x, precision).divideGET(getCosineInRadians(x, precision));
        }

    }


    public static ANumber getTangentInDegrees(ANumber x)
    {
        return getTangentInDegrees(x, Precision.precision);
    }


    public static ANumber getTangentInDegrees(ANumber x, int precision)
    {
        return getTangentInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicTangentInRadians(ANumber x)
    {
        return getHyperbolicTangentInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicTangentInRadians(ANumber x, int precision)
    {
        NumberRules.isNotNull(x);

        if(precision <= Precision.precision)
        {
            return ANumber.of(Math.tanh(x.applyPrecisionGET(precision).get().doubleValue()));
        }
        else
        {
            return getHyperbolicSineInRadians(x, precision).divideGET(getHyperbolicCosineInRadians(x, precision));
        }

    }


    public static ANumber getHyperbolicTangentInDegrees(ANumber x)
    {
        return getHyperbolicTangentInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicTangentInDegrees(ANumber x, int precision)
    {
        return getHyperbolicTangentInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getCotangentInRadians(ANumber x)
    {
        return getCotangentInRadians(x, Precision.precision);
    }


    public static ANumber getCotangentInRadians(ANumber x, int precision)
    {
        Numbers.isNotNull(x);
        return getTangentInRadians(x.addGET(Constants.halfPI), precision).negateGET();
    }


    public static ANumber getCotangentInDegrees(ANumber x)
    {
        return getCotangentInDegrees(x, Precision.precision);
    }


    public static ANumber getCotangentInDegrees(ANumber x, int precision)
    {
        return getCotangentInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicCotangentInRadians(ANumber x)
    {
        return getHyperbolicCotangentInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicCotangentInRadians(ANumber x, int precision)
    {
        Numbers.isNotNull(x);
        return getHyperbolicTangentInRadians(x, precision).reciprocateGET();
    }


    public static ANumber getHyperbolicCotangentInDegrees(ANumber x)
    {
        return getHyperbolicCotangentInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicCotangentInDegrees(ANumber x, int precision)
    {
        return getHyperbolicCotangentInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicSecantInRadians(ANumber x)
    {
        return getHyperbolicSecantInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicSecantInRadians(ANumber x, int precision)
    {
        Numbers.isNotNull(x);
        return getHyperbolicCosecantInRadians(x, precision).reciprocateGET();
    }


    public static ANumber getHyperbolicSecantInDegrees(ANumber x)
    {
        return getHyperbolicSecantInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicSecantInDegrees(ANumber x, int precision)
    {
        return getHyperbolicSecantInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getHyperbolicCosecantInRadians(ANumber x)
    {
        return getHyperbolicCosecantInRadians(x, Precision.precision);
    }


    public static ANumber getHyperbolicCosecantInRadians(ANumber x, int precision)
    {
        Numbers.isNotNull(x);
        return getHyperbolicSineInRadians(x, precision).reciprocateGET();
    }


    public static ANumber getHyperbolicCosecantInDegrees(ANumber x)
    {
        return getHyperbolicCosecantInDegrees(x, Precision.precision);
    }


    public static ANumber getHyperbolicCosecantInDegrees(ANumber x, int precision)
    {
        return getHyperbolicCosecantInRadians(convertDegreesToRadians(x), precision);
    }


    public static ANumber getArcsineAsRadians(ANumber x)
    {
        return getArcsineAsRadians(x, Precision.precision);
    }


    public static ANumber getArcsineAsDegrees(ANumber x)
    {
        return getArcsineAsDegrees(x, Precision.precision);
    }


    public static ANumber getArcsineAsRadians(ANumber x, int precision)
    {
        return GetArcsineAsRadiansTask.run(x, precision);
    }


    public static ANumber getArcsineAsDegrees(ANumber x, int precision)
    {
        return convertRadiansToDegrees(GetArcsineAsRadiansTask.run(x, precision));
    }


    public static ANumber getArccosineAsRadians(ANumber x)
    {
        return getArccosineAsRadians(x, Precision.precision);
    }


    public static ANumber getArccosineAsRadians(ANumber x, int precision)
    {
        return GetArccosineAsRadiansTask.run(x, precision);
    }


    public static ANumber getArccosineAsDegrees(ANumber x)
    {
        return convertRadiansToDegrees(getArccosineAsRadians(x, Precision.precision));
    }


    public static ANumber getArccosineAsDegrees(ANumber x, int precision)
    {
        return convertRadiansToDegrees(getArccosineAsRadians(x, precision));
    }


    public static ANumber getArctangentAsRadians(ANumber x)
    {
        return getArctangentAsRadians(x, Precision.precision);
    }


    public static ANumber getArctangentAsDegrees(ANumber x)
    {
        return getArctangentAsDegrees(x, Precision.precision);
    }


    public static ANumber getArctangentAsRadians(ANumber x, int precision)
    {
        return GetArctangentAsRadiansTask.run(x, precision);
    }


    public static ANumber getArctangentAsDegrees(ANumber x, int precision)
    {
        return convertRadiansToDegrees(GetArctangentAsRadiansTask.run(x, precision));
    }


    public static ANumber convertDegreesToRadians(ANumber x)
    {
        Numbers.isNotNull(x);
        return x.multiplyGET(Constants.PI.getValue()).divideGET(180);
    }


    public static ANumber convertRadiansToDegrees(ANumber x)
    {
        Numbers.isNotNull(x);
        return ANumber.of(180).multiplyGET(x).divideGET(Constants.PI.getValue());
    }


    public static Function1x1<ANumber, ANumber> convertRadiansToDegrees(Function1x1<ANumber, ANumber> x)
    {
        FunctionRules.isValid(x);
        return x.multiply(ANumber.of(180)).divide(Constants.PI.getValue());
    }


    public static ANumber normaliseRadians(ANumber x)
    {
        return NormaliseRadiansTask.run(x);
    }
}