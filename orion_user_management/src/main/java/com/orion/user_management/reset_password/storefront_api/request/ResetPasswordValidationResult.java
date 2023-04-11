package com.orion.user_management.reset_password.storefront_api.request;

import com.orion.core.abstraction.OrionResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class ResetPasswordValidationResult extends OrionResponse
{
    private Boolean validResetPasswordCode;
    private Boolean expiredResetPasswordCode;
    private Boolean passwordHasBeenResetSuccessfully;
    private Boolean newPasswordMatchesOld;
    private String userID;


    public static ResetPasswordValidationResult of()
    {
        return ResetPasswordValidationResult.builder().build();
    }
}