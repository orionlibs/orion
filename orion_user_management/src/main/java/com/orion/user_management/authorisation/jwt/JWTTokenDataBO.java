package com.orion.user_management.authorisation.jwt;

import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.datetime.DateTime;
import com.orion.core.calendar.time.Time;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.user_management.authentication.AuthenticationTokenService;
import com.orion.user_management.model.OrionUserAuthority;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import javax.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class JWTTokenDataBO
{
    private String token;


    public static JWTTokenDataBO ofToken(String token)
    {
        return JWTTokenDataBO.builder().token(token).build();
    }


    public JWTToken getJWTTokenData()
    {
        JWTToken JWTToken = new JWTToken();
        JWTToken.setToken(token);
        JWTToken.setUserID(OrionUserAuthority.Anonymous.get());

        try
        {
            Claims claims = (Claims)Jwts.parserBuilder()
                            .requireAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                            .requireIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                            .setSigningKey(DatatypeConverter.parseBase64Binary(InMemoryConfigurationService.getProp("user.management.jwt.signing.key")))
                            .build()
                            .parse(token)
                            .getBody();
            getDataFromToken(JWTToken, claims);
        }
        catch(SecurityException ex)
        {
            JWTToken.setHasErrors(true);
        }
        catch(MalformedJwtException ex)
        {
            JWTToken.setHasErrors(true);
        }
        catch(ExpiredJwtException ex)
        {
            JWTToken.setHasErrors(true);
            JWTToken.setExpiredToken(true);
            getDataFromToken(JWTToken, ex.getClaims());
        }
        catch(UnsupportedJwtException ex)
        {
            JWTToken.setHasErrors(true);
        }
        catch(IllegalArgumentException ex)
        {
            JWTToken.setHasErrors(true);
        }

        return JWTToken;
    }


    @SuppressWarnings("deprecation")
    private void getDataFromToken(JWTToken JWTToken, Claims claims)
    {
        String subject = claims.getSubject();
        String userID = subject;
        JWTToken.setUserID(userID);
        String refreshToken = claims.get("orion.refresh.token", String.class);
        JWTToken.setDoesRefreshTokenExistInDatabase(AuthenticationTokenService.doesRefreshTokenExistByTokenAndUserID(refreshToken, userID));
        com.orion.core.calendar.date.Date expirationDate = com.orion.core.calendar.date.Date.of(claims.getExpiration().getYear() + 1900,
                        claims.getExpiration().getMonth() + 1,
                        claims.getExpiration().getDate());
        Time expirationTime = Time.of(claims.getExpiration().getHours(),
                        claims.getExpiration().getMinutes(),
                        claims.getExpiration().getSeconds());
        String refreshTokenExpirationInEpochMillisecondsString = claims.get("orion.refresh.token.expiration.timestamp.in.epoch.milliseconds", String.class);
        long refreshTokenExpirationInEpochMilliseconds = -1L;

        if(refreshTokenExpirationInEpochMillisecondsString != null)
        {
            refreshTokenExpirationInEpochMilliseconds = Long.parseLong(refreshTokenExpirationInEpochMillisecondsString);
        }

        JWTToken.setTokenExpirationDateTime(DateTime.of(expirationDate, expirationTime));
        JWTToken.setRefreshToken(refreshToken);
        JWTToken.setRefreshTokenExpirationDateTime(CalendarService.convertEpochMillisecondsToDateTime(refreshTokenExpirationInEpochMilliseconds));
        JWTToken.setExpiredRefreshToken(CalendarService.hasExpired(JWTToken.getRefreshTokenExpirationDateTime()));
    }
}