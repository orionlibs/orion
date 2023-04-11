package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.Orion;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class OrionLoginParameters extends Orion implements AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails>
{
    @Override
    public WebAuthenticationDetails buildDetails(HttpServletRequest request)
    {
        return new OrionLoginDetails(request);
    }
}