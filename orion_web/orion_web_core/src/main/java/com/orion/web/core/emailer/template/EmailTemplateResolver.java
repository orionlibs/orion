package com.orion.web.core.emailer.template;

import com.orion.core.abstraction.Orion;
import com.orion.core.cryptology.encoding.base64.Base64EncodingService;
import com.orion.data.source.configuration.ConfigurationService;

public class EmailTemplateResolver extends Orion
{
    public static String resolve(String velocityTemplateID)
    {
        String emailTemplate = ConfigurationService.getProp(velocityTemplateID);
        return Base64EncodingService.decodeBase64ForString(emailTemplate);
    }
}