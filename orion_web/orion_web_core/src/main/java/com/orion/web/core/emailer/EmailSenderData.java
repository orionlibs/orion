package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import javax.mail.Transport;
// import com.sun.mail.smtp.SMTPTransport;
import javax.mail.internet.MimeMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class EmailSenderData extends Orion
{
    private Transport transport;
    private MimeMessage messageToSend;
    private String SMTPHost;
    private String emailAccountUsername;
    private String emailAccountPassword;
}