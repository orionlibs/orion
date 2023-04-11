package com.orion.user_management.account;

import com.orion.core.abstraction.OrionRequest;
import com.orion.core.data.validation.Validator;
import com.orion.core.data.validation.annotation.NotBlank;
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
public class UserManagementAccountProfileRequestBean extends OrionRequest implements Validator
{
    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    private String emailAddress;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String password;
    private String businessName;
    private String invoiceEmailAddress;
    private Integer businessTypeID;


    public static UserManagementAccountProfileRequestBean of()
    {
        return UserManagementAccountProfileRequestBean.builder().build();
    }
}