package com.orion.user_management.authentication.logout;

import com.orion.core.abstraction.Orion;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class LogoutBO extends Orion
{
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String userID;
    private boolean isSystemTheLogoutCause;


    public boolean logoutUser() throws IOException, UserHasNoAuthorityException
    {
        response.addHeader("Clear-Site-Data", "*");

        if(request != null && request.getSession(false) != null)
        {
            request.getSession(false).invalidate();
        }

        return true;
        //OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);
        //if(authority != null)
        //{
        /*SQLTimestamp timestamp = CalendarService.getCurrentDatetimeAsSQLTimestamp();
        OrionUserLogoutsModel logoutModel = new OrionUserLogoutsModel();
        logoutModel.setUserID(authority.getUserID());
        logoutModel.setLogoutDate(timestamp.toLocalDateTime().toLocalDate().toString());
        logoutModel.setLogoutDateTime(timestamp);
        
        if(isSystemTheLogoutCause)
        {
            logoutModel.setLogoutCauseID(LogoutCausesMapper.getLogoutCauseIDFromName(LogoutCause.System.get()));
        }
        else
        {
            logoutModel.setLogoutCauseID(LogoutCausesMapper.getLogoutCauseIDFromName(LogoutCause.User.get()));
        }
        
        int numberOfRowsAffected = OrionUserLogoutsDAO.save(logoutModel);*/
        /*if(numberOfRowsAffected == 0)
        {
            throw new IOException(String.format("Could not save logout record for userID '{}'", authority.getUserID()));
        }
        else
        {*/
        //if(request != null && request.getSession(false) != null)
        //{
        //request.getSession(false).invalidate();
        //}
        //return true;
        //}
        /*}
        else
        {
            return false;
        }*/
    }
}