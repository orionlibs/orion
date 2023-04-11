package com.orion.user_management.authentication;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.authentication.data_access.AuthenticationRefreshTokensDAO;
import com.orion.user_management.authentication.model.AuthenticationRefreshTokenModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class AuthenticationRefreshTokenBO extends Orion
{
    private String userID;
    private String refreshToken;


    public static AuthenticationRefreshTokenBO ofRefreshToken(String refreshToken)
    {
        return AuthenticationRefreshTokenBO.builder().refreshToken(refreshToken).build();
    }


    public static AuthenticationRefreshTokenBO ofUserID(String userID)
    {
        return AuthenticationRefreshTokenBO.builder().userID(userID).build();
    }


    public boolean doesRefreshTokenExistByTokenAndUserID()
    {
        return AuthenticationRefreshTokensDAO.doesRefreshTokenExistByTokenAndUserID(refreshToken, userID);
    }


    public int save()
    {
        AuthenticationRefreshTokenModel model = AuthenticationRefreshTokenModel.builder()
                        .refreshToken(refreshToken)
                        .userID(userID)
                        .build();
        return AuthenticationRefreshTokensDAO.save(model);
    }


    public int deleteByToken()
    {
        return AuthenticationRefreshTokensDAO.deleteByToken(refreshToken);
    }


    public int deleteRefreshTokensByUserID()
    {
        return AuthenticationRefreshTokensDAO.deleteTokensByUserID(userID);
    }
}