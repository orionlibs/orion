package com.orion.user_management.authentication;

import com.orion.core.abstraction.OrionService;

public class AuthenticationTokenService extends OrionService
{
    public static boolean doesRefreshTokenExistByTokenAndUserID(String refreshToken, String userID)
    {
        return AuthenticationRefreshTokenBO.builder()
                        .refreshToken(refreshToken)
                        .userID(userID)
                        .build()
                        .doesRefreshTokenExistByTokenAndUserID();
    }


    public static int saveRefreshToken(String refreshToken, String userID)
    {
        return AuthenticationRefreshTokenBO.builder()
                        .refreshToken(refreshToken)
                        .userID(userID)
                        .build()
                        .save();
    }


    public static int deleteRefreshTokenByToken(String refreshToken)
    {
        return AuthenticationRefreshTokenBO.ofRefreshToken(refreshToken).deleteByToken();
    }


    public static int deleteRefreshTokensByUserID(String userID)
    {
        return AuthenticationRefreshTokenBO.ofUserID(userID).deleteRefreshTokensByUserID();
    }
}