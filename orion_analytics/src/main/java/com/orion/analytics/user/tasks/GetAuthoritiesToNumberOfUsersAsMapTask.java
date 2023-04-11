package com.orion.analytics.user.tasks;

import com.orion.analytics.user.general.UserGeneralAnalyticsService;
import com.orion.core.abstraction.Orion;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GetAuthoritiesToNumberOfUsersAsMapTask extends Orion
{
    public static Map<String, Long> run(Set<String> authorities)
    {
        Map<String, Long> authoritiesToNumberOfUsersMapper = new HashMap<>();

        for(String authority : authorities)
        {
            authoritiesToNumberOfUsersMapper.put(authority, UserGeneralAnalyticsService.getNumberOfUsersByAuthority(authority));
        }

        return authoritiesToNumberOfUsersMapper;
    }
}