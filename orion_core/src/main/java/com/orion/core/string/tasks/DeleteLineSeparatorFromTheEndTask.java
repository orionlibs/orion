package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.operating_system.OperatingSystemService;

public class DeleteLineSeparatorFromTheEndTask extends Orion
{
    public static String run(String aString)
    {
        Assert.notEmpty(aString, "The aString input cannot be null/empty.");

        if(aString.endsWith(System.lineSeparator()))
        {

            if(OperatingSystemService.isLinuxSystem() || OperatingSystemService.isMacOSXSystem())
            {
                return aString.substring(0, aString.length() - 2);
            }
            else if(OperatingSystemService.isWindowsSystem())
            {
                return aString.substring(0, aString.length() - 4);
            }

        }

        return aString;
    }
}