package com.orion.user_management.authentication.login;

import com.orion.user_management.authentication.security.OrionLoginSuccessService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class OrionLoginSuccessHandler extends OrionLoginSuccessService implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        super.onAuthenticationSuccess(request, response, authentication);
        //setUseReferer(true);

        try
        {
            //SessionService.cacheUserAfterLogin(request, authentication, OrionUserDetailsModel.of());
        }
        catch(Exception e)
        {
            authentication.setAuthenticated(false);
        }

    }
}