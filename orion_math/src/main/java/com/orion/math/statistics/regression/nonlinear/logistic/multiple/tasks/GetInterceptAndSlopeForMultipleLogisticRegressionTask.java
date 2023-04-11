package com.orion.math.statistics.regression.nonlinear.logistic.multiple.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.number.ANumber;
import com.orion.math.number.arithmetic.ArithmeticService;
import com.orion.math.statistics.regression.nonlinear.logistic.multiple.MultipleLogisticRegressionCoefficients;
import java.util.List;

public class GetInterceptAndSlopeForMultipleLogisticRegressionTask extends Orion
{
    public static MultipleLogisticRegressionCoefficients run(Vector probabilitiesNeededToFindIntercept, List<Vector> probabilitiesNeededToFindSlopes)
    {
        ANumber intercept = ArithmeticService.multiply(probabilitiesNeededToFindIntercept);
        ANumber one = ANumber.of(1);
        ANumber[] slopes = new ANumber[probabilitiesNeededToFindSlopes.size()];

        for(int i = 0; i < probabilitiesNeededToFindSlopes.size(); i++)
        {
            ANumber slope = ANumber.of(1);
            probabilitiesNeededToFindSlopes.get(i).forAll(x -> slope.multiply(one.subtractGET(x)));
            slopes[i] = slope;
        }

        return MultipleLogisticRegressionCoefficients.of(intercept, Vector.of(slopes));
    }
}