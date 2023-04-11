package com.orion.user_management.reset_password.reset.using_code;

import com.orion.user_management.forgot_password.model.OrionForgotPasswordCodesModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ResetPasswordUsingForgotPasswordCodeData
{
    private String forgotPasswordCode;
    private String password;
    private Boolean callProcessor;
    private Boolean passwordHasBeenResetSuccessfully;
    private Boolean expiredResetPasswordCode;
    private Boolean validResetPasswordCode;
    private Boolean newPasswordMatchesOld;
    private OrionForgotPasswordCodesModel forgotPasswordCodeModel;
}