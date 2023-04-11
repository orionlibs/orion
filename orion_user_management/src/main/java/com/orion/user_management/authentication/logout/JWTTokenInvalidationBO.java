package com.orion.user_management.authentication.logout;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.authorisation.jwt.JWTService;
import com.orion.user_management.authorisation.jwt.JWTToken;
import com.orion.web.core.cookie.CookieService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class JWTTokenInvalidationBO extends Orion
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private boolean logoutFromAllDevices;
    private String userID;


    public static JWTTokenInvalidationBO of(HttpServletRequest request, HttpServletResponse response, boolean logoutFromAllDevices)
    {
        return JWTTokenInvalidationBO.builder()
                        .request(request)
                        .response(response)
                        .logoutFromAllDevices(logoutFromAllDevices)
                        .build();
    }


    public void invalidateJWTToken()
    {
        ResponseCookie JWTCookie = JWTService.getJWTCookie(request);
        JWTToken JWTTokenData = null;
        String JWTToken = null;

        if(JWTCookie != null)
        {
            JWTToken = JWTCookie.getValue();
        }
        else
        {
            JWTToken = JWTService.getJWTTokenStringFromHTTPHeader(request);
        }

        JWTTokenData = JWTService.getTokenData(JWTToken);
        userID = JWTTokenData.getUserID();

        if(logoutFromAllDevices)
        {
            AuthenticationTokenService.deleteRefreshTokensByUserID(userID);
        }
        else
        {
            AuthenticationTokenService.deleteRefreshTokenByToken(JWTTokenData.getRefreshToken());
        }

        //JWTToken = JWTService.generateAnonymousAccessToken();
        //int expirationInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.cookie.expiration.in.seconds");
        JWTCookie = CookieService.updateCookieValue(JWTCookie, null, 0);
        response.addHeader(HttpHeaders.SET_COOKIE, JWTCookie.toString());
    }
}