package com.orion.user_management.reset_password.reset.using_code;

import com.orion.user_management.reset_password.ResetPasswordResult;
import com.orion.user_management.reset_password.reset.EmailUserAfterResetPasswordHelper;

public class ResetPasswordUsingForgotPasswordCodeManager
{
    public static ResetPasswordResult resetPassword(ResetPasswordUsingForgotPasswordCodeData requestData)
    {

        try
        {
            ResetPasswordUsingForgotPasswordCodePreconditions.validate(requestData);
            ResetPasswordUsingForgotPasswordCodePreprocessor.process(requestData);

            if(requestData.getCallProcessor())
            {
                ResetPasswordResult result = ResetPasswordUsingForgotPasswordCodeProcessor.process(requestData);

                if(result.getPasswordHasBeenResetSuccessfully())
                {
                    EmailUserAfterResetPasswordHelper.run(result.getUserID());
                    result.setUserID(null);
                }

                return result;
            }
            else
            {
                return ResetPasswordResult.builder()
                                .validResetPasswordCode(requestData.getValidResetPasswordCode())
                                .expiredResetPasswordCode(requestData.getExpiredResetPasswordCode())
                                .passwordHasBeenResetSuccessfully(requestData.getPasswordHasBeenResetSuccessfully())
                                .newPasswordMatchesOld(requestData.getNewPasswordMatchesOld())
                                .build();
            }

        }
        catch(Exception e)
        {
            return ResetPasswordResult.builder()
                            .passwordHasBeenResetSuccessfully(Boolean.FALSE)
                            .build();
        }

    }
}