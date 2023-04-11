package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.util.Arrays;
import java.util.List;

public class ConcatenateSeparatedBySpaceTask extends Orion
{
    public static String run(String... strings)
    {
        return run(Arrays.asList(strings));
    }


    public static String run(List<String> strings)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        String newString = "";

        for(int i = 0; i < strings.size(); i++)
        {
            newString += strings.get(i);

            if(i < strings.size() - 1)
            {
                newString += " ";
            }

        }

        return newString;
    }
}