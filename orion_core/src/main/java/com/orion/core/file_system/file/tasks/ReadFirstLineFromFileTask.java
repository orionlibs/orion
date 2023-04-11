package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.IOException;

public class ReadFirstLineFromFileTask extends Orion
{
    public static String run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");

        try
        {
            return input.readLine();
        }
        finally
        {
            OrionUtils.closeResource(input);
        }

    }
}