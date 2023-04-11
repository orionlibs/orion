package com.orion.user_management.email_validation;

import com.orion.core.abstraction.OrionResponse;
import com.orion.user_management.model.OrionUserDetailsModel;

public class OrionEmailValidationResponseBean extends OrionResponse
{
    private Boolean emailValidationEmailSuccessful;
    private Boolean expiredValidationCode;
    private OrionUserDetailsModel user;
    private String authorities;
    private String username;


    public Boolean getEmailValidationEmailSuccessful()
    {
        return this.emailValidationEmailSuccessful;
    }


    public void setEmailValidationEmailSuccessful(Boolean emailValidationEmailSuccessful)
    {
        this.emailValidationEmailSuccessful = emailValidationEmailSuccessful;
    }


    public OrionUserDetailsModel getUser()
    {
        return this.user;
    }


    public void setUser(OrionUserDetailsModel user)
    {
        this.user = user;
    }


    public Boolean getExpiredValidationCode()
    {
        return this.expiredValidationCode;
    }


    public void setExpiredValidationCode(Boolean expiredValidationCode)
    {
        this.expiredValidationCode = expiredValidationCode;
    }


    public String getAuthorities()
    {
        return this.authorities;
    }


    public void setAuthorities(String authorities)
    {
        this.authorities = authorities;
    }


    public String getUsername()
    {
        return this.username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }
}