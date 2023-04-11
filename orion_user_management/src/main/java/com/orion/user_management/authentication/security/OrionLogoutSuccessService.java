package com.orion.user_management.authentication.security;

import com.orion.user_management.authentication.logout.OrionLogoutService;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

public class OrionLogoutSuccessService extends SimpleUrlLogoutSuccessHandler
{
    public OrionLogoutSuccessService(String defaultTargetURL)
    {
        this.setDefaultTargetUrl(defaultTargetURL);
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {

        try
        {
            OrionLogoutService.logoutUser(request, response, false);
            super.onLogoutSuccess(request, response, authentication);
        }
        catch(UserHasNoAuthorityException e)
        {
            //
        }
        catch(IOException e)
        {
            //
        }

    }


    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response)
    {
        return getDefaultTargetUrl();
    }


    @Override
    protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
    {
        return determineTargetUrl(request, response);
    }
}