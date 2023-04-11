package com.orion.math.function.tasks.onevariable.roots;

import com.orion.core.abstraction.Orion;
import com.orion.math.calculus.derivative.DifferentiationService;
import com.orion.math.function.FunctionRules;
import com.orion.math.function.onevariable.Function1x1;
import com.orion.math.function.tasks.roots.KeepUniqueRootsOfFunctionTask;
import com.orion.math.number.ANumber;
import com.orion.math.number.interval.Interval;
import com.orion.math.number.interval.IntervalRules;
import com.orion.math.number.precision.Precision;
import java.util.HashSet;
import java.util.Set;

public class GetRootsOfFunction1x1UsingNewtonRaphsonTask extends Orion
{
    public static ANumber[] run(Function1x1<ANumber, ANumber> f, Interval intervalToSearchForRoots, int precision)
    {
        FunctionRules.isValid(f);
        IntervalRules.isValid(intervalToSearchForRoots);
        precision = Precision.getValidPrecision(precision);
        ANumber EPS = Precision.getEPSAsNumber(precision);
        ANumber intervalLength = intervalToSearchForRoots.getLength();
        ANumber iterationsTemp = intervalLength.multiplyGET(5);
        int iterations = (iterationsTemp.isGreaterThan(1000)) ? 1000 : iterationsTemp.getAsInt();
        ANumber h = intervalLength.divideGET(iterations);
        Set<ANumber> tempRoots = new HashSet<ANumber>();
        ANumber x = intervalToSearchForRoots.getLeftEndpointCopy();
        int limitOfRootApproximationIterations = 1000;

        for(int i = 0; i < iterations; i++)
        {
            ANumber lastLeftEndpoint = x.getCopy();

            if(f.run(x).getAbsoluteValue().isLessThanOrEqual(EPS))
            {
                tempRoots.add(x);
            }
            else
            {
                ANumber temp = null;
                ANumber derivativeAtX = null;
                ANumber lastX = null;
                boolean rootFound = false;
                int rootApproximationIteration = 0;

                do
                {

                    if(rootApproximationIteration == limitOfRootApproximationIterations)
                    {
                        break;
                    }

                    derivativeAtX = DifferentiationService.differentiate(f, x, precision);

                    if(derivativeAtX.isZero())
                    {
                        break;
                    }

                    temp = f.run(x).divideGET(derivativeAtX);
                    lastX = x.getCopy();
                    x.subtract(temp);
                    ++rootApproximationIteration;
                    rootFound = true;
                }
                while(x.subtractGET(lastX).getAbsoluteValue().isGreaterThan(EPS));

                if(rootFound)
                {
                    tempRoots.add(x);
                }

            }

            x = lastLeftEndpoint.addGET(h);
        }

        return KeepUniqueRootsOfFunctionTask.run(tempRoots, EPS).toArray(new ANumber[0]);
    }
}