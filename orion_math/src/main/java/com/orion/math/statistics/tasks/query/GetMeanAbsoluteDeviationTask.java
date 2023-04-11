package com.orion.math.statistics.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.error.ErrorService;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;

public class GetMeanAbsoluteDeviationTask extends Orion
{
    public static ANumber run(Vector numbers)
    {
        VectorRules.isValid(numbers);
        ANumber mean = numbers.getArithmeticAverage();
        ANumber sum = ANumber.of(0);
        numbers.forAll(x -> sum.add(ErrorService.getAbsoluteError(x, mean)));
        return sum.divideGET(numbers.getDimensions());
    }
}