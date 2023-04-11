package com.orion.math.differentialequation;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.orion.math.differentialequation.ordinary.OrdinaryDifferentialEquation;
import com.orion.math.differentialequation.ordinary.OrdinaryDifferentialEquationService;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.function.twovariables.Function2x1IF;
import com.orion.math.number.ANumber;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class OrdinaryDifferentialEquationServiceTest
{
    @Test
    public void test_solveFirstOrderODEUsingEulerMethod()
    {
        Function2x1IF<ANumber, ANumber, ANumber> function = (ANumber x, ANumber y) -> (x.addGET(y).addGET(x.multiplyGET(y)));
        Function2x1<ANumber, ANumber, ANumber> func = Function2x1.<ANumber, ANumber, ANumber>of(function);
        OrdinaryDifferentialEquation ode = OrdinaryDifferentialEquation.of(func, ANumber.of(0), ANumber.of(1), ANumber.of("0.025"), ANumber.of("0.1"));
        ANumber result = OrdinaryDifferentialEquationService.solveFirstOrderODEUsingEulerMethod(ode);
        assertTrue(ANumber.of("1.11167298416748046875").equal(result));
    }
}