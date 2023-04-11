package com.orion.user_management.change_email_address_email_validation.model;

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
public class ChangeEmailAddressEmailValidationCodeModel implements OrionModel
{
    private String userID;
    private String emailValidationCode;
    private SQLTimestamp expirationDateTime;


    public static ChangeEmailAddressEmailValidationCodeModel of()
    {
        return ChangeEmailAddressEmailValidationCodeModel.builder().build();
    }


    public static ChangeEmailAddressEmailValidationCodeModel of(String userID)
    {
        return ChangeEmailAddressEmailValidationCodeModel.builder().userID(userID).build();
    }


    @Override
    public ChangeEmailAddressEmailValidationCodeModel clone()
    {
        return (ChangeEmailAddressEmailValidationCodeModel)CloningService.clone(this);
    }


    @Override
    public ChangeEmailAddressEmailValidationCodeModel getCopy()
    {
        return this.clone();
    }
}