package com.orion.user_management.authentication.login;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.authorisation.jwt.JWTToken;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserAuthority;
import com.orion.web.core.session.SessionAttribute;
import com.orion.web.core.session.SessionService;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.security.core.context.SecurityContextHolder;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class SessionAttributesForUserBO extends Orion
{
    private HttpServletRequest request;
    private JWTToken tokenData;
    private OrionAuthorityModel authority;


    public static SessionAttributesForUserBO of(HttpServletRequest request, JWTToken tokenData)
    {
        return SessionAttributesForUserBO.builder().request(request).tokenData(tokenData).build();
    }


    public static SessionAttributesForUserBO ofAuthority(HttpServletRequest request, JWTToken tokenData, OrionAuthorityModel authority)
    {
        return SessionAttributesForUserBO.builder().request(request).tokenData(tokenData).authority(authority).build();
    }


    public void saveSessionAttributes() throws UserHasNoAuthorityException
    {

        if(authority == null)
        {
            this.authority = UserAccountService.getAuthorityByUserID(tokenData.getUserID());
        }

        if(authority != null)
        {
            SessionService.setAttribute(request, SessionAttribute.currentUserJWTToken, tokenData.getToken());
            SessionService.setAttribute(request, SessionAttribute.currentUserJWTTokenData, tokenData);
            SessionService.setAttribute(request, SessionAttribute.currentUserID, tokenData.getUserID());
            SessionService.setAttribute(request, SessionAttribute.currentUsername, authority.getUsername());
            SessionService.setAttribute(request, SessionAttribute.currentUserAuthority, authority.getAuthority());
            SessionService.setAttribute(request, SessionAttribute.currentSelectedTheme, UserAccountService.getUserSelectedThemeByUserID(tokenData.getUserID()));
        }
        else
        {
            SecurityContextHolder.getContext().setAuthentication(null);
            SessionService.setAttribute(request, SessionAttribute.currentUserID, tokenData.getUserID());
            SessionService.setAttribute(request, SessionAttribute.currentUserAuthority, OrionUserAuthority.Anonymous.get());
        }

    }
}