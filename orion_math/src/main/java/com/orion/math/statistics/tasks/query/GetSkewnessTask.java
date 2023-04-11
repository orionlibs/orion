package com.orion.math.statistics.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetSkewnessTask extends Orion
{
    public static ANumber run(Vector numbers, ANumber mean, ANumber standardDeviation)
    {
        VectorRules.isValid(numbers);
        ANumber numerator = ANumber.of(0);
        numbers.forAllIndices(i -> numerator.add(numbers.get(i).subtractGET(mean).exponentiateGET(3)));
        numerator.divide(numbers.getDimensions());
        return numerator.divideGET(standardDeviation.exponentiateGET(3));
    }
}