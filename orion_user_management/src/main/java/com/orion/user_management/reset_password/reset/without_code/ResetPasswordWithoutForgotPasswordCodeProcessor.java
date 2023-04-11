package com.orion.user_management.reset_password.reset.without_code;

import com.orion.data.user.password.PasswordService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.account.UserManagementAccountPasswordRequestBean;
import com.orion.user_management.reset_password.ResetPasswordResult;
import com.orion.user_management.reset_password.reset.ResetPasswordHelper;

class ResetPasswordWithoutForgotPasswordCodeProcessor
{
    static ResetPasswordResult process(String userID, UserManagementAccountPasswordRequestBean resetPasswordRequestBean)
    {

        try
        {
            return resetPassword(userID, resetPasswordRequestBean.getNewPassword());
        }
        catch(Exception e)
        {
            ResetPasswordResult result = new ResetPasswordResult();
            result.setPasswordHasBeenResetSuccessfully(false);
            return result;
        }

    }


    private static ResetPasswordResult resetPassword(String userID, String newPassword)
    {

        try
        {

            if(PasswordService.isValid(newPassword))
            {
                //SaveUsersOldPasswordTask.run(userID);
                String encryptedPassword = PasswordService.encrypt(newPassword);
                /*
                 * if(doesNewPasswordMatchOldPasswords(userID, newPassword)) { throw new
                 * NewPasswordMatchesOldPasswordException("The new password should not match any of the old ones."
                 * ); } else {
                 */
                UserAccountService.resetPasswordByUserID(userID, encryptedPassword, false);
                ResetPasswordHelper.updateUserAfterPasswordReset(userID);
                return ResetPasswordResult.builder()
                                .passwordHasBeenResetSuccessfully(true)
                                .newPasswordMatchesOld(false)
                                .validPassword(true)
                                .build();
                //}
            }
            else
            {
                ResetPasswordResult result = new ResetPasswordResult();
                result.setPasswordHasBeenResetSuccessfully(false);
                result.setNewPasswordMatchesOld(false);
                result.setValidPassword(false);
                return result;
            }

        }
        /*
         * catch(NewPasswordMatchesOldPasswordException e) { return
         * ResetPasswordResponseBean.builder() .passwordHasBeenResetSuccessfully(false)
         * .newPasswordMatchesOld(true) .build(); }
         */
        catch(Exception e)
        {
            return ResetPasswordResult.builder()
                            .passwordHasBeenResetSuccessfully(false)
                            .build();
        }

    }
}