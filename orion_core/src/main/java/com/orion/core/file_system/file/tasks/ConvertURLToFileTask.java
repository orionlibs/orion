package com.orion.core.file_system.file.tasks;

import com.orion.core.abstraction.Orion;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ConvertURLToFileTask extends Orion
{
    public static File run(URL file)
    {
        URI uri = null;

        try
        {
            uri = file.toURI();
        }
        catch(URISyntaxException e)
        {

            try
            {
                uri = new URI(file.getProtocol(), file.getUserInfo(), file.getHost(), file.getPort(), file.getPath(), file.getQuery(), file.getRef());
            }
            catch(URISyntaxException e1)
            {
                throw new IllegalArgumentException("Broken URL: " + file);
            }

        }

        return new File(uri);
    }
}