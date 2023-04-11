package com.orion.math.geometry.vector.tasks.subsequence;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class GetLengthOfLongestStrictlyIncreasingSubsequenceInVectorTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        int n = x.getDimensions();
        int length = 1;
        int numberOfIncreasingElements = 1;

        for(int i = 0; i < n - 1; i++)
        {

            if(x.get(i).isLessThan(x.get(i + 1)))
            {
                numberOfIncreasingElements += 1;

                if(i == n - 2)
                {
                    length = getUpdatedLength(length, numberOfIncreasingElements);
                }

                continue;
            }
            else
            {
                length = getUpdatedLength(length, numberOfIncreasingElements);
                numberOfIncreasingElements = 1;
            }

        }

        return length;
    }


    private static int getUpdatedLength(int length, int numberOfIncreasingElements)
    {

        if(numberOfIncreasingElements > length)
        {
            return numberOfIncreasingElements;
        }
        else
        {
            return length;
        }

    }
}