package com.orion.admin.usermanagement.userdetails;

import com.orion.admin.usermanagement.userdetails.tasks.GetAllUsersDataAsCSVTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserDataAsCSVTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserLoginDatesAndNumberOfLoginsForAuthorityTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserLoginDatesAndNumberOfLoginsForDateRangeTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserLoginDatesAndNumberOfLoginsTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserLogoutDatesAndNumberOfLogoutsForDateRangeTask;
import com.orion.admin.usermanagement.userdetails.tasks.GetUserLogoutDatesAndNumberOfLogoutsTask;
import com.orion.admin.usermanagement.userdetails.tasks.SaveUserDetailsChangesTask;
import com.orion.analytics.user.UserAnalyticsService;
import com.orion.analytics.user.authentication.UserAuthenticationAnalyticsService;
import com.orion.analytics.user.model.AnalyticsFailedLoginAttemptsModel;
import com.orion.analytics.user.model.AnalyticsLoginModel;
import com.orion.analytics.user.model.AnalyticsLogoutModel;
import com.orion.analytics.user.model.AnalyticsUserAggregatedDataModel;
import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.cryptology.encryption.bcrypt.BCryptEncryptionService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.security.data_access.OrionUserFailedLoginAttemptsDAO;
import com.orion.user_management.authentication.security.model.OrionUserFailedLoginAttemptModel;
import com.orion.user_management.data_access.OrionUsersDAO;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import java.util.List;
import java.util.stream.Collectors;

