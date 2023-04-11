package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.utility.OrionUtils;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConvertFileToStringTask extends Orion
{
    public static String run(BufferedReader input) throws FileNotFoundException, IOException
    {
        Assert.notNull(input, "BufferedReader input cannot be null.");
        String currentLine = null;
        StringBuilder fileStringBuilder = new StringBuilder();

        try
        {

            while((currentLine = input.readLine()) != null)
            {
                fileStringBuilder.append(currentLine);
                fileStringBuilder.append(System.lineSeparator());
            }

            //fileStringBuilder = StringsService.deleteLineSeparatorFromTheEnd(fileStringBuilder);
        }
        finally
        {
            OrionUtils.closeResource(input);
        }

        return fileStringBuilder.toString();
    }
}