package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import java.util.List;

public class DoesStringStartWithAnyTask extends Orion
{
    public static boolean run(String s, List<String> stringsToCheck)
    {

        for(String stringToCheck : stringsToCheck)
        {

            if(s.startsWith(stringToCheck))
            {
                return true;
            }

        }

        return false;
    }
}