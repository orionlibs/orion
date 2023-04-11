package com.orion.user_management.authentication.csrf;

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
public class CSRFResponseBean extends OrionResponse
{
    private String csrfHeaderName;
    private String csrfToken;


    public static CSRFResponseBean of()
    {
        return CSRFResponseBean.builder().build();
    }
}