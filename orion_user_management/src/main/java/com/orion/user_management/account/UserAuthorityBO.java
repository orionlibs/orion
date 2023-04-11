package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.authentication.logout.OrionLogoutService;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationService;
import com.orion.user_management.data_access.OrionAuthoritiesDAO;
import com.orion.user_management.data_access.OrionUsersDAO;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.model.OrionAuthorityModel;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserAuthorityBO extends Orion
{
    private String username;
    private String userID;
    private String authority;


    public static UserAuthorityBO ofUsername(String username)
    {
        return UserAuthorityBO.builder().username(username.trim()).build();
    }


    public static UserAuthorityBO ofUserID(String userID)
    {
        return UserAuthorityBO.builder().userID(userID.trim()).build();
    }


    public static UserAuthorityBO ofAuthority(String authority)
    {
        return UserAuthorityBO.builder().authority(authority.trim()).build();
    }


    public OrionAuthorityModel getAuthorityByUsername() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getByUsername(username);
    }


    public OrionAuthorityModel getAuthorityByUserID() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getByUserID(userID);
    }


    public boolean doesUserExistByUserID()
    {
        return OrionAuthoritiesDAO.doesUserExistByUserID(userID);
    }


    public boolean doesUserExistByUsername()
    {
        return OrionAuthoritiesDAO.doesUserExistByUsername(username);
    }


    public boolean doesPendingUsernameExist()
    {
        return OrionAuthoritiesDAO.doesPendingUsernameExist(username);
    }


    public static List<OrionAuthorityModel> getUsersAuthorities()
    {
        return OrionAuthoritiesDAO.getUsersAuthorities();
    }


    public static long getNumberOfRegisteredUsers()
    {
        return OrionAuthoritiesDAO.getNumberOfRegisteredUsers();
    }


    public static long getNumberOfAdministratorUsers()
    {
        return OrionAuthoritiesDAO.getNumberOfAdministratorUsers();
    }


    public static long getNumberOfAnonymousUsers()
    {
        return OrionAuthoritiesDAO.getNumberOfAnonymousUsers();
    }


    public static long getNumberOfNonAdministratorUsers()
    {
        return OrionAuthoritiesDAO.getNumberOfNonAdministratorUsers();
    }


    public long getNumberOfUsersByAuthority()
    {
        return OrionAuthoritiesDAO.getNumberOfUsersByAuthority(authority);
    }


    public static int updateAuthorityByUserID(OrionAuthorityModel model)
    {
        return OrionAuthoritiesDAO.update(model);
    }


    public int updateNewUsernameByUserID()
    {
        return OrionAuthoritiesDAO.updateNewUsernameByUserID(username, userID);
    }


    public List<OrionAuthorityModel> getAuthoritiesByAuthority()
    {
        return OrionAuthoritiesDAO.getAuthoritiesByAuthority(authority);
    }


    public List<OrionAuthorityModel> getActiveAuthoritiesByAuthority()
    {
        return OrionAuthoritiesDAO.getActiveAuthoritiesByAuthority(authority);
    }


    public List<OrionAuthorityModel> getUsernamesByAuthority()
    {
        return OrionAuthoritiesDAO.getUsernamesByAuthority(authority);
    }


    public int deleteAuthorityByUserID()
    {
        return OrionAuthoritiesDAO.delete(userID);
    }


    public static int saveAuthority(OrionAuthorityModel model)
    {
        return OrionAuthoritiesDAO.save(model);
    }


    public boolean activateAccount()
    {
        return OrionAuthoritiesDAO.activateAccountByUserID(userID) != 0;
    }


    public boolean disableAccountByUserID()
    {
        AuthenticationTokenService.deleteRefreshTokensByUserID(userID);
        return OrionUsersDAO.disableAccountByUserID(userID) != 0;
    }


    public boolean deactivateAccount(HttpServletRequest request, HttpServletResponse response) throws IOException, UserHasNoAuthorityException
    {
        OrionLogoutService.logoutUser(request, response, false);
        ForgotPasswordService.deleteForgotPasswordCodeByUserID(userID);
        ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(userID);
        return disableAccountByUserID() && OrionAuthoritiesDAO.deactivateAccountByUserID(userID) != 0;
    }


    public String getUserIDByUsername() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getUserIDByUsername(username);
    }


    public String getUserIDByNewUsername() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getUserIDByNewUsername(username);
    }


    public String getUsernameByUserID() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getUsernameByUserID(userID);
    }


    public String getNewUsernameByUserID() throws UserHasNoAuthorityException
    {
        return OrionAuthoritiesDAO.getNewUsernameByUserID(userID);
    }
}