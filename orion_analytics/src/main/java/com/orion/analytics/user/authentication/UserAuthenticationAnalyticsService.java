package com.orion.analytics.user.authentication;

import com.orion.analytics.user.AnalyticsUsersPercentageFunction;
import com.orion.analytics.user.authentication.model.UserAuthenticationAnalyticsModel;
import com.orion.analytics.user.authentication.tasks.GetUserLoginsDateTimesForAuthorityForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserLoginsDateTimesForAuthorityTask;
import com.orion.analytics.user.authentication.tasks.GetUserLoginsDateTimesForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserLoginsDateTimesOfUserIDForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserLoginsDateTimesTask;
import com.orion.analytics.user.authentication.tasks.GetUserLogoutsDateTimesOfUserIDForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserLogoutsDateTimesTask;
import com.orion.analytics.user.general.UserGeneralAnalyticsService;
import com.orion.analytics.user.model.AnalyticsLoginModel;
import com.orion.analytics.user.model.AnalyticsLogoutModel;
import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import java.math.BigDecimal;
import java.util.List;

public class UserAuthenticationAnalyticsService extends OrionService
{
    public static BigDecimal getPercentageOfLoggedInUsersOfAllUsers()
    {
        long numberOfLoggedInUsers = UserGeneralAnalyticsService.getNumberOfLoggedInUsers();
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfLoggedInUsers, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfLoggedOutUsersOfAllUsers()
    {
        long numberOfLoggedOutUsers = UserGeneralAnalyticsService.getNumberOfLoggedOutUsers();
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfLoggedOutUsers, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfAdministratorUsersOfAllUsers()
    {
        long numberOfAdministratorUsers = UserGeneralAnalyticsService.getNumberOfAdministratorUsers();
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfAdministratorUsers, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfAnonymousUsersOfAllUsers()
    {
        long numberOfAnonymousUsers = UserGeneralAnalyticsService.getNumberOfAnonymousUsers();
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfAnonymousUsers, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfNonAdministratorUsersOfAllUsers()
    {
        long numberOfNonAdministratorUsers = UserGeneralAnalyticsService.getNumberOfNonAdministratorUsers();
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfNonAdministratorUsers, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfUsersByAuthorityOfAllUsers(String authority)
    {
        long numberOfUsers = UserGeneralAnalyticsService.getNumberOfUsersByAuthority(authority);
        long numberOfRegisteredUsers = UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfUsers, numberOfRegisteredUsers);
    }


    public static UserAuthenticationAnalyticsModel getUserAuthenticationAnalytics()
    {
        return UserAuthenticationAnalyticsModel.builder()
                        .percentageOfAdministratorUsersOfAllUsers(getPercentageOfAdministratorUsersOfAllUsers())
                        .percentageOfAnonymousUsersOfAllUsers(getPercentageOfAnonymousUsersOfAllUsers())
                        .percentageOfLoggedInUsersOfAllUsers(getPercentageOfLoggedInUsersOfAllUsers())
                        .percentageOfLoggedOutUsersOfAllUsers(getPercentageOfLoggedOutUsersOfAllUsers())
                        .percentageOfNonAdministratorUsersOfAllUsers(getPercentageOfNonAdministratorUsersOfAllUsers())
                        .build();
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimes(String userID)
    {
        return GetUserLoginsDateTimesTask.run(userID);
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimes()
    {
        return GetUserLoginsDateTimesTask.run();
    }


    public static List<AnalyticsLogoutModel> getUserLogoutsDateTimes(String userID)
    {
        return GetUserLogoutsDateTimesTask.run(userID);
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimesForAuthority(String authority)
    {
        return GetUserLoginsDateTimesForAuthorityTask.run(authority);
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimesForAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginsDateTimesForAuthorityForDateRangeTask.run(authority, startDate, endDate);
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginsDateTimesForDateRangeTask.run(startDate, endDate);
    }


    public static List<AnalyticsLoginModel> getUserLoginsDateTimesOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginsDateTimesOfUserIDForDateRangeTask.run(userID, startDate, endDate);
    }


    public static List<AnalyticsLogoutModel> getUserLogoutsDateTimesOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLogoutsDateTimesOfUserIDForDateRangeTask.run(userID, startDate, endDate);
    }
}