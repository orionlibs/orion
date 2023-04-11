package com.orion.core.cryptology.encoding.xss.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;

public class DecodeFromXSSTask extends Orion
{
    public static String run(String data)
    {
        Assert.notEmpty(data, "The given data is null/empty.");
        String unsanitized = data;
        unsanitized = unsanitized.replace("&amp;", "&");
        unsanitized = unsanitized.replace("&#36;", "\\$");
        unsanitized = unsanitized.replace("&#034;", "\"");
        unsanitized = unsanitized.replace("&#039;", "\'");
        unsanitized = unsanitized.replace("&lt;", "<");
        unsanitized = unsanitized.replace("&gt;", ">");
        unsanitized = unsanitized.replace("&#40;", "\\(");
        unsanitized = unsanitized.replace("&#41;", "\\)");
        return unsanitized.replace("&#39;", "'");
    }
}