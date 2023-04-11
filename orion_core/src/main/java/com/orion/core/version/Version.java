package com.orion.core.version;

import com.orion.core.abstraction.Orion;

public class Version<T> extends Orion
{
    public static final String MajorVersion = "2";
    public static final String MinorVersion = "0";
    public static final String PatchVersion = "0";


    public static String getFullVersion()
    {
        return MajorVersion + "." + MinorVersion + "." + PatchVersion;
    }
}