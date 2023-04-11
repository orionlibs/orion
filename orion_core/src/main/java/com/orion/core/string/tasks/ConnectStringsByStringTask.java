package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import java.util.List;

public class ConnectStringsByStringTask extends Orion
{
    public static String run(String connectorString, String... strings)
    {
        return String.join(connectorString, strings);
    }


    public static String run(String connectorString, List<String> strings)
    {
        return String.join(connectorString, strings);
    }
}