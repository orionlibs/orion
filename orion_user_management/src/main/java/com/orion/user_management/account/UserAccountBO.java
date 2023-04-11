package com.orion.user_management.account;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.data_access.OrionAuthoritiesDAO;
import com.orion.user_management.data_access.OrionUsersDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserAccountBO extends Orion
{
    private String userID;


    public static UserAccountBO of(String userID)
    {
        return UserAccountBO.builder().userID(userID.trim()).build();
    }


    public boolean isAccountEnabled()
    {
        return OrionUsersDAO.isUserEnabledByUserID(userID);
    }


    public boolean isAccountActivated()
    {
        return OrionAuthoritiesDAO.isAccountActivated(userID);
    }


    public boolean doesAccountNeedReauthentication()
    {
        return OrionUsersDAO.doesAccountNeedReauthentication(userID);
    }


    public boolean enableAccountByUserID()
    {
        return OrionUsersDAO.enableAccountByUserID(userID) != 0;
    }


    public static long getNumberOfEnabledAccounts()
    {
        return OrionUsersDAO.getNumberOfEnabledAccounts();
    }


    public static long getNumberOfDisabledAccounts()
    {
        return OrionUsersDAO.getNumberOfDisabledAccounts();
    }


    public static long getNumberOfAccountLockdowns()
    {
        return OrionUsersDAO.getNumberOfAccountLockdowns();
    }
}