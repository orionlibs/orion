package com.orion.user_management.reset_password.reset.using_code;

import com.orion.core.exception.Assert;

class ResetPasswordUsingForgotPasswordCodePreconditions
{
    static void validate(ResetPasswordUsingForgotPasswordCodeData requestData)
    {
        Assert.notEmpty(requestData.getForgotPasswordCode(), "The given resetPasswordCode is null/empty.");
        Assert.notEmpty(requestData.getPassword(), "The given newPassword is null/empty.");
    }
}