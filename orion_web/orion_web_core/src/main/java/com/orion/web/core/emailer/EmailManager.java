package com.orion.web.core.emailer;

import com.orion.core.abstraction.OrionManager;
import com.orion.core.exception.Assert;
import java.util.Properties;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

class EmailManager extends OrionManager
{
    static boolean sendEmail(EmailData emailData) throws EmailerException
    {
        Assert.notNull(emailData, "The given emailData input cannot be null");
        EmailSanitiser.sanitise(emailData);
        Properties emailParameters = EmailConfigurator.getEmailParameters();
        Session emailSession = Session.getInstance(emailParameters);
        EmailMessageDependencies emailDependencies = EmailMessageDependenciesBuilder.buildDependencies(emailSession, emailData);
        MimeMessage messageToSend = EmailMessageBuilder.buildMessage(emailDependencies);

        try
        {
            return EmailSender.sendEmail(EmailSenderDataBuilder.build(emailSession, messageToSend));
        }
        catch(NoSuchProviderException e)
        {
            throw new EmailerException(e, "there was a problem with the emailer.");
        }
        catch(Exception e)
        {
            throw new EmailerException(e, "there was a problem with the emailer.");
        }

    }
}