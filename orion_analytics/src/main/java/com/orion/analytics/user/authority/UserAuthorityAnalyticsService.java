package com.orion.analytics.user.authority;

import com.orion.analytics.user.model.AnalyticsAuthorityStatisticsModel;
import com.orion.analytics.user.tasks.GetAuthoritiesToNumberOfUsersAsMapTask;
import com.orion.core.abstraction.OrionService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserAuthority;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserAuthorityAnalyticsService extends OrionService
{
    public static Map<String, Long> getAuthoritiesToNumberOfUsersAsMap()
    {
        return GetAuthoritiesToNumberOfUsersAsMapTask.run(getAuthorities());
    }


    public static AnalyticsAuthorityStatisticsModel getAuthoritiesStatistics()
    {
        Map<String, Long> authoritiesToNumberOfUsersMapper = getAuthoritiesToNumberOfUsersAsMap();
        AnalyticsAuthorityStatisticsModel model = AnalyticsAuthorityStatisticsModel.builder()
                        .authoritiesToNumberOfUsersMapper(authoritiesToNumberOfUsersMapper)
                        .numberOfAdministrators(authoritiesToNumberOfUsersMapper.getOrDefault(OrionUserAuthority.Administrator.get(), 0L))
                        .build();
        return model;
    }


    public static Set<String> getAuthorities()
    {
        List<OrionAuthorityModel> authorities = UserAccountService.getUsersAuthorities();
        Set<String> uniqueAuthorities = new HashSet<>();
        authorities.stream()
                        .map(authority -> authority.getAuthorities())
                        .forEach(authoritiesList -> uniqueAuthorities.addAll(authoritiesList));
        return uniqueAuthorities;
    }
}