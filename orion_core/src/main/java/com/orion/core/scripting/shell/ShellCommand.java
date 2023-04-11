package com.orion.core.scripting.shell;

import com.orion.core.abstraction.Orion;
import com.orion.core.operating_system.OperatingSystemType;

public class ShellCommand extends Orion
{
    private OperatingSystemType operatingSystemType;
    private String[] commandParameters;


    public ShellCommand(OperatingSystemType operatingSystemType, String[] commandParameters)
    {
        this.operatingSystemType = operatingSystemType;
        this.commandParameters = commandParameters;
    }


    public String[] getCommandParameters()
    {
        return this.commandParameters;
    }


    public OperatingSystemType getOperatingSystemType()
    {
        return this.operatingSystemType;
    }
}