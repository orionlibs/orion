package com.orion.math.number.average.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.Functions;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetArithmeticAverageVectorTask extends Orion
{
    public static Vector run(List<Vector> vectors)
    {
        VectorRules.doVectorSizesMatch(vectors);
        int vectorDimension = vectors.get(0).getDimensions();
        ANumber[] means = new ANumber[vectorDimension];

        for(int i = 0; i < vectorDimension; i++)
        {
            List<ANumber> numbers = new ArrayList<ANumber>(vectors.size());

            for(int j = 0; j < vectors.size(); j++)
            {
                numbers.add(vectors.get(j).get(i));
            }

            means[i] = Functions.avg.run(numbers);
        }

        return Vector.of(means);
    }
}