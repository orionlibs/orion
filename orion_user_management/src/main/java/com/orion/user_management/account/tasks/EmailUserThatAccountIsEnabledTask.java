package com.orion.user_management.account.tasks;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.account.UserAccountErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailUserThatAccountIsEnabledTask extends Orion
{
    public static boolean run(String emailAddress)
    {
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        String subject = ConfigurationService.getProp("user.management.account.enabled.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.account.enabled.email.velocity.template",
                        "EmailUserThatAccountIsEnabled",
                        subject,
                        emailAddress,
                        ConfigurationService.getProp("email.administrator.email.address"),
                        ConfigurationService.getProp("email.administrator.sender.name"));
        OrionMessageModel messageModel = OrionMessageModel.builder()
                        .messageID(templateParameters.get("emailID"))
                        .emailAddress(emailAddress)
                        .message(emailData.getEmailMessage())
                        .build();
        MessageService.saveMessage(messageModel);

        try
        {
            EmailService.sendEmail(emailData);
        }
        catch(Exception e)
        {
            logError(UserAccountErrors.ErrorWithSendingAccountIsEnabledEmailToUser, e);
            return false;
        }

        return true;
    }
}