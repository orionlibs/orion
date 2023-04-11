package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import java.io.File;
import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;

public class SaveFileTask extends Orion
{
    public static void run(MultipartFile file, File destinationFilePath) throws IOException
    {
        Assert.notNull(file, "file input cannot be null.");
        Assert.notNull(destinationFilePath, "destinationFilePath input cannot be null.");
        file.transferTo(destinationFilePath);
    }


    public static void run(MultipartFile file, String destinationFilePath) throws IOException
    {
        Assert.notNull(file, "file input cannot be null.");
        Assert.notEmpty(destinationFilePath, "destinationFilePath input cannot be null/empty.");
        run(file, new File(destinationFilePath));
    }
}