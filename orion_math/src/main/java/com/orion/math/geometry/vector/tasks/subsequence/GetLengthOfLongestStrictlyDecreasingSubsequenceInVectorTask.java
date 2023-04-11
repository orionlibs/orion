package com.orion.math.geometry.vector.tasks.subsequence;

import com.orion.core.abstraction.Orion;
import com.orion.math.geometry.vector.Vector;
import com.orion.math.geometry.vector.VectorRules;

public class GetLengthOfLongestStrictlyDecreasingSubsequenceInVectorTask extends Orion
{
    public static int run(Vector x)
    {
        VectorRules.isValid(x);
        int n = x.getDimensions();
        int length = 1;
        int numberOfDecreasingElements = 1;

        for(int i = 0; i < n - 1; i++)
        {

            if(x.get(i).isGreaterThan(x.get(i + 1)))
            {
                numberOfDecreasingElements += 1;

                if(i == n - 2)
                {
                    length = getUpdatedLength(length, numberOfDecreasingElements);
                }

                continue;
            }
            else
            {
                length = getUpdatedLength(length, numberOfDecreasingElements);
                numberOfDecreasingElements = 1;
            }

        }

        return length;
    }


    private static int getUpdatedLength(int length, int numberOfDecreasingElements)
    {

        if(numberOfDecreasingElements > length)
        {
            return numberOfDecreasingElements;
        }
        else
        {
            return length;
        }

    }
}