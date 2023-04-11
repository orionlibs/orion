package com.orion.core.net;

import com.orion.core.abstraction.OrionService;
import com.orion.core.net.tasks.BuildIPAddressAsByteArrayTask;
import com.orion.core.net.tasks.BuildIPAddressAsStringTask;
import java.util.Optional;

public class OrionNetService extends OrionService
{
    public static byte[] buildIPAddressAsByteArray(String IPAddress)
    {
        return BuildIPAddressAsByteArrayTask.run(IPAddress);
    }


    public static Optional<String> buildIPAddressAsString(byte[] IPAddress)
    {
        return BuildIPAddressAsStringTask.run(IPAddress);
    }
}