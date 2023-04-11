package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.string.StringsService;

public class IsLastCharacterAWhitespaceTask extends Orion
{
    public static boolean run(String aString)
    {
        boolean isLastCharacterAWhitespace = false;
        String lastCharacter = StringsService.getLastCharacterAsString(aString);

        if(StringsService.isWhitespace(lastCharacter))
        {
            isLastCharacterAWhitespace = true;
        }

        return isLastCharacterAWhitespace;
    }
}