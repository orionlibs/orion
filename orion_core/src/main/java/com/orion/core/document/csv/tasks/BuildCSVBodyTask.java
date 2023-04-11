package com.orion.core.document.csv.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.document.csv.CSVWriterService;
import java.util.List;

public class BuildCSVBodyTask extends Orion
{
    public static String run(List<List<String>> entries)
    {
        String body = "";

        if(entries != null && !entries.isEmpty())
        {

            for(List<String> entry : entries)
            {

                for(int i = 0; i < entry.size(); i++)
                {
                    body += "\"";
                    body += CSVWriterService.sanitiseValue(entry.get(i)) + "\"";

                    if(i < entry.size() - 1)
                    {
                        body += ",";
                    }
                    else
                    {
                        body += "\n";
                    }

                }

            }

        }

        return body;
    }
}