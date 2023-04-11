package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.string.StringsService;
import java.util.List;

public class ConvertToCommaSeparatedStringTask extends Orion
{
    public static String run(List<String> strings)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        StringBuffer commaAndSpaceSeparatedList = new StringBuffer();

        for(int i = 0; i < strings.size(); i++)
        {

            if(StringsService.isNotEmpty(strings.get(i)))
            {
                commaAndSpaceSeparatedList.append(strings.get(i));

                if(i < strings.size() - 1)
                {
                    commaAndSpaceSeparatedList.append(",");
                }

            }

        }

        return commaAndSpaceSeparatedList.toString();
    }
}