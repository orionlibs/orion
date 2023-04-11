package com.orion.user_management.forgot_password.model;

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
public class OrionForgotPasswordCodesModel implements OrionModel
{
    private String userID;
    private String forgotPasswordCode;
    private SQLTimestamp expirationDateTime;
    private Boolean passwordChangeSuccessful;


    public static OrionForgotPasswordCodesModel of()
    {
        return OrionForgotPasswordCodesModel.builder().build();
    }


    public static OrionForgotPasswordCodesModel of(String userID)
    {
        return OrionForgotPasswordCodesModel.builder().userID(userID).build();
    }


    @Override
    public OrionForgotPasswordCodesModel clone()
    {
        return (OrionForgotPasswordCodesModel)CloningService.clone(this);
    }


    @Override
    public OrionForgotPasswordCodesModel getCopy()
    {
        return this.clone();
    }
}