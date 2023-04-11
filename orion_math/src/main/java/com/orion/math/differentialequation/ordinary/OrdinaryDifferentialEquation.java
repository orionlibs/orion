package com.orion.math.differentialequation.ordinary;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.twovariables.Function2x1;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.linearalgebra.matrix.Matrix;
import com.orion.math.number.ANumber;

public class OrdinaryDifferentialEquation extends Orion
{
    private Function2x1<ANumber, ANumber, ANumber> function;
    private ANumber initialConditionX0;
    private ANumber initialConditionY0;
    private ANumber h;
    private ANumber xAtWhichToApproximateSolution;
    private Vector timeSteps;
    private Matrix internalWeights;
    private Vector propagationWeights;


    public OrdinaryDifferentialEquation(Function2x1<ANumber, ANumber, ANumber> function, ANumber initialConditionX0, ANumber initialConditionY0, ANumber h, ANumber xAtWhichToApproximateSolution)
    {
        OrdinaryDifferentialEquationRules.isValid(function, initialConditionX0, initialConditionY0, h, xAtWhichToApproximateSolution);
        this.function = function;
        this.initialConditionX0 = initialConditionX0;
        this.initialConditionY0 = initialConditionY0;
        this.h = h;
        this.xAtWhichToApproximateSolution = xAtWhichToApproximateSolution;
    }


    public OrdinaryDifferentialEquation(Vector timeSteps, Matrix internalWeights, Vector propagationWeights)
    {
        OrdinaryDifferentialEquationRules.isValid(timeSteps, internalWeights, propagationWeights);
        this.timeSteps = timeSteps;
        this.internalWeights = internalWeights;
        this.propagationWeights = propagationWeights;
    }


    public static OrdinaryDifferentialEquation of(Vector timeSteps, Matrix internalWeights, Vector propagationWeights)
    {
        return new OrdinaryDifferentialEquation(timeSteps, internalWeights, propagationWeights);
    }


    public static OrdinaryDifferentialEquation of(Function2x1<ANumber, ANumber, ANumber> function, ANumber initialConditionX0, ANumber initialConditionY0, ANumber h, ANumber xAtWhichToApproximateSolution)
    {
        return new OrdinaryDifferentialEquation(function, initialConditionX0, initialConditionY0, h, xAtWhichToApproximateSolution);
    }


    public Vector getTimeSteps()
    {
        return this.timeSteps;
    }


    public Matrix getInternalWeights()
    {
        return this.internalWeights;
    }


    public Vector getPropagationWeights()
    {
        return this.propagationWeights;
    }


    public Function2x1<ANumber, ANumber, ANumber> getFunction()
    {
        return this.function;
    }


    public ANumber getInitialConditionX0()
    {
        return this.initialConditionX0;
    }


    public ANumber getInitialConditionY0()
    {
        return this.initialConditionY0;
    }


    public ANumber getH()
    {
        return this.h;
    }


    public ANumber getxAtWhichToApproximateSolution()
    {
        return this.xAtWhichToApproximateSolution;
    }
}