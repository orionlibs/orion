package com.orion.math.statistics.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.number.NumberRules;
import com.orion.math.number.Numbers;
import com.orion.math.statistics.StatisticsRules;
import java.util.Arrays;

public class GetPercentileTask extends Orion
{
    public static ANumber run(Vector numbers, ANumber percentile)
    {
        VectorRules.isValid(numbers);
        NumberRules.isNotNull(percentile);
        StatisticsRules.isValidPercentile(percentile);
        ANumber[] elements = numbers.getAsArrayCopy();
        Arrays.sort(elements);
        ANumber rank = percentile.divideGET(ANumber.of(100).multiplyGET(numbers.getDimensions() + 1));

        if(Numbers.hasIntegerValue(rank))
        {
            return rank;
        }
        else if(rank.isZero())
        {
            return ANumber.ofNaN();
        }
        else if(numbers.getDimensions() == 1)
        {
            return numbers.get(0).getCopy();
        }
        else
        {
            ANumber fractionalPart = rank.getDecimalPart();
            rank.round(1);
            int index1 = rank.addOneGET().getAsInt();
            int index2 = rank.getAsInt();
            ANumber interpolation = elements[index1].subtractGET(elements[index2]).multiplyGET(fractionalPart);
            return elements[index2].addGET(interpolation);
        }

    }
}