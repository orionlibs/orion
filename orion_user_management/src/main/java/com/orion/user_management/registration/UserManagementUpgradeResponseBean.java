package com.orion.user_management.registration;

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
public class UserManagementUpgradeResponseBean extends OrionResponse
{
    private Boolean userExists;
    private Boolean upgradeSuccessful;
    private String authorities;


    public static UserManagementUpgradeResponseBean of()
    {
        return UserManagementUpgradeResponseBean.builder().build();
    }
}