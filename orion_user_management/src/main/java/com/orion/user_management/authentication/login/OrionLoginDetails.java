package com.orion.user_management.authentication.login;

import com.orion.user_management.authentication.security.OrionAuthenticationData;
import javax.servlet.http.HttpServletRequest;

public class OrionLoginDetails extends OrionAuthenticationData
{
    private static final long serialVersionUID = -5759764175836728685L;
    private String username;


    public OrionLoginDetails(HttpServletRequest request)
    {
        super(request);
        this.username = request.getParameter("input_username");
    }


    public String getUsername()
    {
        return this.username;
    }
}