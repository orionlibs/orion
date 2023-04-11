package com.orion.user_management.email_validation;

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
public class UserManagementEmailValidationResponseBean extends OrionResponse
{
    private Boolean validValidationCode;
    private Boolean expiredValidationCode;
    private Boolean accountIsAlreadyValidated;
    private Boolean loginSuccessful;
    private String authorities;
    private String username;


    public static UserManagementEmailValidationResponseBean of()
    {
        return UserManagementEmailValidationResponseBean.builder().build();
    }
}