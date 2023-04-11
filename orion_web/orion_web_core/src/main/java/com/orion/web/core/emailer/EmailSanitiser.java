package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import com.orion.core.content.MIMEType;

class EmailSanitiser extends Orion
{
    static void sanitise(EmailData emailData)
    {

        if(emailData.isReplaceNewLineWithBreakLine() && MIMEType.HTML_UTF8.equals(emailData.getMessageMIMEType()))
        {
            emailData.setEmailMessage(emailData.getEmailMessage().replace("\n", "<br>"));
        }

    }
}