package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class ConvertFirstCharacterToUppercaseTask extends Orion
{
    public static String run(String aString)
    {
        Assert.notEmpty(aString, "The aString input cannot be null/empty.");
        char[] stringCharactersArray = aString.toCharArray();
        stringCharactersArray[0] = Character.toUpperCase(stringCharactersArray[0]);
        return String.copyValueOf(stringCharactersArray);
    }
}