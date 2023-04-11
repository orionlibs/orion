package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.authentication.UserIsUnauthorisedException;
import com.orion.user_management.data_access.OrionAuthoritiesDAO;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserAuthority;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class JWTTokenGeneratorBO extends Orion
{
    private String userID;
    private String currentJWTRefreshToken;
    private long refreshTokenExpirationInEpochMilliseconds;
    private Key signingKey;


    public static JWTTokenGeneratorBO ofRegisteredUser(String userID, String currentJWTRefreshToken, long refreshTokenExpirationInEpochMilliseconds, Key signingKey)
    {
        return JWTTokenGeneratorBO.builder()
                        .userID(userID)
                        .currentJWTRefreshToken(currentJWTRefreshToken)
                        .refreshTokenExpirationInEpochMilliseconds(refreshTokenExpirationInEpochMilliseconds)
                        .signingKey(signingKey)
                        .build();
    }


    public static JWTTokenGeneratorBO ofAnonymousUser(Key signingKey)
    {
        return JWTTokenGeneratorBO.builder().signingKey(signingKey).build();
    }


    public String generateForRegisteredUser() throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        String refreshTokenToUse = "";

        if(currentJWTRefreshToken != null && !currentJWTRefreshToken.isEmpty())
        {
            boolean doesRefreshTokenExist = AuthenticationTokenService.doesRefreshTokenExistByTokenAndUserID(currentJWTRefreshToken, userID);

            if(doesRefreshTokenExist)
            {
                refreshTokenToUse = currentJWTRefreshToken;
            }
            else
            {
                throw new UserIsUnauthorisedException();
            }

        }

        int expirationInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.expiration.in.seconds");
        DateTime tokenExpirationDatetime = CalendarService.addSecondsToCurrentDatetime(expirationInSeconds);
        JWTTokenExpiration tokenExpiration = JWTTokenExpiration.builder()
                        .tokenExpirationDatetime(tokenExpirationDatetime)
                        .build();
        Map<String, Object> claims = new HashMap<>();

        if(refreshTokenToUse.isEmpty())
        {
            refreshTokenToUse = UUIDSecurityService.generate3UUIDsWithoutHyphens();
            int expirationOfRefreshTokenInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.refresh.token.expiration.in.seconds");
            DateTime refreshTokenExpirationDatetime = CalendarService.addSecondsToCurrentDatetime(expirationOfRefreshTokenInSeconds);
            refreshTokenExpirationInEpochMilliseconds = refreshTokenExpirationDatetime.toInstant().toEpochMilli();
            AuthenticationTokenService.saveRefreshToken(refreshTokenToUse, userID);
        }

        OrionAuthorityModel authority = OrionAuthoritiesDAO.getByUserID(userID);
        claims.put("user.authorities", authority.getAuthority());
        claims.put("orion.refresh.token", refreshTokenToUse);
        claims.put("orion.refresh.token.expiration.timestamp.in.epoch.milliseconds", Long.toString(refreshTokenExpirationInEpochMilliseconds));
        return Jwts.builder()
                        .setSubject(userID)
                        .addClaims(claims)
                        .setAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                        .setIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                        .setIssuedAt(new Date())
                        .setExpiration(tokenExpiration.getExpirationDate())
                        .signWith(signingKey, SignatureAlgorithm.HS512)
                        .compact();
    }


    public String generateForAnonymousUser()
    {
        int expirationInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.expiration.in.seconds");
        DateTime tokenExpirationDatetime = CalendarService.addSecondsToCurrentDatetime(expirationInSeconds);
        JWTTokenExpiration tokenExpiration = JWTTokenExpiration.builder()
                        .tokenExpirationDatetime(tokenExpirationDatetime)
                        .build();
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                        .setSubject(OrionUserAuthority.Anonymous.get())
                        .addClaims(claims)
                        .setAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                        .setIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                        .setIssuedAt(new Date())
                        .setExpiration(tokenExpiration.getExpirationDate())
                        .signWith(signingKey, SignatureAlgorithm.HS512)
                        .compact();
    }
}