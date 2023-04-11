package com.orion.user_management.reset_password.reset.using_code;

import com.orion.data.user.password.PasswordService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.reset_password.ResetPasswordResult;
import com.orion.user_management.reset_password.exception.NewPasswordMatchesOldPasswordException;
import com.orion.user_management.reset_password.reset.ResetPasswordHelper;

class ResetPasswordUsingForgotPasswordCodeProcessor
{
    static ResetPasswordResult process(ResetPasswordUsingForgotPasswordCodeData requestData)
    {

        try
        {
            return processResetPassword(requestData.getForgotPasswordCodeModel().getUserID(), requestData.getPassword());
        }
        catch(Exception e)
        {
            return ResetPasswordResult.builder()
                            .passwordHasBeenResetSuccessfully(Boolean.FALSE)
                            .build();
        }

    }


    private static ResetPasswordResult processResetPassword(String userID, String newPassword) throws NewPasswordMatchesOldPasswordException
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
            try
            {
                UserAccountService.resetPasswordByUserID(userID, encryptedPassword, true);
                ResetPasswordHelper.updateUserAfterPasswordReset(userID);
                ForgotPasswordService.deleteForgotPasswordCodeByUserID(userID);
                ResetPasswordResult result = new ResetPasswordResult();
                result.setValidSecurityQuestion(true);
                result.setPasswordHasBeenResetSuccessfully(true);
                result.setExpiredResetPasswordCode(false);
                result.setNewPasswordMatchesOld(false);
                result.setValidResetPasswordCode(true);
                result.setValidPassword(true);
                result.setUserID(userID);
                return result;
            }
            catch(Exception e)
            {
                ResetPasswordResult result = new ResetPasswordResult();
                result.setPasswordHasBeenResetSuccessfully(false);
                return result;
            }

            //}
        }
        else
        {
            ResetPasswordResult result = new ResetPasswordResult();
            result.setValidSecurityQuestion(true);
            result.setPasswordHasBeenResetSuccessfully(false);
            result.setExpiredResetPasswordCode(false);
            result.setNewPasswordMatchesOld(false);
            result.setValidResetPasswordCode(true);
            result.setValidPassword(false);
            return result;
        }

    }
}