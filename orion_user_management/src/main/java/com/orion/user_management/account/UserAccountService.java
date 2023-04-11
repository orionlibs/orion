package com.orion.user_management.account;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.user_management.account.data_access.OrionAccountReactivationValidationCodesDAO;
import com.orion.user_management.account.model.OrionAccountReactivationValidationCodeModel;
import com.orion.user_management.account.tasks.DoesNewEmailAddressNeedValidationTask;
import com.orion.user_management.account.tasks.EmailUserAccountDeactivationTask;
import com.orion.user_management.account.tasks.EmailUserAccountReactivationValidationCodeTask;
import com.orion.user_management.account.tasks.EmailUserEmailValidationCodeForNewUsernameTask;
import com.orion.user_management.account.tasks.EmailUserThatAccountIsEnabledTask;
import com.orion.user_management.account.tasks.ResendValidationCodeToNewEmailAddressTask;
import com.orion.user_management.account.tasks.ValidateAccountReactivationTask;
import com.orion.user_management.account.tasks.ValidateNewEmailAddressTask;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationCodeHasExpiredException;
import com.orion.user_management.email_validation.OrionEmailValidationResponseBean;
import com.orion.user_management.email_validation.tasks.EmailUserAccountValidationTask;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.model.OrionUserSettingsModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserAccountService extends OrionService
{
    public static boolean doesUsernameExist(String emailAddress)
    {
        return UsernameBO.of(emailAddress).doesUsernameExist();
    }


    public static OrionAuthorityModel getAuthorityByUsername(String username) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUsername(username).getAuthorityByUsername();
    }


    public static OrionAuthorityModel getAuthorityByUserID(String userID) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUserID(userID).getAuthorityByUserID();
    }


    public static boolean doesUserExistByUserID(String userID)
    {
        return UserAuthorityBO.ofUserID(userID).doesUserExistByUserID();
    }


    public static boolean doesUserNotExistByUserID(String userID)
    {
        return !doesUserExistByUserID(userID);
    }


    public static boolean doesUserExistByUsername(String username)
    {
        return UserAuthorityBO.ofUsername(username).doesUserExistByUsername();
    }


    public static boolean doesPendingUsernameExist(String pendingUsername)
    {
        return UserAuthorityBO.ofUsername(pendingUsername).doesPendingUsernameExist();
    }


    public static boolean validateNewEmailAddress(String userID, UserManagementAccountNewEmailAddressValidationRequestBean requestBean, HttpServletRequest request)
                    throws ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException, ChangeEmailAddressEmailValidationCodeHasExpiredException, UserHasNoAuthorityException
    {
        return ValidateNewEmailAddressTask.run(userID, requestBean, request);
    }


    public static void emailUserEmailValidationCodeForNewUsername(String newEmailAddress, String emailValidationCode)
    {
        EmailUserEmailValidationCodeForNewUsernameTask.run(newEmailAddress, emailValidationCode);
    }


    public static void emailUserAccountReactivationValidationCode(String emailAddress, String emailValidationCode)
    {
        EmailUserAccountReactivationValidationCodeTask.run(emailAddress, emailValidationCode);
    }


    public static void emailUserAccountDeactivation(String userID)
    {
        EmailUserAccountDeactivationTask.run(getUserEmailAddressByUserID(userID));
    }


    public static OrionEmailValidationResponseBean validateAccountReactivationCode(String emailValidationCode) throws UserHasNoAuthorityException
    {
        return ValidateAccountReactivationTask.run(emailValidationCode);
    }


    public static boolean resendValidationCodeToNewEmailAddress(String userID)
    {
        return ResendValidationCodeToNewEmailAddressTask.run(userID);
    }


    public static boolean isAccountEnabledAndActivated(String userID)
    {
        return isAccountActivated(userID) && isAccountEnabled(userID);
    }


    public static boolean isAccountEnabled(String userID)
    {
        return UserAccountBO.of(userID).isAccountEnabled();
    }


    public static boolean isAccountDisabled(String userID)
    {
        return !isAccountEnabled(userID);
    }


    public static boolean isAccountActivated(String userID)
    {
        return UserAccountBO.of(userID).isAccountActivated();
    }


    public static boolean isAccountDeactivated(String userID)
    {
        return !isAccountActivated(userID);
    }


    public static List<OrionAuthorityModel> getUsersAuthorities()
    {
        return UserAuthorityBO.getUsersAuthorities();
    }


    public static long getNumberOfRegisteredUsers()
    {
        return UserAuthorityBO.getNumberOfRegisteredUsers();
    }


    public static long getNumberOfAdministratorUsers()
    {
        return UserAuthorityBO.getNumberOfAdministratorUsers();
    }


    public static long getNumberOfAnonymousUsers()
    {
        return UserAuthorityBO.getNumberOfAnonymousUsers();
    }


    public static long getNumberOfNonAdministratorUsers()
    {
        return UserAuthorityBO.getNumberOfNonAdministratorUsers();
    }


    public static long getNumberOfUsersByAuthority(String authority)
    {
        return UserAuthorityBO.ofAuthority(authority).getNumberOfUsersByAuthority();
    }


    public static int updateAuthorityByUserID(OrionAuthorityModel model)
    {
        return UserAuthorityBO.updateAuthorityByUserID(model);
    }


    public static int updateNewUsernameInAuthorityByUserID(String newUsername, String userID)
    {
        return UserAuthorityBO.builder()
                        .username(newUsername)
                        .userID(userID)
                        .build()
                        .updateNewUsernameByUserID();
    }


    public static List<OrionAuthorityModel> getAuthoritiesByAuthority(String authority)
    {
        return UserAuthorityBO.ofAuthority(authority).getAuthoritiesByAuthority();
    }


    public static List<OrionAuthorityModel> getActiveAuthoritiesByAuthority(String authority)
    {
        return UserAuthorityBO.ofAuthority(authority).getActiveAuthoritiesByAuthority();
    }


    public static List<OrionAuthorityModel> getUsernamesByAuthority(String authority)
    {
        return UserAuthorityBO.ofAuthority(authority).getUsernamesByAuthority();
    }


    public static int deleteAuthorityByUserID(String userID)
    {
        return UserAuthorityBO.ofUserID(userID).deleteAuthorityByUserID();
    }


    public static int saveAuthority(OrionAuthorityModel model)
    {
        return UserAuthorityBO.saveAuthority(model);
    }


    public static boolean doesAccountNeedReauthentication(String userID)
    {
        return UserAccountBO.of(userID).doesAccountNeedReauthentication();
    }


    public static boolean doesNewEmailAddressNeedValidation(String userID) throws UserHasNoAuthorityException
    {
        return DoesNewEmailAddressNeedValidationTask.run(userID);
    }


    public static boolean enableAccountByUserID(String userID)
    {
        return UserAccountBO.of(userID).enableAccountByUserID();
    }


    public static boolean activateAccount(String userID)
    {
        return UserAuthorityBO.ofUserID(userID).activateAccount();
    }


    public static boolean deactivateAccount(String userID, HttpServletRequest request, HttpServletResponse response) throws IOException, UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUserID(userID).deactivateAccount(request, response);
    }


    public static boolean disableAccountByUserID(String userID)
    {
        return UserAuthorityBO.ofUserID(userID).disableAccountByUserID();
    }


    public static boolean emailUserThatAccountIsEnabled(String userID)
    {
        return EmailUserThatAccountIsEnabledTask.run(getUserEmailAddressByUserID(userID));
    }


    public static OrionUserDetailsModel getUserDetailsByUserID(String userID)
    {
        return UserDetailsBO.ofUserID(userID).getUserDetailsByUserID();
    }


    public static String getFirstNameByUserID(String userID)
    {
        return UserDetailsBO.ofUserID(userID).getFirstNameByUserID();
    }


    public static String getFullNameByUserID(String userID)
    {
        return UserDetailsBO.ofUserID(userID).getFullNameByUserID();
    }


    public static String getUserSelectedThemeByUserID(String userID)
    {
        return UserSettingsBO.of(userID).getUserSelectedThemeByUserID();
    }


    public static OrionUserSettingsModel getUserSettingsByUserID(String userID)
    {
        return UserSettingsBO.of(userID).getUserSettingsByUserID();
    }


    public static List<OrionUserDetailsModel> getUsersDetailsByPhoneNumber(String phoneNumber)
    {
        return UserDetailsBO.ofPhoneNumber(phoneNumber).getUsersDetailsByPhoneNumber();
    }


    public static String getUserPhoneNumberByUserID(String userID)
    {
        return UserDetailsBO.ofUserID(userID).getUserPhoneNumberByUserID();
    }


    public static String getUserEmailAddressByUserID(String userID)
    {
        return UserDetailsBO.ofUserID(userID).getUserEmailAddressByUserID();
    }


    public static String getUserIDByUsername(String emailAddress) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUsername(emailAddress).getUserIDByUsername();
    }


    public static String getUserIDByNewUsername(String emailAddress) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUsername(emailAddress).getUserIDByNewUsername();
    }


    public static String getUsernameByUserID(String userID) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUserID(userID).getUsernameByUserID();
    }


    public static String getNewUsernameByUserID(String userID) throws UserHasNoAuthorityException
    {
        return UserAuthorityBO.ofUserID(userID).getNewUsernameByUserID();
    }


    public static int saveUserDetails(OrionUserDetailsModel model)
    {
        return UserDetailsBO.save(model);
    }


    public static int updateUserDetailsByUserID(OrionUserDetailsModel user)
    {
        return UserDetailsBO.updateByUserID(user);
    }


    public static int updateUserSelectedThemeByUserID(String selectedTheme, String userID)
    {
        return UserSettingsBO.of(userID).updateUserSelectedThemeByUserID(selectedTheme);
    }


    public static OrionUserModel getUserByUserID(String userID)
    {
        return UserBO.of(userID).getUserByUserID();
    }


    public static int updateUserByUserID(OrionUserModel user)
    {
        return UserBO.update(user);
    }


    public static long getNumberOfUserRegistrationsByAuthorityAndDate(String authority, String date)
    {
        return UserBO.getNumberOfUserRegistrationsByAuthorityAndDate(authority, date);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthorityForDateRange(String authority, String date1, String date2) throws InvalidDateException
    {
        return UserBO.getUserRegistrationDateTimesByAuthorityForDateRange(authority, date1, date2);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesForDateRange(String date1, String date2) throws InvalidDateException
    {
        return UserBO.getUserRegistrationDateTimesForDateRange(date1, date2);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthority(String authority)
    {
        return UserBO.getUserRegistrationDateTimesByAuthority(authority);
    }


    public static long getNumberOfUserRegistrationsByDate(String date)
    {
        return UserBO.getNumberOfUserRegistrationsByDate(date);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimes()
    {
        return UserBO.getUserRegistrationDateTimes();
    }


    public static long getNumberOfEnabledAccounts()
    {
        return UserAccountBO.getNumberOfEnabledAccounts();
    }


    public static long getNumberOfDisabledAccounts()
    {
        return UserAccountBO.getNumberOfDisabledAccounts();
    }


    public static long getNumberOfLoggedInUsers()
    {
        return UserBO.getNumberOfLoggedInUsers();
    }


    public static long getNumberOfLoggedOutUsers()
    {
        return UserBO.getNumberOfLoggedOutUsers();
    }


    public static long getNumberOfAccountLockdowns()
    {
        return UserAccountBO.getNumberOfAccountLockdowns();
    }


    public static int deleteUserByUserID(String userID)
    {
        return UserBO.of(userID).deleteUserByUserID();
    }


    public static int saveUser(OrionUserModel model)
    {
        return UserBO.save(model);
    }


    public static int resetPasswordByUserID(String userID, String password, boolean deleteJWTRefreshTokens)
    {
        return UserBO.of(userID).resetPasswordByUserID(password, deleteJWTRefreshTokens);
    }


    public static OrionUserModel getUserByUserIDAndEnabled(String userID)
    {
        return UserBO.of(userID).getUserByUserIDAndEnabled();
    }


    public static int setUserAsLoggedOutByUserID(String userID)
    {
        return UserBO.of(userID).setUserAsLoggedOutByUserID();
    }


    public static OrionAccountReactivationValidationCodeModel getAccountReactivationValidationCodeByCode(String emailValidationCode)
    {
        return OrionAccountReactivationValidationCodesDAO.getByCode(emailValidationCode);
    }


    public static OrionAccountReactivationValidationCodeModel getAccountReactivationValidationCodeByUserID(String userID)
    {
        return OrionAccountReactivationValidationCodesDAO.getByUserID(userID);
    }


    public static int saveAccountReactivationValidationCode(OrionAccountReactivationValidationCodeModel model)
    {
        return OrionAccountReactivationValidationCodesDAO.save(model);
    }


    public static int updateAccountReactivationValidationCode(OrionAccountReactivationValidationCodeModel model)
    {
        return OrionAccountReactivationValidationCodesDAO.update(model);
    }


    public static int deleteAccountReactivationValidationCodeByUserID(String userID)
    {
        return OrionAccountReactivationValidationCodesDAO.delete(userID);
    }


    public static void emailUserAccountValidation(String emailAddress)
    {
        EmailUserAccountValidationTask.run(emailAddress);
    }
}