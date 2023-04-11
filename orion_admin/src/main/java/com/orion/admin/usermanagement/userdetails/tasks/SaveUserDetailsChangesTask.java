package com.orion.admin.usermanagement.userdetails.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.data_access.OrionUserDetailsDAO;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;

public class SaveUserDetailsChangesTask extends Orion
{
    public static boolean run(OrionUserDetailsModel newUserDetails) throws UserHasNoAuthorityException
    {
        OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(newUserDetails.getUserID());
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(newUserDetails.getUserID());
        authority.setUsername(newUserDetails.getEmailAddress());
        UserAccountService.updateAuthorityByUserID(authority);
        userDetails.setEmailAddress(newUserDetails.getEmailAddress());
        userDetails.setMobileNumber(newUserDetails.getMobileNumber());
        return OrionUserDetailsDAO.update(userDetails) > 0;
    }
}
