package com.orion.math.statistics.regression.linear.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.regression.linear.simple.SimpleLinearRegression;

public class GetDurbinWatsonStatisticTask extends Orion
{
    public static ANumber run(SimpleLinearRegression regression)
    {
        ANumber sum = ANumber.of(0);
        ANumber sumOfSquaredResiduals = regression.getResidual(0);

        for(int i = 1; i < regression.getNumberOfValues(); i++)
        {
            ANumber residual = regression.getResidual(i);
            sum.add(residual.subtractGET(regression.getResidual(i - 1)).squareGET());
            sumOfSquaredResiduals.add(residual);
        }

        return sum.divideGET(sumOfSquaredResiduals);
    }
}