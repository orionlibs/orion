package com.orion.core.data.structure.set.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.data.structure.set.OrionSet;
import com.orion.core.data.structure.set.type.OrionHashMultiSet;

public class GetSumOfMultiSetsTask<T> extends Orion
{
    public static <T> OrionSet<T> run(OrionHashMultiSet<T> set1, OrionHashMultiSet<T> set2)
    {

        if(set1 != null && set2 == null)
        {
            return OrionHashMultiSet.<T>of(set1);
        }
        else if(set1 == null && set2 != null)
        {
            return OrionHashMultiSet.<T>of(set2);
        }
        else
        {
            OrionSet<T> result = OrionHashMultiSet.<T>of();

            for(T elementInSet1 : set1.getAsArray())
            {

                if(result.notContains(elementInSet1))
                {

                    if(set2.contains(elementInSet1))
                    {
                        long multiplicityOfElement = set1.getMultiplicityOfElement(elementInSet1) + set2.getMultiplicityOfElement(elementInSet1);

                        for(long i = 0L; i < multiplicityOfElement; i++)
                        {
                            result.append(elementInSet1);
                        }

                    }
                    else
                    {
                        result.append(elementInSet1);
                    }

                }

            }

            for(T elementInSet2 : set2.getAsArray())
            {

                if(result.notContains(elementInSet2))
                {

                    if(set1.contains(elementInSet2))
                    {
                        long multiplicityOfElement = set1.getMultiplicityOfElement(elementInSet2) + set2.getMultiplicityOfElement(elementInSet2);

                        for(long i = 0L; i < multiplicityOfElement; i++)
                        {
                            result.append(elementInSet2);
                        }

                    }
                    else
                    {
                        result.append(elementInSet2);
                    }

                }

            }

            return result;
        }

    }
}