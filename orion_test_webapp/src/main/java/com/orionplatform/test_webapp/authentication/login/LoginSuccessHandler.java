package com.orionplatform.test_webapp.authentication.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import com.orionplatform.calendar.CalendarService;
import com.orionplatform.calendar.datetime.DateTime;
import com.orionplatform.data.data_access.OrionAuthoritiesDAO;
import com.orionplatform.data.data_access.OrionUserLoginsDAO;
import com.orionplatform.data.data_model.OrionAuthorityModel;
import com.orionplatform.data.data_model.OrionUserLoginsModel;
import com.orionplatform.test_webapp.model.UserDetailsModel;
import com.orionplatform.user_management.account.password.UsernameService;
import com.orionplatform.web.core.session.SessionService;

public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        super.onAuthenticationSuccess(request, response, authentication);
        
        try
        {
            String username = null;

            if(authentication != null)
            {
                Object userDetails = authentication.getPrincipal();

                if(userDetails instanceof UserDetails)
                {
                    username = ((UserDetails)userDetails).getUsername();
                }
                else
                {
                    username = userDetails.toString();
                }
            }
            
            String encryptedUsername = UsernameService.encryptUsername(username);
            OrionAuthorityModel authority = OrionAuthoritiesDAO.getAuthorityByEncryptedUsername(encryptedUsername);
            DateTime currentDatetime = CalendarService.getCurrentDatetime();
            OrionUserLoginsModel loginModel = new OrionUserLoginsModel();
            loginModel.setUserID(authority.getUserID());
            loginModel.setLoginDate(currentDatetime.getDate().getDateStringSplitByHyphens());
            loginModel.setLoginTime(currentDatetime.getTime().getTimeString());
            OrionUserLoginsDAO.saveUserLogin(loginModel);
            UserDetailsModel userDetails = (UserDetailsModel)SessionService.cacheUserAfterLogin(request, username, encryptedUsername, authority.getUserID(), UserDetailsModel.of());
        }
        catch(Exception e)
        {
            if(authentication != null)
            {
                authentication.setAuthenticated(false);
            }
            
            e.printStackTrace();
        }
    }
}