package com.orion.user_management.authentication.login;

import com.orion.data.user.password.PasswordService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.UserIsUnauthorisedException;
import com.orion.user_management.authorisation.jwt.JWTToken;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class OrionLoginService implements AuthenticationProvider
{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        return authenticateUser(null, authentication.getName(), authentication.getCredentials().toString(), null);
    }


    public static Authentication authenticateUser(HttpServletRequest request, String username, String password, OrionAuthorityModel authority) throws AuthenticationException
    {

        try
        {

            if(authority == null)
            {
                authority = UserAccountService.getAuthorityByUsername(username);
            }

            if(authority != null)
            {
                OrionUserModel user = UserAccountService.getUserByUserID(authority.getUserID());

                if(user != null)
                {

                    if(PasswordService.doesPasswordMatchEncryptedOne(password, user.getPassword()))
                    {
                        List<GrantedAuthority> grantedAuthorities = authority.getAuthoritiesAsGrantedAuthoritiesAsList();
                        UserDetails principal = new User(username, password, grantedAuthorities);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, user.getPassword(), grantedAuthorities);
                        return authentication;
                    }
                    else
                    {
                        FailedLoginAttemptBO.of(authority).processFailedLoginAttempt();
                        return null;
                    }

                }
                else
                {
                    return null;
                }

            }
            else
            {
                return null;
            }

        }
        catch(Exception e)
        {
            return null;
        }

    }


    @Override
    public boolean supports(Class<?> authentication)
    {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


    public static String loginUserUsingNewJWTToken(HttpServletRequest request, HttpServletResponse response, JWTToken tokenData) throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        return InitialUserLoginBO.builder()
                        .request(request)
                        .tokenData(tokenData)
                        .response(response)
                        .currentJWTRefreshToken(tokenData.getRefreshToken())
                        .refreshTokenExpirationInEpochMilliseconds(0L)
                        .build()
                        .loginUserAndGenerateToken();
    }


    public static void loginUser(HttpServletRequest request, JWTToken tokenData) throws UserHasNoAuthorityException
    {
        InitialUserLoginBO.builder()
                        .request(request)
                        .tokenData(tokenData)
                        .build()
                        .loginUser();
    }


    public static void saveSessionAttributesForUser(HttpServletRequest request, JWTToken tokenData) throws UserHasNoAuthorityException
    {
        SessionAttributesForUserBO.of(request, tokenData).saveSessionAttributes();
    }
}