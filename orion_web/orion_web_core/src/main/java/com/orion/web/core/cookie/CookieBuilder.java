package com.orion.web.core.cookie;

import com.orion.core.abstraction.Orion;
import com.orion.core.exception.Assert;
import org.springframework.http.ResponseCookie;

class CookieBuilder extends Orion
{
    static ResponseCookie createCookie(String cookieName, String cookieValue, int expirationInSeconds)
    {
        Assert.notNull(cookieName, "The cookieName input cannot be null.");
        ResponseCookie cookie = ResponseCookie.from(cookieName, cookieValue)
                        .domain(CookieDefaults.domain)
                        .httpOnly(CookieDefaults.HTTPOnly)
                        .maxAge(expirationInSeconds)
                        .path(CookieDefaults.path)
                        .sameSite(CookieDefaults.sameSite)
                        .secure(CookieDefaults.secure)
                        .build();
        /*Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setDomain(CookieDefaults.domain);
        cookie.setPath(CookieDefaults.path);
        cookie.setHttpOnly(CookieDefaults.HTTPOnly);
        cookie.setSecure(CookieDefaults.secure);
        cookie.setMaxAge(expirationInSeconds);*/
        return cookie;
    }
}