package com.orion.user_management.registration;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class UserManagementRegistrationResponseBean extends OrionResponse
{
    private Boolean userExists;
    private Boolean registrationSuccessful;
    private String userID;
    private String username;
    private Boolean isAddressValid;
    private Boolean isNextOfKinValid;
    private Boolean isIdentificationDocumentValid;
    private Boolean isBankDetailsValid;


    public static UserManagementRegistrationResponseBean of()
    {
        return UserManagementRegistrationResponseBean.builder().build();
    }


    @JsonIgnore
    public String getUsername()
    {
        return this.username;
    }
}