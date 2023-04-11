package com.orion.user_management.contact_us;

import com.orion.core.abstraction.Orion;
import com.orion.core.calendar.CalendarService;
import com.orion.core.cryptology.encoding.xss.XSSEncodingService;
import com.orion.data.source.configuration.ConfigurationService;
import com.orion.data.user.email_address.EmailAddressService;
import com.orion.notification.MessageService;
import com.orion.notification.model.OrionMessageModel;
import com.orion.user_management.contact_us.model.ContactUsMessageModel;
import com.orion.web.core.emailer.EmailData;
import com.orion.web.core.emailer.EmailService;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// @NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
//@Setter
public class ContactUsFormProcessorBO extends Orion
{
    private UserManagementContactUsRequestBean requestBean;


    public static ContactUsFormProcessorBO of(UserManagementContactUsRequestBean requestBean)
    {
        return ContactUsFormProcessorBO.builder().requestBean(requestBean).build();
    }


    public boolean process()
    {
        boolean isValidEmailAddress = EmailAddressService.isValidEmailAddress(requestBean.getEmailAddress());

        if(isValidEmailAddress)
        {
            String userEmailAddress = EmailAddressService.normaliseEmailAddress(requestBean.getEmailAddress().trim());
            String sanitisedMessage = XSSEncodingService.encodeWithXSS(requestBean.getMessage().trim());
            String userFullName = requestBean.getFullName().trim();
            String userPhoneNumber = requestBean.getPhoneNumber() != null ? requestBean.getPhoneNumber() : "";
            Map<String, String> templateParameters = EmailService.getInitialTemplateParameters();
            templateParameters.put("userFullName", userFullName);
            templateParameters.put("userEmailAddress", userEmailAddress);
            templateParameters.put("userPhoneNumber", userPhoneNumber);
            templateParameters.put("userMessage", sanitisedMessage);
            String subject = ConfigurationService.getProp("contact.us.email.subject");
            String supportEmailAddress = ConfigurationService.getProp("email.support.email.address");
            EmailData emailToSupport = EmailService.prepareEmailFromTemplate(templateParameters,
                            "contact.us.email.to.support.velocity.template",
                            "ContactUsForm",
                            subject,
                            supportEmailAddress,
                            ConfigurationService.getProp("email.administrator.email.address"),
                            ConfigurationService.getProp("email.administrator.sender.name"));

            try
            {
                EmailService.sendEmail(emailToSupport);
            }
            catch(Exception e)
            {
                logError(ContactUsErrors.ErrorWithSendingContactUsFormByEmailToSupport, e);
            }

            EmailData emailToUser = EmailService.prepareEmailFromTemplate(templateParameters,
                            "contact.us.email.to.user.velocity.template",
                            "ContactUsForm",
                            subject,
                            userEmailAddress,
                            ConfigurationService.getProp("email.administrator.email.address"),
                            ConfigurationService.getProp("email.administrator.sender.name"));
            OrionMessageModel messageModel = OrionMessageModel.builder()
                            .messageID(templateParameters.get("emailID"))
                            .fullName(userFullName)
                            .emailAddress(userEmailAddress)
                            .phoneNumber(userPhoneNumber)
                            .message(emailToUser.getEmailMessage())
                            .messageDateTime(CalendarService.getCurrentDatetimeAsSQLTimestamp())
                            .build();
            MessageService.saveMessage(messageModel);
            ContactUsMessageModel contactUsMessageModel = ContactUsMessageModel.builder()
                            .messageID(templateParameters.get("emailID"))
                            .build();
            int rowsAffected = UserManagementContactUsService.saveContactUsMessage(contactUsMessageModel);

            if(rowsAffected > 0)
            {

                try
                {
                    EmailService.sendEmail(emailToUser);
                }
                catch(Exception e)
                {
                    logError(ContactUsErrors.ErrorWithSendingContactUsFormByEmailToUser, e);
                }
                /*
                 * finally { try { Email emailToOnelivery =
                 * EmailService.prepareEmailFromTemplate(templateParameters,
                 * "contact.us.email.to.user.velocity.template", "ContactUsForm", subject,
                 * ConfigurationService.getProp("email.onelivery.email.address"));
                 * EmailService.sendEmail(emailToOnelivery); } catch(Exception e) {
                 * logError(ContactUsErrors.ErrorWithSendingContactUsFormByEmailToSupport, e); }
                 * }
                 */

                return true;
            }
            else
            {
                return false;
            }

        }
        else
        {
            return false;
        }

    }
}