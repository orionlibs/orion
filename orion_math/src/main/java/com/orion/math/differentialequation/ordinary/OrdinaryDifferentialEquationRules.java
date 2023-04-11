package com.orion.math.differentialequation.ordinary;

import com.orion.core.exception.Assert;
import com.orion.math.MathRule;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.linearalgebra.matrix.MatrixRules;
import com.orion.math.number.ANumber;

public class OrdinaryDifferentialEquationRules extends MathRule
{
    public static void isValid(Vector timeSteps, Matrix internalWeights, Vector propagationWeights)
    {
        VectorRules.isValid(timeSteps);
        MatrixRules.isValid(internalWeights);
        VectorRules.isValid(propagationWeights);
    }


    public static void isValid(OrdinaryDifferentialEquation ode)
    {
        Assert.notNull(ode, "The OrdinaryDifferentialEquation input cannot be null.");
        isValid(ode.getTimeSteps(), ode.getInternalWeights(), ode.getPropagationWeights());
    }


    public static void isValid(Function2x1<ANumber, ANumber, ANumber> function, ANumber initialConditionX0, ANumber initialConditionY0, ANumber h, ANumber xAtWhichToApproximateSolution)
    {
        Assert.notNull(function, "The function input cannot be null.");
        Assert.notNull(initialConditionX0, "The initialConditionX0 input cannot be null.");
        Assert.notNull(initialConditionY0, "The initialConditionY0 input cannot be null.");
        Assert.notNull(h, "The h input cannot be null.");
        Assert.notNull(xAtWhichToApproximateSolution, "The xAtWhichToApproximateSolution input cannot be null.");
    }
}