package com.orion.user_management.account.model;

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
public class OrionAccountReactivationValidationCodeModel implements OrionModel
{
    private String userID;
    private String emailValidationCode;
    private SQLTimestamp expirationDateTime;


    public static OrionAccountReactivationValidationCodeModel of()
    {
        return OrionAccountReactivationValidationCodeModel.builder().build();
    }


    public static OrionAccountReactivationValidationCodeModel of(String userID)
    {
        return OrionAccountReactivationValidationCodeModel.builder().userID(userID).build();
    }


    @Override
    public OrionAccountReactivationValidationCodeModel clone()
    {
        return (OrionAccountReactivationValidationCodeModel)CloningService.clone(this);
    }


    @Override
    public OrionAccountReactivationValidationCodeModel getCopy()
    {
        return this.clone();
    }
}