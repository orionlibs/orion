package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.string.StringsService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.change_email_address_email_validation.ChangeEmailAddressEmailValidationService;
import com.orion.user_management.change_email_address_email_validation.model.ChangeEmailAddressEmailValidationCodeModel;
import com.orion.user_management.model.OrionAuthorityModel;

public class ResendValidationCodeToNewEmailAddressTask extends OrionService
{
    public static boolean run(String userID)
    {

        try
        {
            ChangeEmailAddressEmailValidationCodeModel ChangeEmailAddressEmailValidation = ChangeEmailAddressEmailValidationService.getEmailValidationCodeByUserID(userID);
            String emailValidationCode = "";

            if(ChangeEmailAddressEmailValidation != null)
            {
                emailValidationCode = ChangeEmailAddressEmailValidation.getEmailValidationCode();
                int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.change.email.address.code.expiration.in.minutes", 30);
                ChangeEmailAddressEmailValidation.setExpirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes));
                ChangeEmailAddressEmailValidationService.updateEmailValidationCode(ChangeEmailAddressEmailValidation);
            }
            else
            {
                emailValidationCode = StringsService.generateRandomNumericCode(ConfigurationService.getIntegerProp("user.management.length.of.validation.numeric.code", 4));
                int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.change.email.address.code.expiration.in.minutes", 30);
                ChangeEmailAddressEmailValidationCodeModel emailValidationCodeModel = ChangeEmailAddressEmailValidationCodeModel.builder()
                                .userID(userID)
                                .emailValidationCode(emailValidationCode)
                                .expirationDateTime(CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes))
                                .build();
                ChangeEmailAddressEmailValidationService.saveEmailValidationCode(emailValidationCodeModel);
            }

            OrionAuthorityModel authority = UserAccountService.getAuthorityByUserID(userID);
            UserAccountService.emailUserEmailValidationCodeForNewUsername(authority.getNewUsername(), emailValidationCode);
            return true;
        }
        catch(Throwable e)
        {
            return false;
        }

    }
}