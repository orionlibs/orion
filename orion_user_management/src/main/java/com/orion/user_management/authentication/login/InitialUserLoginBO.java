package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authentication.UserIsUnauthorisedException;
import com.orion.user_management.authentication.security.data_access.OrionUserFailedLoginAttemptsDAO;
import com.orion.user_management.authorisation.jwt.JWTService;
import com.orion.user_management.authorisation.jwt.JWTToken;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserAuthority;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class InitialUserLoginBO extends Orion
{
    private HttpServletRequest request;
    private JWTToken tokenData;
    private HttpServletResponse response;
    private String currentJWTRefreshToken;
    private long refreshTokenExpirationInEpochMilliseconds;


    public OrionAuthorityModel loginUser() throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(tokenData.getUserID());

        if(authority != null)
        {
            loginUserInSpring(authority);
            SessionAttributesForUserBO.ofAuthority(request, tokenData, authority).saveSessionAttributes();
            /*SQLTimestamp timestamp = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            OrionUserLoginModel loginModel = new OrionUserLoginModel();
            loginModel.setUserID(tokenData.getUserID());
            loginModel.setLoginDate(timestamp.toLocalDateTime().toLocalDate().toString());
            loginModel.setLoginDateTime(timestamp);
            OrionUserLoginsDAO.save(loginModel);*/
        }

        return authority;
    }


    public String loginUserAndGenerateToken() throws UserIsUnauthorisedException, UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = loginUser();

        if(authority != null)
        {
            /*SQLTimestamp timestamp = CalendarService.getCurrentDatetimeAsSQLTimestamp();
            OrionUserLoginModel loginModel = new OrionUserLoginModel();
            loginModel.setUserID(tokenData.getUserID());
            loginModel.setLoginDate(timestamp.toLocalDateTime().toLocalDate().toString());
            loginModel.setLoginDateTime(timestamp);
            OrionUserLoginsDAO.save(loginModel);*/

            if(!OrionUserAuthority.Anonymous.get().equals(tokenData.getUserID()))
            {
                UserAccountService.enableAccountByUserID(tokenData.getUserID());
                OrionUserFailedLoginAttemptsDAO.delete(tokenData.getUserID());
                //OrionUsersDAO.setUserAsLoggedInByUserID(authority.getUserID());
            }

            return JWTService.generateTokenAndAddCookieToResponse(tokenData.getUserID(), request, response, currentJWTRefreshToken, refreshTokenExpirationInEpochMilliseconds);
        }

        return null;
    }


    private void loginUserInSpring(OrionAuthorityModel authority)
    {
        List<GrantedAuthority> authorities = authority.getAuthoritiesAsGrantedAuthoritiesAsList();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(authority.getUsername(), null, authorities);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}