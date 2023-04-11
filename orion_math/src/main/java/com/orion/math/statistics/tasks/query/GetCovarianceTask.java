package com.orion.math.statistics.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.statistics.StatisticsRules;
import java.util.Map;

public class GetCovarianceTask extends Orion
{
    public static ANumber run(Vector vector1, Vector vector2)
    {
        VectorRules.doVectorSizesMatch(vector1, vector2);
        ANumber mean1 = vector1.getArithmeticAverage();
        ANumber mean2 = vector2.getArithmeticAverage();
        ANumber sum = ANumber.of(0);

        for(int i = 0; i < vector1.getDimensions(); i++)
        {
            sum.add(vector1.get(i).subtractGET(mean1).multiplyGET(vector2.get(i).subtractGET(mean2)));
        }

        return sum.divideGET(vector1.getDimensions());
    }


    public static ANumber run(Vector vector1, Map<ANumber, ANumber> probabilityOfEachValueInVector1, Vector vector2, Map<ANumber, ANumber> probabilityOfEachValueInVector2, Map<Integer, ANumber> jointProbabilityOfVector1And2, ANumber expectdValueOfVector1, ANumber expectdValueOfVector2)
    {
        StatisticsRules.isValidForCovariance(vector1, probabilityOfEachValueInVector1, vector2, probabilityOfEachValueInVector2);
        ANumber sum = ANumber.of(0);

        for(int i = 0; i < vector1.getDimensions(); i++)
        {
            sum.add(vector1.get(i).subtractGET(expectdValueOfVector1).multiplyGET(vector2.get(i).subtractGET(expectdValueOfVector2)).multiplyGET(jointProbabilityOfVector1And2.get(i)));
        }

        return sum;
    }
}