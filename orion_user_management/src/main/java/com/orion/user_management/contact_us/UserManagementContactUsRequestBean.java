package com.orion.user_management.contact_us;

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
public class UserManagementContactUsRequestBean extends OrionRequest implements Validator
{
    @NotBlank
    private String fullName;
    @NotBlank
    private String emailAddress;
    private String phoneNumber;
    @NotBlank
    private String message;


    public static UserManagementContactUsRequestBean of()
    {
        return UserManagementContactUsRequestBean.builder().build();
    }
}