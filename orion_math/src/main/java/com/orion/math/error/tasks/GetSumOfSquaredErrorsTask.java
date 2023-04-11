package com.orion.math.error.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.error.ErrorService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;

public class GetSumOfSquaredErrorsTask extends Orion
{
    public static ANumber run(Vector realValues, Vector approximateValues)
    {
        VectorRules.doVectorSizesMatch(realValues, approximateValues);
        ANumber residualSumOfSquares = ANumber.of(0);

        for(int i = 0; i < realValues.getDimensions(); i++)
        {
            process(approximateValues.get(i), realValues.get(i), residualSumOfSquares);
        }

        return residualSumOfSquares;
    }


    public static ANumber run(ANumber x, Vector approximateValues)
    {
        VectorRules.isValid(approximateValues);
        NumberRules.isNotNull(x);
        ANumber residualSumOfSquares = ANumber.of(0);

        for(int i = 0; i < approximateValues.getDimensions(); i++)
        {
            process(x, approximateValues.get(i), residualSumOfSquares);
        }

        return residualSumOfSquares;
    }


    private static void process(ANumber x, ANumber y, ANumber residualSumOfSquares)
    {
        ANumber residualSquared = ErrorService.getErrorSquared(y, x);
        residualSumOfSquares.add(residualSquared);
    }
}