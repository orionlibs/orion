package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import com.orion.core.document.velocity.VelocityTemplateService;
import com.orion.web.core.emailer.template.EmailTemplateDefaults;
import com.orion.web.core.emailer.template.EmailTemplateResolver;
import java.util.Map;

public class EmailDataPopulator extends Orion
{
    public static EmailData populate(Map<String, String> templateParameters, String velocityTemplateID, String velocityTemplateName, String emailSubject, String emailRecipient, String emailSender, String emailSenderName)
    {
        String decodedHTMLTemplate = EmailTemplateResolver.resolve(velocityTemplateID);
        String templateBody = VelocityTemplateService.getVelocityTemplateAsString(templateParameters, velocityTemplateName, decodedHTMLTemplate);
        return EmailData.builder()
                        .emailID(templateParameters.get("emailID"))
                        .emailMessage(templateBody)
                        .emailRecipient(emailRecipient)
                        .emailSender(emailSender)
                        .emailSenderName(emailSenderName)
                        .emailSubject(emailSubject)
                        .messageMIMEType(EmailTemplateDefaults.messageMIMEType)
                        .build();
    }
}