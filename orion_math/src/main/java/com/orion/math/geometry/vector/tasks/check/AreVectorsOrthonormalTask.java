package com.orion.math.geometry.vector.tasks.check;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import java.util.List;

public class AreVectorsOrthonormalTask extends Orion
{
    public static boolean run(List<Vector> vectors, int precision)
    {
        VectorRules.areValid(vectors);
        VectorRules.isValidNumberOfVectors(vectors, 2);

        for(int i = 0; i < vectors.size() - 1; i++)
        {

            for(int j = i + 1; j < vectors.size(); j++)
            {

                if(vectors.get(i).isNotOrthonormalTo(vectors.get(j), precision))
                {
                    return false;
                }

            }

        }

        return true;
    }
}