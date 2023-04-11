package com.orion.core.utility;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import com.orion.core.utility.tasks.CloseResourceTask;
import java.io.Closeable;

public class OrionUtils extends Orion
{
    public static void closeResource(Closeable closeable)
    {
        CloseResourceTask.run(closeable);
    }


    public static int getBooleanAsInteger(boolean x)
    {
        return (x) ? 1 : 0;
    }


    public static int getBooleanAsInteger(Boolean x)
    {
        Assert.notNull(x, "The given Boolean object cannot be null.");
        return (x) ? 1 : 0;
    }
}