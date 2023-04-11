package com.orion.user_management.authentication.csrf;

import com.orion.core.abstraction.OrionService;
import org.springframework.security.web.csrf.CsrfToken;

public class UserManagementCSRFService extends OrionService
{
    public static CSRFResponseBean generateCSRFToken(CsrfToken token)
    {
        return CSRFTokenBO.generateCSRFToken(token);
    }
}