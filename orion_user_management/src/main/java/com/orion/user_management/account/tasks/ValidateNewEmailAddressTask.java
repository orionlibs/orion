package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.account.UserManagementAccountNewEmailAddressValidationRequestBean;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationCodeHasExpiredException;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationService;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserDetailsModel;
import com.orion.web.core.session.SessionAttribute;
import javax.servlet.http.HttpServletRequest;

public class ValidateNewEmailAddressTask extends OrionService
{
    public static boolean run(String userID, UserManagementAccountNewEmailAddressValidationRequestBean requestBean, HttpServletRequest request)
                    throws ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException, ChangeEmailAddressEmailValidationCodeHasExpiredException, UserHasNoAuthorityException
    {
        String emailValidationCode = requestBean.getEmailValidationCode();
        ChangeEmailAddressEmailValidationCodeModel model = ChangeEmailAddressEmailValidationService.getEmailValidationCodeModelByCode(emailValidationCode);

        if(model != null)
        {

            if(CalendarService.hasExpired(model.getExpirationDateTime()))
            {
                ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(userID);
                throw new ChangeEmailAddressEmailValidationCodeHasExpiredException();
            }
            else
            {
                ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(userID);
                OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);
                authority.setUsername(new String(authority.getNewUsername()));
                authority.setNewUsername(null);
                UserAccountService.updateAuthorityByUserID(authority);
                OrionUserDetailsModel userDetails = UserAccountService.getUserDetailsByUserID(userID);
                userDetails.setEmailAddress(authority.getUsername());
                UserAccountService.updateUserDetailsByUserID(userDetails);
                request.setAttribute(SessionAttribute.currentUsername, authority.getUsername());
                return true;
            }

        }
        else
        {
            throw new ChangeEmailAddressEmailValidationCodeForUserDoesNotExistException();
        }

    }
}