package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConvertFileToStringListTask extends Orion
{
    public static List<String> run(BufferedReader input) throws IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        List<String> fileLines = new ArrayList<>();
        String currentLine = null;

        try
        {

            while((currentLine = input.readLine()) != null)
            {
                fileLines.add(currentLine);
            }

        }
        finally
        {
            OrionUtils.closeResource(input);
        }

        return fileLines;
    }
}