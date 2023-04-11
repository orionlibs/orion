package com.orion.user_management.authentication.login;

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
public class OrionLoginResponseBean extends OrionResponse
{
    private Boolean userExists;
    private Boolean loginSuccessful;
    private Boolean isFirstLoginEver;
    private Boolean pendingEmailAddressValidation;
    private Boolean pendingNewEmailAddressValidation;
    private Boolean pendingAccountEnablement;
    private Boolean isAccountActivated;
    private String authorities;
    private String username;


    public static OrionLoginResponseBean of()
    {
        return OrionLoginResponseBean.builder().build();
    }
}