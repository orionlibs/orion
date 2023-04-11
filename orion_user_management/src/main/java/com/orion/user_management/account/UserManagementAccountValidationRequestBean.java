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
public class UserManagementAccountValidationRequestBean extends OrionRequest implements Validator
{
    @NotBlank
    private String username;


    public static UserManagementAccountValidationRequestBean of()
    {
        return UserManagementAccountValidationRequestBean.builder().build();
    }
}