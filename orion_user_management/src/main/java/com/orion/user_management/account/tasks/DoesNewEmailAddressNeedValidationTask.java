package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationService;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;

public class DoesNewEmailAddressNeedValidationTask extends Orion
{
    public static boolean run(String userID) throws UserHasNoAuthorityException
    {
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);
        ChangeEmailAddressEmailValidationCodeModel emailValidation = ChangeEmailAddressEmailValidationService.getEmailValidationCodeByUserID(userID);
        boolean validationCodeNotExpired = false;

        if(emailValidation != null && CalendarService.isDateAfterAnother(emailValidation.getExpirationDateTime(), CalendarService.getCurrentDatetime()))
        {
            validationCodeNotExpired = true;
        }
        else
        {
            authority.setNewUsername(null);
            UserAccountService.updateNewUsernameInAuthorityByUserID(null, userID);
            ChangeEmailAddressEmailValidationService.deleteEmailValidationCodeByUserID(userID);
        }

        return authority.getNewUsername() != null
                        && !authority.getNewUsername().isEmpty()
                        && validationCodeNotExpired;
    }
}