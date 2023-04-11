package com.orion.user_management.authentication.logout;

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
public class LogoutResponseBean extends OrionResponse
{
    private Boolean logoutSuccessful;


    public static LogoutResponseBean of()
    {
        return LogoutResponseBean.builder().build();
    }
}