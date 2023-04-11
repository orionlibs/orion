package com.orion.user_management.registration;

import com.orion.core.abstraction.OrionResponse;

public class OrionRegistrationResponseBean extends OrionResponse
{
    private Boolean userExists;
    private Boolean allowUserToRegister;
    private Boolean emailValidationEmailSuccessful;


    public Boolean getUserExists()
    {
        return this.userExists;
    }


    public void setUserExists(Boolean userExists)
    {
        this.userExists = userExists;
    }


    public Boolean getAllowUserToRegister()
    {
        return this.allowUserToRegister;
    }


    public void setAllowUserToRegister(Boolean allowUserToRegister)
    {
        this.allowUserToRegister = allowUserToRegister;
    }


    public Boolean getEmailValidationEmailSuccessful()
    {
        return this.emailValidationEmailSuccessful;
    }


    public void setEmailValidationEmailSuccessful(Boolean emailValidationEmailSuccessful)
    {
        this.emailValidationEmailSuccessful = emailValidationEmailSuccessful;
    }
}