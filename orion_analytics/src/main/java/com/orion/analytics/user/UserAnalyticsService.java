package com.orion.analytics.user;

import com.orion.analytics.user.authentication.UserAuthenticationAnalyticsService;
import com.orion.analytics.user.authority.UserAuthorityAnalyticsService;
import com.orion.analytics.user.general.UserGeneralAnalyticsService;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.analytics.user.model.UserAnalyticsModel;
import com.orion.analytics.user.tasks.GetUsersDataByAuthorityForAnalyticsTask;
import com.orion.analytics.user.tasks.GetUsersDataForAnalyticsTask;
import com.orion.analytics.user.tasks.PopulateUserAggregatedDataModelForUserTask;
import com.orion.analytics.user.tasks.PopulateUserAggregatedDataModelTask;
import com.orion.core.abstraction.OrionService;
import com.orion.user_management.model.OrionAuthorityModel;
import java.util.List;

public class UserAnalyticsService extends OrionService
{
    public static UserAnalyticsModel getUserAnalytics()
    {
        return UserAnalyticsModel.builder()
                        .userGeneralAnalyticsModel(UserGeneralAnalyticsService.getUserGeneralAnalytics())
                        .userAuthenticationAnalyticsModel(UserAuthenticationAnalyticsService.getUserAuthenticationAnalytics())
                        .userAuthorityStatisticsModel(UserAuthorityAnalyticsService.getAuthoritiesStatistics())
                        .build();
    }


    public static List<AnalyticsUserAggregatedDataModel> getUsersData()
    {
        return GetUsersDataForAnalyticsTask.run();
    }


    public static List<AnalyticsUserAggregatedDataModel> getUsersDataByAuthority(String authority)
    {
        return GetUsersDataByAuthorityForAnalyticsTask.run(authority);
    }


    public static AnalyticsUserAggregatedDataModel populateUserAggregatedDataModel(OrionAuthorityModel authority)
    {
        return PopulateUserAggregatedDataModelTask.run(authority);
    }


    public static AnalyticsUserAggregatedDataModel populateUserAggregatedDataModelForUser(OrionAuthorityModel authority)
    {
        return PopulateUserAggregatedDataModelForUserTask.run(authority);
    }
}