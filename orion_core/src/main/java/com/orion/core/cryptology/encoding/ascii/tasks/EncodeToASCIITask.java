package com.orion.core.cryptology.encoding.ascii.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class EncodeToASCIITask extends Orion
{
    public static String run(String data)
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        String ASCIIData = "";

        if(!data.isEmpty())
        {

            for(int i = 0; i < data.length(); i++)
            {

                if(data.charAt(i) == ' ')
                {
                    ASCIIData += " ";
                }
                else
                {
                    ASCIIData += "" + (int)data.charAt(i);
                }

                if(i < data.length() - 1)
                {
                    ASCIIData += "_";
                }

            }

        }

        return ASCIIData;
    }
}