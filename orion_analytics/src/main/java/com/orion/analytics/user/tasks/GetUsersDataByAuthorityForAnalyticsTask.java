package com.orion.analytics.user.tasks;

import com.orion.analytics.user.UserAnalyticsService;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionAuthorityModel;
import java.util.ArrayList;
import java.util.List;

public class GetUsersDataByAuthorityForAnalyticsTask extends Orion
{
    public static List<AnalyticsUserAggregatedDataModel> run(String authority)
    {
        List<AnalyticsUserAggregatedDataModel> usersData = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getAuthoritiesByAuthority(authority);

        for(OrionAuthorityModel authority1 : authorities)
        {

            if(authority1 != null)
            {
                usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority1));
            }

        }

        return usersData;
    }
}