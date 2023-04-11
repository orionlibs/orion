package com.orion.user_management.reset_password.reset;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.account.UserAccountService;
import com.orion.user_management.exception.UserHasNoAuthorityException;
import com.orion.user_management.reset_password.ResetPasswordErrors;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;

public class EmailUserAfterResetPasswordHelper extends Orion
{
    public static void run(String userID) throws UserHasNoAuthorityException
    {
        String emailAddress = UserAccountService.getAuthorityByUserID(userID).getUsername();
        Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
        String subject = ConfigurationService.getProp("user.management.password.changed.email.subject");
        EmailData emailData = EmailService.prepareEmailFromTemplate(templateParameters,
                        "user.management.password.changed.email.velocity.template",
                        "PasswordChanged",
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
            logError(ResetPasswordErrors.ErrorWithEmailingUserAboutPasswordChange, e);
        }

    }
}