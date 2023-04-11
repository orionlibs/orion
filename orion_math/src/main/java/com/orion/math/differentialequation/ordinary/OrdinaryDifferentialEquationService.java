package com.orion.math.differentialequation.ordinary;

import com.orion.core.abstraction.OrionService;
import com.orion.math.differentialequation.ordinary.tasks.SolveFirstOrderOrdinaryDifferentialEquationUsingEulerMethodTask;
import com.orion.math.number.ANumber;

public class OrdinaryDifferentialEquationService extends OrionService
{
    /**
     * Given an ODE dy/dx = f(x, y) with initial condition y(x0) = y0
     * @param ode
     * @return
     */
    public static ANumber solveFirstOrderODEUsingEulerMethod(OrdinaryDifferentialEquation ode)
    {
        return SolveFirstOrderOrdinaryDifferentialEquationUsingEulerMethodTask.run(ode);
    }
}