package com.orion.core.string.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class PrefixStringTask extends Orion
{
    public static String run(String s, String prefix)
    {
        Assert.notNull(s, "The main string input cannot be null.");
        Assert.notNull(prefix, "The prefix input cannot be null.");
        return prefix + s;
    }
}