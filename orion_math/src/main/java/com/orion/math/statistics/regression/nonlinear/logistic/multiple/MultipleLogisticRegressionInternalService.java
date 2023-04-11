package com.orion.math.statistics.regression.nonlinear.logistic.multiple;

import com.orion.core.abstraction.OrionService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.statistics.regression.nonlinear.logistic.multiple.tasks.GetInterceptAndSlopeForMultipleLogisticRegressionTask;
import java.util.List;

class MultipleLogisticRegressionInternalService extends OrionService
{
    public static MultipleLogisticRegressionCoefficients getInterceptAndSlope(Vector probabilitiesNeededToFindIntercept, List<Vector> probabilitiesNeededToFindSlope)
    {
        return GetInterceptAndSlopeForMultipleLogisticRegressionTask.run(probabilitiesNeededToFindIntercept, probabilitiesNeededToFindSlope);
    }
}