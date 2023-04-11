package com.orion.web.core.services;

import com.orion.core.abstraction.OrionService;
import com.orion.logger.LoggingService;
import com.orion.web.core.session.OrionUserAuthority;
import com.orion.web.core.session.SessionAttribute;
import com.orion.web.core.session.SessionService;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;

public class OrionWebService extends OrionService
{
    protected Object getUserAuthority(HttpServletRequest request)
    {
        Object authority = SessionService.getAttribute(request, SessionAttribute.currentUserAuthority);
        return authority instanceof String ? (String)authority : getSessionUserAuthority(request);
    }


    protected String getUserAuthorityAsString(HttpServletRequest request)
    {
        Object authority = getUserAuthority(request);
        return authority instanceof String ? (String)authority : "";
        /*else if(authority instanceof OrionAuthorityModel)
        {
            return ((OrionAuthorityModel)authority).getAuthority();
        }*/
    }


    protected Object getSessionUserAuthority(HttpServletRequest request)
    {
        Object authority = SessionService.getSessionAttribute(request, SessionAttribute.currentUserAuthority);
        return authority instanceof String ? (String)authority : "";
        /*else
        {
            return (OrionAuthorityModel)authority;
        }*/
    }


    protected boolean doesUserHaveAuthority(HttpServletRequest request, String authorityToCheck)
    {
        String authority = getUserAuthorityAsString(request);

        if(authority != null && !authority.isEmpty())
        {
            return Arrays.stream(authority.split(","))
                            .anyMatch(auth -> auth.equals(authorityToCheck));
        }

        return false;
    }


    protected String getUsername(HttpServletRequest request)
    {
        String username = SessionService.getUsername(request);
        return (username != null) ? username : getSessionUsername(request);
    }


    protected String getSessionUsername(HttpServletRequest request)
    {
        return SessionService.getSessionUsername(request);
    }


    protected String getSelectedTheme(HttpServletRequest request)
    {
        String selectedTheme = SessionService.getSelectedTheme(request);
        return (selectedTheme != null) ? selectedTheme : getSessionSelectedTheme(request);
    }


    protected String getSessionSelectedTheme(HttpServletRequest request)
    {
        return SessionService.getSessionSelectedTheme(request);
    }


    protected String getJWT(HttpServletRequest request)
    {
        String JWTToken = SessionService.getJWT(request);
        return (JWTToken != null) ? JWTToken : getSessionJWT(request);
    }


    protected boolean isAnonymousUser(HttpServletRequest request)
    {
        String userID = getUserID(request);

        if(userID == null || userID.isEmpty())
        {
            return true;
        }
        else
        {
            return OrionUserAuthority.Anonymous.get().equalsIgnoreCase(userID) ? true : false;
        }

    }


    protected boolean isNotAnonymousUser(HttpServletRequest request)
    {
        return !isAnonymousUser(request);
    }


    protected String getUserID(HttpServletRequest request)
    {
        String userID = SessionService.getUserID(request);
        return (userID != null) ? userID : getSessionUserID(request);
    }


    protected String getSessionUserID(HttpServletRequest request)
    {
        return SessionService.getSessionUserID(request);
    }


    protected String getSessionJWT(HttpServletRequest request)
    {
        return SessionService.getSessionJWT(request);
    }


    protected boolean isUserLoggedIn(HttpServletRequest request)
    {
        String username = getUsername(request);

        if(username == null)
        {
            username = getSessionUsername(request);
        }

        return username != null && !username.isEmpty();
    }


    protected CsrfToken getCSRFToken(HttpServletRequest request)
    {
        return SessionService.getCSRFToken(request);
    }


    protected void logAction(String actionType, String actionDescription, HttpServletRequest request)
    {
        LoggingService.logAction(getUserID(request), actionType, actionDescription, request);
    }


    protected void logAction(String actionType, String actionDescription)
    {
        LoggingService.logAction(actionType, actionDescription);
    }


    protected void logError(String errorType, String errorMessage, Throwable exception, HttpServletRequest request, Object... parameters)
    {
        LoggingService.logError(exception, request.getRemoteAddr(), getUserID(request), errorType, errorMessage, parameters);
    }


    protected void logError(String errorType, String errorMessage, HttpServletRequest request, Object... parameters)
    {
        LoggingService.logError(request.getRemoteAddr(), getUserID(request), errorType, errorMessage, null, parameters);
    }


    protected void logError(String errorType, String errorMessage, Throwable exception, Object... parameters)
    {
        LoggingService.logError(exception, null, null, errorType, errorMessage, parameters);
    }


    protected void logError(String errorType, String errorMessage, Object... parameters)
    {
        LoggingService.logError(null, null, errorType, errorMessage, null, parameters);
    }
}