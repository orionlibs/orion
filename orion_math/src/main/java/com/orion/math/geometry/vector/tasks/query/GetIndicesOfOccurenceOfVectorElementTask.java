package com.orion.math.geometry.vector.tasks.query;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;
import com.orion.math.number.ANumber;
import java.util.ArrayList;
import java.util.List;

public class GetIndicesOfOccurenceOfVectorElementTask extends Orion
{
    public static List<Integer> run(Vector x, ANumber element)
    {
        VectorRules.isValid(x);
        List<Integer> indices = new ArrayList<>();

        for(int i = 0; i < x.getSize(); i++)
        {

            if(x.get(i).equal(element))
            {
                indices.add(i);
            }

        }

        return indices;
    }
}