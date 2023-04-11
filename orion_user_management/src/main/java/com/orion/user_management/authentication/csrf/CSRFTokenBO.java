package com.orion.user_management.authentication.csrf;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import org.springframework.security.web.csrf.CsrfToken;

public class CSRFTokenBO extends Orion
{
    public static CSRFResponseBean generateCSRFToken(CsrfToken token)
    {
        Assert.notNull(token, "The token input cannot be null.");
        return CSRFResponseBean.builder()
                        .csrfHeaderName(token.getHeaderName())
                        .csrfToken(token.getToken())
                        .build();
    }
}