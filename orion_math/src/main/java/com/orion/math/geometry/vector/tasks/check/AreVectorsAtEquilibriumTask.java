package com.orion.math.geometry.vector.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import com.orion.math.streams.NumberArrayStream;

public class AreVectorsAtEquilibriumTask extends Orion
{
    public static boolean run(Vector... vectors)
    {
        VectorRules.doVectorSizesMatch(vectors);
        ANumber[] sumOfEachCoordinate = new ANumber[vectors.length];
        NumberArrayStream.setZeroValue(sumOfEachCoordinate);

        for(int j = 0; j < vectors[0].getDimensions(); j++)
        {

            for(int i = 0; i < vectors.length; i++)
            {
                sumOfEachCoordinate[j].add(vectors[i].get(j));
            }

        }

        return NumberArrayStream.hasZeroValues(sumOfEachCoordinate);
    }
}