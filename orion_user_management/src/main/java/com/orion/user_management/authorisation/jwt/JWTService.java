package com.orion.user_management.authorisation.jwt;

import com.orion.core.abstraction.Orion;
import com.orion.core.configuration.InMemoryConfigurationService;
import com.orion.user_management.authentication.UserIsUnauthorisedException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionUserAuthority;
import com.orion.web.core.cookie.CookieName;
import com.orion.web.core.cookie.CookieService;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

public class JWTService extends Orion
{
    public static boolean doesJWTTokenExist(HttpServletRequest request)
    {
        return (getJWTTokenString(request) != null) ? true : false;
    }


    public static boolean doesValidJWTTokenExist(HttpServletRequest request)
    {
        String JWTToken = getJWTTokenString(request);
        boolean foundJWT = (JWTToken != null) ? true : false;
        return foundJWT && isValid(JWTToken);
    }


    public static boolean doesValidJWTTokenExistForAuthenticatedUser(HttpServletRequest request)
    {
        String JWTToken = getJWTTokenString(request);
        boolean foundJWT = (JWTToken != null) ? true : false;
        JWTToken tokenData = getTokenData(JWTToken);
        return foundJWT
                        && !OrionUserAuthority.Anonymous.get().equals(tokenData.getUserID())
                        && isValid(JWTToken);
    }


    public static boolean doesValidJWTTokenExistForAnonymousUser(HttpServletRequest request)
    {
        String JWTToken = getJWTTokenString(request);
        boolean foundJWT = (JWTToken != null) ? true : false;
        JWTToken tokenData = getTokenData(JWTToken);
        return foundJWT
                        && isValid(JWTToken)
                        && OrionUserAuthority.Anonymous.get().equals(tokenData.getUserID());
    }


    public static String getJWTTokenStringFromRequest(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.ofRequest(request).getJWTTokenStringFromRequest();
    }


    public static String getJWTTokenString(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.ofRequest(request).getJWTTokenString();
    }


    public static ResponseCookie getJWTCookie(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.ofRequest(request).getJWTCookie();
    }


    public static String getJWTCookieValue(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.ofRequest(request).getJWTCookieValue();
    }


    public static String getJWTTokenStringFromHTTPHeader(HttpServletRequest request)
    {
        return JWTTokenExtractorBO.ofRequest(request).getJWTTokenStringFromHTTPHeader();
    }


    public static Key convertSigningKeyToSecretKeyObject(String signingKey)
    {
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(signingKey);
        return new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS512.getJcaName());
    }


    public static String generateAccessTokenForRegisteredUser(String userID, String currentJWTRefreshToken, long refreshTokenExpirationInEpochMilliseconds) throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        return JWTTokenGeneratorBO.ofRegisteredUser(userID, currentJWTRefreshToken, refreshTokenExpirationInEpochMilliseconds, convertSigningKeyToSecretKeyObject(InMemoryConfigurationService.getProp("user.management.jwt.signing.key"))).generateForRegisteredUser();
    }


    public static String generateAccessTokenForRegisteredUser(String userID) throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        return generateAccessTokenForRegisteredUser(userID, null, 0L);
    }


    public static String generateAnonymousAccessToken()
    {
        return JWTTokenGeneratorBO.ofAnonymousUser(convertSigningKeyToSecretKeyObject(InMemoryConfigurationService.getProp("user.management.jwt.signing.key"))).generateForAnonymousUser();
    }


    public static JWTToken getTokenData(String token)
    {
        return JWTTokenDataBO.ofToken(token).getJWTTokenData();
    }


    public static boolean isValid(String token)
    {
        return JWTTokenValidatorBO.ofToken(token).isValid();
    }


    public static boolean isValidAnonymousToken(String token)
    {
        return JWTTokenValidatorBO.ofToken(token).isValidAnonymousToken();
    }


    public static boolean isInvalid(String token)
    {
        return !isValid(token);
    }


    public static boolean isInvalidAnonymousToken(String token)
    {
        return !isValidAnonymousToken(token);
    }


    public static boolean isExpired(String token)
    {
        return JWTTokenValidatorBO.ofToken(token).hasExpired();
    }


    public static String generateTokenAndAddCookieToResponse(String userID, HttpServletRequest request, HttpServletResponse response) throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        return generateTokenAndAddCookieToResponse(userID, request, response, null, 0L);
    }


    public static String generateTokenAndAddCookieToResponse(String userID, HttpServletRequest request, HttpServletResponse response, String currentJWTRefreshToken, long refreshTokenExpirationInEpochMilliseconds) throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        String JWTToken = "";

        if(OrionUserAuthority.Anonymous.get().equals(userID))
        {
            JWTToken = generateAnonymousAccessToken();
        }
        else
        {
            JWTToken = generateAccessTokenForRegisteredUser(userID, currentJWTRefreshToken, refreshTokenExpirationInEpochMilliseconds);
        }

        addCookieToResponse(JWTToken, request, response);
        return JWTToken;
    }


    public static void addCookieToResponse(String JWTToken, HttpServletRequest request, HttpServletResponse response)
    {
        int expirationInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.cookie.expiration.in.seconds");

        if(Orion.isDev())
        {
            response.addHeader(HttpHeaders.SET_COOKIE, CookieService.createCookie(CookieName.JWTAccessTokenDev.get(), JWTToken, expirationInSeconds).toString());
        }
        else
        {
            response.addHeader(HttpHeaders.SET_COOKIE, CookieService.createCookie(CookieName.JWTAccessToken.get(), JWTToken, expirationInSeconds).toString());
        }

        /*Cookie JWTCookie = getJWTCookie(request);
        int expirationInSeconds = InMemoryConfigurationService.getIntegerProp("user.management.jwt.cookie.expiration.in.seconds");
        
        if(JWTCookie != null)
        {
            CookieService.updateCookieValue(JWTCookie, JWTToken, expirationInSeconds);
        }
        else
        {
            JWTCookie = CookieService.createCookie(CookieName.JWTAccessToken.get(), JWTToken, expirationInSeconds);
        }
        
        response.addCookie(JWTCookie);*/
    }
}