public class AdminUserManagementUserDetailsService extends OrionService
{
    public static AnalyticsUserAggregatedDataModel getUserData(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null)
        {
            return UserAnalyticsService.populateUserAggregatedDataModel(authority);
        }
        else
        {
            return null;
        }

    }


    public static String getUserDataAsCSV(String userID) throws UserHasNoAuthorityException
    {
        return GetUserDataAsCSVTask.run(getUserData(userID));
    }


    public static String getAllUsersDataAsCSV()
    {
        return GetAllUsersDataAsCSVTask.run(UserAnalyticsService.getUsersData());
    }


    public static String getAllUsersDataAsCSV(List<AnalyticsUserAggregatedDataModel> usersData)
    {
        return GetAllUsersDataAsCSVTask.run(usersData);
    }


    public static String getAllUsersOfAuthorityDataAsCSV(String authority)
    {
        return GetAllUsersDataAsCSVTask.run(UserAnalyticsService.getUsersDataByAuthority(authority));
    }


    public static boolean makeUserATestUser(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null)
        {
            authority.setIsTestUser(Boolean.TRUE);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean makeUserNotATestUser(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null)
        {
            authority.setIsTestUser(Boolean.FALSE);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean addDriverAuthorityToUser(String userID, String authorityToAdd) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.doesNotHaveAuthority(authorityToAdd))
        {

            if(authority.getAuthority().endsWith(","))
            {
                authority.setAuthority(authority.getAuthority() + authorityToAdd);
            }
            else
            {
                authority.setAuthority(authority.getAuthority() + "," + authorityToAdd);
            }

            authority.setIsDriver(Boolean.TRUE);
            authority.setIsSendDriverEmails(Boolean.TRUE);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean removeDriverAuthorityFromUser(String userID, String authorityToRemove) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.hasAuthority(authorityToRemove))
        {
            String newAuthority = authority.getAuthority();
            newAuthority = newAuthority.replace(authorityToRemove, "");
            newAuthority = newAuthority.replace(",,", ",");

            while(newAuthority.endsWith(","))
            {
                newAuthority = newAuthority.substring(0, newAuthority.length() - 1);
            }

            authority.setAuthority(newAuthority);
            authority.setIsDriver(Boolean.FALSE);
            authority.setIsSendDriverEmails(Boolean.FALSE);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean addAdministratorAuthorityToUser(String userID, String authorityToAdd) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.doesNotHaveAuthority(authorityToAdd))
        {

            if(authority.getAuthority().endsWith(","))
            {
                authority.setAuthority(authority.getAuthority() + authorityToAdd);
            }
            else
            {
                authority.setAuthority(authority.getAuthority() + "," + authorityToAdd);
            }

            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean removeAdministratorAuthorityFromUser(String userID, String authorityToRemove) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.hasAuthority(authorityToRemove))
        {
            String newAuthority = authority.getAuthority();
            newAuthority = newAuthority.replace(authorityToRemove, "");
            newAuthority = newAuthority.replace(",,", ",");

            while(newAuthority.endsWith(","))
            {
                newAuthority = newAuthority.substring(0, newAuthority.length() - 1);
            }

            authority.setAuthority(newAuthority);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean addCustomerSupportAuthorityToUser(String userID, String authorityToAdd) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.doesNotHaveAuthority(authorityToAdd))
        {

            if(authority.getAuthority().endsWith(","))
            {
                authority.setAuthority(authority.getAuthority() + authorityToAdd);
            }
            else
            {
                authority.setAuthority(authority.getAuthority() + "," + authorityToAdd);
            }

            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean removeCustomerSupportAuthorityFromUser(String userID, String authorityToRemove) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);

        if(authority != null && authority.hasAuthority(authorityToRemove))
        {
            String newAuthority = authority.getAuthority();
            newAuthority = newAuthority.replace(authorityToRemove, "");
            newAuthority = newAuthority.replace(",,", ",");

            while(newAuthority.endsWith(","))
            {
                newAuthority = newAuthority.substring(0, newAuthority.length() - 1);
            }

            authority.setAuthority(newAuthority);
            return UserAccountService.updateAuthorityByUserID(authority) != 0;
        }
        else
        {
            return false;
        }

    }


    public static boolean enableAccount(String userID)
    {
        boolean accountEnabled = UserAccountService.enableAccountByUserID(userID);
        OrionUserFailedLoginAttemptsDAO.delete(userID);
        return accountEnabled;
    }


    public static boolean disableAccount(String userID)
    {
        return UserAccountService.disableAccountByUserID(userID);
    }


    public static boolean emailUserthatAccountIsEnabled(String userID)
    {
        return UserAccountService.emailUserThatAccountIsEnabled(userID);
    }


    public static boolean saveUserDetailsChanges(OrionUserDetailsModel newUserDetails) throws UserHasNoAuthorityException
    {
        return SaveUserDetailsChangesTask.run(newUserDetails);
    }


    public static boolean updatePassword(String userID, String newPassword) throws UserHasNoAuthorityException
    {
        OrionUserModel user = UserAccountService.getUserByUserID(userID);
        user.setPassword(BCryptEncryptionService.encrypt(newPassword));
        return OrionUsersDAO.update(user) > 0;
    }


    public static AnalyticsFailedLoginAttemptsModel getFailedLoginAttempts(String userID)
    {
        OrionUserFailedLoginAttemptModel model = OrionUserFailedLoginAttemptsDAO.getByUserID(userID);
        return AnalyticsFailedLoginAttemptsModel.builder()
                        .model(model)
                        .build();
    }


    public static List<AnalyticsLoginModel> getUserLogins(String userID)
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimes(userID);
    }


    public static List<AnalyticsLoginModel> getUserLogins()
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimes();
    }


    public static List<AnalyticsLoginModel> getUserLoginsForAuthority(String authority)
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimesForAuthority(authority);
    }


    public static List<AnalyticsLoginModel> getUserLoginsForAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimesForAuthorityForDateRange(authority, startDate, endDate);
    }


    public static List<AnalyticsLoginModel> getUserLoginsForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimesForDateRange(startDate, endDate);
    }


    public static List<AnalyticsLoginModel> getUserLoginsOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return UserAuthenticationAnalyticsService.getUserLoginsDateTimesOfUserIDForDateRange(userID, startDate, endDate);
    }


    public static List<AnalyticsLogoutModel> getUserLogoutsOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return UserAuthenticationAnalyticsService.getUserLogoutsDateTimesOfUserIDForDateRange(userID, startDate, endDate);
    }


    public static List<AnalyticsLogoutModel> getUserLogouts(String userID)
    {
        return UserAuthenticationAnalyticsService.getUserLogoutsDateTimes(userID);
    }


    public static List<DateTime> getUserLoginsDateTimes(String userID)
    {
        return getUserLogins(userID).stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginsDateTimes()
    {
        return getUserLogins().stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginsDateTimesForAuthority(String authority)
    {
        return getUserLoginsForAuthority(authority).stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginsDateTimesForAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return getUserLoginsForAuthorityForDateRange(authority, startDate, endDate).stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginsDateTimesForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return getUserLoginsForDateRange(startDate, endDate).stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLoginsDateTimesOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return getUserLoginsOfUserIDForDateRange(userID, startDate, endDate).stream()
                        .map(model -> model.getLoginDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLogoutsDateTimes(String userID)
    {
        return getUserLogouts(userID).stream()
                        //.filter(model -> model != null)
                        .map(model -> model.getLogoutDateTime())
                        .collect(Collectors.toList());
    }


    public static List<DateTime> getUserLogoutsDateTimesOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return getUserLogoutsOfUserIDForDateRange(userID, startDate, endDate).stream()
                        .map(model -> model.getLogoutDateTime())
                        .collect(Collectors.toList());
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLogins(String userID)
    {
        return GetUserLoginDatesAndNumberOfLoginsTask.run(userID, getUserLoginsDateTimes(userID));
    }


    public static List<List<Long>> getUserLogoutDatesAndNumberOfLogouts(String userID)
    {
        return GetUserLogoutDatesAndNumberOfLogoutsTask.run(userID, getUserLogoutsDateTimes(userID));
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLoginsForAuthority(String authority)
    {
        return GetUserLoginDatesAndNumberOfLoginsForAuthorityTask.run(authority, getUserLoginsDateTimesForAuthority(authority));
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLoginsForAuthorityForDateRange(String authority, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginDatesAndNumberOfLoginsForAuthorityTask.run(authority, getUserLoginsDateTimesForAuthorityForDateRange(authority, startDate, endDate));
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLoginsForDateRange(String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginDatesAndNumberOfLoginsForDateRangeTask.run(getUserLoginsDateTimesForDateRange(startDate, endDate));
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLoginsOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLoginDatesAndNumberOfLoginsForDateRangeTask.run(getUserLoginsDateTimesOfUserIDForDateRange(userID, startDate, endDate));
    }


    public static List<List<Long>> getUserLoginDatesAndNumberOfLogins()
    {
        return GetUserLoginDatesAndNumberOfLoginsTask.run(getUserLoginsDateTimes());
    }


    public static List<List<Long>> getUserLogoutDatesAndNumberOfLogoutsOfUserIDForDateRange(String userID, String startDate, String endDate) throws InvalidDateException
    {
        return GetUserLogoutDatesAndNumberOfLogoutsForDateRangeTask.run(getUserLogoutsDateTimesOfUserIDForDateRange(userID, startDate, endDate));
    }
}