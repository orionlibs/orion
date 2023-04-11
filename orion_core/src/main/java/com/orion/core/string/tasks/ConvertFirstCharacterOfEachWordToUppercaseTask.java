package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.string.StringsService;

public class ConvertFirstCharacterOfEachWordToUppercaseTask extends Orion
{
    public static String run(String[] stringTokens)
    {
        Assert.notNull(stringTokens, "The stringTokens input cannot be null.");
        String stringTemp = "";

        if(stringTokens.length > 0)
        {

            for(String stringToken : stringTokens)
            {
                stringTemp += StringsService.convertFirstCharacterToUppercase(stringToken) + " ";
            }

        }

        return stringTemp.trim();
    }


    public static String run(String aString)
    {
        Assert.notNull(aString, "The aString input cannot be null.");

        if(!aString.isEmpty())
        {
            return run(aString.split(" "));
        }
        else
        {
            return "";
        }

    }
}