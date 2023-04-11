package com.orion.core.cryptology.encoding.xss.tasks;

import com.orion.core.abstraction.Orion;

public class EncodeWithXSSTask extends Orion
{
    public static String run(String data)
    {

        if(data != null)
        {

            if(data.isEmpty())
            {
                return "";
            }
            else
            {
                String sanitized = data;
                sanitized = sanitized.replace("&", "&amp;");
                sanitized = sanitized.replace("\\$", "&#36;");
                sanitized = sanitized.replace("\"", "&#034;");
                sanitized = sanitized.replace("\'", "&#039;");
                sanitized = sanitized.replace("<", "&lt;");
                sanitized = sanitized.replace(">", "&gt;");
                sanitized = sanitized.replace("\\(", "&#40;");
                sanitized = sanitized.replace("\\)", "&#41;");
                sanitized = sanitized.replace("'", "&#39;");
                sanitized = sanitized.replace("eval\\((.*)\\)", "");
                return sanitized.replace("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");
            }

        }
        else
        {
            return null;
        }

    }
}