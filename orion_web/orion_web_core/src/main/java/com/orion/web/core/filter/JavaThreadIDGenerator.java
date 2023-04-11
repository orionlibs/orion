package com.orion.web.core.filter;

import com.orion.core.abstraction.Orion;
import com.orion.core.uuid.UUIDSecurityService;

public class JavaThreadIDGenerator extends Orion
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}