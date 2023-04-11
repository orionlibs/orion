package com.orion.user_management.reset_password.storefront_api.request;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.user_management.forgot_password.ForgotPasswordService;
import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;
import com.orion.user_management.reset_password.reset.using_code.ResetPasswordValidationData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class ResetPasswordRequestValidator extends Orion
{
    public static ResetPasswordValidationResult isValidRequest(ResetPasswordValidationData requestData)
    {
        OrionForgotPasswordCodesModel forgotPasswordCodeModel = ForgotPasswordService.getForgotPasswordCodeByCode(requestData.getForgotPasswordCode());

        if(forgotPasswordCodeModel != null)
        {

            if(CalendarService.hasExpired(forgotPasswordCodeModel.getExpirationDateTime()))
            {
                return ResetPasswordValidationResult.builder()
                                .validResetPasswordCode(false)
                                .expiredResetPasswordCode(true)
                                .passwordHasBeenResetSuccessfully(false)
                                .newPasswordMatchesOld(false)
                                .build();
            }
            else
            {
                return ResetPasswordValidationResult.builder()
                                .validResetPasswordCode(true)
                                .expiredResetPasswordCode(false)
                                .passwordHasBeenResetSuccessfully(false)
                                .newPasswordMatchesOld(false)
                                .userID(forgotPasswordCodeModel.getUserID())
                                .build();
            }

        }
        else
        {
            return ResetPasswordValidationResult.builder()
                            .validResetPasswordCode(false)
                            .expiredResetPasswordCode(false)
                            .passwordHasBeenResetSuccessfully(false)
                            .newPasswordMatchesOld(false)
                            .build();
        }

    }
}