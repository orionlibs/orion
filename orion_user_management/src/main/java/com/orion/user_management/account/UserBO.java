package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.data_access.OrionUsersDAO;
import com.orion.user_management.model.OrionUserModel;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserBO extends Orion
{
    private String userID;


    public static UserBO of(String userID)
    {
        return UserBO.builder().userID(userID.trim()).build();
    }


    public OrionUserModel getUserByUserID()
    {
        return OrionUsersDAO.getByUserID(userID);
    }


    public static int update(OrionUserModel user)
    {
        return OrionUsersDAO.update(user);
    }


    public static long getNumberOfUserRegistrationsByAuthorityAndDate(String authority, String date)
    {
        return OrionUsersDAO.getNumberOfUserRegistrationsByAuthorityAndDate(authority, date);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthorityForDateRange(String authority, String date1, String date2) throws InvalidDateException
    {
        return OrionUsersDAO.getUserRegistrationDateTimesByAuthorityForDateRange(authority, date1, date2);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesForDateRange(String date1, String date2) throws InvalidDateException
    {
        return OrionUsersDAO.getUserRegistrationDateTimesForDateRange(date1, date2);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimesByAuthority(String authority)
    {
        return OrionUsersDAO.getUserRegistrationDateTimesByAuthority(authority);
    }


    public static long getNumberOfUserRegistrationsByDate(String date)
    {
        return OrionUsersDAO.getNumberOfUserRegistrationsByDate(date);
    }


    public static List<OrionUserModel> getUserRegistrationDateTimes()
    {
        return OrionUsersDAO.getUserRegistrationDateTimes();
    }


    public static long getNumberOfLoggedInUsers()
    {
        return OrionUsersDAO.getNumberOfLoggedInUsers();
    }


    public static long getNumberOfLoggedOutUsers()
    {
        return OrionUsersDAO.getNumberOfLoggedOutUsers();
    }


    public int deleteUserByUserID()
    {
        AuthenticationTokenService.deleteRefreshTokensByUserID(userID);
        return OrionUsersDAO.delete(userID);
    }


    public static int save(OrionUserModel model)
    {
        return OrionUsersDAO.save(model);
    }


    public int resetPasswordByUserID(String password, boolean deleteJWTRefreshTokens)
    {

        if(deleteJWTRefreshTokens)
        {
            AuthenticationTokenService.deleteRefreshTokensByUserID(userID);
        }

        return OrionUsersDAO.resetPasswordByUserID(userID, password);
    }


    public OrionUserModel getUserByUserIDAndEnabled()
    {
        return OrionUsersDAO.getByUserIDAndEnabled(userID);
    }


    public int setUserAsLoggedOutByUserID()
    {
        return OrionUsersDAO.setUserAsLoggedOutByUserID(userID);
    }
}