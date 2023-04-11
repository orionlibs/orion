package com.orion.math.function;

import com.orion.core.abstraction.Orion;
import com.orion.core.runnable.functions.OrionFunction;
import com.orion.math.MathObject;
import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.combinatorics.CombinatoricsService;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.Function1x1IF;
import com.orion.math.function.tasks.GetRunMethodOfFunctionTask;
import com.orion.math.function.threevariables.Function3x1;
import com.orion.math.function.threevariables.Function3x1IF;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.geometry.trigonometry.TrigonometryService;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.number.average.AverageService;
import com.orion.math.number.services.NumberService;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.IntStream;

public class Functions extends Orion implements MathObject
{
    public static Function1x1<ANumber, ANumber> sin;
    public static Function1x1<ANumber, ANumber> cos;
    public static Function1x1<ANumber, ANumber> tan;
    public static Function1x1<ANumber, ANumber> sinh;
    public static Function1x1<ANumber, ANumber> cosh;
    public static Function1x1<ANumber, ANumber> tanh;
    public static Function1x1<ANumber, ANumber> coth;
    public static Function1x1<ANumber, ANumber> sech;
    public static Function1x1<ANumber, ANumber> cosech;
    public static Function1x1<ANumber, ANumber> cotan;
    public static Function1x1<ANumber, ANumber> secant;
    public static Function1x1<ANumber, ANumber> cosecant;
    public static Function1x1<ANumber, ANumber> arcsin;
    public static Function1x1<ANumber, ANumber> arccos;
    public static Function1x1<ANumber, ANumber> arctan;
    public static Function1x1<List<ANumber>, ANumber> avg;
    public static Function1x1<List<ANumber>, ANumber> gavg;
    public static Function2x1<ANumber, ANumber, ANumber> gcd;
    public static Function2x1<ANumber, ANumber, ANumber> lcm;
    public static Function2x1<ANumber, Integer, ANumber> round;
    public static Function1x1<ANumber, ANumber> reciprocate;
    public static Function1x1<List<ANumber>, ANumber> min;
    public static Function1x1<List<ANumber>, ANumber> max;
    public static Function1x1<ANumber, ANumber> factorial;
    public static Function1x1<ANumber, ANumber> abs;
    public static Function1x1<ANumber, ANumber> sqrt;
    public static Function1x1<ANumber, ANumber> cbrt;
    public static Function2x1<ANumber, Integer, ANumber> nthrt;
    public static Function1x1<ANumber, ANumber> exp;
    public static Function1x1<ANumber, ANumber> ln;
    public static Function1x1<ANumber, ANumber> log2;
    public static Function1x1<ANumber, ANumber> log10;
    public static Function2x1<ANumber, ANumber, ANumber> log;
    public static Function1x1<List<ANumber>, ANumber> sum;
    public static Function2x1<ANumber, ANumber, ANumber> remainder;
    public static Function1x1<ANumber, ANumber> ceil;
    public static Function1x1<ANumber, ANumber> floor;
    public static Function2x1<ANumber, ANumber, ANumber> random;
    public static Function1x1<ANumber, Integer> sign;
    public static Function1x1<List<ANumber>, ANumber> havg;
    public static Function1x1<List<ANumber>, ANumber> qavg;
    public static Function2x1<Function1x1<ANumber, ANumber>, ANumber, ANumber> derivative;
    public static Function3x1<Function1x1<ANumber, ANumber>, ANumber, Integer, ANumber> derivativePrecision;
    public static Function2x1<ANumber, ANumber, ANumber> combinations;
    static
    {
        Function1x1IF<ANumber, ANumber> sinFunction = (ANumber x) -> (TrigonometryService.getSineInRadians(x));
        sin = Function1x1.<ANumber, ANumber>of(sinFunction);
        Function1x1IF<ANumber, ANumber> cosFunction = (ANumber x) -> (TrigonometryService.getCosineInRadians(x));
        cos = Function1x1.<ANumber, ANumber>of(cosFunction);
        Function1x1IF<ANumber, ANumber> tanFunction = (ANumber x) -> (TrigonometryService.getTangentInRadians(x));
        tan = Function1x1.<ANumber, ANumber>of(tanFunction);
        Function1x1IF<ANumber, ANumber> sinhFunction = (ANumber x) -> (TrigonometryService.getHyperbolicSineInRadians(x));
        sinh = Function1x1.<ANumber, ANumber>of(sinhFunction);
        Function1x1IF<ANumber, ANumber> coshFunction = (ANumber x) -> (TrigonometryService.getHyperbolicCosineInRadians(x));
        cosh = Function1x1.<ANumber, ANumber>of(coshFunction);
        Function1x1IF<ANumber, ANumber> tanhFunction = (ANumber x) -> (TrigonometryService.getHyperbolicTangentInRadians(x));
        tanh = Function1x1.<ANumber, ANumber>of(tanhFunction);
        Function1x1IF<ANumber, ANumber> cothFunction = (ANumber x) -> (TrigonometryService.getHyperbolicCotangentInRadians(x));
        coth = Function1x1.<ANumber, ANumber>of(cothFunction);
        Function1x1IF<ANumber, ANumber> sechFunction = (ANumber x) -> (TrigonometryService.getHyperbolicSecantInRadians(x));
        sech = Function1x1.<ANumber, ANumber>of(sechFunction);
        Function1x1IF<ANumber, ANumber> cosechFunction = (ANumber x) -> (TrigonometryService.getHyperbolicCosecantInRadians(x));
        cosech = Function1x1.<ANumber, ANumber>of(cosechFunction);
        Function1x1IF<ANumber, ANumber> cotanFunction = (ANumber x) -> (TrigonometryService.getCotangentInRadians(x));
        cotan = Function1x1.<ANumber, ANumber>of(cotanFunction);
        Function1x1IF<ANumber, ANumber> secantFunction = (ANumber x) -> (TrigonometryService.getSecantInRadians(x));
        secant = Function1x1.<ANumber, ANumber>of(secantFunction);
        Function1x1IF<ANumber, ANumber> cosecantFunction = (ANumber x) -> (TrigonometryService.getCosecantInRadians(x));
        cosecant = Function1x1.<ANumber, ANumber>of(cosecantFunction);
        Function1x1IF<ANumber, ANumber> arcsinFunction = (ANumber x) -> (TrigonometryService.getArcsineAsRadians(x));
        arcsin = Function1x1.<ANumber, ANumber>of(arcsinFunction);
        Function1x1IF<ANumber, ANumber> arccosFunction = (ANumber x) -> (TrigonometryService.getArccosineAsRadians(x));
        arccos = Function1x1.<ANumber, ANumber>of(arccosFunction);
        Function1x1IF<ANumber, ANumber> arctanFunction = (ANumber x) -> (TrigonometryService.getArctangentAsRadians(x));
        arctan = Function1x1.<ANumber, ANumber>of(arctanFunction);
        Function1x1IF<List<ANumber>, ANumber> avgFunction = (List<ANumber> x) -> (AverageService.getArithmeticAverage(x));
        avg = new Function1x1<List<ANumber>, ANumber>(avgFunction);
        Function1x1IF<List<ANumber>, ANumber> gavgFunction = (List<ANumber> x) -> (AverageService.getGeometricAverage(x));
        gavg = new Function1x1<List<ANumber>, ANumber>(gavgFunction);
        Function2x1IF<ANumber, ANumber, ANumber> gcdFunction = (ANumber x, ANumber y) -> (NumberService.getGreatestCommonDivisor(x, y));
        gcd = new Function2x1<ANumber, ANumber, ANumber>(gcdFunction);
        Function2x1IF<ANumber, ANumber, ANumber> lcmFunction = (ANumber x, ANumber y) -> (NumberService.getLeastCommonMultiple(x, y));
        lcm = new Function2x1<ANumber, ANumber, ANumber>(lcmFunction);
        Function2x1IF<ANumber, Integer, ANumber> roundFunction = (ANumber x, Integer precision) -> (ArithmeticService.round(x, precision));
        round = new Function2x1<ANumber, Integer, ANumber>(roundFunction);
        Function1x1IF<ANumber, ANumber> reciprocateFunction = (ANumber x) -> x.reciprocateGET();
        reciprocate = Function1x1.<ANumber, ANumber>of(reciprocateFunction);
        Function1x1IF<List<ANumber>, ANumber> minFunction = (List<ANumber> x) -> (ArithmeticService.getMinimum(x));
        min = new Function1x1<List<ANumber>, ANumber>(minFunction);
        Function1x1IF<List<ANumber>, ANumber> maxFunction = (List<ANumber> x) -> (ArithmeticService.getMaximum(x));
        max = new Function1x1<List<ANumber>, ANumber>(maxFunction);
        Function1x1IF<ANumber, ANumber> factorialFunction = (ANumber x) -> (ArithmeticService.getFactorial(x));
        factorial = Function1x1.<ANumber, ANumber>of(factorialFunction);
        Function1x1IF<ANumber, ANumber> absFunction = (ANumber x) -> x.getAbsoluteValue();
        abs = Function1x1.<ANumber, ANumber>of(absFunction);
        Function1x1IF<ANumber, ANumber> sqrtFunction = (ANumber x) -> x.getNthRoot(2);
        sqrt = Function1x1.<ANumber, ANumber>of(sqrtFunction);
        Function1x1IF<ANumber, ANumber> cbrtFunction = (ANumber x) -> x.getNthRoot(3);
        cbrt = Function1x1.<ANumber, ANumber>of(cbrtFunction);
        Function2x1IF<ANumber, Integer, ANumber> nthrtFunction = (ANumber x, Integer n) -> x.getNthRoot(n);
        nthrt = new Function2x1<ANumber, Integer, ANumber>(nthrtFunction);
        Function1x1IF<ANumber, ANumber> expFunction = (ANumber x) -> (ArithmeticService.getEToThePowerOf(x));
        exp = new Function1x1<ANumber, ANumber>(expFunction);
        Function1x1IF<ANumber, ANumber> lnFunction = (ANumber x) -> x.getNeperianLogarithm();
        ln = Function1x1.<ANumber, ANumber>of(lnFunction);
        Function1x1IF<ANumber, ANumber> log2Function = (ANumber x) -> (ArithmeticService.getLogarithmBase2(x));
        log2 = Function1x1.<ANumber, ANumber>of(log2Function);
        Function1x1IF<ANumber, ANumber> log10Function = (ANumber x) -> (ArithmeticService.getLogarithmBase10(x));
        log10 = Function1x1.<ANumber, ANumber>of(log10Function);
        Function2x1IF<ANumber, ANumber, ANumber> logFunction = (ANumber base, ANumber x) -> (ArithmeticService.getLogarithm(base, x));
        log = new Function2x1<ANumber, ANumber, ANumber>(logFunction);
        Function1x1IF<List<ANumber>, ANumber> sumFunction = (List<ANumber> x) -> (ArithmeticService.add(x));
        sum = new Function1x1<List<ANumber>, ANumber>(sumFunction);
        Function2x1IF<ANumber, ANumber, ANumber> remainderFunction = (ANumber x, ANumber divisor) -> (ArithmeticService.getRemainderOfDivision(x, divisor));
        remainder = new Function2x1<ANumber, ANumber, ANumber>(remainderFunction);
        Function1x1IF<ANumber, ANumber> ceilFunction = (ANumber x) -> (NumberService.getCeiling(x));
        ceil = Function1x1.<ANumber, ANumber>of(ceilFunction);
        Function1x1IF<ANumber, ANumber> floorFunction = (ANumber x) -> (NumberService.getFloor(x));
        floor = Function1x1.<ANumber, ANumber>of(floorFunction);
        Function2x1IF<ANumber, ANumber, ANumber> randomFunction = (ANumber start, ANumber end) -> (NumberService.getRandomNumber(start, end));
        random = new Function2x1<ANumber, ANumber, ANumber>(randomFunction);
        Function1x1IF<ANumber, Integer> signFunction = (ANumber x) -> x.getSignum();
        sign = Function1x1.<ANumber, Integer>of(signFunction);
        Function1x1IF<List<ANumber>, ANumber> havgFunction = (List<ANumber> x) -> (AverageService.getHarmonicAverage(x));
        havg = new Function1x1<List<ANumber>, ANumber>(havgFunction);
        Function1x1IF<List<ANumber>, ANumber> qavgFunction = (List<ANumber> x) -> (AverageService.getQuadraticAverage(x));
        qavg = new Function1x1<List<ANumber>, ANumber>(qavgFunction);
        Function2x1IF<Function1x1<ANumber, ANumber>, ANumber, ANumber> derivativeFunction = (Function1x1<ANumber, ANumber> f, ANumber x) -> (DifferentiationService.differentiate(f, x));
        derivative = new Function2x1<Function1x1<ANumber, ANumber>, ANumber, ANumber>(derivativeFunction);
        Function3x1IF<Function1x1<ANumber, ANumber>, ANumber, Integer, ANumber> derivativePrecisionFunction = (Function1x1<ANumber, ANumber> f, ANumber x, Integer p) -> (DifferentiationService.differentiate(f, x, p));
        derivativePrecision = new Function3x1<Function1x1<ANumber, ANumber>, ANumber, Integer, ANumber>(derivativePrecisionFunction);
        Function2x1IF<ANumber, ANumber, ANumber> combinationsFunction = (ANumber x, ANumber y) -> (CombinatoricsService.getNumberOfCombinations(x, y));
        combinations = new Function2x1<ANumber, ANumber, ANumber>(combinationsFunction);
    }


    public static boolean isValid(OrionFunction f)
    {
        return f != null;
    }


    public static boolean isNotValid(OrionFunction f)
    {
        return !isValid(f);
    }


    public static boolean isThereOnly1Variable(boolean[] indicesOfVariablesThatAreConstants)
    {
        return IntStream.range(0, indicesOfVariablesThatAreConstants.length)
                        .filter(i -> !indicesOfVariablesThatAreConstants[i])
                        .count() == 1L;
    }


    public static Method getRunMethod(OrionFunction f)
    {
        return GetRunMethodOfFunctionTask.run(f);
    }
}