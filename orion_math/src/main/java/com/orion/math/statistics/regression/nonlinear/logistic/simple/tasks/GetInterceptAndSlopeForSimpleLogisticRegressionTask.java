package com.orion.math.statistics.regression.nonlinear.logistic.simple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.statistics.regression.nonlinear.logistic.simple.SimpleLogisticRegressionCoefficients;

public class GetInterceptAndSlopeForSimpleLogisticRegressionTask extends Orion
{
    public static SimpleLogisticRegressionCoefficients run(Vector probabilitiesNeededToFindIntercept, Vector probabilitiesNeededToFindSlope)
    {
        ANumber intercept = ArithmeticService.multiply(probabilitiesNeededToFindIntercept);
        ANumber one = ANumber.of(1);
        ANumber slope = ANumber.of(1);
        probabilitiesNeededToFindSlope.forAll(x -> slope.multiply(one.subtractGET(x)));
        return SimpleLogisticRegressionCoefficients.of(intercept, slope);
    }
}