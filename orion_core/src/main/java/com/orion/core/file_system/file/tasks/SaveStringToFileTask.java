package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.file_system.stream.FileSystemStreamsService;
import com.orion.core.utility.OrionUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class SaveStringToFileTask extends Orion
{
    private boolean addEmptyLineAtTheEndOfTheFile;
    private String lineSeparator = System.lineSeparator();
    private BufferedWriter output;
    private int numberOfLines;
    private int lineCounter;


    public void run(String filePath, String fileString, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        this.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        run(filePath, fileString);
    }


    public void run(File file, String fileString, boolean addEmptyLineAtTheEndOfTheFile) throws IOException
    {
        this.addEmptyLineAtTheEndOfTheFile = addEmptyLineAtTheEndOfTheFile;
        run(file, fileString);
    }


    public void run(String filePath, String fileContent) throws IOException
    {
        Assert.notEmpty(filePath, "filePath input cannot be null/empty.");
        Assert.notEmpty(fileContent, "fileContent input cannot be null/empty.");
        output = (BufferedWriter)FileSystemStreamsService.getWriterForFile(filePath);
        String[] lines = fileContent.split(lineSeparator);
        numberOfLines = lines.length;
        lineCounter = 1;

        try
        {

            for(String line : lines)
            {
                writeLineToFile(line);
            }

        }
        finally
        {
            OrionUtils.closeResource(output);
        }

    }


    public void run(File file, String fileContent) throws IOException
    {
        Assert.notNull(file, "file input cannot be null/empty.");
        Assert.notEmpty(fileContent, "fileContent input cannot be null/empty.");
        output = (BufferedWriter)FileSystemStreamsService.getWriterForFile(file);
        String[] lines = fileContent.split(lineSeparator);
        numberOfLines = lines.length;
        lineCounter = 1;

        try
        {

            for(String line : lines)
            {
                writeLineToFile(line);
            }

        }
        finally
        {
            OrionUtils.closeResource(output);
        }

    }


    private void writeLineToFile(String lineToWrite) throws IOException
    {
        output.write(lineToWrite);

        if(lineCounter != numberOfLines || addEmptyLineAtTheEndOfTheFile)
        {
            output.write(lineSeparator);
        }

    }
}