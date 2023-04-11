package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;

public class AppendToFileTask extends Orion
{
    public static boolean run(File file, String contentsToAppend)
    {

        try
        {
            OpenOption[] openOptions = new OpenOption[]
            {StandardOpenOption.APPEND};
            Files.write(file.toPath(), contentsToAppend.getBytes(), openOptions);
            return true;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return false;
        }

    }


    public static boolean run(String file, String contentsToAppend)
    {
        return run(new File(file), contentsToAppend);
    }
}