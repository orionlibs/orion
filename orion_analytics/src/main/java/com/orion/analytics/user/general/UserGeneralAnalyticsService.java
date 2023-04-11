package com.orion.analytics.user.general;

import com.orion.analytics.user.AnalyticsUsersPercentageFunction;
import com.orion.analytics.user.authentication.tasks.GetUserRegistrationsDateTimesByAuthorityForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserRegistrationsDateTimesByAuthorityTask;
import com.orion.analytics.user.authentication.tasks.GetUserRegistrationsDateTimesForDateRangeTask;
import com.orion.analytics.user.authentication.tasks.GetUserRegistrationsDateTimesTask;
import com.orion.analytics.user.authority.UserAuthorityAnalyticsService;
import com.orion.analytics.user.general.model.UserGeneralAnalyticsModel;
import com.orion.analytics.user.model.AnalyticsRegistrationModel;
import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.login.data_access.OrionUserLoginsDAO;
import com.orion.user_management.authentication.logout.data_access.OrionUserLogoutsDAO;
import com.orion.user_management.authentication.security.data_access.OrionUserFailedLoginAttemptsDAO;
import com.orion.user_management.email_validation.OrionEmailValidationService;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.model.OrionUserAuthority;
import java.math.BigDecimal;
import java.util.List;

public class UserGeneralAnalyticsService extends OrionService
{
    public static long getNumberOfRegisteredUsers()
    {
        return UserAccountService.getNumberOfRegisteredUsers();
    }


    public static long getNumberOfAdministratorUsers()
    {
        return UserAccountService.getNumberOfAdministratorUsers();
    }


    public static long getNumberOfAnonymousUsers()
    {
        return UserAccountService.getNumberOfAnonymousUsers();
    }


    public static long getNumberOfNonAdministratorUsers()
    {
        return UserAccountService.getNumberOfNonAdministratorUsers();
    }


    public static long getNumberOfCustomerUsers()
    {
        return getNumberOfUsersByAuthority(OrionUserAuthority.Customer.get());
    }


    public static long getNumberOfBusinessUsers()
    {
        return getNumberOfUsersByAuthority(OrionUserAuthority.Business.get());
    }


    public static long getNumberOfUsersByAuthority(String authority)
    {
        return UserAccountService.getNumberOfUsersByAuthority(authority);
    }


    public static long getNumberOfEnabledAccounts()
    {
        return UserAccountService.getNumberOfEnabledAccounts();
    }


    public static long getNumberOfDisabledAccounts()
    {
        return UserAccountService.getNumberOfDisabledAccounts();
    }


    public static long getNumberOfLoggedInUsers()
    {
        return UserAccountService.getNumberOfLoggedInUsers();
    }


    public static long getNumberOfLoggedOutUsers()
    {
        return UserAccountService.getNumberOfLoggedOutUsers();
    }


    public static long getNumberOfAccountLockdowns()
    {
        return UserAccountService.getNumberOfAccountLockdowns();
    }


    public static long getNumberOfUserLogins()
    {
        return OrionUserLoginsDAO.getNumberOfUserLogins();
    }


    public static long getNumberOfUserLogouts()
    {
        return OrionUserLogoutsDAO.getNumberOfUserLogouts();
    }


    public static long getNumberOfUsersWithFailedLoginAttempts()
    {
        return OrionUserFailedLoginAttemptsDAO.getNumberOfUsersWithFailedLoginAttempts();
    }


    public static long getNumberOfAccountsYetToBeValidated()
    {
        return OrionEmailValidationService.getNumberOfAccountsYetToBeValidated();
    }


    public static long getNumberOfResetPasswordRequests()
    {
        return ForgotPasswordService.getNumberOfResetPasswordRequests();
    }


    public static BigDecimal getPercentageOfEnabledAccountsOfAllAccounts()
    {
        long numberOfEnabledAccounts = getNumberOfEnabledAccounts();
        long numberOfRegisteredUsers = getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfEnabledAccounts, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfDisabledAccountsOfAllAccounts()
    {
        long numberOfDisabledAccounts = getNumberOfDisabledAccounts();
        long numberOfRegisteredUsers = getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfDisabledAccounts, numberOfRegisteredUsers);
    }


    public static BigDecimal getPercentageOfAccountsYetToBeValidatedOfAllAccounts()
    {
        long numberOfEnabledAccountsYetToBeValidated = getNumberOfAccountsYetToBeValidated();
        long numberOfRegisteredUsers = getNumberOfRegisteredUsers();
        return AnalyticsUsersPercentageFunction.run(numberOfEnabledAccountsYetToBeValidated, numberOfRegisteredUsers);
    }


    public static long getNumberOfAuthorities()
    {
        return UserAuthorityAnalyticsService.getAuthorities().size();
    }


    public static UserGeneralAnalyticsModel getUserGeneralAnalytics()
    {
        UserGeneralAnalyticsModel userGeneralAnalyticsModel = UserGeneralAnalyticsModel.builder()
                        .numberOfRegisteredUsers(getNumberOfRegisteredUsers())
                        .numberOfAdministratorUsers(getNumberOfAdministratorUsers())
                        .numberOfNonAdministratorUsers(getNumberOfNonAdministratorUsers())
                        .authoritiesToNumberOfUsersMapper(UserAuthorityAnalyticsService.getAuthoritiesToNumberOfUsersAsMap())
                        .numberOfEnabledAccounts(getNumberOfEnabledAccounts())
                        .numberOfDisabledAccounts(getNumberOfDisabledAccounts())
                        .numberOfLoggedInUsers(getNumberOfLoggedInUsers())
                        .numberOfLoggedOutUsers(getNumberOfLoggedOutUsers())
                        .numberOfAccountLockdowns(getNumberOfAccountLockdowns())
                        .numberOfUserLogins(getNumberOfUserLogins())
                        .numberOfUserLogouts(getNumberOfUserLogouts())
                        .numberOfUsersWithFailedLoginAttempts(getNumberOfUsersWithFailedLoginAttempts())
                        .numberOfAccountsYetToBeValidated(getNumberOfAccountsYetToBeValidated())
                        .numberOfResetPasswordRequests(getNumberOfResetPasswordRequests())
                        .authorities(UserAuthorityAnalyticsService.getAuthorities())
                        .percentageOfEnabledAccountsOfAllAccounts(getPercentageOfEnabledAccountsOfAllAccounts())
                        .percentageOfDisabledAccountsOfAllAccounts(getPercentageOfDisabledAccountsOfAllAccounts())
                        .percentageOfAccountsYetToBeValidatedOfAllAccounts(getPercentageOfAccountsYetToBeValidatedOfAllAccounts())
                        .build();
        return userGeneralAnalyticsModel;
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsDateTimes()
    {
        return GetUserRegistrationsDateTimesTask.run();
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return GetUserRegistrationsDateTimesForDateRangeTask.run(startDate, endDate);
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsDateTimesByAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserRegistrationsDateTimesByAuthorityForDateRangeTask.run(authority, startDate, endDate);
    }


    public static List<AnalyticsRegistrationModel> getUserRegistrationsDateTimesByAuthority(String authority)
    {
        return GetUserRegistrationsDateTimesByAuthorityTask.run(authority);
    }
}