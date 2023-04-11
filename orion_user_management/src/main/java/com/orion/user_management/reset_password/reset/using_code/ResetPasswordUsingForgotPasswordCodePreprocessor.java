package com.orion.user_management.reset_password.reset.using_code;

import com.orion.core.calendar.CalendarService;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;

class ResetPasswordUsingForgotPasswordCodePreprocessor
{
    static void process(ResetPasswordUsingForgotPasswordCodeData requestData)
    {

        try
        {
            //OrionForgotPasswordCodesModel forgotPasswordCodeModel = ForgotPasswordService.getForgotPasswordCodeModelByCode(resetPasswordRequestBean.getForgotPasswordCode());
            //boolean isValidSecurityQuestion = true;
            OrionForgotPasswordCodesModel forgotPasswordCodeModel = ForgotPasswordService.getForgotPasswordCodeByCode(requestData.getForgotPasswordCode());

            if(forgotPasswordCodeModel != null)
            {
                requestData.setForgotPasswordCodeModel(forgotPasswordCodeModel);

                if(CalendarService.hasExpired(forgotPasswordCodeModel.getExpirationDateTime()))
                {
                    ForgotPasswordService.deleteForgotPasswordCodeByUserID(forgotPasswordCodeModel.getUserID());
                    requestData.setValidResetPasswordCode(true);
                    requestData.setExpiredResetPasswordCode(true);
                    requestData.setPasswordHasBeenResetSuccessfully(false);
                    requestData.setNewPasswordMatchesOld(false);
                    requestData.setCallProcessor(false);
                }
                else
                {
                    requestData.setCallProcessor(true);
                }

            }
            else
            {
                requestData.setValidResetPasswordCode(false);
                requestData.setExpiredResetPasswordCode(false);
                requestData.setPasswordHasBeenResetSuccessfully(false);
                requestData.setNewPasswordMatchesOld(false);
                requestData.setCallProcessor(false);
            }

            /*
             * catch(NewPasswordMatchesOldPasswordException e) { return
             * ResetPasswordResponseBean.builder()
             * //.areSecurityQuestionsSetUpForUser(resetPasswordRequestBean.
             * getAreSecurityQuestionsSetUpForUser()) //.validSecurityQuestion(true)
             * .validResetPasswordCode(true) .expiredResetPasswordCode(false)
             * .passwordHasBeenResetSuccessfully(false) .newPasswordMatchesOld(true)
             * .build(); }
             */
        }
        catch(Exception e)
        {
            requestData.setPasswordHasBeenResetSuccessfully(Boolean.FALSE);
            requestData.setCallProcessor(false);
        }

    }
}