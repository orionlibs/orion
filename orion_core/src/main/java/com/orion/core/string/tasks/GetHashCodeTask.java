package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class GetHashCodeTask extends Orion
{
    public static int run(String s)
    {
        Assert.notEmpty(s, "The string input cannot be null/empty.");
        int hash = 3;
        char val[] = s.toCharArray();

        for(int i = 0; i < s.length(); i++)
        {
            hash = 31 * hash + val[i];
        }

        return hash;
    }
}