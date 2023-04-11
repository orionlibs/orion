package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.string.builder.StringBuilderService;
import java.util.Arrays;
import java.util.Collection;

public class ConcatenateTask extends Orion
{
    public static String run(String... strings)
    {
        return run(Arrays.asList(strings));
    }


    public static String run(Collection<String> strings)
    {
        Assert.notEmpty(strings, "The strings input cannot be null/empty.");
        final StringBuilderService stringBuilderService = new StringBuilderService();

        if(strings != null)
        {
            strings.forEach(aString -> stringBuilderService.add(aString));
        }

        return stringBuilderService.toString();
    }
}