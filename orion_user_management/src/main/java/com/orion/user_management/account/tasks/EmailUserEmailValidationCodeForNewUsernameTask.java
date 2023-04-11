package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.calendar.SQLTimestamp;
import com.orion.core.exception.Assert;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.account.UserAccountErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailUserEmailValidationCodeForNewUsernameTask extends OrionService
{
    public static void run(String newEmailAddress, String emailValidationCode)
    {
        Assert.notEmpty(newEmailAddress, "The newEmailAddress input cannot be null/empty.");
        SQLTimestamp currentDateTimeAsSQLTimestamp = CalendarService.getCurrentDatetimeAsSQLTimestamp();
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        templateParameters.put("emailValidationCode", emailValidationCode);
        String subject = ConfigurationService.getProp("user.management.change.email.address.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.change.email.address.email.velocity.template",
                        "ChangeEmailAddressEmailTemplate",
                        subject,
                        newEmailAddress,
                        ConfigurationService.getProp("email.administrator.email.address"),
                        ConfigurationService.getProp("email.administrator.sender.name"));
        OrionMessageModel messageModel = OrionMessageModel.builder()
                        .messageID(templateParameters.get("emailID"))
                        .emailAddress(newEmailAddress)
                        .message(emailData.getEmailMessage())
                        .messageDateTime(currentDateTimeAsSQLTimestamp)
                        .build();
        messageModel = MessageService.saveMessage(messageModel);

        try
        {
            EmailService.sendEmail(emailData);
        }
        catch(Exception e)
        {
            logError(UserAccountErrors.ErrorWithSendingChangeEmailAddressEmail, e);
        }

    }
}