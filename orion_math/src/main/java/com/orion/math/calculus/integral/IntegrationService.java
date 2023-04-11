package com.orion.math.calculus.integral;

import com.orion.core.abstraction.OrionService;
import com.orion.math.calculus.integral.tasks.IntegrateUsingTrapezoidalRuleForFunction1x1Task;
import com.orion.math.calculus.integral.tasks.IntegrateUsingTrapezoidalRuleForFunction2x1Task;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.onevariable.IdentityFunction;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;

public class IntegrationService extends OrionService
{
    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber integrate(Function1x1 f, Interval integrationInterval)
    {
        return integrate(f, integrationInterval, 200);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static ANumber integrate(Function1x1 f, Interval integrationInterval, int iterations)
    {
        return IntegrateUsingTrapezoidalRuleForFunction1x1Task.run(f, integrationInterval, iterations);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber integrate(IdentityFunction f, Interval integrationInterval)
    {
        return integrate(f, integrationInterval, 200);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static ANumber integrate(IdentityFunction f, Interval integrationInterval, int iterations)
    {
        FunctionRules.isValid(f);
        return IntegrateUsingTrapezoidalRuleForFunction1x1Task.run(f.getFunctionCasted(), integrationInterval, iterations);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber integrate(Function2x1 f, Interval intervalForX, ANumber y)
    {
        return integrate(f, intervalForX, y, 200);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static ANumber integrate(Function2x1 f, Interval intervalForX, ANumber y, int iterations)
    {
        return new IntegrateUsingTrapezoidalRuleForFunction2x1Task().run(f, intervalForX, y, iterations);
    }


    @SuppressWarnings(
    {"rawtypes"})
    public static ANumber integrate(Function2x1 f, ANumber x, Interval intervalForY)
    {
        return integrate(f, x, intervalForY, 200);
    }


    @SuppressWarnings(
    {"rawtypes", "unchecked"})
    public static ANumber integrate(Function2x1 f, ANumber x, Interval intervalForY, int iterations)
    {
        return new IntegrateUsingTrapezoidalRuleForFunction2x1Task().run(f, x, intervalForY, iterations);
    }
}