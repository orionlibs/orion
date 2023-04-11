package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import com.orion.data.source.configuration.ConfigurationService;
import java.util.Properties;

class EmailConfigurator extends Orion
{
    static Properties getEmailParameters()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.setProperty("mail.transport.protocol", "smtp");
        emailProperties.setProperty("administrator.mail.smtp.starttls.enable", "true");
        emailProperties.setProperty("email.administrator.email.address.smtp.host", ConfigurationService.getProp("email.administrator.email.address.smtp.host"));
        emailProperties.setProperty("email.administrator.email.address.smtp.port", ConfigurationService.getProp("email.administrator.email.address.smtp.port"));
        emailProperties.setProperty("email.administrator.email.address.smtp.auth", ConfigurationService.getProp("email.administrator.email.address.smtp.auth"));
        return emailProperties;
    }
}