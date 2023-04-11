package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.profile.Profile;
import com.orion.user_management.authorisation.jwt.JWTService;
import com.orion.user_management.exception.CouldNotSaveUserAuthorityException;
import com.orion.user_management.exception.CouldNotSaveUserDetailsException;
import com.orion.user_management.exception.CouldNotSaveUserException;
import com.orion.user_management.exception.UserAlreadyExistsException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.registration.OrionRegistrationService;
import com.orion.user_management.registration.RegistrationErrors;
import com.orion.user_management.registration.UserManagementRegistrationResponseBean;
import com.orion.web.core.cookie.CookieName;
import com.orion.web.core.cookie.CookieService;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

public class ProcessUserRegistrationTask extends OrionService
{
    public static UserManagementRegistrationResponseBean run(OrionAuthorityModel authorityModel, OrionUserModel user, OrionUserDetailsModel userDetails, String username, Boolean sendEmailValidationEmailToUser, HttpServletRequest request, HttpServletResponse response)
                    throws InvalidDateException, UserHasNoAuthorityException
    {

        try
        {
            userDetails = OrionRegistrationService.registerUser(authorityModel, user, userDetails, true, sendEmailValidationEmailToUser);

            //OrionUserSecurityQuestionsModel userSecurityQuestionsModel = UserManagementRegistrationService.buildUserSecurityQuestionsModel(registrationRequestBean, userDetails.getUserID());
            //OrionUsersSecurityQuestionsDAO.saveUserSecurityQuestions(userSecurityQuestionsModel);
            if(response != null)
            {
                ResponseCookie JWTCookie = JWTService.getJWTCookie(request);

                if(JWTCookie != null)
                {
                    JWTCookie = CookieService.updateCookieValue(JWTCookie, null, 0);
                }
                else
                {

                    if(Orion.isDev())
                    {
                        JWTCookie = CookieService.createCookie(CookieName.JWTAccessTokenDev.get(), null, 0);
                    }
                    else
                    {
                        JWTCookie = CookieService.createCookie(CookieName.JWTAccessToken.get(), null, 0);
                    }

                }

                response.addHeader(HttpHeaders.SET_COOKIE, JWTCookie.toString());
            }

            if(userDetails.getUserID() != null && !userDetails.getUserID().isEmpty())
            {
                return UserManagementRegistrationResponseBean.builder()
                                .userExists(false)
                                .registrationSuccessful(true)
                                .userID(userDetails.getUserID())
                                .username(username)
                                .build();
            }
            else
            {
                return UserManagementRegistrationResponseBean.builder()
                                .userExists(false)
                                .registrationSuccessful(false)
                                .errorMessage(RegistrationErrors.RegistrationProblemForUser)
                                .build();
            }

        }
        catch(UserAlreadyExistsException e)
        {
            return UserManagementRegistrationResponseBean.builder()
                            .userExists(true)
                            .registrationSuccessful(false)
                            .errorMessage(RegistrationErrors.RegistrationProblemForUser)
                            .build();
        }
        catch(CouldNotSaveUserAuthorityException | CouldNotSaveUserException | CouldNotSaveUserDetailsException | IOException e)
        {
            return UserManagementRegistrationResponseBean.builder()
                            .userExists(false)
                            .registrationSuccessful(false)
                            .errorMessage(RegistrationErrors.RegistrationProblemForUser)
                            .build();
        }

    }
}