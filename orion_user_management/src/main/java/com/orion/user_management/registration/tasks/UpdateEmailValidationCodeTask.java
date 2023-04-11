package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.core.exception.Assert;
import com.orion.core.uuid.UUIDSecurityService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.user_management.email_validation.OrionEmailValidationService;
import com.orion.user_management.email_validation.model.OrionEmailValidationCodeModel;

public class UpdateEmailValidationCodeTask extends Orion
{
    public static String run(String userID)
    {
        Assert.notEmpty(userID, "The userID input cannot be null/empty.");
        return buildAndSaveEmailValidationCodesModel(userID);
    }


    private static String generateUUIDWithoutHyphensBase64ForURLEncoded()
    {
        String UUID1 = UUIDSecurityService.generateUUIDWithoutHyphens();
        String UUID2 = UUIDSecurityService.generateUUIDWithoutHyphens();
        return Base64EncodingService.encodeBase64ForURL(UUID1 + UUID2);
    }


    private static String buildAndSaveEmailValidationCodesModel(String userID)
    {
        int numberOfMinutes = ConfigurationService.getIntegerProp("user.management.registration.email.validation.code.expiration.in.minutes", 20);
        SQLTimestamp currentInstancePlusDuration = CalendarService.addMinutesToCurrentSQLDatetime(numberOfMinutes);
        OrionEmailValidationCodeModel emailValidationCodeModel = OrionEmailValidationService.getEmailValidationCodeByUserID(userID);
        boolean modelDoesNotExist = false;

        if(emailValidationCodeModel == null)
        {
            modelDoesNotExist = true;
            emailValidationCodeModel = new OrionEmailValidationCodeModel();
            emailValidationCodeModel.setUserID(userID);
            emailValidationCodeModel.setEmailValidationCode(generateUUIDWithoutHyphensBase64ForURLEncoded());
        }

        emailValidationCodeModel.setExpirationDateTime(currentInstancePlusDuration);

        if(modelDoesNotExist)
        {
            OrionEmailValidationService.saveEmailValidationCode(emailValidationCodeModel);
        }
        else
        {
            OrionEmailValidationService.updateEmailValidationCode(emailValidationCodeModel);
        }

        return emailValidationCodeModel.getEmailValidationCode();
    }
}