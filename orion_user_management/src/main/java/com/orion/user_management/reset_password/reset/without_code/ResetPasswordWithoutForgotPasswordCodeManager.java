package com.orion.user_management.reset_password.reset.without_code;

import com.orion.user_management.account.UserManagementAccountPasswordRequestBean;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.reset_password.ResetPasswordResult;
import com.orion.user_management.reset_password.reset.EmailUserAfterResetPasswordHelper;

public class ResetPasswordWithoutForgotPasswordCodeManager
{
    public static ResetPasswordResult resetPassword(String userID, UserManagementAccountPasswordRequestBean resetPasswordRequestBean)
    {
        ResetPasswordResult result = ResetPasswordWithoutForgotPasswordCodeProcessor.process(userID, resetPasswordRequestBean);

        if(result.getPasswordHasBeenResetSuccessfully())
        {

            try
            {
                EmailUserAfterResetPasswordHelper.run(userID);
            }
            catch(UserHasNoAuthorityException e)
            {
                //
            }

        }

        return result;
    }
}