package com.orion.user_management.authorisation.jwt.filter;

import com.orion.logger.LoggingService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.authentication.UserIsUnauthorisedException;
import com.orion.user_management.authentication.login.OrionLoginService;
import com.orion.user_management.authorisation.CSRFConfiguration;
import com.orion.user_management.authorisation.jwt.JWTService;
import com.orion.user_management.authorisation.jwt.JWTToken;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionUserAuthority;
import com.orion.web.core.urls.URLService;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

public class JWTTokenFilter extends OncePerRequestFilter
{
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {

        if(HttpMethod.OPTIONS.matches(request.getMethod())
                        || URLService.doesURLStartWithAny(request.getRequestURI(), CSRFConfiguration.nonAPIURLs))
        {
            filterChain.doFilter(request, response);
            return;
        }
        else
        {
            String JWTToken = JWTService.getJWTTokenStringFromRequest(request);
            JWTToken tokenData = JWTService.getTokenData(JWTToken);

            if(URLService.doesURLStartWithAny(request.getRequestURI(), CSRFConfiguration.URLsThatDoNotNeedAuthentication))
            {

                try
                {
                    processJWTTokenForURLThatDoesNotNeedAuthentication(tokenData, JWTToken, request, response, filterChain);
                }
                catch(UserIsUnauthorisedException e)
                {
                    //
                }
                catch(IOException e)
                {
                    //
                }
                catch(ServletException e)
                {
                    //
                }

                filterChain.doFilter(request, response);
                return;
            }
            else
            {

                if(JWTToken != null && !JWTToken.isEmpty())
                {
                    processJWTTokenForURLThatNeedsAuthentication(tokenData, JWTToken, request, response, filterChain);
                }
                else
                {

                    if(request.getRequestURI().indexOf("/auth/") != -1 && request.getRequestURI().indexOf("/logout/") != -1)
                    {

                        try
                        {
                            OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                        }
                        catch(UserHasNoAuthorityException e)
                        {
                            //
                        }

                        filterChain.doFilter(request, response);
                        return;
                    }
                    else
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        //filterChain.doFilter(request, response);
                        return;
                    }

                }

            }

        }

