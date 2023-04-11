package com.orion.math.function.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.math.function.Function;

public class GetIndexOfVariableTask extends Orion
{
    public static int run(Function f, int index)
    {
        int numberOfVariablesFound = 0;
        int indexOfVariable = -1;

        for(int i = 0; i < f.getIndicesOfVariablesThatAreConstants().length; i++)
        {

            if(!f.getIndicesOfVariablesThatAreConstants()[i])
            {
                indexOfVariable = i;
                numberOfVariablesFound++;

                if(numberOfVariablesFound == index)
                {
                    break;
                }

            }

        }

        return indexOfVariable;
    }
}