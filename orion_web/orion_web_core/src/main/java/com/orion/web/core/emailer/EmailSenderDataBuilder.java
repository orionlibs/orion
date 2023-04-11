package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

class EmailSenderDataBuilder extends Orion
{
    static EmailSenderData build(Session emailSession, MimeMessage messageToSend) throws NoSuchProviderException
    {
        return EmailSenderData.builder()
                        .transport(emailSession.getTransport("smtp"))
                        .messageToSend(messageToSend)
                        .SMTPHost(ConfigurationService.getProp("email.administrator.email.address.smtp.host"))
                        .emailAccountUsername(ConfigurationService.getProp("email.administrator.email.address.username"))
                        .emailAccountPassword(ConfigurationService.getProp("email.administrator.email.address.password"))
                        .build();
    }
}