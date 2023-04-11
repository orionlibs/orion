package com.orion.admin.usermanagement;

import com.orion.admin.usermanagement.tasks.GetUserRegistrationDatesAndNumberOfRegistrationsByAuthorityTask;
import com.orion.admin.usermanagement.tasks.GetUserRegistrationDatesAndNumberOfRegistrationsTask;
import com.orion.admin.usermanagement.tasks.GetUsersTask;
import com.orion.analytics.user.UserAnalyticsService;
import com.orion.analytics.user.authority.UserAuthorityAnalyticsService;
import com.orion.analytics.user.general.UserGeneralAnalyticsService;
import com.orion.analytics.user.model.AnalyticsAuthorityStatisticsModel;
import com.orion.analytics.user.model.AnalyticsRegistrationModel;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.analytics.user.model.UserAnalyticsModel;
import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdminUserManagementService extends OrionService
{
    public static long getNumberOfRegisteredUsers()
    {
        return UserGeneralAnalyticsService.getNumberOfRegisteredUsers();
    }


    public static long getNumberOfLoggedInUsers()
    {
        return UserGeneralAnalyticsService.getNumberOfLoggedInUsers();
    }


    public static long getNumberOfAccountsYetToBeValidated()
    {
        return UserGeneralAnalyticsService.getNumberOfAccountsYetToBeValidated();
    }


    public static long getNumberOfAdministrators()
    {
        return UserGeneralAnalyticsService.getNumberOfAdministratorUsers();
    }


    public static long getNumberOfUsersByAuthority(String authority)
    {
        return UserGeneralAnalyticsService.getNumberOfUsersByAuthority(authority);
    }


    public static Set<String> getAuthorities()
    {
        return UserAuthorityAnalyticsService.getAuthorities();
    }


    public static long getNumberOfAuthorities()
    {
        return UserGeneralAnalyticsService.getNumberOfAuthorities();
    }


    public static UserAnalyticsModel getUserAnalytics()
    {
        return UserAnalyticsService.getUserAnalytics();
    }


    public static List<AnalyticsUserAggregatedDataModel> getUsersData()
    {
        return UserAnalyticsService.getUsersData();
    }


    public static List<AnalyticsUserAggregatedDataModel> getUsersDataByAuthority(String authority)
    {
        return UserAnalyticsService.getUsersDataByAuthority(authority);
    }


    public static List<AnalyticsUserAggregatedDataModel> getUsersData(String query, int searchOption) throws UserHasNoAuthorityException
    {
        return GetUsersTask.run(query, searchOption);
    }


    public static Map<String, Long> getAuthoritiesToNumberOfUsersAsMap()
    {
        return UserAuthorityAnalyticsService.getAuthoritiesToNumberOfUsersAsMap();
    }


    public static AnalyticsAuthorityStatisticsModel getAuthoritiesStatistics()
    {
        return UserAuthorityAnalyticsService.getAuthoritiesStatistics();
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrations()
    {
        return UserGeneralAnalyticsService.getUserRegistrationsDateTimes();
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return UserGeneralAnalyticsService.getUserRegistrationsDateTimesForDateRange(startDate, endDate);
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsByAuthority(String authority)
    {
        return UserGeneralAnalyticsService.getUserRegistrationsDateTimes();
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsByAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return UserGeneralAnalyticsService.getUserRegistrationsDateTimesByAuthorityForDateRange(authority, startDate, endDate);
    }


    public static List<AnalyticsRegistrationModel> getUserLogins()
    {
        return UserGeneralAnalyticsService.getUserRegistrationsDateTimes();
    }


    public static List<DateTime> getUserRegistrationDateTimes()
    {
        return getUserRegistrations().stream()
                        .map(model -> model.getRegistrationDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserRegistrationDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return getUserRegistrationsForDateRange(startDate, endDate).stream()
                        .map(model -> model.getRegistrationDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserRegistrationDateTimesByAuthority(String authority)
    {
        return getUserRegistrationsByAuthority(authority).stream()
                        .map(model -> model.getRegistrationDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserRegistrationDateTimesByAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return getUserRegistrationsByAuthorityForDateRange(authority, startDate, endDate).stream()
                        .map(model -> model.getRegistrationDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginDateTimes()
    {
        return getUserLogins().stream()
                        .map(model -> model.getRegistrationDateTime())
                        .collect(Collectors.toList());
    }


    public static List<List<Long>> getUserRegistrationDatesAndNumberOfRegistrations()
    {
        return GetUserRegistrationDatesAndNumberOfRegistrationsTask.run(getUserRegistrationDateTimes());
    }


    public static List<List<Long>> getUserRegistrationDatesAndNumberOfRegistrationsForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return GetUserRegistrationDatesAndNumberOfRegistrationsTask.run(getUserRegistrationDateTimesForDateRange(startDate, endDate));
    }


    public static List<List<Long>> getUserRegistrationDatesAndNumberOfRegistrationsByAuthority(String authority)
    {
        return GetUserRegistrationDatesAndNumberOfRegistrationsByAuthorityTask.run(authority, getUserRegistrationDateTimesByAuthority(authority));
    }


    public static List<List<Long>> getUserRegistrationDatesAndNumberOfRegistrationsOfAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserRegistrationDatesAndNumberOfRegistrationsTask.run(getUserRegistrationDateTimesByAuthorityForDateRange(authority, startDate, endDate));
    }
}