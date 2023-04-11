package com.orion.user_management.authentication.security.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.authentication.security.LoginErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailUserAboutFailedLoginAttemptsTask extends Orion
{
    public static void run(String emailAddress)
    {
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        String subject = ConfigurationService.getProp("user.management.login.failed.attempts.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.login.failed.attempts.email.velocity.template",
                        "FailedLoginAttempts",
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
            logError(LoginErrors.ErrorWithSendingFailedLoginAttemptsEmail, e);
        }

    }
}