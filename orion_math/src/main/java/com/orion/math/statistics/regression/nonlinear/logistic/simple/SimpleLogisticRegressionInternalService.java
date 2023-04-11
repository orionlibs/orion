package com.orion.math.statistics.regression.nonlinear.logistic.simple;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.statistics.regression.nonlinear.logistic.simple.tasks.GetInterceptAndSlopeForSimpleLogisticRegressionTask;

class SimpleLogisticRegressionInternalService extends OrionService
{
    public static SimpleLogisticRegressionCoefficients getInterceptAndSlope(Vector probabilitiesNeededToFindIntercept, Vector probabilitiesNeededToFindSlope)
    {
        return GetInterceptAndSlopeForSimpleLogisticRegressionTask.run(probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlope);
    }
}