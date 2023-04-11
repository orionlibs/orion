package com.orion.core.configuration.tasks;

import com.orion.core.abstraction.Orion;

public class ProcessStaticVariableNameWithUnderscoresTask extends Orion
{
    public static void run(String variableName, StringBuilder key)
    {
        String[] tokens = variableName.split("_");

        for(int i = 0; i < tokens.length; i++)
        {
            key.append(tokens[i].toLowerCase());

            if(i < tokens.length - 1)
            {
                key.append(".");
            }

        }

    }
}