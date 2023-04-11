package com.orion.user_management.contact_information;

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
public class UserManagementContactInformationResponseBean extends OrionResponse
{
    private String firstName;
    private String lastName;
    private String username;
    private String mobileNumber;


    public static UserManagementContactInformationResponseBean of()
    {
        return UserManagementContactInformationResponseBean.builder().build();
    }
}