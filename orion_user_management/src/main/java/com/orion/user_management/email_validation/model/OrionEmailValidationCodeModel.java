package com.orion.user_management.email_validation.model;

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
public class OrionEmailValidationCodeModel implements OrionModel
{
    private String userID;
    private String emailValidationCode;
    private SQLTimestamp expirationDateTime;


    public static OrionEmailValidationCodeModel of()
    {
        return OrionEmailValidationCodeModel.builder().build();
    }


    public static OrionEmailValidationCodeModel of(String userID)
    {
        return OrionEmailValidationCodeModel.builder().userID(userID).build();
    }


    @Override
    public OrionEmailValidationCodeModel clone()
    {
        return (OrionEmailValidationCodeModel)CloningService.clone(this);
    }


    @Override
    public OrionEmailValidationCodeModel getCopy()
    {
        return this.clone();
    }
}