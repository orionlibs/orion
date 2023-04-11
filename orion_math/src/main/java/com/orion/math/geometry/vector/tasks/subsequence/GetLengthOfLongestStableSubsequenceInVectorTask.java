package com.orion.math.geometry.vector.tasks.subsequence;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class GetLengthOfLongestStableSubsequenceInVectorTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        int n = x.getDimensions();
        int length = 1;
        int numberOfStableElements = 1;

        for(int i = 0; i < n - 1; i++)
        {

            if(x.get(i).equal(x.get(i + 1)))
            {
                numberOfStableElements += 1;

                if(i == n - 2)
                {
                    length = getUpdatedLength(length, numberOfStableElements);
                }

                continue;
            }
            else
            {
                length = getUpdatedLength(length, numberOfStableElements);
                numberOfStableElements = 1;
            }

        }

        return length;
    }


    private static int getUpdatedLength(int length, int numberOfStableElements)
    {

        if(numberOfStableElements > length)
        {
            return numberOfStableElements;
        }
        else
        {
            return length;
        }

    }
}