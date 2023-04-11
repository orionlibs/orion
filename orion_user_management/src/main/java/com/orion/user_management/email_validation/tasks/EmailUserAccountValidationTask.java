package com.orion.user_management.email_validation.tasks;

import com.orion.core.abstraction.OrionService;
import com.orion.core.calendar.CalendarService;
import com.orion.core.exception.Assert;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.account.UserAccountErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailUserAccountValidationTask extends OrionService
{
    public static void run(String emailAddress)
    {
        Assert.notEmpty(emailAddress, "The emailAddress input cannot be null/empty.");
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        String subject = ConfigurationService.getProp("user.management.account.validated.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.account.validated.email.velocity.template",
                        "AccountValidationEmailTemplate",
                        subject,
                        emailAddress,
                        ConfigurationService.getProp("email.administrator.email.address"),
                        ConfigurationService.getProp("email.administrator.sender.name"));
        OrionMessageModel messageModel = OrionMessageModel.builder()
                        .messageID(templateParameters.get("emailID"))
                        .emailAddress(emailAddress)
                        .message(emailData.getEmailMessage())
                        .messageDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                        .build();
        messageModel = MessageService.saveMessage(messageModel);

        try
        {
            EmailService.sendEmail(emailData);
        }
        catch(Exception e)
        {
            logError(UserAccountErrors.ErrorWithSendingAccountIsValidatedEmailToUser, e);
        }

    }
}