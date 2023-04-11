package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class CopyFromTheBeginningUpToTask extends Orion
{
    public static String run(String stringToCopyFrom, int indexToCopyTo)
    {
        Assert.notEmpty(stringToCopyFrom, "The stringToCopyFrom input cannot be null/empty.");

        if(indexToCopyTo < stringToCopyFrom.length())
        {
            return new String(stringToCopyFrom.substring(0, indexToCopyTo + 1));
        }
        else
        {
            return "";
        }

    }
}