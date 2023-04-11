package com.orion.user_management.authentication.model;

import com.orion.core.abstraction.OrionModel;
import com.orion.core.object.CloningService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AuthenticationRefreshTokenModel implements OrionModel
{
    private String refreshToken;
    private String userID;


    public static AuthenticationRefreshTokenModel of()
    {
        return AuthenticationRefreshTokenModel.builder().build();
    }


    public static AuthenticationRefreshTokenModel of(String refreshToken)
    {
        return AuthenticationRefreshTokenModel.builder().refreshToken(refreshToken).build();
    }


    @Override
    public AuthenticationRefreshTokenModel clone()
    {
        return (AuthenticationRefreshTokenModel)CloningService.clone(this);
    }


    @Override
    public AuthenticationRefreshTokenModel getCopy()
    {
        return this.clone();
    }
}