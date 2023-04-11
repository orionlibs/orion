package com.orion.user_management.authorisation.jwt;

import com.orion.core.calendar.datetime.DateTime;
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
public class JWTToken
{
    private String token;
    private String userID;
    private DateTime tokenExpirationDateTime;
    private String refreshToken;
    private DateTime refreshTokenExpirationDateTime;
    private boolean expiredToken;
    private boolean expiredRefreshToken;
    private boolean doesRefreshTokenExistInDatabase;
    private boolean hasErrors;


    public static JWTToken of()
    {
        return JWTToken.builder().build();
    }
}