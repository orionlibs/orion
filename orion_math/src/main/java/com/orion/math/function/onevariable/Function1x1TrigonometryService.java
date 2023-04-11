package com.orion.math.function.onevariable;

import com.orion.core.abstraction.OrionService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.Functions;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;

public class Function1x1TrigonometryService extends OrionService
{
    public static Function1x1<ANumber, ANumber> getSineInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.sin.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getSineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.sin.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArcsineAsRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.arcsin.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArcsineAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return TrigonometryService.convertRadiansToDegrees(getArcsineAsRadians(f));
    }


    public static Function1x1<ANumber, ANumber> getCosineInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.cos.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getCosineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.cos.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArccosineAsRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.arccos.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArccosineAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return TrigonometryService.convertRadiansToDegrees(getArccosineAsRadians(f));
    }


    public static Function1x1<ANumber, ANumber> getTangentInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.tan.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getTangentInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.tan.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArctangentAsRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.arctan.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getArctangentAsDegrees(Function1x1<ANumber, ANumber> f)
    {
        return TrigonometryService.convertRadiansToDegrees(getArctangentAsRadians(f));
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicSineInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.sinh.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicSineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.sinh.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicCosineInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.cosh.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicCosineInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.cosh.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicTangentInRadians(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.tanh.run(f.run(x)));
        return Function1x1.<ANumber, ANumber>of(func);
    }


    public static Function1x1<ANumber, ANumber> getHyperbolicTangentInDegrees(Function1x1<ANumber, ANumber> f)
    {
        FunctionRules.isValid(f);
        Function1x1IF<ANumber, ANumber> func = (x -> Functions.tanh.run(TrigonometryService.convertDegreesToRadians(f.run(x))));
        return Function1x1.<ANumber, ANumber>of(func);
    }
}