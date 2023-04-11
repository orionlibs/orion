package com.orion.web.core.emailer;

import com.orion.core.abstraction.Orion;
import javax.mail.Session;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
class EmailMessageDependencies extends Orion
{
    private Session emailSession;
    private String emailSender;
    private String emailSenderName;
    private String emailRecipient;
    private String emailSubject;
    private String emailMessage;
    private String messageMIMEType;
    private boolean hasAttachment;
    private boolean loadAttachmentFromFileSystem;
    private String attachmentFileURL;
    private String attachmentFileName;
}