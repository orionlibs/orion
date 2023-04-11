package com.orion.user_management.change_email_address_email_validation;

import com.orion.core.abstraction.OrionResponse;

public class ChangeEmailAddressEmailValidationResponseBean extends OrionResponse
{
    private Boolean emailValidationEmailSuccessful;
    private Boolean expiredValidationCode;


    public Boolean getEmailValidationEmailSuccessful()
    {
        return this.emailValidationEmailSuccessful;
    }


    public void setEmailValidationEmailSuccessful(Boolean emailValidationEmailSuccessful)
    {
        this.emailValidationEmailSuccessful = emailValidationEmailSuccessful;
    }


    public Boolean getExpiredValidationCode()
    {
        return this.expiredValidationCode;
    }


    public void setExpiredValidationCode(Boolean expiredValidationCode)
    {
        this.expiredValidationCode = expiredValidationCode;
    }
}