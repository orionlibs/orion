package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.SendFailedException;
import javax.mail.Transport;

public class EmailSender extends Orion
{
    public static boolean sendEmail(EmailSenderData senderData) throws EmailerException
    {
        boolean emailWasSentSuccessfully = false;

        try
        {
            Transport transport = senderData.getTransport();
            transport.connect(senderData.getSMTPHost(), ConfigurationService.getIntegerProp("email.administrator.email.address.smtp.port"), senderData.getEmailAccountUsername(), senderData.getEmailAccountPassword());
            transport.sendMessage(senderData.getMessageToSend(), senderData.getMessageToSend().getAllRecipients());
            transport.close();
            emailWasSentSuccessfully = true;
        }
        catch(NoSuchProviderException e)
        {
            throw new EmailerException(e, "there was a problem with the emailer.");
        }
        catch(SendFailedException e)
        {
            throw new EmailerException(e, "I could not send the email.");
        }
        catch(MessagingException e)
        {
            throw new EmailerException(e, "there was a problem with the emailer.");
        }
        catch(Exception e)
        {
            throw new EmailerException(e, "there was some problem with the emailer.");
        }

        return emailWasSentSuccessfully;
    }
}