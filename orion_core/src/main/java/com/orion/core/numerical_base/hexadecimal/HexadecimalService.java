package com.orion.core.numerical_base.hexadecimal;

import com.orion.core.abstraction.OrionService;
import com.orion.core.numerical_base.hexadecimal.tasks.ConvertToHexadecimalBaseTask;

public class HexadecimalService extends OrionService
{
    public static String convertToHexadecimalBase(String data)
    {
        return ConvertToHexadecimalBaseTask.run(data.getBytes());
    }


    public static String convertToHexadecimalBase(byte[] data)
    {
        return ConvertToHexadecimalBaseTask.run(data);
    }
}