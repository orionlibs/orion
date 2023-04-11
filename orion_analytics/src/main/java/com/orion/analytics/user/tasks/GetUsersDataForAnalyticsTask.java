package com.orion.analytics.user.tasks;

import com.orion.analytics.user.UserAnalyticsService;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionAuthorityModel;
import java.util.ArrayList;
import java.util.List;

public class GetUsersDataForAnalyticsTask extends Orion
{
    public static List<AnalyticsUserAggregatedDataModel> run()
    {
        List<AnalyticsUserAggregatedDataModel> usersData = new ArrayList<>();
        List<OrionAuthorityModel> authorities = UserAccountService.getUsersAuthorities();

        for(OrionAuthorityModel authority : authorities)
        {

            if(authority != null)
            {
                usersData.add(UserAnalyticsService.populateUserAggregatedDataModel(authority));
            }

        }

        return usersData;
    }
}