package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.io.File;
import java.io.IOException;

public class CreateFileTask extends Orion
{
    public static boolean run(File directory) throws IOException
    {
        Assert.notNull(directory, "directory input cannot be null.");
        return directory.createNewFile();
    }


    public static boolean run(String directory) throws IOException
    {
        Assert.notEmpty(directory, "directory input cannot be null/empty.");
        return run(new File(directory));
    }
}