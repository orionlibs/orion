package com.orion.math.differentialequation.ordinary.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.differentialequation.ordinary.OrdinaryDifferentialEquation;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.number.ANumber;

public class SolveFirstOrderOrdinaryDifferentialEquationUsingEulerMethodTask extends Orion
{
    public static ANumber run(OrdinaryDifferentialEquation ode)
    {
        ANumber x0 = ode.getInitialConditionX0().getCopy();
        ANumber x = ode.getxAtWhichToApproximateSolution().getCopy();
        ANumber y = ode.getInitialConditionY0().getCopy();
        ANumber h = ode.getH().getCopy();
        Function2x1<ANumber, ANumber, ANumber> function = ode.getFunction();

        while(x0.isLessThan(x))
        {
            y.add(h.multiplyGET(function.run(x0, y)));
            x0.add(h);
        }

        return y;
    }
}