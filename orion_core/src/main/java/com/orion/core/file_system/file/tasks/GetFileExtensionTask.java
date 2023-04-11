package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;

public class GetFileExtensionTask extends Orion
{
    public static String run(String fileName)
    {

        if(fileName != null && !fileName.isEmpty() && fileName.lastIndexOf(".") >= 0)
        {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        }
        else
        {
            return "";
        }

    }
}