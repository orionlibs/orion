package com.orion.user_management.authentication.logout.model;

import com.orion.core.abstraction.OrionConstants;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class LogoutCausesMapper extends OrionConstants
{
    private static final ConcurrentMap<Integer, String> mapper = new ConcurrentHashMap<>();
    static
    {
        mapper.put(1, LogoutCause.User.get());
        mapper.put(2, LogoutCause.System.get());
    }


    public static int getLogoutCauseIDFromName(String logoutCauseName)
    {

        for(Map.Entry<Integer, String> logoutCauseCodeToName : mapper.entrySet())
        {

            if(logoutCauseCodeToName.getValue().equals(logoutCauseName))
            {
                return logoutCauseCodeToName.getKey();
            }

        }

        return -1;
    }
}