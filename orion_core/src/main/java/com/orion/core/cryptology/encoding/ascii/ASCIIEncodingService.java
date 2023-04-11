package com.orion.core.cryptology.encoding.ascii;

import com.orion.core.abstraction.OrionService;
import com.orion.core.cryptology.encoding.ascii.tasks.DecodeASCIITask;
import com.orion.core.cryptology.encoding.ascii.tasks.EncodeToASCIITask;

public class ASCIIEncodingService extends OrionService
{
    public static String encodeToASCII(String data)
    {
        return EncodeToASCIITask.run(data);
    }


    public static String decodeASCII(String data)
    {
        return DecodeASCIITask.run(data);
    }
}