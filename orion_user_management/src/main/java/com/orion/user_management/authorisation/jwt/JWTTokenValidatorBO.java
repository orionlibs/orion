package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.AuthenticationTokenService;
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
public class JWTTokenValidatorBO extends Orion
{
    private String token;


    public static JWTTokenValidatorBO ofToken(String token)
    {
        return JWTTokenValidatorBO.builder().token(token).build();
    }


    public boolean isValid()
    {

        try
        {
            Claims claims = (Claims)Jwts.parserBuilder()
                            .requireAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                            .requireIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                            .setSigningKey(DatatypeConverter.parseBase64Binary(InMemoryConfigurationService.getProp("user.management.jwt.signing.key")))
                            .build()
                            .parse(token)
                            .getBody();
            String userID = claims.getSubject();
            String refreshToken = claims.get("orion.refresh.token", String.class);
            return AuthenticationTokenService.doesRefreshTokenExistByTokenAndUserID(refreshToken, userID)
                            && UserAccountService.isAccountEnabledAndActivated(userID);
        }
        catch(SecurityException ex)
        {
            logError("Invalid JWT signature - {}", ex.getMessage());
        }
        catch(MalformedJwtException ex)
        {
            logError("Invalid JWT token - {}", ex.getMessage());
        }
        catch(ExpiredJwtException ex)
        {
            //logError("Expired JWT token - {}", ex.getMessage());
        }
        catch(UnsupportedJwtException ex)
        {
            logError("Unsupported JWT token - {}", ex.getMessage());
        }
        catch(IllegalArgumentException ex)
        {
            logError("Signing key is required or JWT claims string is empty - {}", ex.getMessage());
        }
        catch(Exception ex)
        {
            logError("Invalid JWT - {}", ex.getMessage());
        }

        return false;
    }


    public boolean isValidAnonymousToken()
    {

        try
        {
            Claims claims = (Claims)Jwts.parserBuilder()
                            .requireAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                            .requireIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                            .setSigningKey(DatatypeConverter.parseBase64Binary(InMemoryConfigurationService.getProp("user.management.jwt.signing.key")))
                            .build()
                            .parse(token)
                            .getBody();
            return true;
        }
        catch(SecurityException ex)
        {
            logError("Invalid JWT signature - {}", ex.getMessage());
        }
        catch(MalformedJwtException ex)
        {
            logError("Invalid JWT token - {}", ex.getMessage());
        }
        catch(ExpiredJwtException ex)
        {
            //logError("Expired JWT token - {}", ex.getMessage());
        }
        catch(UnsupportedJwtException ex)
        {
            logError("Unsupported JWT token - {}", ex.getMessage());
        }
        catch(IllegalArgumentException ex)
        {
            logError("Signing key is required or JWT claims string is empty - {}", ex.getMessage());
        }
        catch(Exception ex)
        {
            logError("Invalid JWT - {}", ex.getMessage());
        }

        return false;
    }


    public boolean hasExpired()
    {

        try
        {
            Jwts.parserBuilder()
                            .requireAudience(InMemoryConfigurationService.getProp("user.management.jwt.audience"))
                            .requireIssuer(InMemoryConfigurationService.getProp("user.management.jwt.issuer"))
                            .setSigningKey(DatatypeConverter.parseBase64Binary(InMemoryConfigurationService.getProp("user.management.jwt.signing.key")))
                            .build()
                            .parse(token);
            return false;
        }
        catch(ExpiredJwtException ex)
        {
            //logError("Expired JWT token - {}", ex.getMessage());
            return true;
        }

    }
}