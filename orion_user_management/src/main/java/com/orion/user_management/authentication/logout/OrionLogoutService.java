package com.orion.user_management.authentication.logout;

import com.orion.core.abstraction.OrionService;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OrionLogoutService extends OrionService
{
    public static boolean logoutUser(HttpServletRequest request, HttpServletResponse response, boolean isSystemTheLogoutCause) throws IOException, UserHasNoAuthorityException
    {
        JWTTokenInvalidationBO tokenInvalidation = JWTTokenInvalidationBO.of(request, response, false);
        tokenInvalidation.invalidateJWTToken();
        return LogoutBO.builder()
                        .request(request)
                        .response(response)
                        .userID(tokenInvalidation.getUserID())
                        .isSystemTheLogoutCause(isSystemTheLogoutCause)
                        .build()
                        .logoutUser();
    }


    public static boolean logoutUserFromAllDevices(HttpServletRequest request, HttpServletResponse response, boolean isSystemTheLogoutCause) throws IOException, UserHasNoAuthorityException
    {
        JWTTokenInvalidationBO tokenInvalidation = JWTTokenInvalidationBO.of(request, response, true);
        tokenInvalidation.invalidateJWTToken();
        return LogoutBO.builder()
                        .request(request)
                        .response(response)
                        .userID(tokenInvalidation.getUserID())
                        .isSystemTheLogoutCause(isSystemTheLogoutCause)
                        .build()
                        .logoutUser();
    }
}