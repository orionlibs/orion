package com.orion.user_management.authentication.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

public class OrionLogoutHandler extends SecurityContextLogoutHandler
{
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        setClearAuthentication(true);
        setInvalidateHttpSession(true);
        super.logout(request, response, authentication);
    }
}