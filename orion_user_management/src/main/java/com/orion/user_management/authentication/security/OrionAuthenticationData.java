package com.orion.user_management.authentication.security;

import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

public class OrionAuthenticationData extends WebAuthenticationDetails
{
    private static final long serialVersionUID = 7169628276208297078L;


    public OrionAuthenticationData(HttpServletRequest request)
    {
        super(request);
    }
}