        /*if(URLService.doesURLStartWithAny(request.getRequestURI(), CSRFConfiguration.URLsThatDoNotNeedCSRFToken))
        {
            
        
        }
        else
        {
            filterChain.doFilter(request, response);
            return;
        }*/
    }


    private void processJWTTokenForURLThatDoesNotNeedAuthentication(JWTToken tokenData, String JWTToken, HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException, UserIsUnauthorisedException
    {

        try
        {
            OrionLoginService.saveSessionAttributesForUser(request, tokenData);
            JWTService.addCookieToResponse(JWTToken, request, response);
        }
        catch(UserHasNoAuthorityException e)
        {
            //
        }

    }
    /*private void processJWTTokenForURLThatDoesNotNeedAuthentication(JWTToken tokenData, String JWTToken, HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException, UserIsUnauthorisedException
    {
    
        if(JWTToken == null || JWTToken.isEmpty())
        {
    
            try
            {
                JWTToken = JWTService.generateTokenAndAddCookieToResponse(OrionUserAuthority.Anonymous.get(), request, response);
                tokenData = JWTService.getTokenData(JWTToken);
    
                try
                {
                    OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                }
                catch(UserHasNoAuthorityException e)
                {
                    //
                }
    
            }
            catch(UserIsUnauthorisedException e)
            {
                //
            }
            catch(UserHasNoAuthorityException e)
            {
                //
            }
    
        }
        else if(tokenData.isExpiredToken())
        {
    
            if(OrionUserAuthority.Anonymous.get().equals(tokenData.getUserID()))
            {
    
                try
                {
                    JWTToken = JWTService.generateTokenAndAddCookieToResponse(OrionUserAuthority.Anonymous.get(), request, response);
                    tokenData = JWTService.getTokenData(JWTToken);
    
                    try
                    {
                        OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                    }
                    catch(UserHasNoAuthorityException e)
                    {
                        //
                    }
    
                }
                catch(UserIsUnauthorisedException e)
                {
                    e.printStackTrace();
                }
                catch(UserHasNoAuthorityException e)
                {
                    e.printStackTrace();
                }
    
            }
            else
            {
    
                try
                {
    
                    try
                    {
                        JWTToken = generateNewTokenForExpiredToken(tokenData, request, response);
                        tokenData = JWTService.getTokenData(JWTToken);
                        OrionLoginService.loginUser(request, tokenData);
                        setHTTPHeaderForReauthentication(tokenData.getUserID(), response);
    
                        try
                        {
                            OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                        }
                        catch(UserHasNoAuthorityException e)
                        {
                            //
                        }
    
                    }
                    catch(UserHasNoAuthorityException e)
                    {
                        //
                    }
                    catch(IOException e)
                    {
                        //
                    }
                    catch(ServletException e)
                    {
                        //
                    }
    
                }
                catch(UserIsUnauthorisedException e1)
                {
                    //
                }
    
            }
    
        }
        else if(tokenData.isHasErrors())
        {
    
            try
            {
                JWTToken = JWTService.generateTokenAndAddCookieToResponse(OrionUserAuthority.Anonymous.get(), request, response);
                tokenData = JWTService.getTokenData(JWTToken);
    
                try
                {
                    OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                }
                catch(UserHasNoAuthorityException e)
                {
                    //
                }
    
            }
            catch(UserIsUnauthorisedException e)
            {
                e.printStackTrace();
            }
            catch(UserHasNoAuthorityException e)
            {
                e.printStackTrace();
            }
    
        }
        else
        {
    
            try
            {
                OrionLoginService.saveSessionAttributesForUser(request, tokenData);
            }
            catch(UserHasNoAuthorityException e)
            {
                //
            }
    
        }
    
    }*/


    private void processJWTTokenForURLThatNeedsAuthentication(JWTToken tokenData, String JWTToken, HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException
    {

        if(tokenData.getUserID() == null
                        || tokenData.getUserID().isEmpty()
                        || OrionUserAuthority.Anonymous.get().equals(tokenData.getUserID())
                        || !tokenData.isDoesRefreshTokenExistInDatabase()
                        || !UserAccountService.isAccountEnabledAndActivated(tokenData.getUserID()))
        {
            response.sendError(HttpStatus.UNAUTHORIZED.value());
            return;
        }
        else
        {

            if(tokenData.isExpiredToken())
            {

                try
                {

                    try
                    {
                        JWTToken = generateNewTokenForExpiredToken(tokenData, request, response);
                        tokenData = JWTService.getTokenData(JWTToken);
                        OrionLoginService.loginUser(request, tokenData);
                        //setHTTPHeaderForReauthentication(tokenData.getUserID(), response);

                        try
                        {
                            OrionLoginService.saveSessionAttributesForUser(request, tokenData);
                            filterChain.doFilter(request, response);
                            return;
                        }
                        catch(UserHasNoAuthorityException e)
                        {
                            response.sendError(HttpStatus.UNAUTHORIZED.value());
                            return;
                        }

                    }
                    catch(UserHasNoAuthorityException e)
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }
                    catch(IOException e)
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }
                    catch(ServletException e)
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }

                }
                catch(UserIsUnauthorisedException e1)
                {

                    try
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }
                    catch(IOException e2)
                    {
                        LoggingService.logError(e2, "", tokenData.getUserID(), "JWT", e2.getMessage());
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }

                }

            }
            else if(tokenData.isHasErrors())
            {
                response.sendError(HttpStatus.UNAUTHORIZED.value());
                return;
            }
            else
            {

                try
                {
                    OrionLoginService.loginUser(request, tokenData);
                    //setHTTPHeaderForReauthentication(tokenData.getUserID(), response);

                    try
                    {
                        OrionLoginService.saveSessionAttributesForUser(request, tokenData);

                        if(!request.getRequestURI().endsWith("/logout"))
                        {
                            JWTService.addCookieToResponse(JWTToken, request, response);
                        }

                        filterChain.doFilter(request, response);
                        return;
                    }
                    catch(UserHasNoAuthorityException e)
                    {
                        response.sendError(HttpStatus.UNAUTHORIZED.value());
                        return;
                    }

                }
                catch(UserHasNoAuthorityException e)
                {
                    response.sendError(HttpStatus.UNAUTHORIZED.value());
                    return;
                }

            }

        }

    }
    /*private void setHTTPHeaderForReauthentication(String userID, HttpServletResponse response)
    {
        boolean needsReauthentication = UserAccountService.doesAccountNeedReauthentication(userID);
        response.setHeader(HTTPHeader.NeedsReauthentication.get(), Boolean.toString(needsReauthentication));
    }*/


    private String generateNewTokenForExpiredToken(JWTToken tokenData, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, UserIsUnauthorisedException, UserHasNoAuthorityException
    {

        if(tokenData.getRefreshToken() != null
                        && !tokenData.getRefreshToken().isEmpty()
                        && tokenData.isExpiredRefreshToken())
        {
            AuthenticationTokenService.deleteRefreshTokenByToken(tokenData.getRefreshToken());
            tokenData.setRefreshToken(null);
        }

        return OrionLoginService.loginUserUsingNewJWTToken(request, response, tokenData);
    }
}