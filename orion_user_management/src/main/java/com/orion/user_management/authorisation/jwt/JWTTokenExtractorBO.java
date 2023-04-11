package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.Orion;
import com.orion.web.core.app.header.HTTPHeader;
import com.orion.web.core.app.header.HTTPHeaderValue;
import com.orion.web.core.cookie.CookieName;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class JWTTokenExtractorBO extends Orion
{
    private HttpServletRequest request;


    public static JWTTokenExtractorBO ofRequest(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.builder().request(request).build();
    }


    public ResponseCookie getJWTCookie()
    {

        if(request.getCookies() != null && request.getCookies().length > 0)
        {

            for(Cookie cookie : request.getCookies())
            {

                if(Orion.isDev())
                {

                    if(CookieName.JWTAccessTokenDev.get().equals(cookie.getName()))
                    {
                        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), cookie.getValue())
                                        .domain(cookie.getDomain())
                                        .httpOnly(cookie.isHttpOnly())
                                        .maxAge(cookie.getMaxAge())
                                        .path(cookie.getPath())
                                        .sameSite("None")
                                        .secure(cookie.getSecure())
                                        .build();
                        return cookie1;
                    }

                }
                else
                {

                    if(CookieName.JWTAccessToken.get().equals(cookie.getName()))
                    {
                        ResponseCookie cookie1 = ResponseCookie.from(cookie.getName(), cookie.getValue())
                                        .domain(cookie.getDomain())
                                        .httpOnly(cookie.isHttpOnly())
                                        .maxAge(cookie.getMaxAge())
                                        .path(cookie.getPath())
                                        .sameSite("None")
                                        .secure(cookie.getSecure())
                                        .build();
                        return cookie1;
                    }

                }

            }

        }

        return null;
    }


    public String getJWTCookieValue()
    {
        ResponseCookie JWTCookie = getJWTCookie();
        return (JWTCookie != null) ? JWTCookie.getValue() : null;
    }


    public String getJWTTokenStringFromHTTPHeader()
    {
        String headerValue = request.getHeader(HttpHeaders.AUTHORIZATION);

        if(headerValue != null && !headerValue.isEmpty() && headerValue.startsWith(HTTPHeaderValue.Bearer.get()))
        {
            return headerValue.split("\\s+")[1].trim();
        }
        else
        {
            headerValue = request.getHeader(HTTPHeader.XAPIKey.get());

            if(headerValue != null && !headerValue.isEmpty())
            {
                return headerValue;
            }
            else
            {
                headerValue = request.getHeader(HTTPHeader.XAPIKey.get().toLowerCase());

                if(headerValue != null && !headerValue.isEmpty())
                {
                    return headerValue;
                }
                else
                {
                    return null;
                }

            }

        }

    }


    public String getJWTTokenString()
    {
        String token = getJWTCookieValue();
        return (token != null && !token.isEmpty()) ? token : getJWTTokenStringFromHTTPHeader();
    }


    public String getJWTTokenStringFromRequest()
    {
        String JWTToken = getJWTTokenString();
        return (JWTToken != null) ? JWTToken : null;
    }
}