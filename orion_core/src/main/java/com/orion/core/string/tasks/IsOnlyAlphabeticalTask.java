package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import java.util.stream.IntStream;

public class IsOnlyAlphabeticalTask extends Orion
{
    public static boolean run(String s)
    {

        if(s != null && !s.isEmpty())
        {
            return !IntStream.range(0, s.length()).anyMatch(i -> !Character.isLetter(s.charAt(i)));
        }
        else
        {
            return false;
        }

    }
}