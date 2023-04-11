package com.orion.core.cryptology.encoding.xss;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.xss.tasks.DecodeFromXSSTask;
import com.orion.core.cryptology.encoding.xss.tasks.EncodeWithXSSTask;

public class XSSEncodingService extends OrionService
{
    public static String encodeWithXSS(String data)
    {
        return EncodeWithXSSTask.run(data);
    }


    public static String decodeFromXSS(String data)
    {
        return DecodeFromXSSTask.run(data);
    }
}