package com.orion.core.file_system;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Test;

// @RunWith(ConcurrentJUnitRunner.class)
public class FileSystemServiceTest
{
    @Test
    public void testDeleteFile()
    {

        try
        {
            new File("src/test/resources/hello.txt").createNewFile();
            File file = new File("src/test/resources/hello.txt");
            assertTrue(file.exists());

            if(file.exists())
            {
                FileSystemService.delete(file);
                file = new File("src/test/resources/hello.txt");
                assertFalse(file.exists());
            }

        }
        catch(IOException e)
        {
        }

    }


    @Test
    public void testDeleteFile2()
    {

        try
        {
            new File("src/test/resources/hello.txt").createNewFile();
            File file = new File("src/test/resources/hello.txt");
            assertTrue(file.exists());

            if(file.exists())
            {
                FileSystemService.delete("src/test/resources/hello.txt");
                file = new File("src/test/resources/hello.txt");
                assertFalse(file.exists());
            }

        }
        catch(IOException e)
        {
        }

    }
}