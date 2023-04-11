package com.orion.user_management.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.object.CloningService;
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
public class OrionUserModel implements OrionModel
{
    private String userID;
    private String password;
    private Boolean mustChangePassword;
    private Boolean needsReauthentication;
    private Boolean pendingEmailAddressValidation;
    private Boolean enabled;
    private Boolean acceptedTermsAndConditionsAndPrivacyNotice;
    private Boolean loggedIn;
    private SQLTimestamp lastLogInDateTime;
    private String registrationDate;
    private SQLTimestamp registrationDateTime;
    private SQLTimestamp lastAccountUpdateDateTime;
    private int numberOfAccountLockdowns;
    private String timezone;


    public static OrionUserModel of()
    {
        return OrionUserModel.builder().build();
    }


    public static OrionUserModel of(String userID)
    {
        return OrionUserModel.builder().userID(userID).build();
    }


    public String getLastLogInDateTimeAsString()
    {

        if(getLastLogInDateTime() != null)
        {
            return getLastLogInDateTime().printInInternationalFormat();
        }
        else
        {
            return "";
        }

    }


    public String getRegistrationDateTimeAsString()
    {

        if(getRegistrationDateTime() != null)
        {
            return getRegistrationDateTime().printInInternationalFormat();
        }
        else
        {
            return "";
        }

    }


    @Override
    public OrionUserModel clone()
    {
        return (OrionUserModel)CloningService.clone(this);
    }


    @Override
    public OrionUserModel getCopy()
    {
        return this.clone();
    }
}