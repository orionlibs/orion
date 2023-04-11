package com.orion.user_management.registration.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.calendar.date.InvalidDateException;
import com.orion.core.exception.Assert;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.registration.RegistrationErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailValidationURLToUserTask extends Orion
{
    public static void run(String userID, String username, String UUIDBase64Encoded) throws InvalidDateException
    {
        run(userID, username, UUIDBase64Encoded, CalendarService.getCurrentDatetimeAsSQLTimestamp());
    }


    public static void run(String userID, String username, String UUIDBase64Encoded, SQLTimestamp registrationDateTime) throws InvalidDateException
    {
        Assert.notEmpty(username, "The username input cannot be null/empty.");
        Assert.notEmpty(UUIDBase64Encoded, "The UUIDBase64Encoded input cannot be null/empty.");

        if(registrationDateTime == null)
        {
            registrationDateTime = CalendarService.getCurrentDatetimeAsSQLTimestamp();
        }

        String formattedRegistrationDateTime = registrationDateTime.printWithoutSecondsInLongFormat();
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        templateParameters.put("emailValidationCode", UUIDBase64Encoded);
        templateParameters.put("registrationDateTime", formattedRegistrationDateTime);
        String subject = ConfigurationService.getProp("user.management.registration.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.registration.email.velocity.template",
                        "RegistrationEmailTemplate",
                        subject,
                        username,
                        ConfigurationService.getProp("email.administrator.email.address"),
                        ConfigurationService.getProp("email.administrator.sender.name"));
        OrionMessageModel messageModel = OrionMessageModel.builder()
                        .messageID(templateParameters.get("emailID"))
                        .userID(userID)
                        .emailAddress(username)
                        .message(emailData.getEmailMessage())
                        .build();
        MessageService.saveMessage(messageModel);

        try
        {
            EmailService.sendEmail(emailData);
        }
        catch(Exception e)
        {
            logError(RegistrationErrors.ErrorWithSendingRegistrationEmailToUser, e);
        }

    }
}