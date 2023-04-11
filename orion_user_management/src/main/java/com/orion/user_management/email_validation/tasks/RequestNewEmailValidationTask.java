package com.orion.user_management.email_validation.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.email_validation.AccountIsAlreadyValidatedException;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.model.OrionAuthorityModel;
import com.orion.user_management.model.OrionUserModel;
import com.orion.user_management.registration.OrionRegistrationService;

public class RequestNewEmailValidationTask extends OrionService
{
    public static boolean run(String emailAddress) throws AccountIsAlreadyValidatedException, InvalidDateException, UserHasNoAuthorityException
    {
        emailAddress = EmailAddressService.normaliseEmailAddress(emailAddress);
        OrionAuthorityModel authority = UserAccountService.getAuthorityByUsername(emailAddress);

        if(authority != null)
        {
            OrionUserModel user = UserAccountService.getUserByUserID(authority.getUserID());

            if(user != null)
            {

                if((user.getEnabled() == null
                                || !user.getEnabled())
                                && user.getPendingEmailAddressValidation() != null
                                && user.getPendingEmailAddressValidation())
                {
                    String UUIDBase64Encoded = OrionRegistrationService.updateEmailValidationCode(authority.getUserID());
                    OrionRegistrationService.emailValidationURLToUser(authority.getUserID(), emailAddress, UUIDBase64Encoded, user.getRegistrationDateTime());
                    return true;
                }
                else
                {
                    throw new AccountIsAlreadyValidatedException();
                }

            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}