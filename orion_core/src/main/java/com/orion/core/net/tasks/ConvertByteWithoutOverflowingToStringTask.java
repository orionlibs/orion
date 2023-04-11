package com.orion.core.net.tasks;

import com.orion.core.abstraction.Orion;

public class ConvertByteWithoutOverflowingToStringTask extends Orion
{
    public static String run(String IPAddressString, byte aByte)
    {

        if(aByte < 0)
        {
            IPAddressString += (aByte + 256);
        }
        else
        {
            IPAddressString += Byte.toString(aByte);
        }

        return IPAddressString;
    }
}