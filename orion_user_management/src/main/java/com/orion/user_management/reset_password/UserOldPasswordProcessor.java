package com.orion.user_management.reset_password;

import com.orion.core.abstraction.OrionService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.reset_password.exception.CannotSaveUsersOldPasswordException;
import com.orion.user_management.reset_password.model.OrionUserOldPasswordModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class UserOldPasswordProcessor extends OrionService
{
    private String userID;


    public static UserOldPasswordProcessor of(String userID)
    {
        return UserOldPasswordProcessor.builder().userID(userID).build();
    }


    public void saveOldUserPassword() throws CannotSaveUsersOldPasswordException
    {
        OrionUserModel user = UserAccountService.getUserByUserID(userID);
        OrionUserOldPasswordModel oldPasswordModel = new OrionUserOldPasswordModel();
        oldPasswordModel.setUserID(userID);
        oldPasswordModel.setPassword(user.getPassword());
        int numberOfRowsAffected = ResetPasswordService.saveUserOldPassword(oldPasswordModel);

        if(numberOfRowsAffected == 0)
        {
            throw new CannotSaveUsersOldPasswordException("Cannot save the old password of userID '{}'", userID);
        }

    }
}